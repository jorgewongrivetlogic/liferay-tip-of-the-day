AUI.add(
    'rivetlogic-tipday-modal',
    function (A) {
        var Lang = A.Lang;

        var Modal = A.Component.create({
            ATTRS: {
                /**
                 * Index of current display tip of the day
                 */
                activeIndex: {
                    value: 0
                },
                contentURL: {
                    value: ''
                },
                resourceURL: {
                    value: ''
                },
                articleIds: {
                    value: []
                },
                show: {
                    value: false
                },
                title: {
                    value: 'Modal Title'
                }
            },

            AUGMENTS: [Liferay.PortletBase],

            EXTENDS: A.Base,

            NAME: 'tipOfTheDayModal',

            prototype: {
                initializer: function (config) {
                    var instance = this;
                    if (instance.get('show')) {
                        instance.show();
                    }
                    Liferay.on('tipday:show', function() {
                        instance.show();
                    });
                },

                show: function () {
                    var instance = this;
                    var showButtonCss = instance.get('articleIds').length > 1 ? '' : 'hidden';
                    Liferay.Util.openWindow({
                        dialog: {
                            width: '600',
                            height: '400',
                            cssClass: 'tipday-modal',
                            destroyOnHide: true,
                            'toolbars.footer': [
                                {
                                    cssClass: 'previous-btn ' + showButtonCss,
                                    label: Liferay.Language.get('previous'),
                                    on: {
                                        click: A.bind('onPreviousHandler', instance)
                                    }
                                },
                                {
                                    cssClass: 'next-btn ' + showButtonCss,
                                    label: Liferay.Language.get('next'),
                                    on: {
                                        click: A.bind('onNextHandler', instance)
                                    }
                                },
                                {
                                    cssClass: 'done-btn',
                                    label: Liferay.Language.get('done'),
                                    on: {
                                        click: A.bind('onDoneHandler', instance)
                                    }
                                },
                            ],
                        },

                        title: instance.get('title'),
                        id: instance.NS
                    }, function(dialogWindow) {
                        dialogWindow.plug(A.LoadingMask);
                        instance.retrieveArticle();
                    });
                },

                onPreviousHandler: function() {
                    var instance = this;
                    var maxIndex = (instance.get('articleIds').length - 1);
                    var currentIndex = instance.get('activeIndex');
                    if (currentIndex > 0) {
                        instance.set('activeIndex', (currentIndex - 1));
                    } else {
                        instance.set('activeIndex', maxIndex);
                    }
                    instance.retrieveArticle();
                },

                onNextHandler: function() {
                    var instance = this;
                    var maxIndex = (instance.get('articleIds').length - 1);
                    var currentIndex = instance.get('activeIndex');
                    if (currentIndex < maxIndex) {
                        instance.set('activeIndex', (currentIndex + 1));
                    } else {
                        instance.set('activeIndex', 0);
                    }
                    instance.retrieveArticle();
                },

                onDoneHandler: function() {
                    var instance = this;
                    Liferay.Util.getWindow(instance.NS).hide();

                    // send acknowledge to the backend
                    var data = Liferay.Util.ns(instance.NS, {
                        action: 'user-visited'
                    });
                    A.io.request(instance.get('resourceURL'), {
                        method: 'GET',
                        data: data,
                        dataType: 'json', // expects json as response
                        on: {
                            success: function (e) {
                                var data = this.get('responseData');
                            }
                        }
                    });
                },

                /**
                 * Retrieves article markup
                 * 
                 * @param {*} callback 
                 */
                retrieveArticle: function() {
                    var instance = this;

                    if (!instance.get('articleIds').length) {
                        Liferay.Util.getWindow(instance.NS).bodyNode.set('innerHTML', instance.renderNoArticlesMessage());
                        return;
                    }

                    var data = Liferay.Util.ns(instance.NS, {
                        articleId: instance.get('articleIds')[instance.get('activeIndex')]
                    });
                    // ajax call

                    Liferay.Util.getWindow(instance.NS).loadingmask.show();
                    A.io.request(instance.get('contentURL'), {
                        method: 'GET',
                        data: data,
                        dataType: 'json', // expects json as response
                        on: {
                            success: function (e) {
                                var data = this.get('responseData');
                                Liferay.Util.getWindow(instance.NS).loadingmask.hide();
                                Liferay.Util.getWindow(instance.NS).bodyNode.set('innerHTML', data);

                                // if title node exists, we set the modal title with its value
                                var titleNode = Liferay.Util.getWindow(instance.NS).bodyNode.one('.tipday-renderer-title');
                                if (titleNode) {
                                    Liferay.Util.getWindow(instance.NS).titleNode.set('innerHTML', titleNode.get('text'));
                                }
                            }
                        }
                    });
                },  

                renderNoArticlesMessage: function() {
                    return '<div class="alert alert-warning">' +
                        '<strong class="lead">Warning</strong> There are no articles to show</a>.' +
                    '</div>';
                },

                destructor: function () {
                    var instance = this;
                    A.Array.invoke(instance._eventHandles, 'detach');
                }
            }
        });

        A.TipDayModal = Modal;
    },
    '', {
        requires: ['liferay-portlet-base']
    }
);