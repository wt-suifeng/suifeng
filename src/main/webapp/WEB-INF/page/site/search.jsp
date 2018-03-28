<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.Site"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Site> sites = (List<Site>) request.getAttribute("sites");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th width="200">ID</th>
		<th width="200">名称</th>
		<th width="200">地址</th>
		<th width="200">简介</th>
		<th width="200">开放</th>
	</tr>
	<%
		for (Site e : sites) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=e.getId()%>"
			id="woUserListPanel_<%=e.getId()%>" /></td>
		<td class="woTableTd"><%=e.getId()%></td>
		<td class="woTableTd"><%=e.getName()%></td>
		<td class="woTableTd"><%=e.getPlace()%></td>
		<td class="woTableTd"><%=e.getDescription()%></td>
		<td class="woTableTd"><%=e.getOpen()%></td>
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>