<%@ include file="/entry/init.jsp" %>
<liferay-util:body-bottom outputKey="tipdayContentMenu">
    <div class="closed hidden-print lfr-add-panel lfr-admin-panel sidenav-fixed sidenav-menu-slider sidenav-right" id="<%= TIPDAY_CONTROLMENU_NAMESPACE %>tipdayPanelId">
        <div class="product-menu sidebar sidebar-inverse sidenav-menu">
            <div class="sidebar-header">
                <span><liferay-ui:message key="tipday-menuentry-message" /></span>

                <aui:icon cssClass="icon-monospaced sidenav-close" image="times" markupView="lexicon" url="javascript:;" />
            </div>

            <div class="sidebar-body">
                <div class="container-fluid">
                    <form>
                        <div class="form-group"></div>
                        <div class="form-group">
                            <button data-action="showme-tips-now" class="btn btn-default" type="button">Show me tips now</button>
                        </div>
                        <div class="form-group">
                            <label>
                                <input class="toggle-switch" type="checkbox">
                                <span class="toggle-switch-label">Show tips at login</span>
                        
                                <span aria-hidden="true" class="toggle-switch-bar">
                                    <span class="toggle-switch-handle" data-label-off="OFF" data-label-on="ON">
                                    </span>
                                </span>
                            </label>
                        </div>
                        <div class="form-group">
                                <label>
                                    <input class="toggle-switch" type="checkbox">
                                    <span class="toggle-switch-label">Show only new tips</span>
                            
                                    <span aria-hidden="true" class="toggle-switch-bar">
                                        <span class="toggle-switch-handle" data-label-off="OFF" data-label-on="ON">
                                        </span>
                                    </span>
                                </label>
                            </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <aui:script use="rivetlogic-tipday-menu">
        new A.TipDayMenu({
            resourceURL: '<portlet:resourceURL />',
            namespace: window.TIPDAY.portletNamespace,
            node: A.one('#<%= TIPDAY_CONTROLMENU_NAMESPACE %>tipdayPanelId')
        });
    </aui:script>
    <aui:script>
        var toggle = $('#<%= TIPDAY_CONTROLMENU_NAMESPACE %>tipdayToggleId>');

        toggle.sideNavigation();

        Liferay.once(
            'screenLoad',
            function() {
                var sideNavigation = toggle.data('lexicon.sidenav');

                if (sideNavigation) {
                    sideNavigation.destroy();
                }
            }
        );
    </aui:script>
</liferay-util:body-bottom>