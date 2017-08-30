package com.rivetlogic.tipday.control.menu.entry.control.menu;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.product.navigation.control.menu.BaseJSPProductNavigationControlMenuEntry;
import com.liferay.product.navigation.control.menu.ProductNavigationControlMenuEntry;
import com.liferay.product.navigation.control.menu.constants.ProductNavigationControlMenuCategoryKeys;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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