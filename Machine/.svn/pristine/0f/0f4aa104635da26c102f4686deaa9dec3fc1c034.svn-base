<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>红岩SIM卡号导入数据列表</title>
    
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
  </head>
  
  <body>
    	<table id="dg">
    		<thead>
				<tr>
					<th data-options="field:'ticcid',align:'center'" style="width: 20%;" >ICCID</th>
					<th data-options="field:'tmsisdn',align:'center'" style="width: 20%;" >MSISDN</th>
				    <th data-options="field:'tsim',align:'center'"  style="width: 20%;">SIM卡号</th>
				    <th data-options="field:'tid',align:'center'"  style="width: 18%;">设备ID号</th>
				    <th data-options="field:'tdate',align:'center'"  style="width: 18%;">领卡日期</th>
				</tr>
			</thead>
    	</table>
		<div id="toolbar">
			<form id="questionTypesManage" name="f" action="importExcel.action"  method="post" enctype="multipart/form-data" style="margin: 5px 0 0 10px">  
			  	<span>选择文件：</span><input id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:180px;" data-options="prompt:'请选择文件...'">
				<a href="javascript:void(0)" id="importDate" style="margin-left: 10px;" class="easyui-linkbutton" iconCls="icon-redo">导入数据</a>
				<input type="submit" value="表单提交" style="display: none;"/>
			</form>
			<div style="margin: 5px 0 5px 10px">
				<span>设备ID号：</span><input id="tnum" class="easyui-textbox" data-options="prompt: '设备ID号'" style="width: 150px;text-align: center;">
				<span style="margin-left: 10px;">SIM卡号：</span><input id="simmun" class="easyui-textbox" data-options="prompt: 'SIM卡号'" style="width: 150px;text-align: center;">
	        	<a href="javascript:void(0)" style="margin-left: 10px;" class="easyui-linkbutton" iconCls="icon-search" onclick="dosearch()">查询</a>
	        </div>
	    </div>
	    <script type="text/javascript">
	    	//先触发点击事件，在提交表单
	    	$("#importDate").on("click",function(){
	    		var fileName= $("#uploadExcel").filebox("getValue");
	    		if(fileName == ""){
		    		$.messager.alert('提示','请选择上传文件!','info');
	    		}else{
	    			//对文件格式进行校验  
                    var d1=/\.[^\.]+$/.exec(fileName);   
		    		if(d1 != ".xlsx"){
		    			$.messager.alert('提示','请选择xlsx格式文件!','info');
		    			//$('#uploadExcel').filebox('setValue','');
		    		}else{
		    			$.messager.confirm('提示','确定要导入数据吗？',function(r){
		    				if(r){
		    					document.f.submit();
		    					$.messager.alert('提示','正在导入数据中...请稍等!','warning');
		    				}
		    			}); 
		    		}
	    		}	
	    	});
	    	//预加载表格(分页查询)
			$('#dg').datagrid({
				  url:"SelectSIMImportByPage.action",
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
			      /* onLoadSuccess:function(data){
			    	  console.log(data);
			      } */
			});
	    	//条件查询
			function dosearch(){
				var tnum1 = $("#tnum").textbox("getValue");
				var simmun1 = $("#simmun").textbox("getValue");
				$('#dg').datagrid({
					queryParams: {
						tid: tnum1,
						tsim: simmun1
					},
			        url : "SelectSIMImportByPageParm.action",
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
			/* function dateformater(value,row,index){
			    if(row.tdate){
				    return row.tdate.replace(".","-");
			    }
			} */
		</script>
  </body>
</html>
