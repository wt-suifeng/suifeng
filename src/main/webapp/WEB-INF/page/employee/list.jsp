<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%
	// String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
	//		+ request.getContextPath() + "/";
	//List<Menu> menus = (List<Menu>) request.getAttribute("menus");
%>
<div class="panel hidden" id="woUserSearchPanel">
	<div class="panel-head" id="woUserSearchPanelHeader">
		<span class='icon-times float-right rotate'></span>
		<h4 class="icon-search">&nbsp;查询</h4>
	</div>
	<div class="panel-body padding-small" id="woUserSearchPanelBody">
		<form onsubmit="return false;" class="form-inline" id="woUserSearchForm">
			<div class="form-group">
				<div class="label">
					<label for="loginName">&nbsp;&nbsp;&nbsp;&nbsp;登录名</label>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="field">
					<input type="text" class="input" id="loginName" name="loginName"
						maxlength="50" value="" placeholder="" onblur="$('#woUserPageStart').val(0);"/>
				</div>
			</div>
			<button type="button" class="button button-small bg-main"
				onclick="Wobb.searchUser();">
				<span class="icon-search text-white">&nbsp;查询</span>
			</button>
		</form>
	</div>
</div>
<div class="panel" id="woUserListPanel">
	<div class="panel-head" id="woUserListPanelHeader">
		<form onsubmit="return false;" id="woUserSearchPageForm">
			<span class='icon-search float-right' id="woUserListPanelShowSearch" onclick="$('#woUserSearchPanel').removeClass ('hidden')"></span>
			<span>
				<span class='icon-step-backward' onclick="Wobb.loadUserFirstPage();"> </span>
				<span class='icon-backward' onclick="Wobb.loadUserLastPage();"></span>
				<span class="text-gray" id="woUserPageText">用户列表</span>
				<span class='icon-forward' onclick="Wobb.loadUserNextPage();"> </span>
				<span class='icon-step-forward' onclick="Wobb.loadUserFinalPage();"> </span>
				<span class='icon-refresh'></span>
			</span>
			<input type="hidden" class="input" id="woUserPageStart" name="woPageStart" value="0" />
			<input type="hidden" class="input" id="woUserPageSize" name="woPageSize" value="10" />
		</form>
	</div>
	
	<div class="panel-body-little woPanelBody">
		<form method="post" id="woUserListPanelHeaderForm">
			<div class="padding-small border-bottom">
				<input type="button" class="button button-small checkall"
					name="checkall" value="全选"/>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadUserCreateForm();">
					<span>创建</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadUserUpdateForm();">
					<span>修改</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-yellow icon-minus-circle" onclick="Wobb.deleteUsers ();">
					<span>删除</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-file-excel-o" onclick="Wobb.loadUserImportForm();">
					<span>导入</span>
				</button>
			</div>
			<div id="woUserListPanelBody">
				<!-- 点击查询按钮时，下面内容会被替换 -->
				<jsp:include page="search.jsp"></jsp:include>
			</div>
		</form>
	</div>
</div>