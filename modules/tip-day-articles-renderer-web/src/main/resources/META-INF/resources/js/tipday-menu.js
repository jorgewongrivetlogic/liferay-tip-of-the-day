AUI.add(
    'rivetlogic-tipday-menu',
    function (A) {
        var Lang = A.Lang;

        var Menu = A.Component.create({

            ATTRS: {
                resourceURL: {
                    value: ''
                },

                namespace: {
                    value: ''
                },

                node: {
                    value: null
                }
            },

            EXTENDS: A.Base,

            NAME: 'tipOfTheDayMenu',

            prototype: {
                initializer: function (config) {
                    var instance = this;

                    instance.get('node').one('[data-action="showme-tips-now"]').on('click', function() {
                        Liferay.fire('tipday:show');
                    });
                }
            }
        });

        A.TipDayMenu = Menu;
    },
    '', {
        requires: ['liferay-portlet-base']
    }
);