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
boolean disablePrev = GetterUtil.getBoolean(request.getAttribute("disablePrev"));
boolean disableNext = GetterUtil.getBoolean(request.getAttribute("disableNext"));
boolean stopShowing = GetterUtil.getBoolean(request.getAttribute(WebKeys.STOP_SHOWING));
%>

<portlet:renderURL var="previousURL">
	<portlet:param name="<%=WebKeys.MVC_PATH%>" value="<%=TipOfTheDayDockbarPortlet.CONTENT_VIEW%>"/>
	<portlet:param name="<%=WebKeys.ARTICLE_IDS%>" value="${articleIds}"/>
	<portlet:param name="<%=WebKeys.VISITED%>" value="${visited}"/>
	<portlet:param name="<%=WebKeys.ARTICLE_ID%>" value="${prevArticleId}"/>
</portlet:renderURL>

<portlet:renderURL var="nextURL">
	<portlet:param name="<%=WebKeys.MVC_PATH%>" value="<%=TipOfTheDayDockbarPortlet.CONTENT_VIEW%>"/>
	<portlet:param name="<%=WebKeys.ARTICLE_IDS%>" value="${articleIds}"/>
	<portlet:param name="<%=WebKeys.VISITED%>" value="${visited}"/>
	<portlet:param name="<%=WebKeys.ARTICLE_ID%>" value="${nextArticleId}"/>
</portlet:renderURL>

<div id="<portlet:namespace/>" class="tip-ctn">
    <div class="tip-content">
        <c:choose>
            <c:when test="${not empty articleId}">
                <liferay-ui:journal-article groupId="<%=themeDisplay.getScopeGroupId()%>" articleId="${articleId}" />
            </c:when>
            <c:otherwise>
                <div class="portlet-msg-info">
                    <liferay-ui:message key="no-tips-to-display"/>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="clearfix"></div>
    <br/>
    <div class="tip-buttons">
        <aui:input name="<%=WebKeys.STOP_SHOWING%>" label="tof-dont-show" type="checkbox" checked="<%= stopShowing %>" cssClass="ajax-checkbox-action" />
        <aui:button name="previous" value='<%= LanguageUtil.get(pageContext, "tof-previous") %>' href="<%= previousURL %>" disabled="<%= disablePrev %>"/>
        <aui:button name="next" value='<%= LanguageUtil.get(pageContext, "tof-next") %>' href="<%= nextURL %>" disabled="<%= disableNext %>" />
        <aui:button name="done" value='<%= LanguageUtil.get(pageContext, "tof-done") %>' cssClass="tofd-close-pop-up"/>
        <div class="clearfix"></div>
    </div>
    <div class="clearfix"></div>
</div>

<aui:script use="tip-of-the-day-dockbar">
	var tipOfTheDayContent = new A.TipOfTheDay({
		container: A.one('#<portlet:namespace/>'),
		portletId: '<%= portletId %>',
		portletNamespace: '<portlet:namespace/>'
	});
</aui:script>
