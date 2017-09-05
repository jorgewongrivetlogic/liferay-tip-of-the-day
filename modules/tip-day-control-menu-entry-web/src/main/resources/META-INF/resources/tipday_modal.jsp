<aui:script use="rivetlogic-tipday-modal">
    new A.TipDayModal({
        namespace: window.TIPDAY.portletNamespace,
        contentURL: window.TIPDAY.contentURL,
        articleIds: window.TIPDAY.articleIds,
        show: window.TIPDAY.showPopUp,
        title: '<liferay-ui:message key="tipday-menuentry-message" />'
    });
</aui:script>