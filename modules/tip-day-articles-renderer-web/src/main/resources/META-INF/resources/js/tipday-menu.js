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

                    instance.get('node').delegate('click', function(e) {
                        instance.onCheckboxClickHandler(this);
                    }, '[type="checkbox"]');
                },

                onCheckboxClickHandler: function(checkbox) {
                    var instance = this;
                    var action = checkbox.getAttribute('data-action');
                    var state = checkbox.get('checked');
                    var changedValue = '';

                    if (action === 'tof-checkbox-only-new') {
                        changedValue = 'showAllTips';            
                    } else if (action === 'tof-checkbox-show') {
                        changedValue = 'stopShowing'; 
                    }

                    var data = Liferay.Util.ns(instance.get('namespace'), {
                        changedValue: changedValue,
                        value: !state,
                        action: 'user-settings-update'
                    });
                    // ajax call
                    A.io.request(instance.get('resourceURL'), {
                        method: 'GET',
                        data: data,
                        dataType: 'json', // expects json as response
                        on: {
                            success: function (e) {
                                var data = this.get('responseData');
                                console.log(data);
                                //Liferay.Util.getWindow(instance.NS).bodyNode.set('innerHTML', data);
                            }
                        }
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