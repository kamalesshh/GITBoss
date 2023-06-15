package de.hybris.myshoestore.storefront.controllers.cms;

import com.stackextend.training.model.components.YoutubeVideoComponentModel;
import de.hybris.myshoestore.storefront.controllers.ControllerConstants;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.cms.AbstractCMSComponentController;
import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Scope("tenant")
@Controller("YoutubeVideoComponentController")
@RequestMapping("/view/YoutubeVideoComponentController")
public class YoutubeVideoComponentController
        extends AbstractCMSComponentController<YoutubeVideoComponentModel>
{
    @Override
    protected void fillModel(HttpServletRequest request, Model model, YoutubeVideoComponentModel component) {

        model.addAttribute("width", component.getWidth());
        model.addAttribute("height", component.getHeight());
        model.addAttribute("videoId", component.getVideoId());

        model.addAttribute("autoPlay", BooleanUtils.toBoolean(component.getAutoPlay()) ? 1 : 0);
        model.addAttribute("showControls", BooleanUtils.toBoolean(component.getShowControls()) ? 1 : 0);
    }

    @Override
    protected String getView(YoutubeVideoComponentModel component) {
        return ControllerConstants.Views.Cms.ComponentPrefix + StringUtils.lowerCase(getTypeCode(component));
    }
}