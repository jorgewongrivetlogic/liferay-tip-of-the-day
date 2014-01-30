<%
/**
* Copyright (C) 2005-2014 Rivet Logic Corporation.
*
* This program is free software; you can redistribute it and/or
* modify it under the terms of the GNU General Public License
* as published by the Free Software Foundation; version 2
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
%>

<%@include file="/html/init.jsp" %>

<%
boolean stopShowing = GetterUtil.getBoolean(request.getAttribute("stopShowing"));
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
		<li class="nav-item-label switch-btn"> 
			<a href="#" class="switch-off-on <%= stopShowing ? "off" : "on"%>">
				<span><%= stopShowing ? "off" : "on"%></span>
			</a>
		</li>
	</ul>
</li>

<portlet:renderURL var="contentURL" windowState="<%=LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcPath" value="/html/dockbar/content.jsp"/>
	<portlet:param name="articleIds" value="${articleIds}"/>
	<portlet:param name="articleId" value="${nextArticleId}"/>
</portlet:renderURL>

<aui:script use="tip-of-the-day-dockbar">
	var tipOfTheDay = new A.TipOfTheDay({
		container: A.one('#<portlet:namespace/>tip-of-the-day-menu'),
		portletId: '<%= portletId %>',
		portletNamespace: '<portlet:namespace/>',
		contentURL: '<%= contentURL %>',
	<c:if test="${showTips eq true }">
		showPopUp: true 
	</c:if>
	});
</aui:script>