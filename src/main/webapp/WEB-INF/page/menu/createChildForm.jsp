﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.Menu"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	Menu parentMenu = (Menu) request.getAttribute("parentMenu");
	String parentId = parentMenu == null ? "" : parentMenu.getId();
	String parentName = parentMenu == null ? "" : parentMenu.getName();
%>
<div>
	<form method="post" class="form-x" id="woMenuCreateChildForm">
		<div class="form-group">
			<div class="label">
				<label for="id">ID</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="id" name="id" size="50"
					placeholder="请输入ID" data-validate="required:必填 " />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="name">名称</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="name" name="name" size="50"
					placeholder="请输入名称" data-validate="required:必填 " />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="icon">图标</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="icon" name="icon" size="50"
					placeholder="请输入图标" data-validate="required:必填 " value="icon-asterisk"/>
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="url">URL</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="url" name="url" size="50"
					placeholder="请输入URL" />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="no">编号</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="no" name="no" size="50"
					placeholder="请输入编号" data-validate="required:必填 " />
			</div>
		</div>
		<div class="form-group">
			<div class="label">
				<label for="parent.id">上级菜单</label>
			</div>
			<div class="field">
				<input type="text" class="input" id="parent.name" name="parent.name"
					size="50" placeholder="" value="<%=parentName%>"
					readonly="readonly" />
				<input type="hidden" id="parent.id"
					name="parent.id" size="50" placeholder="" value="<%=parentId%>" />
			</div>
		</div>
		<div class="form-button">
			<button class="button bg-main icon-save" type="button"
				onclick="Wobb.submitMenuChildForm();">保存</button>
			<button class="button bg-yellow icon-arrow-circle-right"
				type="button" onclick="WoKit.destroyMainFrame();">取消</button>
		</div>
	</form>
</div>