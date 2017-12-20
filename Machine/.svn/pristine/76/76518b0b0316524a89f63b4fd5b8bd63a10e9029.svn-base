<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>定位模块</title>
    
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"> 
	<!-- <link rel="stylesheet" type="text/css" href="easyui/demo/demo.css"> --> 
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
				<th data-options="field:'id',align:'center'" style="width: 24%;">定位模块编号</th>
				<th data-options="field:'name',align:'center'" style="width: 14%;">定位模块名称</th> 
				<th data-options="field:'softwareversion',align:'center'" style="width: 12%;" >硬件名称</th>
				<th data-options="field:'hardwareversion',align:'center'"  style="width: 12%;">软件名称</th>
				<th data-options="field:'outroomdate',align:'center'"  style="width: 12%;">生产时间</th>
				<th data-options="field:'createusername',align:'center'"  style="width: 8%;">操作人</th>
				<th data-options="field:'createtime',align:'center'"  style="width: 12%;">操作时间</th>
				<!-- <th data-options="field:'isDelete',align:'center'" style="width: 6%;">是否删除</th> --> 
			</tr>
		</thead>  		     
	</table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()" style="margin-top: 5px;">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()" style="margin-top: 5px;">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroy()" style="margin-top: 5px;">移除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addmuch()" style="margin-top: 5px;">批量添加</a><br>                                    
    </div>
 
<script type="text/javascript">
  
  $('#dg').datagrid({
	  //url:'TLocation_listbypage.action',
	  rownumbers:true,
	  method:'get',
	  singleSelect:true,
	  border:false,
	  fit:true,
	  toolbar:'#toolbar',
	  fitColumns:true,  
	  pagination:true,
	  pageSize: 23,
      pageList: [23, 45, 70, 100]
  }); 
  
</script> 

  </body>
</html>
