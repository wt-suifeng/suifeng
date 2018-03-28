<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.qfedu.lvyou.model.TicketRecord"%>
<%@ page import="java.util.List"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
	//List<TicketRecord> menus = (List<TicketRecord>) request.getAttribute("TicketRecords");
%>
<div class="panel hidden" id="woTicketRecordSearchPanel">
	<div class="panel-head" id="woTicketRecordSearchPanelHeader">
		<span class='icon-times float-right rotate'></span>
		<h4 class="icon-search">&nbsp;查询</h4>
	</div>
	<div class="panel-body padding-small" id="woTicketRecordSearchPanelBody">
		<form onsubmit="return false;" class="form-inline" id="woTicketRecordSearchForm">
			<div class="form-group">
				<div class="label">
					<label for="name">&nbsp;&nbsp;&nbsp;&nbsp;姓名</label>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="field">
					<input type="text" class="input" id="name" name="name"
						maxlength="50" value="" placeholder="" />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label for="phone">&nbsp;&nbsp;&nbsp;&nbsp;电话</label>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="field">
					<input type="text" class="input" id="phone" name="phone"
						maxlength="50" value="" placeholder="" />
				</div>
			</div>
			<div class="form-group">
				<div class="label">
					<label for="idCard">&nbsp;&nbsp;&nbsp;&nbsp;身份证</label>&nbsp;&nbsp;&nbsp;&nbsp;
				</div>
				<div class="field">
					<input type="text" class="input" id="idCard" name="idCard"
						maxlength="50" value="" placeholder="" />
				</div>
			</div>
			<div class="form-group">
			<button type="button" class="button button-small bg-main"
				onclick="Wobb.searchTicketRecord();">
				<span class="icon-search text-white">&nbsp;查询</span>
			</button>
			</div>
			
		</form>
	</div>
</div>
<div class="panel" id="woTicketRecordListPanel">
	<div class="panel-head" id="woTicketRecordListPanelHeader">
		<form onsubmit="return false;" id="woTicketRecordSearchPageForm">
			<span>
				<span class='icon-step-backward' onclick="Wobb.loadTicketRecordFirstPage();"> </span>
				<span class='icon-backward' onclick="Wobb.loadTicketRecordLastPage();"></span>
				<span class="text-gray" id="woTicketRecordPageText">景点列表</span>
				<span class='icon-forward' onclick="Wobb.loadTicketRecordNextPage();"> </span>
				<span class='icon-step-forward' onclick="Wobb.loadTicketRecordFinalPage();"> </span>
				<span class='icon-refresh'></span>
			</span>
			<input type="hidden" class="input" id="woTicketRecordPageStart" name="woPageStart" value="0" />
			<input type="hidden" class="input" id="woTicketRecordPageSize" name="woPageSize" value="3" />
		</form>
	</div>
	
	<div class="panel-body-little woPanelBody">
		<form method="post" id="woTicketRecordListPanelHeaderForm">
			<div class="padding-small border-bottom">
				<input type="button" class="button button-small checkall"
					name="checkall" value="全选"/>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadTicketRecordCreateForm();">
					<span>创建</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.loadTicketRecordUpdateForm();">
					<span>修改</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-plus-circle" onclick="Wobb.showTicketRecordSearchForm();">
					<span>查询</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-yellow icon-minus-circle" onclick="Wobb.deleteTicketRecords();">
					<span>删除</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-file-excel-o" onclick="Wobb.importTicketRecordFileForm();">
					<span>导入</span>
				</button>
				<button type="button"
					class="button button-small text-white bg-main icon-file-excel-o" onclick="Wobb.exportTicketRecordFileForm();">
					<span>导出</span>
				</button>
			</div>
			<div id="woTicketRecordListPanelBody">
				<!-- 点击查询按钮时，下面内容会被替换 -->
				<jsp:include page="search.jsp"></jsp:include>
			</div>
		</form>
	</div>
</div>