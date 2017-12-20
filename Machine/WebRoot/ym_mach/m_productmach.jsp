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
    
    <title>生产机列表信息</title>
    
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
				<th data-options="field:'id',align:'center',hidden:true" style="width: 10%;">编号</th> 
				<th data-options="field:'serNumber',align:'center'" style="width: 16%;">设备序列号</th>
			    <th data-options="field:'machName',align:'center'" style="width: 11%;">设备型号</th>
			    <th data-options="field:'machState',align:'center',styler: function(value,row,index){
					if (row.machState){
						return 'color:#CD2626;';
					}
				}" style="width: 8%;">设备状态</th>
			    <th data-options="field:'terminalId',align:'center'" style="width: 8%;">终端ID</th>
			    <th data-options="field:'manufacturerId',align:'center'" style="width: 8%;">制造商ID</th>
			    <th data-options="field:'detectionId',align:'center',formatter:deteformater" style="width: 15%;">单板编号</th>
			    <th data-options="field:'psModule',align:'center'" style="width: 12%;">定位模块</th>
				<th data-options="field:'phModule',align:'center'" style="width: 15%;">通讯模块</th>
			    <th data-options="field:'hardwareversion',align:'center'" style="width: 8%;">硬件版本</th>					
				<th data-options="field:'softwareversion',align:'center'" style="width: 8%;">软件版本</th>			
				<th data-options="field:'mainnetIp1',align:'center'" style="width: 10%;">主服务器IP1</th>
				<th data-options="field:'secondnetIp1',align:'center'" style="width: 10%;">备服务器IP1</th>
				<th data-options="field:'mainnetIp2',align:'center'" style="width: 10%;">主服务器IP2</th>
				<th data-options="field:'secondnetIp2',align:'center'" style="width: 18%;">备服务器IP2</th>
				<th data-options="field:'mainnetIp3',align:'center'" style="width: 10%;">主服务器IP3</th>
				<th data-options="field:'secondnetIp3',align:'center'" style="width: 10%;">备服务器IP3</th>
				<th data-options="field:'tcpprot1',align:'center'" style="width: 8%;">TCP端口1</th>
				<th data-options="field:'udpprot1',align:'center'" style="width: 8%;">UDP端口1</th>
				<th data-options="field:'tcpprot2',align:'center'" style="width: 8%;">TCP端口2</th>
				<th data-options="field:'udpprot2',align:'center'" style="width: 8%;">UDP端口2</th>
				<th data-options="field:'tcpprot3',align:'center'" style="width: 8%;">TCP端口3</th>
				<th data-options="field:'udpprot3',align:'center'" style="width: 8%;">UDP端口3</th>
				<th data-options="field:'phoneModel1',align:'center'" style="width: 6%;">通讯模式1</th>
				<th data-options="field:'phoneMode2',align:'center'" style="width: 6%;">通讯模式2</th>
				<th data-options="field:'phoneModel3',align:'center'" style="width: 6%;">通讯模式3</th>
				<th data-options="field:'carplateNum',align:'center'" style="width: 8%;">车牌号</th>
				<th data-options="field:'carplateColor',align:'center'" style="width: 8%;">车牌颜色</th>				
				<th data-options="field:'provinceId',align:'center'" style="width: 8%;">省城ID</th>
				<th data-options="field:'cityId',align:'center'" style="width: 8%;">市县城ID</th>
				<th data-options="field:'simcard',align:'center'" style="width: 10%;">SIM卡号</th>
				<th data-options="field:'apnname',align:'center'" style="width: 8%;">主服务器APN</th>				
				<th data-options="field:'apnuserName',align:'center'" style="width: 8%;">APN用户名</th>
				<th data-options="field:'apnpassWrod',align:'center'" style="width: 8%;">APN密码</th>				
				<th data-options="field:'productDate',align:'center'" style="width: 12%;" >生产日期</th>
				<th data-options="field:'productUserName',align:'center',hidden:true"  style="width: 8%;">生产负责人</th>
				<th data-options="field:'operator',align:'center'" style="width: 8%;">操作人</th>
				<th data-options="field:'optime',align:'center'" style="width: 12%;">操作时间</th>
				<th data-options="field:'remark',align:'center'" style="width: 18%;">备注</th>
				<!-- <th data-options="field:'isDelete',align:'center'" style="width: 6%;">是否删除</th> -->
			</tr>
		</thead>   
	</table>
    <div id="toolbar">
        <!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()" style="margin-top: 5px;">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()" style="margin-top: 5px;">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroy()" style="margin-top: 5px;">移除</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addmuch()" style="margin-top: 5px;">批量添加</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editmuch()" style="margin-top: 5px;">批量更新</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removemuch()" style="margin-top: 5px;">批量删除</a><br> -->                              
        <div style="margin: 5px 0 0 10px">
        	<span>序列号：</span><input id="mhsernum" class="easyui-textbox" data-options="prompt: '序列号'" style="width: 150px;text-align: center;">
            <span style="margin-left: 10px;">设备型号：</span><select id="mhname" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
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
         	<span>操作人：</span><input id="opuser" class="easyui-textbox" data-options="prompt: '操作人'" style="width: 150px;text-align: center;">
         	<span style="margin-left: 10px;">设备状态：</span><select id="mhstate" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
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
	    $(function () {
			var viewHeight = $(".datagrid-view").css("height").replace("px", "");
			$(".datagrid-view").css("height", viewHeight - 5);
			var bodyHeight = $(".datagrid-body").css("height").replace("px", "");
			$(".datagrid-body").css("height", bodyHeight - 5);
		});
    
    
  		//预加载表格(分页查询)
    	$('#dg').datagrid({
			  url:'SelectProductMachByPage.action',
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
  
  		  //格式化datagrid数据显示
		  function deteformater(value,row,index){
			  if(row.detectionId){
				  return row.detectionId.replace(/,/g," <br>");
			  }
		  }

		  //条件查询
		  function dosearch(){
			  var mhsernum1 = $("#mhsernum").textbox("getValue");
			  var mhname1 = $("#mhname").combobox("getValue");
			  var mhstate1 = $("#mhstate").combobox("getValue");
			  var prostarttime1 = $("#prostarttime").datebox("getValue");
			  var proendtime1 = $("#proendtime").datebox("getValue");
			  var opuser1 = $("#opuser").textbox("getValue");
			  $('#dg').datagrid({ 
				  queryParams: {
					  serNumber: mhsernum1,
					  machName: mhname1,
					  machState : mhstate1,
					  starttime : prostarttime1,
					  endtime : proendtime1,
					  operator : opuser1
				  },
			      url : 'SelectProductMachByPageParm.action',
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

</body>

</html>

