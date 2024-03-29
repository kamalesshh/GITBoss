package com.gigya.login.service.web.filters;

import de.hybris.platform.cms2.model.site.CMSSiteModel;
import de.hybris.platform.cms2.servicelayer.services.CMSSiteService;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.user.CookieBasedLoginToken;
import de.hybris.platform.jalo.user.User;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.persistence.security.EJBPasswordEncoderNotFoundException;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;

import java.io.IOException;
import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.RedirectStrategy;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gigya.common.enums.GigyaSessionLead;
import com.gigya.common.enums.GigyaSessionType;
import com.gigya.common.model.GigyaConfigModel;
import com.gigya.common.model.GigyaSessionConfigurationModel;
import com.gigya.common.service.GigyaService;
import com.gigya.login.security.GigyaAutoLoginStrategy;
import com.gigya.login.util.GigyaGltExpCookieGenerator;


public class GigyaLoginFilter extends OncePerRequestFilter {
    private SessionService sessionService;

    @Resource(name = "redirectStrategy")
    private RedirectStrategy redirectStrategy;

    @Resource(name = "gigyaService")
    private GigyaService gigyaService;

    @Resource(name = "cmsSiteService")
    private CMSSiteService cmsSiteService;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "gltCookieGenerator")
    private GigyaGltExpCookieGenerator cookieGenerator;

    @Resource(name = "gigyaAutoLoginStrategy")
    private GigyaAutoLoginStrategy gigyaAutoLoginStrategy;

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response, final FilterChain filterChain)
        throws IOException, ServletException {
        CMSSiteModel currentSite = cmsSiteService.getCurrentSite();
        Optional<GigyaConfigModel> config = gigyaService.getConfigurationForSite(currentSite);

        if (config.isPresent() && config.get().getSessionConfiguration() != null) {
            GigyaConfigModel gigyaConfig = config.get();
            GigyaSessionConfigurationModel sessionConfig = gigyaConfig.getSessionConfiguration();

            if (GigyaSessionLead.HYBRIS.equals(sessionConfig.getSessionLead())) {
                filterChain.doFilter(request, response);
            }
            else {
                handleSessionExpiration(request, response, filterChain, gigyaConfig, sessionConfig, currentSite);
            }
        }
        else {
            filterChain.doFilter(request, response);
        }
    }

    private void handleSessionExpiration(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain filterChain,
        GigyaConfigModel gigyaConfig,
        GigyaSessionConfigurationModel sessionConfig,
        CMSSiteModel cmsSiteModel) throws IOException, ServletException {
        UserModel user = userService.getCurrentUser();
        boolean shouldRedirect = false;

        if (!userService.isAnonymousUser(user) &&
            GigyaSessionLead.GIGYA.equals(sessionConfig.getSessionLead())) {
            switch (sessionConfig.getSessionType()) {
                case SLIDING:
                    cookieGenerator.addCookie(request, response, gigyaConfig);
                    break;
                case FIXED:
                    break;
                case FOREVER:
                    break;
                case BROWSERCLOSED:
                    break;
                default:
                    break;
            }
        }
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {

                if (cookie.getName().equals(cmsSiteModel.getUid() + "-LoginToken")) {
                    CookieBasedLoginToken cookieBasedLoginToken = new CookieBasedLoginToken(cookie);
                    User tokenJaloUser = cookieBasedLoginToken.getUser();
                    if (tokenJaloUser != null) {
                        UserModel tokenUser = userService.getUserForUID(tokenJaloUser.getUid());
                        if (!userService.getCurrentUser().getUid().equals(tokenUser.getUid())) {
                            try {
                                gigyaAutoLoginStrategy
                                    .login(cmsSiteModel, tokenUser, request, response);
                            }
                            catch (Exception e) {
                                logger.error(e);
                                shouldRedirect = true;
                            }
                        }
                        else if (GigyaSessionType.SLIDING.equals(sessionConfig.getSessionType())) {
                            try {
                                UserManager.getInstance().storeLoginTokenCookie(
                                    cookieBasedLoginToken.getName(),
                                    cookieBasedLoginToken.getUser().getUid(),
                                    cookieBasedLoginToken.getLanguage().getIsocode(),
                                    cookieBasedLoginToken.getPassword(),
                                    "/",
                                    cookieBasedLoginToken.getDomain(),
                                    true,
                                    sessionConfig.getDurationInSeconds(),
                                    response);
                            }
                            catch (EJBPasswordEncoderNotFoundException e) {
                                logger.error(e);
                            }
                        }
                    }
                    else if (!userService.isAnonymousUser(userService.getCurrentUser())) {
                        shouldRedirect = true;
                    }
                }
            }
        }
        else if (!userService.isAnonymousUser(userService.getCurrentUser())) {
            shouldRedirect = true;
        }

        if (shouldRedirect) {
            redirectStrategy.sendRedirect(request, response, "/logout");
            return;
        }

        filterChain.doFilter(request, response);
    }

    /**
     * @return the sessionService
     */
    public SessionService getSessionService() {
        return sessionService;
    }

    /**
     * @param sessionService the sessionService to set
     */
    public void setSessionService(final SessionService sessionService) {
        this.sessionService = sessionService;
    }
}
