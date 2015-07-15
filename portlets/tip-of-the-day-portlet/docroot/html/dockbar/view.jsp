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

<%
boolean stopShowing = GetterUtil.getBoolean(request.getAttribute(WebKeys.STOP_SHOWING));
boolean showAllTips = (Boolean) request.getAttribute(WebKeys.SHOW_ALL_TIPS);
%>

<li id="<portlet:namespace/>tip-of-the-day-menu" class="tip-of-the-day-help dropdown dockbar-item" role="presentation"> 
	<a class="dropdown-toggle" href="#" role="menuitem" title="">
 	<span class="icon-question-sign"> <!-- Help --> </span> 
	</a> 
	<ul class="taglib-tip-of-the-day-help dropdown-menu tip-of-the-day-menu"> 
		<li class="tip-of-the-day-menu display-tips-of-the-day display-pop-up"> 
			<a href="javascript:;"> 
				<span class="nav-item-label"><liferay-ui:message key="tof-display"/></span>
			</a>  
		</li>

		<li class="nav-item-label tof-checkbox-label">
			<a href="javascript:;" class="tof-checkbox-a"> 
				<span class="pull-left"><liferay-ui:message key="tof-show-tips"/></span>
				<input id="tof-checkbox-show" class="tof-checkbox pull-right" type="checkbox" <c:if test="${!stopShowing}"> checked </c:if> />
			</a>
		</li>
		<li class="nav-item-label tof-checkbox-label">
			<a href="javascript:;" class="tof-checkbox-a">
				<span class="pull-left"><liferay-ui:message key="tof-show-only-new"/></span>
				<input id="tof-checkbox-only-new" class="tof-checkbox pull-right" type="checkbox" <c:if test="${!showAllTips}"> checked </c:if> />
			</a>
		</li>
	</ul>
</li>

<portlet:renderURL var="contentURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="<%=WebKeys.MVC_PATH%>" value="<%=TipOfTheDayDockbarPortlet.CONTENT_VIEW%>"/>
	<portlet:param name="<%=WebKeys.ARTICLE_ID%>" value="${nextArticleId}"/>
</portlet:renderURL>

<aui:script use="tip-of-the-day-dockbar">
	var tipOfTheDay = new A.TipOfTheDay({
		container: A.one('#<portlet:namespace/>tip-of-the-day-menu'),
		portletId: '<%= portletId %>',
		portletNamespace: '<portlet:namespace/>',
		contentURL: '<%= contentURL %>',
		<c:choose>
			<c:when test="${showTips eq true }">
				showPopUp: true 
			</c:when>
			<c:otherwise>
				showPopUp: false 
			</c:otherwise>
		</c:choose>
	});
</aui:script>