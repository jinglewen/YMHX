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
    
    <title>所有设备列表信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		.leftt{
		  text-align: right;
		}
	</style>
  </head>
  
<body>
    <table id="dg">
	    <thead>
			<tr>
				<!-- <th data-options="field:'ck',checkbox:true" style="width: 5%"></th> -->
				<th data-options="field:'serNumber',align:'center'" style="width: 20%;">设备序列号</th>
				<th data-options="field:'machName',align:'center'" style="width: 15%;" >设备型号</th>
				<th data-options="field:'machState',align:'center',styler: function(value,row,index){
				if (row.machState){
					return 'color:#CD2626;';
				}
			}" style="width: 15%;">设备状态</th>
			    <!-- <th data-options="field:'areaName',align:'center'"  style="width: 11%;">所属区域</th> -->
			    <th data-options="field:'carnum',align:'center'"  style="width: 15%;">车牌号</th>
			    <th data-options="field:'productDate',align:'center'"  style="width: 15%;">生产日期</th>
			    <th data-options="field:'action',align:'center',formatter:rowformater" style="width: 10%;">查看</th>
			</tr>
		</thead>   
	</table>
    <div id="toolbar">
        <!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addmach()" style="margin-top: 5px;">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editmach()" style="margin-top: 5px;">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroymach()" style="margin-top: 5px;">移除</a><br> -->       
        <div style="margin: 5px 0 0 10px">
	        <span>设备序列号：</span><input id="sernum" class="easyui-textbox" data-options="prompt: '序列号'" style="width: 150px;text-align: center;">    
	        <span style="margin-left: 10px;">设备型号：</span><select id="sername" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
			       <option value="">全部</option>
			       <option value="BNT4000HG-A">BNT4000HG-A</option>
			       <option value="PT8000">PT8000</option>
			       <option value="BNT4000HD">BNT4000HD</option>
			       <option value="BNT4000HC">BNT4000HC</option>
			       <option value="BNT4000HG">BNT4000HG</option>
			       <option value="BNT4000C-I">BNT4000C-I</option>
			       <option value="BNT4000G-I">BNT4000G-I</option>             
			    </select>
	    </div>
	    <div style="margin: 5px 0 5px 10px">	      
	        <span style="margin-right: 12px;">设备状态：</span><select id="serstate" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
				       <option value="">全部</option>
				       <option value="生产机">生产机</option>
				       <option value="出货机">出货机</option>          
				    </select>           
	        <span style="margin-left: 10px;">生产日期：</span><input id="prostarttime" class="easyui-datetimebox" style="width: 150px;text-align: center;">
	        <span style="margin-left: 10px;">至：</span><input id="proendtime" class="easyui-datetimebox" style="width: 150px;text-align: center;">                                                                                                                                    
	        <a href="javascript:void(0)" style="margin-left: 10px;" class="easyui-linkbutton" iconCls="icon-search" onclick="dosearch()">查询</a>
        </div>
    </div>
    
	<script type="text/javascript">

		//改变datagrid高度
		/* $(function () {
			var viewHeight = $(".datagrid-view").css("height").replace("px", "");
			$(".datagrid-view").css("height", viewHeight - 5);
			var bodyHeight = $(".datagrid-body").css("height").replace("px", "");
			$(".datagrid-body").css("height", bodyHeight - 5);
		}); */
	
		//分页查询预加载
		$('#dg').datagrid({
			url:'SelectMachByPage.action',
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
	
		//格式化表格数据
		function rowformater(value,row,index){
		    if (row.serNumber){
			    return "<a href='javascript:ckxq();' style='text-decoration:none;'>设备详情</a>";
		    }
		}
	
		//点击查询详情
		function ckxq(){
			var row = $('#dg').datagrid("getSelected");
			var urll = 'Mach_listall.action?sernum='+row.serNumber;
			$('#dlg').dialog('open').dialog('center').dialog('setTitle','设备详细信息').load(urll);  	  	  
		}
	
		//条件查询
		function dosearch(){
			var sernum1 = $("#sernum").textbox("getValue");
			var sername1 = $("#sername").combobox("getValue"); 
			var prostarttime1 = $("#prostarttime").datebox("getValue");
			var proendtime1 = $("#proendtime").datebox("getValue");
			var serstate1 = $("#serstate").combobox("getValue");
			//alert(sernum1+sername1+prostarttime1+proendtime1+serstate1);
			$('#dg').datagrid({ 
				queryParams: {
					serNumber: sernum1,
					machName: sername1,
					machState : serstate1,
					starttime: prostarttime1,
					endtime : proendtime1
				},
				url : 'SelectMachByPageParm.action',
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
    <div id="dlg" class="easyui-dialog" style="width:1100px;height:530px;padding:10px 20px" closed="true">
           
    </div>
</body>

</html>
