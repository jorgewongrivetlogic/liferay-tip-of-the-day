/**
* Copyright (C) 2005-2014 Rivet Logic Corporation.
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; version 3
* of the License.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 51 Franklin Street, Fifth Floor,
* Boston, MA 02110-1301, USA.
*/

AUI.add('tip-of-the-day-dockbar', function (A, NAME) {
	
	A.TipOfTheDay = A.Base.create('tip-of-the-day-dockbar', A.Base, [], {
		switchButtons : null,
		closeButtons : null,
		portletId : null,
		portletNamespace: null,
		showCheckboxes : null,
		dropdowns: null,
		modal: null,
		menuOptionsDisplay: null,
		contentURL: null,
		
		initializer: function(){
			var box = this.get('container');
			this.portletId = this.get('portletId');
			this.portletNamespace = this.get('portletNamespace');
			this.switchButtons = box.all(".switch-off-on");
			this.closeButtons = box.all(".tofd-close-pop-up");
			this.showCheckboxes = box.all(".ajax-checkbox-action");
			this.dropdowns = box.all(".dropdown-toggle");
			this.menuOptionsDisplay = box.all(".tip-of-the-day-menu .display-pop-up");
			this.contentURL = this.get('contentURL');
			this.setClosePortletAction();
			this.setInnerContent();
			this.setComponents(box);
			if (this.get('showPopUp')) {
				this.showPopUp();
			}
			this.setScrollHeight();
		},
		
		setComponents: function(container) {
			var instance = this;
			
			this.switchButtons.each(function(switchButton){
				instance.chooseDisplayPopUp(switchButton, 
					function(switchButton, e){
						e.stopPropagation();
						e.preventDefault();
						var switchState;
						if (switchButton.hasClass('on')) {
							switchButton.removeClass('on');
							switchButton.addClass('off');
							switchButton.get('children').filter('span').text('Off');
							switchState = false;
						} else {
							switchButton.removeClass('off');
							switchButton.addClass('on');
							switchButton.get('children').filter('span').text('On');
							switchState = true;
						}
						return !switchState;
					}
				);
				
				switchButton.on('mouseover', function(e){
					var thisElement = this;
					new A.Tooltip({
		    		   	bodyContent: Liferay.Language.get('tof-switch'),
		    		    trigger: '#'+thisElement.get('id'),
		    		    opacity: 1,
		    		    cssClass:'tooltip-switch-btn',
		    		    showArrow: false,
		    		    position: 'left'
		 			}).render();
				});
			});
			
			this.closeButtons.each(function(closeButton){
				closeButton.on('click', 
						new Function(instance.closePopUpFunctionName + '();')
				);
			});
			
			this.showCheckboxes.each(function(checkbox){
				instance.chooseDisplayPopUp(checkbox, 
						function(box){
							return box.get('checked');
						}
				);	
			});
			
			this.dropdowns.each(function(dropdown){
				dropdown.on('click', function(e){
					e.stopPropagation();
					e.preventDefault();
					ul = dropdown.get('parentNode');
					if (ul){
						if (!ul.hasClass('open')){
							ul.addClass('open');
						} else{
							ul.removeClass('open');
						}
					}
				});
			});
			
			this.menuOptionsDisplay.each(function(menuOption){
				menuOption.on('click', function(e){
					e.preventDefault();
			        if (instance.modal) {
			        	instance.modal.show();
			        	instance.modal.align();
			        } else {
			        	instance.showPopUp();
			        }
				});
			});
			
			/*Manage dispay of the help menu in the dockbar*/
			(function(menu){
				A.one('body').on('click', function(e){
					if (menu.hasClass('open')){
						menu.removeClass('open');
					}
				});
			})(container);
		},
		
		setClosePortletAction: function() {
			var instance = this;
			
			instance.closePopUpFunctionName = 
				instance.portletNamespace + 'closePopUp';
			
			Liferay.provide(
				window,
				instance.closePopUpFunctionName,
				function() {
					Liferay.fire(
						'closeWindow',
						{
							id: instance.portletId    					
						}
					);
				}
			);
		},
		
		/*Ajax call to change user preference about displaying the pop up*/
		chooseDisplayPopUp: function(element, func) {
			var instance = this;
			if (element) {
				element.on('click', function(e){
					var resourceURL= Liferay.PortletURL.createResourceURL();
					resourceURL.setPortletId(instance.portletId);
					resourceURL.setParameter('cmd', 'DISPLAY');
					resourceURL.setParameter('stopShowing', func(element, e));
					A.io(resourceURL.toString(), {
						method: 'POST',
						on: {
							failure: function () {
								if (console) { 
									console.error('failure on ajax call');
								}
							}
						}
					});
				});
			}
		},
		
		/*Resizes the pop up when the content changes*/
		setInnerContent : function() {
			var instance = this;
			Liferay.provide(window, 'setInnerContent', function(heigth) {
			    var dialog = {
			        bodyNode: A.one(".modal:visible")
			    };
			    instance.setContentHeight(dialog, heigth);
			});
		},
		
		setContentHeight: function(self, height) {
			var instance = this;
			var modal = self.bodyNode;
		    instance.setElementHeight(modal, height);
		},
		
		setElementHeight: function(element, height) {
			var instance = this;
			var visibleAreaHeight = A.one('body').get('winHeight');
			var GAP_SIZE = 110;
			height = (height > (visibleAreaHeight - GAP_SIZE)) ? 
					(visibleAreaHeight - (GAP_SIZE - 100)) : (height + GAP_SIZE);
			instance.modal.set('height', height);
			instance.modal.align();
		},
		
		showPopUp: function() {
			var instance = this;
			Liferay.Util.openWindow(
				{
					dialog: {
	                    width: 600,
	                    height: 400,
	                    centered: true
	                },
					xy: ['center', 'center'],
					id: instance.portletId, 
					title: Liferay.Language.get('tip-of-the-day'),
					uri: instance.contentURL
				}, function(modal) {
						instance.modal = modal;
						instance.modal.after('visibleChange', function(){
							if (instance.modal.get('visible') == false ) {
								instance.setUserVisitance();
							}
						});
	            }
			);
		},
		
		setScrollHeight: function() {
			A.on("domready", function(e){
				var contentPopUp = A.one('.tip-ctn');
				if (contentPopUp) {
					window.parent.setInnerContent(contentPopUp.get('scrollHeight'));			
				}
			});
		},
		
		setUserVisitance: function() {
			var instance = this;
			
			var resourceURL= Liferay.PortletURL.createResourceURL();
			resourceURL.setPortletId(instance.portletId);
			resourceURL.setParameter('cmd', 'USER_STATUS');
			A.io(resourceURL.toString(), {
				method: 'POST',
				on: {
					failure: function () {
						if (console) { 
							console.error('failure on ajax call');
						}
					}
				}
			});
		}
		
    }, {
        ATTRS: {
            container: {
                value: null
            },
            portletId: {
            	value: null
            },
            portletNamespace: {
            	value: null
            },
            contentURL: {
            	value: null
            },
            showPopUp: {
            	value: false
            }
        }
    });

}, '@VERSION@', {
    "requires": ["yui-base", "base-build", "node", "event", "io", 
                 "liferay-portlet-url", "aui-tooltip", "aui-io-plugin"]
});
