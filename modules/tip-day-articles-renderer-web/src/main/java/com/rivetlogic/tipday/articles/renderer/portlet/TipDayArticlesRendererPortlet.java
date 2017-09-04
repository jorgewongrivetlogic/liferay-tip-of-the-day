package com.rivetlogic.tipday.articles.renderer.portlet;

import com.rivetlogic.tipday.articles.renderer.constants.TipDayArticlesRendererPortletKeys;
import com.rivetlogic.tipday.api.constants.WebKeys;
import com.rivetlogic.tipday.api.utils.TipOfTheDayUtil;

import java.io.IOException;

import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

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
		"com.liferay.portlet.header-portal-javascript=/o/tipoftheday-web/js/tipday-modal.js",
		"com.liferay.portlet.header-portal-javascript=/o/tipoftheday-web/js/tipday-menu.js",
		"javax.portlet.name=" + TipDayArticlesRendererPortletKeys.TipDayArticlesRenderer,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TipDayArticlesRendererPortlet extends MVCPortlet {
	private static final Log logger = 
			LogFactoryUtil.getLog(TipDayArticlesRendererPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		renderRequest.setAttribute(WebKeys.SHOW_ALL_TIPS, true); // TODO: fill show all tips based on user data
		
		String mode = ParamUtil.getString(renderRequest, "tipDayPortletMode");
		
		// Render article by id
		if (mode.equals("renderArticle")) {
			this.doArticleRenderProcessing(themeDisplay, renderRequest, mode);
			
		// Render Articles Ids so frontend can cycle around the list and render each by id
		} else {
			long[] categoryIds = TipOfTheDayUtil.getCategoryIds(renderRequest, themeDisplay);
			String[] articleIds = TipOfTheDayUtil.getFilteredArticleIds(renderRequest, categoryIds);
			renderRequest.setAttribute(WebKeys.ARTICLE_IDS, StringUtil.merge(articleIds));
		}
		super.doView(renderRequest, renderResponse);
	}
	
	private void doArticleRenderProcessing(ThemeDisplay themeDisplay, RenderRequest renderRequest, String mode) {
		String articleId = ParamUtil.getString(renderRequest, "articleId");
		logger.debug("Rendering article " + articleId);
		// saveVisitedTip(request, articleId);
		renderRequest.setAttribute("currentArticleId", articleId);
		renderRequest.setAttribute("tipDayPortletMode", mode);
		if (JournalArticleLocalServiceUtil.hasArticle(themeDisplay.getScopeGroupId(), articleId)) {
			try {
				renderRequest.setAttribute("article", JournalArticleLocalServiceUtil.getArticle(themeDisplay.getScopeGroupId(), articleId));
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}