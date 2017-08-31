<%@ include file="/init.jsp" %>

<portlet:renderURL var="contentURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="articleId" value="123456"/>
</portlet:renderURL>
<!-- set object only if it is not in article render mode  -->
<script>
	window.TIPDAY = window.TIPDAY || {};
	window.TIPDAY = {
		contentURL: '<%=contentURL %>'
	};
</script>
<liferay-ui:asset-display className="<%= JournalArticle.class.getName() %>" classPK="31431"></liferay-ui:asset-display>
<c:choose>
	<c:when test="${not empty article}">
		<liferay-ui:asset-display className="<%= JournalArticle.class.getName() %>" classPK="31431"></liferay-ui:asset-display>
		<!-- template = resource prim key -->
	</c:when>
	<c:otherwise>
		<div class="portlet-msg-info">
			<liferay-ui:message key="no-tips-to-display"/>
		</div>
	</c:otherwise>
</c:choose>
