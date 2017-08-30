<%@ include file="/entry/init.jsp" %>
<liferay-util:body-bottom outputKey="tipdayContentMenu">
    Tip of day body
    <div class="closed hidden-print lfr-add-panel lfr-admin-panel sidenav-fixed sidenav-menu-slider sidenav-right" id="<%= TIPDAY_CONTROLMENU_NAMESPACE %>tipdayPanelId">
        <div class="product-menu sidebar sidebar-inverse sidenav-menu">
            <div class="sidebar-header">
                <span><liferay-ui:message key="tipday-menuentry-message" /></span>

                <aui:icon cssClass="icon-monospaced sidenav-close" image="times" markupView="lexicon" url="javascript:;" />
            </div>

            <div class="sidebar-body">
                
            </div>
        </div>
    </div>

    <aui:script use="liferay-store,io-request,parse-content">
            var addToggle = $('#<%= TIPDAY_CONTROLMENU_NAMESPACE %>tipdayToggleId>');
    
            addToggle.sideNavigation();
    
            Liferay.once(
                'screenLoad',
                function() {
                    var sideNavigation = addToggle.data('lexicon.sidenav');
    
                    if (sideNavigation) {
                        sideNavigation.destroy();
                    }
                }
            );
        </aui:script>
</liferay-util:body-bottom>