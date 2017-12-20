<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>检测配置信息表</title>
    
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
				<th data-options="field:'batchNumber',align:'center'" style="width: 20%;" >序列号</th>
				<th data-options="field:'terminalModel',align:'center'" style="width: 13%;" >终端类型</th>
			    <th data-options="field:'detectionType',align:'center',formatter:dtypeformater" style="width: 13%;">检测类型</th>
			    <th data-options="field:'result',align:'center',styler:resultstyle" style="width: 12%;">检测结果</th>
			    <th data-options="field:'createrRealName',align:'center'" style="width: 11%;">检测人</th>
			    <th data-options="field:'creationTime',align:'center',formatter:dateformater" style="width: 15%;">检测时间</th> 
			    <th data-options="field:'action',align:'center',formatter:rowformater" style="width: 7%;">查看</th>
			</tr>
		</thead>   
	</table>
	<form id="downFileForm" method="post" target="_blank">
			<input id="param" name="param" type="hidden" />
			<input id="cols" name="cols" type="hidden" />
			<input id="fileName" name="fileName" type="hidden" />
			<input id="titleName" name="titleName" type="hidden" />
			<input id="beginTime" name="beginTime" type="hidden" />
			<input id="endTime" name="endTime" type="hidden" />
	</form>
    <div id="toolbar">
		<div style="margin-top: 5px;">
		<span style="margin-left: 10px;">序列号：</span><input id="bnum" class="easyui-textbox" data-options="prompt:'序列号'" style="width: 150px;text-align: center;">                
		<span style="margin-left: 10px;">终端类型：</span><select id="sername" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
			       <option value="">全部</option>
			       <option value="BNT4000HG_A">BNT4000HG_A</option>
			       <option value="PT8000">PT8000</option>
			       <option value="BNT4000HD">BNT4000HD</option>
			       <option value="BNT4000HC">BNT4000HC</option>
			       <option value="BNT4000HG">BNT4000HG</option>
			       <option value="BNT4000C-I">BNT4000C-I</option>
			       <option value="BNT4000G-I">BNT4000G-I</option>             
			    </select> 
		<span style="margin-left: 10px;">检测类型：</span><select id="dtype" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
					<option value="0">全部</option>
					<option value="1">模块检测</option>
					<option value="2">单板检测</option>
					<option value="3">整机检测</option>          
			  </select>
		</div>
		<div style="margin-top: 5px;margin-bottom: 5px;">
		 <span style="margin-left: 10px;">检测人：</span><select id="dperson" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
				<option value="">全部</option>
				<option value="超级管理员">超级管理员</option>
				<option value="管理员">管理员</option>          
				<option value="维克特">维克特</option>           
				<option value="双流兴弘">双流兴弘</option>           
				<option value="龙泉创宏">龙泉创宏</option>           
				<option value="金奥">金奥</option>           
				<option value="恒瑞鑫">恒瑞鑫</option>          
		 	  </select>
		<span style="margin-left: 10px;">检测结果：</span><select id="dresult" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
					<option value="0">全部</option>
					<option value="检测通过">检测通过</option>
					<option value="检测不通过">检测不通过</option>  
			  </select>	 	                 
		<span style="margin-left: 10px;">检测日期：</span><input id="ctimestart" class="easyui-datetimebox" style="width: 150px;text-align: center;">
		<span style="margin-left: 10px;">至：</span><input id="ctimeend" class="easyui-datetimebox" style="width: 150px;text-align: center;">
		</div>
		<div style="position: absolute;right: 10px;top: 33px;">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" onclick="dosearch()">查询</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" onclick="exportExcel()">导出Excel</a> 
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
		    url:"SelectDetectionMain2017ByPage.action",        
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
	
		//条件查询
		function dosearch(){
			var bnum1 = $("#bnum").textbox("getValue");
			var dtype1 = $("#dtype").combobox("getValue");
			var dresult1 = $("#dresult").combobox("getValue");
			var sername1 = $("#sername").combobox("getValue");
			var dperson1 = $("#dperson").combobox("getValue");
			var ctimestart1 = $("#ctimestart").datebox("getValue");
			var ctimeend1 = $("#ctimeend").datebox("getValue");
			$('#dg').datagrid({ 
				queryParams: {
					batchNumber: bnum1,
					detectionType: dtype1,
					result: dresult1,
					terminalModel: sername1,
					createrRealName: dperson1,
					starttime: ctimestart1,
					endtime: ctimeend1
				},
		        url : "SelectDetectionMain2017ByPageParm.action",
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
		
		//格式化dagrid(查看)
		function rowformater(value,row,index){ 
		    if (row.id){
			    return "<a href='javascript:ck();' style='text-decoration:none;'>查看</a>";
		    }
		}
		function ck(){
		    var row = $('#dg').datagrid("getSelected");
	        var urll = "TDetectionMain2017_listbyid.action?tdid="+row.id;
	        $('#dlg').dialog('open').dialog('center').dialog('setTitle','附表详细信息').load(urll);
		}
		
		//格式化datagrid数据显示
		function dateformater(value,row,index){
			if(row.creationTime){
				return row.creationTime.replace("T"," ");
			}
		}
		
		//格式化datagrid数据显示
		function dtypeformater(detectionType){
		  	if(detectionType == '1'){
			  	return "模块检测";
		  	}
		  	if(detectionType == '2'){
			 	return "单板检测";
		  	}
		  	if(detectionType == '3'){
				return "整机检测";
		  	}
		}
		
		//格式化dtagrid数据样式
		function resultstyle(value,row,index){
			if (value == "检测不通过"){
				return "color:red;";
			}
		}
		
		//数据导出本表
		function exportExcel(){
			var rows = $("#dg").datagrid("getRows");
			var datas = new Array();
			for (var i = 0; i < rows.length; i++) {
				var data = [
					rows[i].batchNumber,
					rows[i].terminalModel,
					dtypeformater(rows[i].detectionType),
					rows[i].result,
					rows[i].createrRealName,
					rows[i].creationTime,
				];
				datas.push(data);
			}
			
			var ths = $("#dg thead tr th");
			var cols = new Array();
			for (var i = 0; i < ths.length-1; i++) {
				cols.push($(ths[i]).text());
			}
			if(rows == void 0 || rows.length == 0){
				$.messager.alert('提示','没有需要导出的数据！','info');
				return;
			}
			var nowDate = new Date();
    		var time = nowDate.toLocaleDateString();
			$("#param").val(JSON.stringify(datas));
			$("#cols").val(JSON.stringify(cols));
			$("#fileName").val("检测信息表"+time);
			$("#titleName").val("检测信息表");
			$("#beginTime").val("");
			$("#endTime").val("");
			$("#downFileForm").attr("action", "ExportExcel.action");
			$("#downFileForm").submit();
		}
		
	</script>
    
	<!--弹出框的表单设置  --> 
	<div id="dlg" class="easyui-dialog" style="width:800px;height:600px;padding:1px 1px" closed="true">
	</div>
</body>
</html>