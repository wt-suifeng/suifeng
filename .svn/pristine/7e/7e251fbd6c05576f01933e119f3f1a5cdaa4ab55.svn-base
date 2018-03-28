<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.Advice"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Advice> advices = (List<Advice>) request.getAttribute("advices");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">标题</th>
		<th th:width="*">内容</th>
		<th th:width="200">发布时间</th>

	</tr>
	<%
		for (Advice a : advices) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=a.getId()%>"
			id="woUserListPanel_<%=a.getId()%>" /></td>
		<td class="woTableTd"><%=a.getId()%></td>
		<td class="woTableTd"><%=a.getTitle()%></td>
		<td class="woTableTd"><%=a.getContent()%></td>
		<td class="woTableTd"><%=a.getTime().toGMTString()%></td>
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>