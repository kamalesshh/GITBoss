package com.gigya.login.security;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import com.gigya.common.model.GigyaConfigModel;
import com.gigya.common.service.GigyaService;
import com.gigya.login.security.impl.GigyaAutentication;
import com.gigya.login.util.GigyaGltExpCookieGenerator;
import de.hybris.platform.acceleratorstorefrontcommons.security.StorefrontLogoutSuccessHandler;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.jalo.user.CookieBasedLoginToken;
import de.hybris.platform.jalo.user.UserManager;
import de.hybris.platform.persistence.security.EJBPasswordEncoderNotFoundException;
import de.hybris.platform.servicelayer.session.SessionService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.util.Config;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;

public class GigyaLogoutSuccessHandler extends StorefrontLogoutSuccessHandler
{
    @Resource(name = "gltCookieGenerator")
    private GigyaGltExpCookieGenerator cookieGenerator;

    @Resource(name = "gigyaService")
    private GigyaService gigyaService;

    private SessionService sessionService;

    private static final Logger LOGGER = Logger.getLogger(GigyaLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(final HttpServletRequest request, final HttpServletResponse response, final Authentication authentication)
    throws IOException, ServletException
    {
        getGuidCookieStrategy().deleteCookie(request, response);

        if(authentication instanceof GigyaAutentication)
        {
            GigyaAutentication gigyaAutentication = (GigyaAutentication) authentication;
            Optional<GigyaConfigModel> configurationForSite = gigyaService.getConfigurationForSite(gigyaAutentication.getCmsSiteModel());
            configurationForSite.ifPresent(gigyaConfigModel -> cookieGenerator.removeCookie(response, gigyaConfigModel));
            if(request.getCookies()!=null){
                for(Cookie cookie : request.getCookies()){
                    if(cookie.getName().equals(gigyaAutentication.getCmsSiteModel().getUid() + "-LoginToken")){
                        CookieBasedLoginToken cookieBasedLoginToken = new CookieBasedLoginToken(cookie);
                        try {
                            UserManager.getInstance().storeLoginTokenCookie(
                                cookieBasedLoginToken.getName(), cookieBasedLoginToken.getUser().getUid(),
                                cookieBasedLoginToken.getLanguage().getIsocode(), cookieBasedLoginToken.getPassword(),
                                "/",
                                cookieBasedLoginToken.getDomain(), true, 0, response);
                        }
                        catch (EJBPasswordEncoderNotFoundException e) {
                            LOGGER.error(e);
                        }
                    }
                }
            }
        }
        // Delegate to default redirect behaviour
        super.onLogoutSuccess(request, response, authentication);
    }


    public SessionService getSessionService() {
        return sessionService;
    }


    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }
}
