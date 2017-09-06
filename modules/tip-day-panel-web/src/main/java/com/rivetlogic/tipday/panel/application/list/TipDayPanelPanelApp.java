package com.rivetlogic.tipday.panel.application.list;

//import com.rivetlogic.tipday.panel.constants.TipDayPanelPanelCategoryKeys;
import com.rivetlogic.tipday.panel.constants.TipDayPanelPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.application.list.constants.PanelCategoryKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author alejandrosoto
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONFIGURATION
	},
	service = PanelApp.class
)
public class TipDayPanelPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return TipDayPanelPortletKeys.TipDayPanel;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + TipDayPanelPortletKeys.TipDayPanel + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}