<%@ include file="/init.jsp" %>
<portlet:actionURL name="savePreferences" var="savePreferencesURL">
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:actionURL>

<aui:form action="<%=savePreferencesURL %>" cssClass="container-fluid-1280" method="post">
	<aui:fieldset-group markupView="lexicon">

		<aui:fieldset>
			<h2>
				<liferay-ui:message key="tip-day-panel.caption" />
			</h2>
            <!-- categories selection -->
			<aui:field-wrapper name="categoriesIds" label="Select the categories of the webcontent to display">
				<aui:input name="<%=WebKeys.TIPS_CATEGORIES_ID%>" value="${tipsCategoriesId}" type="hidden"/>
				<liferay-ui:asset-categories-selector curCategoryIds="${curCategoryIds}" />
			</aui:field-wrapper>

            <!-- config how often tips are displayed -->
			<aui:field-wrapper name="tips-often" label="Select how often the tips will be shown">
				<div class="clearfix"></div>
				<aui:input inlineLabel="right" 
				    name="<%=WebKeys.TIPS_OFTEN_RADIO%>" 
				    type="radio" 
				    value="<%=WebKeys.TIPS_EACH_LOGIN%>" 
				    label="Each Login" 
				    checked="${tipsEachLoginChecked}" />
				<div class="clearfix"></div>
				<aui:input inlineLabel="right"
				    name="<%=WebKeys.TIPS_OFTEN_RADIO%>" 
				    type="radio" 
				    value="<%=WebKeys.TIPS_INTERVAL_DAYS%>" 
				    label="Interval of days" 
				    checked="${!tipsEachLoginChecked}" />
				<div class="clearfix"></div>
				<aui:input name="<%=WebKeys.TIPS_INTERVAL_VALUE%>" value="${tipsIntervalValue}" type="number" min="1" label="" />
			</aui:field-wrapper>

            <!-- show article title when displaying tip -->
			<aui:field-wrapper name="showTitle" label="Check to show the title of the selected article in the modal's titlebar">
				<div class="clearfix"></div>
				<label>
					<input name="<portlet:namespace/><%=WebKeys.SHOW_ARTICLE_TITLE %>" <c:if test="${showArticleTitle}">checked="checked"</c:if> class="toggle-switch" type="checkbox">
					<!-- <span class="toggle-switch-label">Show tips at login</span> -->
			
					<span aria-hidden="true" class="toggle-switch-bar">
						<span class="toggle-switch-handle" data-label-off="NO" data-label-on="YES">
						</span>
					</span>
				</label>
			</aui:field-wrapper>
            
            <!-- submit -->
			<aui:button-row>
				<aui:button cssClass="btn-lg" type="submit" />
			</aui:button-row>
			
		</aui:fieldset>

	</aui:fieldset-group>

</aui:form>

<!-- Toggle the how often tip is displayed configuration  -->
<aui:script use="aui-base"> 
    <c:choose>
        <c:when test="${tipsEachLoginChecked}">
            A.one('#<portlet:namespace/><%=WebKeys.TIPS_INTERVAL_VALUE%>').hide();
        </c:when>
        <c:otherwise>
            A.one('#<portlet:namespace/><%=WebKeys.TIPS_INTERVAL_VALUE%>').show();
        </c:otherwise>
    </c:choose>
    
    A.all('[name=<portlet:namespace/><%=WebKeys.TIPS_OFTEN_RADIO%>]').on('click', function(){
            
        var tipsOften = A.one('[name=<portlet:namespace/><%=WebKeys.TIPS_OFTEN_RADIO%>]:checked').get('value');
        
        if (tipsOften == '<%=WebKeys.TIPS_EACH_LOGIN%>'){
            A.one('#<portlet:namespace/><%=WebKeys.TIPS_INTERVAL_VALUE%>').hide();
        }
        else{
            A.one('#<portlet:namespace/><%=WebKeys.TIPS_INTERVAL_VALUE%>').show();
        }
    });
</aui:script>