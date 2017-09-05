package com.rivetlogic.tipday.control.menu.entry.control.menu;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.product.navigation.control.menu.BaseJSPProductNavigationControlMenuEntry;
import com.liferay.product.navigation.control.menu.ProductNavigationControlMenuEntry;
import com.liferay.product.navigation.control.menu.constants.ProductNavigationControlMenuCategoryKeys;
import com.rivetlogic.services.model.TipsOfTheDayUsers;
import com.rivetlogic.services.service.TipsOfTheDayUsersLocalServiceUtil;
import com.rivetlogic.tipday.api.constants.WebKeys;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author alejandrosoto
 */
@Component(
	immediate = true,
	property = {
		"product.navigation.control.menu.category.key=" + ProductNavigationControlMenuCategoryKeys.USER,
		"product.navigation.control.menu.entry.order:Integer=1"
	},
	service = ProductNavigationControlMenuEntry.class
)
public class TipDayControlMenuEntryProductNavigationControlMenuEntry
	extends BaseJSPProductNavigationControlMenuEntry {
	
	private static final Log logger = 
			LogFactoryUtil.getLog(TipDayControlMenuEntryProductNavigationControlMenuEntry.class);
	
	@Override
	public String getIconJspPath() {
		return "/entry/tipday_controlmenu_icon.jsp";
	}

	// @Override
	// public String getIcon(HttpServletRequest request) {
	// 	return "message-boards";
	// }

	@Override
	public String getBodyJspPath() {
		return "/entry/tipday_controlmenu_body.jsp";
	}
	
	@Override
	public boolean includeBody(HttpServletRequest request, HttpServletResponse response) throws IOException {
		logger.debug("Rendering tip of the day user settings");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String userStatus = StringPool.BLANK;
			TipsOfTheDayUsers user = TipsOfTheDayUsersLocalServiceUtil.getUser(
							themeDisplay.getCompanyId(), 
							themeDisplay.getScopeGroupId(), 
							themeDisplay.getUserId());
			logger.debug(user);
			if (Validator.isNotNull(user)) {
				userStatus = user.getStatus();
				request.setAttribute(WebKeys.USER_STATUS, userStatus);
				request.setAttribute(WebKeys.SHOW_ALL_TIPS, user.getShowAll());
			}
			if (userStatus.equals(StringPool.BLANK)) {
				request.setAttribute(WebKeys.STOP_SHOWING, true);
			}
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return super.includeBody(request, response);
	}

	// @Override
	// public String getLabel(Locale locale) {
	// 	ResourceBundle resourceBundle = ResourceBundleUtil.getBundle(
	// 		"content.Language", locale, getClass());

	// 	return LanguageUtil.get(resourceBundle, "tipday-menuentry-message");
	// }

	@Override
	@Reference(
		target = "(osgi.web.symbolicname=com.rivetlogic.tipday.control.menu.web)",
		unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		super.setServletContext(servletContext);
	}

	// @Override
	// public String getURL(HttpServletRequest request) {
	// 	return "https://www.liferay.com";
	// }

	@Override
	public boolean isShow(HttpServletRequest request) throws PortalException {
		return true;
	}

}