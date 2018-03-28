<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.Advice"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	List<Advice> advices = (List<Advice>) request.getAttribute("advices");
%>
<div class="panel hidden" id="woAdviceSearchPanel">
	<div class="panel-head" id="woAdviceSearchPanelHeader">
		<span class='icon-times float-right rotate'></span>
		<h4 class="icon-search">&nbsp;查询</h4>
	</div>
	<div class="panel-body padding-small" id="woAdviceSearchPanelBody">
		<form onsubmit="return false;" class="form-inline" id="woAdviceSearchForm">
			<div class="form-group">
				<div class="label">
					<label for="name">&nbsp;&nbsp;&nbsp;&nbsp;名称</label>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="field">
					<input type="text" class="input" id="name" name="name"
						maxlength="50" value="" placeholder="" />
				</div>
			</div>
			<button type="button" class="button button-small bg-main"
				onclick="Wobb.searchAdvice();">
				<span class="icon-search text-white">&nbsp;查询</span>
			</button>
		</form>
	</div>
</div>
<div class="panel" id="woAdviceListPanel">
	<div class="panel-head" id="woAdviceListPanelHeader">
		<form onsubmit="return false;">
			<span class='icon-search float-right' id="woAdviceListPanelShowSearch" onclick="$('#woAdviceSearchPanel').removeClass ('hidden')"></span>
			<h4>菜单列表</h4>
		</form>
	</div>
	
	<div class="panel-body-little woPanelBody">
		<form method="post" id="woAdviceListPanelHeaderForm">
			<div class="padding-small border-bottom">
				<input type="button" class="button button-small checkall"
					name="checkall" value="全选"/>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadAdviceCreateForm();">
					<span>创建</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadAdviceUpdateForm();">
					<span>修改</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-yellow icon-minus-circle" onclick="Wobb.deleteAdvices ();">
					<span>删除</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadAdviceReletedMenuList();">
					<span>设置菜单</span>
				</button>
			</div>
			<div id="woAdviceListPanelBody">
				<!-- 点击查询按钮时，下面内容会被替换 -->
				<jsp:include page="search.jsp"></jsp:include>
			</div>
		</form>
	</div>
</div>