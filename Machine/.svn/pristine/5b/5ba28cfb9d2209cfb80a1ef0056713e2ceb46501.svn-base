<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>终端组装信息列表</title>
    
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
				<!-- <th data-options="field:'id',align:'center'" style="width: 10%;">编号</th> -->
				<th data-options="field:'action',align:'center',formatter:rowformater" style="width: 7%;">查看</th> 
				<th data-options="field:'wholeMachineModuleId',align:'center'" style="width: 16%;">整机ID</th>
			    <th data-options="field:'posModuleId',align:'center'" style="width: 15%;">定位模块ID</th>
			    <th data-options="field:'communicationModuleId',align:'center'" style="width: 15%;">通讯模块ID</th>
			    <th data-options="field:'pcbmoduleId',align:'center',formatter:pcbformater" style="width: 15%;">PCB板ID</th>
			    <th data-options="field:'wifiModuleId',align:'center'" style="width: 15%;">Wifi模块ID</th>
			    <th data-options="field:'createrRealName',align:'center'" style="width: 8%;" >创建人</th>
			    <th data-options="field:'creationTime',align:'center',formatter:dateformater" style="width: 12%;">创建时间</th>
			</tr>
		</thead>   
	</table>
    <div id="toolbar">
        <!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addmach()" style="margin-top: 5px;">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editmach()" style="margin-top: 5px;">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroymach()" style="margin-top: 5px;">移除</a><br> -->                                               
		整机ID:<input id="wmmid" type="text" placeholder="ID" style="width: 100px;"> &nbsp;&nbsp;                  
		创建人:<input id="cuser" type="text" placeholder="创建人" style="width: 100px;margin-top: 13px;margin-bottom: 8px;">&nbsp;&nbsp;                  
		创建日期(开始):<input id="ctimestart" class="easyui-datetimebox" style="width: 100px;"> &nbsp;&nbsp;
		创建日期(结束):<input id="ctimeend" class="easyui-datetimebox" style="width: 100px;"> &nbsp;&nbsp;                                                                                                   
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="dosearch()">查询</a>
    </div>

	<script type="text/javascript">
	
		$('#dg').datagrid({    
			url:'TTerminalassembly_listbypage.action',        
			rownumbers:true,
			method:'get',
			border:false,
			fit:true,
			toolbar:'#toolbar',
			fitColumns:true,
			singleSelect:true,
			pagination:true,	
			pageSize: 23,
			pageList: [23, 45, 70, 100]
		}); 
		
		function dateformater(value,row,index){
			  if(row.creationTime){
				   return row.creationTime.replace("T"," ");
			  }
		}
		
		function pcbformater(value,row,index){
			 if(row.pcbmoduleId){
				  //while(row.pcbmoduleId.indexOf(",") >= 0)
				  return row.pcbmoduleId.replace(/,/g," <br>");	  
			 }
		}
		
		function dosearch(){
			var wmmid1 = $("#wmmid").val();
			var cuser1 = $("#cuser").val();
			var ctimestart1 = $("#ctimestart").datebox("getValue");
			var ctimeend1 = $("#ctimeend").datebox("getValue");
			$('#dg').datagrid({ 
			      url : "TTerminalassembly_searchbyparm.action?wmmid="+wmmid1+"&cuser="+cuser1+"&ctimestart="+ctimestart1+"&ctimeend="+ctimeend1,
			      rownumbers:true,
				  method:'post',
				  singleSelect:true,
				  border:false,
				  fit:true,
				  toolbar:'#toolbar',
				  fitColumns:true,  
				  pagination:true,
				  pageSize: 23,
			      pageList: [23, 45, 70, 100]
			});
		}
		
		function rowformater(value,row,index){
			  if (row.wholeMachineModuleId){
				  return "<a href='javascript:ckxq();'>查看详情</a>";
			  }
		}
		
		function ckxq(){
			var row = $('#dg').datagrid("getSelected");
			//alert(row.communicationModuleId);
			var urll = "TTerminalassembly_listbyid.action?id1="+row.posModuleId+"&id2="+row.communicationModuleId+"&id3="+row.pcbmoduleId+"&id4="+row.wifiModuleId;
		    $('#dlg').dialog('open').dialog('center').dialog('setTitle','详细信息').load(urll);
		}
	</script>   

	<!--弹出框的表单设置  --> 
    <div id="dlg" class="easyui-dialog" style="width:900px;height:380px;padding:1px 1px" closed="true"> 
  </body>
</html>
