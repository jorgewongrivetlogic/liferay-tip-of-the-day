<%@ include file="/init.jsp" %>
<c:choose>
	
	<c:when test="${tipDayPortletMode != 'renderArticle'}">
		<portlet:renderURL var="contentURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
			<portlet:param name="tipDayPortletMode" value="renderArticle"/>
		</portlet:renderURL>
		<!-- set object only if it is not in article render mode  -->
		<script>
			window.TIPDAY = window.TIPDAY || {};
			window.TIPDAY = {
				portletNamespace: '<portlet:namespace/>',
				contentURL: '<%=contentURL %>',
				resourceURL: '<portlet:resourceURL />',
				articleIds: [${articleIds}],
				<c:choose>
		            <c:when test="${showTips eq true }">
		        showPopUp: true 
		            </c:when>
		            <c:otherwise>
		        showPopUp: false 
		            </c:otherwise>
		        </c:choose>
			};
		</script>
	</c:when>

	<c:otherwise>
		<c:choose>
			<c:when test="${not empty article}">
				<div class="tipday-renderer">
					<c:if test="${showArticleTitle}">
						<h1 class="tipday-renderer-title">${articleTitle}</h1>
					</c:if>
					<div class="tipday-renderer-content">
						<liferay-ui:asset-display className="<%= JournalArticle.class.getName() %>" classPK="${article.getResourcePrimKey()}"></liferay-ui:asset-display>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="portlet-msg-info">
					<liferay-ui:message key="no-tips-to-display"/>
				</div>
			</c:otherwise>
		</c:choose>
	</c:otherwise>

</c:choose>