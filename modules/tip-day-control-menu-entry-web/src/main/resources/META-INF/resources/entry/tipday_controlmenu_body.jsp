<%@ include file="/entry/init.jsp" %>

<%
boolean stopShowing = GetterUtil.getBoolean(request.getAttribute(WebKeys.STOP_SHOWING));
boolean showAllTips = (Boolean) request.getAttribute(WebKeys.SHOW_ALL_TIPS);
%>

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
                                <input data-action="tof-each-login" class="toggle-switch" type="checkbox" <c:if test="${!stopShowing}"> checked </c:if> />
                                <span class="toggle-switch-label">Show tips at login</span>
                        
                                <span aria-hidden="true" class="toggle-switch-bar">
                                    <span class="toggle-switch-handle" data-label-off="OFF" data-label-on="ON">
                                    </span>
                                </span>
                            </label>
                        </div>
                        <div class="form-group">
                                <label>
                                    <input data-action="tof-checkbox-only-new" class="toggle-switch" type="checkbox" <c:if test="${!showAllTips}"> checked </c:if> />
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
            resourceURL: window.TIPDAY.resourceURL,
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