<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>终端SIM卡号信息列表</title>
    
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
				<th data-options="field:'terminalNo',align:'center'" style="width: 20%;" >终端编号</th>
			    <th data-options="field:'simno',align:'center'"  style="width: 20%;">SIM卡号</th>
			    <th data-options="field:'createrRealName',align:'center'"  style="width: 20%;">创建人</th>
			    <th data-options="field:'creationTime',align:'center',formatter:dateformater"  style="width: 20%;">创建时间</th>
			</tr>
		</thead>   
	</table>
    <div id="toolbar">
        <!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addmach()" style="margin-top: 5px;">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editmach()" style="margin-top: 5px;">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroymach()" style="margin-top: 5px;">移除</a><br> -->                                               
        <div style="margin: 5px 0 5px 10px">
        	<span>终端编号：</span><input id="tnum" class="easyui-textbox" data-options="prompt: '终端编号'" style="width: 150px;text-align: center;">
        	<span style="margin-left: 10px;">SIM卡号：</span><input id="simmun" class="easyui-textbox" data-options="prompt: 'SIM卡号'" style="width: 150px;text-align: center;">
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
	
		//预加载表格(分页查询)
		$('#dg').datagrid({
			  url:"SelectTerminalsimmapByPage.action",
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
		});
		
		//条件查询
		function dosearch(){
			var tnum1 = $("#tnum").textbox("getValue");
			var simmun1 = $("#simmun").textbox("getValue");
			$('#dg').datagrid({
				queryParams: {
					terminalNo: tnum1,
					simno: simmun1
				},
		        url : "SelectTerminalsimmapByPageParm.action",
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
			});
		}
		
		//格式化datagrid数据显示
		function dateformater(value,row,index){
		    if(row.creationTime){
			    return row.creationTime.replace("T"," ");
		    }
		}
	</script>
	    
  </body>
</html>
