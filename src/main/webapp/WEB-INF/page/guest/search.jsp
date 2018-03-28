<%@page import="com.qfedu.lvyou.model.Guest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Guest> guests = (List<Guest>)request.getAttribute("guests");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="100" style="text-align: center">选择</th>
		<th width="200">ID</th>
		<th width="200">姓名</th>
		<th width="50">性别</th>
		<th width="200">生日</th>
		<th width="300">联系电话</th>
		<th width="200">身份证</th>
	</tr>
	<%
		for (Guest m : guests) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=m.getId()%>"
			id="woUserListPanel_<%=m.getId()%>" /></td>
		<td class="woTableTd"><%=m.getId()%></td>
		<td class="woTableTd"><%=m.getName() %></td>
		<td class="woTableTd"><%=m.getSex() %></td>
		<td class="woTableTd"><%=m.getBirthday() %></td>
		<td class="woTableTd"><%=m.getMobile() %></td>
		<td class="woTableTd"><%=m.getIdCard() %></td>
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>
<script>

</script>