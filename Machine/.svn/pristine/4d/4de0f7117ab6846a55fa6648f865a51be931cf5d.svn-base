<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/themes/color.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>     
    
    <title>区域信息表</title>
    
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
    <table id="dg" >
	    <thead>
			<tr>
				<!-- <th data-options="field:'id',align:'center'" style="width: 9%;">区域编号</th> -->
				<th data-options="field:'areaName',align:'center'" style="width: 15%;">区域名称</th> 
				<!-- <th data-options="field:'fatherId',align:'center',hidden:true" style="width: 8%;" >父区域编号</th> -->
				<th data-options="field:'chargeUserName',align:'center'"  style="width: 15%;">区域负责人</th>
				<th data-options="field:'optionUser',align:'center'" style="width:15%;">操作人</th>
				<th data-options="field:'optionTime',align:'center'" style="width: 15%;">操作时间</th>
				<!-- <th data-options="field:'isDelete',align:'center'" style="width: 6%;">是否删除</th> --> 
			</tr>
		</thead>  		     
	</table>
    <div id="toolbar">
    	<div style="margin: 5px 0 0 10px">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="add()">新增</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="edit()">编辑</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" onclick="destroy()">移除</a><br>                                    
        </div>
        <div style="margin: 5px 0 5px 10px">
	        <span>区域名称：</span><input id="username" class="easyui-textbox" data-options="prompt: '区域名称'" style="width: 150px;text-align: center;">                                                                               
	        <a href="javascript:void(0)" style="margin-left: 10px;" class="easyui-linkbutton" iconCls="icon-search" onclick="dosearch()">查询</a>
        </div>
    </div>
 
	<script type="text/javascript">
		//分页查询加载
		$('#dg').datagrid({
			url:'SelectAreaByPage.action',
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
	        pageList: [100, 200, 500, 1000]
		}); 
  
		var urls;
		//添加
		function add(){
			$('#dlg').dialog('open').dialog('center').dialog('setTitle','新增区域');
			$('#fm').form('clear');
			urls = 'AddArea.action';
		}
		//编辑
		function edit(){
			var row = $('#dg').datagrid("getSelected");
			if (row){
				$('#fm').form('clear');
				$('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑区域');
				$('#fm').form('load',row);
				urls = 'UpdateArea.action?id='+row.id;
			}else{
				$.messager.alert('提示','请选择要编辑的一行!');
			}
		}
		//保存
		function save(){
			$('#fm').form('submit',{
			    url: urls,
			    onSubmit: function(){
			        return $(this).form('validate');//验证通过则返回true,否则不能提交
			    },
			    success: function(result){
			        var result = eval('('+result+')');
			        if(result.ErrorCode == 0){
			            $('#dlg').dialog('close');        
			            $('#dg').datagrid('reload');
			            $.messager.alert('操作提示','添加成功!');
			        } else if(result.ErrorCode == 1){
			        	$('#dlg').dialog('close');        
			            $('#dg').datagrid('reload');
			      	    $.messager.alert('操作提示','编辑成功!');
			        }
			    }
			});
		}
		//删除
		function destroy(){
		    var row = $('#dg').datagrid('getSelected');
		    if (row){
		        $.messager.confirm('提示','你确定要删除吗?',function(r){
		            if (r){
		                $.post('DeleteeArea.action',{id:row.id},function(result){
		                    if (result.ErrorCode == 0){
		                        $('#dg').datagrid('reload'); 
		                        $.messager.alert('操作提示','删除成功!');
		                    }else{
		                  	    $.messager.alert('操作提示','删除失败!');
		                    }
		                },'json');
		            }
		        });
		    }else{
		  	    $.messager.alert('操作提示','请选择要删除的一行!');
		    }
		}

		//条件查询
		function dosearch(){
			var areaname1 = $("#username").textbox("getValue");
			$('#dg').datagrid({ 
				queryParams: {
					areaName : areaname1
				},
				url : 'SelectAreaByPageParm.action',
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
		        pageList: [100, 200, 500, 1000]
			});
		}
	</script>
  
    <!--弹出框的表单设置  -->
	<div id="dlg" class="easyui-dialog"
		style="width:400px;height:320px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table style="margin-top: 25px;margin-left: 20px;">
				<tr>
					<td style="text-align: right;font-weight: 400;">区域名称:</td>
					<td><input name="areaName" class="easyui-textbox" required="true"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;">区域负责人姓名:</td>
					<td><input name="chargeUserName" class="easyui-textbox"></td>
				</tr>
			</table>
		</form>
	</div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="save()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
</body>

</html>
