<%--
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
--%>

<%@include file="/html/init.jsp" %>

<portlet:actionURL name="savePreferences" var="savePreferencesURL">
	<portlet:param name="redirect" value="<%= currentURL %>"/>
</portlet:actionURL>

<aui:form name="tips-of-day-fm" action="<%= savePreferencesURL %>" method="post">

	<aui:fieldset label="tof-category-select">
		<aui:input name="<%=WebKeys.TIPS_CATEGORIES_ID%>" value="${tipsCategoriesId}" type="hidden"/>
		<liferay-ui:asset-categories-selector curCategoryIds="${curCategoryIds}" />
        <div class="clearfix"></div>
	</aui:fieldset>
	<br><br>
	<aui:fieldset label="tof-how-often-select">
		<aui:field-wrapper name="tips-often" label="">
			<aui:input inlineLabel="right" name="<%=WebKeys.TIPS_OFTEN_RADIO%>" type="radio" 
			value="<%=WebKeys.TIPS_EACH_LOGIN%>" label="tof-each-login"  checked="${tipsEachLoginChecked}"/>
			
			<aui:input inlineLabel="right" name="<%=WebKeys.TIPS_OFTEN_RADIO%>" type="radio" 
			value="<%=WebKeys.TIPS_INTERVAL_DAYS%>" label="tof-interval-days" checked="${!tipsEachLoginChecked}" />		
		</aui:field-wrapper>
		<aui:input name="<%=WebKeys.TIPS_INTERVAL_VALUE%>" value="${tipsIntervalValue}" type="number" min="1" label="" />
	</aui:fieldset>
	<br><br>
	<aui:fieldset label="show-article-title-select">
		<aui:input name="<%=WebKeys.SHOW_ARTICLE_TITLE %>" value="${showArticleTitle}" type="checkbox" label="show-article-title" />
	</aui:fieldset>
	<aui:input name="submit" cssClass="btn btn-primary" label="" value='<%= LanguageUtil.get(pageContext, "tof-save-preferences") %>' type="submit"/>
</aui:form>

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
