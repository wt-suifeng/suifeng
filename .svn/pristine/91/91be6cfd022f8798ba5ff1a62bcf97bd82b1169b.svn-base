<%@page import="com.qfedu.lvyou.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	// List<Employee> menus = (List<Employee>) request.getAttribute("employee");
%>
<div class="panel hidden" id="woGuestSearchPanel">
	<div class="panel-head" id="woGuestSearchPanelHeader">
		<span class='icon-times float-right rotate'></span>
		<h4 class="icon-search">&nbsp;查询</h4>
	</div>
	<div class="panel-body padding-small" id="woGuestSearchPanelBody">
		<form onsubmit="return false;" class="form-inline" id="woGuestSearchForm">
			<div class="form-group">
				<div class="label">
					<label for="Name">&nbsp;&nbsp;&nbsp;&nbsp;名称</label>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="field">
					<input type="text" class="input" id="Name" name="name"
						maxlength="50" value="" placeholder="" />
				</div>
			</div>
			<button type="button" class="button button-small bg-main"
				onclick="Wobb.searchEmployee();">
				<span class="icon-search text-white">&nbsp;查询</span>
			</button>
		</form>
	</div>
</div>
<div class="panel" id="woGuestListPanel">
	<div class="panel-head" id="woGuestListPanelHeader">
		<form onsubmit="return false;">
			<span class='icon-search float-right' id="woGuestListPanelShowSearch" onclick="$('#woGuestSearchPanel').removeClass ('hidden')"></span>
			<h4>游客列表</h4>
		</form>
	</div>
	
	<div class="panel-body-little woPanelBody">
		<form method="post" id="woGuestListPanelHeaderForm">
			<div class="padding-small border-bottom">
				<input type="button" class="button button-small checkall"
					name="checkall" value="全选"/>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadEmployeeCreateForm();">
					<span>创建</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadEmployeeUpdateForm();">
					<span>修改</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-yellow icon-minus-circle" onclick="Wobb.deleteEmployees();">
					<span>删除</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadImportEmployeeForm();">
					<span>导入数据</span>
				</button>
			</div>
			<div id="woGuestListPanelBody">
				<!-- 点击查询按钮时，下面内容会被替换 -->
				<jsp:include page="search.jsp"></jsp:include>
			</div>
		</form>
	</div>
</div>