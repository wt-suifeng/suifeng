<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.Comment"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Comment> comments = (List<Comment>) request.getAttribute("comments");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">标题</th>
		<th th:width="*">时间</th>
		<th th:width="200">评论</th>
	</tr>
	<%
		for (Comment c : comments) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=c.getId()%>"
			id="woUserListPanel_<%=c.getId()%>" /></td>
		<td class="woTableTd"><%=c.getId()%></td>
		<td class="woTableTd"><%=c.getTitle()%></td>
		<td class="woTableTd"><%=c.getTime()%></td>
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>