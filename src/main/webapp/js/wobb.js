var Wobb = {};

Wobb.submitForm = function(cfg) {
	WoAjaxKit.submitForm(cfg.domSelector, {
		type : "post",
		dataType : "json",
		validateForm : true,
		url : WoKit.basePath + cfg.url,
		success : function(json) {
			WoKit.showInfo(json.msg);
			if (json.code == 1) {
				WoKit.destroyMainFrame();
				if (cfg.success) {
					cfg.success(json);
				}
			}
		},
		error : function(XmlHttpRequest, textStatus, errorThrown) {
			if (XmlHttpRequest.responseJSON) {
				WoKit.showWarn(XmlHttpRequest.responseJSON.message);
			} else {
				WoKit.showWarn('提交失败！');
			}
		}
	});
};

Wobb.loadMenuCreateForm = function() {
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/menu/loadCreateForm'
	});
};

Wobb.submitMenuCreateForm = function() {
	Wobb.submitForm({
		domSelector : '#woMenuCreateForm',
		url : 'sys/menu/create',
		success : Wobb.searchMenu
	});
};

Wobb.loadMenuUpdateForm = function() {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个菜单！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/menu/loadUpdateForm?menuId=' + id
	});
};

Wobb.submitMenuUpdateForm = function() {
	Wobb.submitForm({
		domSelector : '#woMenuUpdateForm',
		url : 'sys/menu/update',
		success : Wobb.searchMenu
	});
};

// 创建子菜单按钮点击事件
Wobb.loadMenuCreateChildForm = function() {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个菜单作为父菜单！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/menu/loadCreateChildForm?parentId=' + id
	});
};

Wobb.submitMenuChildForm = function() {
	Wobb.submitForm({
		domSelector : '#woMenuCreateChildForm',
		url : 'sys/menu/create',
		success : Wobb.searchMenu
	});
};

Wobb.deleteMenus = function() {
	var ids = WoKit.getListSelectedIds('#woMenuListPanelHeaderForm');
	if (WoKit.isEmpty(ids) || ids.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个菜单！');
		return;
	}
	WoKit.showConfirm('确认删除选中的菜单吗？', function() {
		WoAjaxKit.requestJson({
			url : WoKit.basePath + 'sys/menu/delete?menuId=' + ids,
			success : Wobb.searchMenu
		});
	});
};

Wobb.searchMenu = function () {
	// 获取查询参数 : {loginName : ''}
	var data = WoKit.getFormData('#woMenuSearchForm');
	// 加载html覆盖列表body
	WoAjaxKit.load({
		domSelector : '#woMenuListPanelBody',
		url : WoKit.basePath + 'sys/menu/search',
		data : data
	});
};

Wobb.loadUserCreateForm = function() {
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/user/loadCreateForm'
	});
};

Wobb.submitUserCreateForm = function() {
	Wobb.submitForm({
		domSelector : '#woUserCreateForm',
		url : 'sys/user/create',
		success : Wobb.searchUser
	});
};

Wobb.searchUser = function () {
	// 获取查询参数 : { loginName : ''}
	// 查找id以woUserSearch开头的form
	var data = WoKit.getFormData("form[id^='woUserSearch']");
	// 加载html覆盖列表body
	WoAjaxKit.load({
		domSelector : '#woUserListPanelBody',
		url : WoKit.basePath + 'sys/user/search',
		data : data
	});
};

Wobb.loadUserUpdateForm = function() {
	var id = WoKit.getListSelectedIds();
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个用户！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/user/loadUpdateForm?userId=' + id
	});
};

Wobb.submitUserUpdateForm = function() {
	Wobb.submitForm({
		domSelector : '#woUserUpdateForm',
		url : 'sys/user/update',
		success : Wobb.searchUser
	});
};

Wobb.deleteUsers = function() {
	var ids = WoKit.getListSelectedIds('#woUserListPanelHeaderForm');
	if (WoKit.isEmpty(ids)) {
		WoKit.showWarn('请至少选择一个用户！');
		return;
	}
	WoKit.showConfirm('确认删除选中的用户吗？', function() {
		WoAjaxKit.requestJson({
			url : WoKit.basePath + 'sys/user/delete?userIds=' + ids,
			success : Wobb.searchUser
		});
	});
};

// 用户保存用户总数
Wobb.totalUsers = 0;

Wobb.loadUserFirstPage = function () {
	// 设置page表单中的hidden字段
	$('#woUserPageStart').prop('value', 0);
	// 提交
	Wobb.searchUser();
};

Wobb.loadUserLastPage = function () {
	// 获取page表单中的hidden字段
	var pageStart = parseInt($('#woUserPageStart').val());
	var pageSize = parseInt($('#woUserPageSize').val());
	// 计算分页参数
	if ((pageStart - pageSize) >= 0) {
		pageStart -= pageSize;
	}
	// 设置page表单中的hidden字段
	$('#woUserPageStart').prop('value', pageStart);
	// 提交
	Wobb.searchUser();
};

Wobb.loadUserNextPage = function () {
	// 获取page表单中的hidden字段
	var pageStart = parseInt($('#woUserPageStart').val());
	var pageSize = parseInt($('#woUserPageSize').val());
	// 计算分页参数
	if ((pageStart + pageSize) < Wobb.totalUsers) {
		pageStart += pageSize;
	}
	// 设置page表单中的hidden字段
	$('#woUserPageStart').prop('value', pageStart);
	// 提交
	Wobb.searchUser();
};

Wobb.loadUserFinalPage = function () {
	// 获取page表单中的hidden字段
	var pageStart = parseInt($('#woUserPageStart').val());
	var pageSize = parseInt($('#woUserPageSize').val());
	// 计算分页参数
	pageStart = Math.floor(Wobb.totalUsers / pageSize) * pageSize;
	if (pageStart == Wobb.totalUsers) {
		pageStart -= pageSize;
	}
	// 设置page表单中的hidden字段
	$('#woUserPageStart').prop('value', pageStart);
	// 提交
	Wobb.searchUser();
};

// 角色列表中的“设置菜单”按钮的点击响应事件
Wobb.loadRoleRelatedMenuList = function() {
	var id = WoKit.getListSelectedIds('#woRoleListPanelHeaderForm');
	if (WoKit.isEmpty(id) || id.indexOf(',') > 0) {
		WoKit.showWarn('请选择一个角色！');
		return;
	}
	WoKit.loadMainFrame({
		url : WoKit.basePath + 'sys/role/loadRelatedMenuList?roleId=' + id
	});
};

// 角色的关联菜单列表中，保存按钮的点击响应事件
Wobb.submitRoleRelatedMenus = function (roleId) {
	// 获取选中的菜单id，多个以逗号隔开
	var ids = WoKit.getListSelectedIds('#woMenuListPanelHeaderForm');
	if (WoKit.isEmpty(ids)) {
		WoKit.showWarn('请选择至少一个菜单！');
		return;
	}
	// 发送ajax-json请求，传入角色ID及多个菜单ID
	WoAjaxKit.requestJson({
		url : WoKit.basePath + 'sys/role/relateMenus?roleId=' + roleId + '&menuIds=' + ids,
		success : WoKit.destroyMainFrame
	});
};