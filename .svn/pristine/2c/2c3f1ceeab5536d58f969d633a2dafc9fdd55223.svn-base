<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.TicketRecord"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<TicketRecord> ticketRecords = (List<TicketRecord>) request.getAttribute("ticketRecords");
%>
<table class="table table-hover table-condensed">
	<tr>
		<th width="45" style="text-align: center">选择</th>
		<th th:width="200">ID</th>
		<th th:width="200">购票说明</th>
		<th th:width="200">购票时间</th>
	</tr>
	<%
		for (TicketRecord t : ticketRecords) {
	%>
	<tr>
		<td style="text-align: center"><input type="checkbox"
			name="woSelectedIds" value="<%=t.getId()%>"
			id="woTicketRecordListPanel_<%=t.getId()%>" /></td>
		<td class="woTableTd"><%=t.getId()%></td>
		<td class="woTableTd"><%=t.getInstruction()%></td>
		<td class="woTableTd"><%=t.getTime()%></td>
	</tr>
	<%
		// [{woSelectedIds:val1},{}...] - > woSelectedIds:val1,val2
		}
	%>
</table>