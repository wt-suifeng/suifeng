<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.Scene"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Scene> scenes = (List<Scene>) request.getAttribute("scenes");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th width="200">ID</th>
		<th width="200">景区名</th>
		<th width="200">描述</th>
	</tr>
	<%
		for (Scene s : scenes) {
			//String parentName = m.getParent() == null ? "" : m.getParent().getName();
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=s.getId()%>"
			id="woUserListPanel_<%=s.getId()%>" /></td>
		<td class="woTableTd"><%=s.getId()%></td>
		<td class="woTableTd"><%=s.getName()%></td>
		<td class="woTableTd"><%=s.getDescription()%></td>
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>
<script>
	<%-- Wobb.totalUsers = <%=pgUsers.getTotal()%>; --%>


</script>


