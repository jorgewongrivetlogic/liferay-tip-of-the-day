<a href="javascript:window.showTipDay();">show (test)</a>

<aui:script>
    /* TODO: this is just for styling, need to move to dedicated js file */
    window.showTipDay = function() {
        Liferay.Util.openWindow(
            {
                dialog: {
                    cssClass: 'tipday-modal',
                    destroyOnHide: true,
                    width: 700
                },
                dialogIframe: {
                    bodyCssClass: 'dialog-with-footer'
                },
                title: '<liferay-ui:message key="tipday-menuentry-message" />',
                uri: 'http://google.com'
            }
        );
    };
</aui:script>