package com.rivetlogic.tipday.articles.renderer.portlet;

import com.rivetlogic.tipday.articles.renderer.constants.TipDayArticlesRendererPortletKeys;

import java.io.IOException;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author alejandrosoto
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=tip-day-articles-renderer Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TipDayArticlesRendererPortletKeys.TipDayArticlesRenderer,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TipDayArticlesRendererPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String mode = ParamUtil.getString(renderRequest, "tipDayPortletMode");
		if (mode.equals("renderArticle")) {
			String articleId = ParamUtil.getString(renderRequest, "articleId");
			renderRequest.setAttribute("tipDayPortletMode", mode);
		}
		super.doView(renderRequest, renderResponse);
	}
	
}