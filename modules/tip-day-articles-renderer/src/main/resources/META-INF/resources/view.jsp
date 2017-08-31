<%@ include file="/init.jsp" %>

<portlet:renderURL var="contentURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
	<portlet:param name="articleId" value="123456"/>
</portlet:renderURL>
<script>
	window.TIPDAY = window.TIPDAY || {};
	window.TIPDAY = {
		contentURL: '<%=contentURL %>'
	};
</script>

