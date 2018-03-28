<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.User"%>
<%@ page import="com.qfedu.lvyou.model.PageBean"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	PageBean<User> pgUsers = (PageBean<User>) request.getAttribute("pgUsers");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">登录名</th>
	</tr>
	<%
		for (User u : pgUsers.getList()) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=u.getId()%>"
			id="woUserListPanel_<%=u.getId()%>" /></td>
		<td class="woTableTd"><%=u.getId()%></td>
		<td class="woTableTd"><%=u.getLoginName()%></td>
	</tr>
	<%
		}
	%>
</table>
<script>
	Wobb.totalUsers = <%=pgUsers.getTotal()%>;
</script>