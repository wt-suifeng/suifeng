<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.Menu"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Menu> menus = (List<Menu>) request.getAttribute("menus");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">名称</th>
		<th th:width="*">URL</th>
		<th th:width="200">上级</th>
	</tr>
	<%
		for (Menu m : menus) {
			request.setAttribute("menu", m);
			// String parentName = m.getParent() == null ? "" : m.getParent().getName();
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="${menu.id}"
			id="woUserListPanel_${menu.id}" /></td>
		<td class="woTableTd">${menu.id}</td>
		<td class="woTableTd">${menu.name}</td>
		<td class="woTableTd">${menu.url}</td>
		<td class="woTableTd">${menu.parent.name}</td>
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>