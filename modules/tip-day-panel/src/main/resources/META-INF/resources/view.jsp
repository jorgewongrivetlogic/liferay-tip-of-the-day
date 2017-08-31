<%@ include file="/init.jsp" %>

	<%-- <liferay-ui:success key='<%= SiteAdminPortletKeys.SITE_SETTINGS + "requestProcessed" %>' message="site-was-added" /> --%>


		<aui:form action="" cssClass="container-fluid-1280" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveGroup();" %>'>
			<aui:fieldset-group markupView="lexicon">

				<aui:fieldset>
					<h2>
						<liferay-ui:message key="tip-day-panel.caption" />
					</h2>
					
					<aui:field-wrapper name="categoriesIds" label="Select the categories of the webcontent to display">
						<aui:input name="categoriesIds" value="" type="hidden"/>
						<liferay-ui:asset-categories-selector curCategoryIds="" />
					</aui:field-wrapper>

					<aui:field-wrapper name="tips-often" label="Select how often the tips will be shown">
						<div class="clearfix"></div>
						<aui:input
							inlineLabel="right" 
							name="tips-often"
							type="radio" 
							value=""
							label="Each Login"
							checked=""/>
						<div class="clearfix"></div>
						<aui:input
							inlineLabel="right"
							name="tips-often"
							type="radio" 
							value="" 
							label="Interval of days"
							checked="$" />
						<div class="clearfix"></div>
						<aui:input name="tipsInterval" value="" type="number" min="1" label="" />	
					</aui:field-wrapper>

					<aui:field-wrapper name="showTitle" label="Check to show the title of the selected article in the modal's titlebar">
						<div class="clearfix"></div>
						<label>
							<input class="toggle-switch" type="checkbox">
							<!-- <span class="toggle-switch-label">Show tips at login</span> -->
					
							<span aria-hidden="true" class="toggle-switch-bar">
								<span class="toggle-switch-handle" data-label-off="NO" data-label-on="YES">
								</span>
							</span>
						</label>
					</aui:field-wrapper>
					
					<aui:button-row>
						<aui:button cssClass="btn-lg" type="submit" />
					</aui:button-row>
				</aui:fieldset>

			</aui:fieldset-group>


		</aui:form>