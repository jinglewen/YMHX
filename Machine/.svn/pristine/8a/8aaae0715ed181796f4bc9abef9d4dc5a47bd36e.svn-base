<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>装箱管理</title>
    
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/themes/color.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    
     <table id="dg">
	    <thead>
			<tr>
				<!-- <th data-options="field:'ck',checkbox:true" style="width: 5%"></th> -->
				<!-- <th data-options="field:'id',align:'center'" style="width: 20%;">编号</th> -->
				<th data-options="field:'boxNumber',align:'center'" style="width: 20%;" >箱子编号</th>
				<th data-options="field:'boxState',align:'center',formatter:boxformater,styler:boxStyler" style="width: 10%;" >箱子状态</th>
			    <th data-options="field:'wholeMachineId',align:'center'"  style="width: 22%;">设备序列号</th>
			    <th data-options="field:'wholeMachState',align:'center',formatter:wholeMachformater,styler:wholeMachStyler" style="width: 10%;" >设备状态</th>
			    <th data-options="field:'createrRealName',align:'center'"  style="width: 14%;">装箱人</th>
			    <th data-options="field:'modifyTime',align:'center',formatter:dateformater"  style="width: 21%;">装箱日期</th>
			</tr>
		</thead>   
	</table>
    <div id="toolbar">
        <!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addmach()" style="margin-top: 5px;">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editmach()" style="margin-top: 5px;">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroymach()" style="margin-top: 5px;">移除</a><br> -->                                               
        <div style="margin: 5px 0 0 10px">
        	<span>装箱编号：</span><input id="boxnum" class="easyui-textbox" data-options="prompt: '装箱编号'" style="width: 150px;text-align: center;">
            <span style="margin-left: 10px;">装箱状态：</span><select id="boxstate" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
                  <option value="2">全部</option>
                  <option value="0">未发货</option>
                  <option value="1">已发货</option>         
              </select>
         </div>                                 
         <div style="margin: 5px 0 5px 10px">
         	<span style="margin-right: 12px;">序列号：</span><input id="wholenum" class="easyui-textbox" data-options="prompt: '序列号'" style="width: 150px;text-align: center;">
         	<span style="margin-left: 10px;">装箱日期：</span><input id="boxstarttime" class="easyui-datetimebox" style="width: 150px;text-align: center;">
	        <span style="margin-left: 10px;">至：</span><input id="boxendtime" class="easyui-datetimebox" style="width: 150px;text-align: center;">                                                                             
        	<a href="javascript:void(0)" style="margin-left: 10px;" class="easyui-linkbutton" iconCls="icon-search" onclick="dosearch()">查询</a>
        </div>
    </div>
    
	<script type="text/javascript">
		//改变datagrid高度
		$(function () {
			var viewHeight = $(".datagrid-view").css("height").replace("px", "");
			$(".datagrid-view").css("height", viewHeight - 5);
			var bodyHeight = $(".datagrid-body").css("height").replace("px", "");
			$(".datagrid-body").css("height", bodyHeight - 5);
		});
		
		//分页查询预加载
		$('#dg').datagrid({
			  url:'SelectTerminalmaintainByPage.action',
			  rownumbers:true,
			  method:'get',
			  singleSelect:true,
			  border:false,
			  fit:true,
			  toolbar:'#toolbar',
			  fitColumns:true,  
			  pagination:true,
			  resizeHandle:'both',
			  rownumberWidth:40,
			  pageSize: 100,
			  pageList: [100, 200, 500, 1000],
		      onLoadSuccess: function(data) {
		          //所有列进行合并操作
		          //$(this).datagrid("autoMergeCells");
		          //指定列进行合并操作
		          $(this).datagrid("autoMergeCells", ['boxNumber']);
		      }      
		});
		
		//条件查询
		function dosearch(){
			var boxnum1 = $("#boxnum").textbox("getValue");
			var boxstate1 = $("#boxstate").combobox("getValue");
			var wholenum1 = $("#wholenum").textbox("getValue");
			var boxstarttime1 = $("#boxstarttime").datebox("getValue");
			var boxendtime1 = $("#boxendtime").datebox("getValue");
			$('#dg').datagrid({ 
				 queryParams: {
					 boxNumber: boxnum1,
					 boxState: boxstate1,
					 wholeMachineId: wholenum1,
					 starttime : boxstarttime1,
					 endtime : boxendtime1
			      },
			      url : 'SelectTerminalmaintainByPageParm.action',
			      rownumbers:true,
				  method:'get',
				  singleSelect:true,
				  border:false,
				  fit:true,
				  toolbar:'#toolbar',
				  fitColumns:true,  
				  pagination:true,
				  resizeHandle:'both',
				  rownumberWidth:40,
				  pageSize: 100,
				  pageList: [100, 200, 500, 1000],
			      onLoadSuccess: function(data) {
			          //所有列进行合并操作
			          //$(this).datagrid("autoMergeCells");
			          //指定列进行合并操作
			          $(this).datagrid("autoMergeCells", ['boxNumber']);
			      }
			});
		}
		
		//datagrid数据格式化
		function dateformater(value,row,index){
			if(row.creationTime){
				return row.creationTime.replace("T"," ");
			}
		}
		function boxformater(value,row,index){
			if(row.boxState == '0'){
				return "";
			}
			if(row.boxState == 1){
				return "已发货";
			}
		}
		function wholeMachformater(value,row,index){
			if(row.wholeMachState == 0){
				return "";
			}
			if(row.wholeMachState == 1){
				return "已删除";
			}
		}
		
		//datagrid样式格式化
		function boxStyler(index,row){
			if(row.boxState == 1){
				return "color:red;";
			}
		}
		function wholeMachStyler(index,row){
			if(row.wholeMachState == 1){
				return "color:red;";
			}
		}
		
	</script>
	
	<script type="text/javascript">
	
		$.extend($.fn.datagrid.methods, {
			autoMergeCells : function(jq, fields) {
				return jq.each(function() {
					var target = $(this);
					if (!fields) {
						fields = target.datagrid("getColumnFields");
					}
					var rows = target.datagrid("getRows");
					var i = 0,
					j = 0,
					temp = {};
					for (i; i < rows.length; i++) {
						var row = rows[i];
						j = 0;
						for (j; j < fields.length; j++) {
							var field = fields[j];
							var tf = temp[field];
							if (!tf) {
								tf = temp[field] = {};
								tf[row[field]] = [ i ];
							} else {
								var tfv = tf[row[field]];
								if (tfv) {
									tfv.push(i);
								} else {
									tfv = tf[row[field]] = [ i ];
								}
							}
						}
					}
					$.each(temp, function(field, colunm) {
						$.each(colunm, function() {
							var group = this;
							if (group.length > 1) {
								var before,
								after,
								megerIndex = group[0];
								for (var i = 0; i < group.length; i++) {
									before = group[i];
									after = group[i + 1];
									if (after && (after - before) == 1) {
										continue;
									}
									var rowspan = before - megerIndex + 1;
									if (rowspan > 1) {
										target.datagrid('mergeCells', {
											index : megerIndex,
											field : field,
											rowspan : rowspan
										});
									}
									if (after && (after - before) != 1) {
										megerIndex = after;
									}
								}
							}
						});
					});
				});
			}
		}); 
	</script>
	    
  </body>
</html>
