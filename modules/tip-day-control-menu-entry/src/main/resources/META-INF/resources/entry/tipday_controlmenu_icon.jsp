<%@ include file="/entry/init.jsp" %>
<li class="control-menu-nav-item">
	<a class="control-menu-icon lfr-portal-tooltip product-menu-toggle sidenav-toggler" data-content="body" data-open-class="open-admin-panel" data-qa-id="tipday" data-target="#<%= TIPDAY_CONTROLMENU_NAMESPACE %>tipdayPanelId" data-title="<%= HtmlUtil.escape(LanguageUtil.get(resourceBundle, "tipday-menuentry-message")) %>" data-toggle="sidenav" data-type="fixed-push" data-type-mobile="fixed" data-url="" href="javascript:;" id="<%= TIPDAY_CONTROLMENU_NAMESPACE %>tipdayToggleId">
		<aui:icon cssClass="icon-monospaced" image="wiki" markupView="lexicon" />
	</a>
</li>