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
    
    <title>出货机列表信息</title>
    
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
				<th data-options="field:'id',align:'center',hidden:'true'" style="width: 10%;">编号</th>
				<th data-options="field:'boxNumber',align:'center'" style="width: 16%;" >箱子编号</th> 
				<th data-options="field:'serNumber',align:'center'" style="width: 19%;">设备序列号</th>
			    <th data-options="field:'machName',align:'center'" style="width: 12%;">设备型号</th> 
				<th data-options="field:'machState',align:'center',styler: function(value,row,index){
					if (row.machState){
						return 'color:#CD2626;';
					}
				}" style="width: 8%;">设备状态</th>
				<th data-options="field:'outRoomNumber',align:'center'"  style="width: 15%;">发货单编号</th>
				<th data-options="field:'outRoomBatch',align:'center'"  style="width: 8%;">发货批次</th>
				<th data-options="field:'outRoomAdress',align:'center'"  style="width: 25%;">发货地址</th>
				<th data-options="field:'outRoomDate',align:'center'" style="width: 12%;" >发货日期</th>
				<th data-options="field:'outRoomUserName',align:'center'" style="width: 8%;">发货人</th>
				<th data-options="field:'outRoomUserPhone',align:'center'" style="width: 15%;">发货人电话</th>							    		    
				<th data-options="field:'customerName',align:'center'" style="width: 8%;">收货人</th>
				<th data-options="field:'customerPhone',align:'center'" style="width: 15%;">收货人电话</th>
				<th data-options="field:'customerAdress',align:'center'" style="width: 18%;">收货人地址</th>
				<th data-options="field:'customerCompany',align:'center'" style="width: 18%;">收货人所在公司</th>
				<th data-options="field:'customerCompanyPhone',align:'center'" style="width: 15%;">收货人公司电话</th>
				<th data-options="field:'optionUser',align:'center'" style="width: 8%;">操作人</th>
				<th data-options="field:'optionTime',align:'center'" style="width: 12%;">操作时间</th>
				<!-- <th data-options="field:'isDelete',align:'center'" style="width: 6%;">是否删除</th> -->
			</tr>
		</thead>   
	</table>
    <div id="toolbar">
    	<div style="margin: 5px 0 0 10px">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="add()">新增</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="edit()">编辑</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" onclick="destroy()">移除</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" onclick="exportExcel()">导出Excel</a>
        </div>
        <!-- <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addmuch()" style="margin-top: 5px;">批量添加</a> -->                                            
        <div style="margin: 5px 0 0 10px">
	        <span>序列号：</span><input id="sernum" class="easyui-textbox" data-options="prompt: '序列号'" style="width: 150px;text-align: center;">
	        <span style="margin-left: 10px;">箱子编号：</span><input id="boxnum" class="easyui-textbox" data-options="prompt: '装箱编号'" style="width: 150px;text-align: center;">
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
			<span style="margin-left: 10px;">设备状态：</span><select id="serstate" class="easyui-combobox" data-options="panelHeight:'auto'" style="width: 150px;text-align: center;">
					<option value="">全部</option>
					<option value="生产机">生产机</option>
					<option value="出货机">出货机</option>         
				</select>
			<span style="margin-left: 10px;">发货单编号：</span><input id="outnum" class="easyui-textbox" data-options="prompt: '发货单编号'" style="width: 150px;text-align: center;">                                                   
		</div>
		<div style="margin: 5px 0 5px 10px">
			<span>收货人：</span><input id="outuser" class="easyui-textbox" data-options="prompt: '收货人'" style="width: 150px;text-align: center;">
			<span style="margin-left: 10px;">收货公司：</span><input id="outusercompany" class="easyui-textbox" data-options="prompt: '收货公司'" style="width: 150px;text-align: center;">
			<span style="margin-left: 10px;">出货日期：</span><input id="outstarttime" class="easyui-datetimebox" style="width: 150px;text-align: center;">
	        <span style="margin-left: 47px;">至：</span><input id="outendtime" class="easyui-datetimebox" style="width: 150px;text-align: center;">                                                                             
	       	<a href="javascript:void(0)" style="margin-left: 10px;" class="easyui-linkbutton" iconCls="icon-search" onclick="dosearch()">查询</a>
        </div>
    </div>
   
   <script type="text/javascript">
		//改变datagrid高度
		$(function () {
			var viewHeight = $(".datagrid-view").css("height").replace("px", "");
			$(".datagrid-view").css("height", viewHeight - 14);
			var bodyHeight = $(".datagrid-body").css("height").replace("px", "");
			$(".datagrid-body").css("height", bodyHeight - 14);
		});

		//预加载表格(分页查询)
		$('#dg').datagrid({
			url:'SelectOutRoomMachByPage.action',
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
  
		/* $.getJSON('SelectAreaAll.action', function(json) {
			$('#cc').combobox({
				data : json.rows,
				valueField:'areaDescription',
				textField:'areaName',
				panelHeight:'auto'
			});
		});
		$.getJSON('SelectAreaAll.action', function(json) {
			$('#ccc').combobox({
				data : json.rows,
				valueField:'areaDescription',
				textField:'areaName',
				panelHeight:'auto'
			});
		}); */
  		
  		//添加
		var urls;
		function add(){
			$("#boxid").val("").attr("disabled",false);
			var row = $('#dg').datagrid("getSelected");
			if(row){
				$('#fm').form('clear');
				$('#dlg').dialog('open').dialog('center').dialog('setTitle','添加');
				$('#fm').form('load',row);
				urls = 'AddOutRoomMach.action';
			}else{
				$('#dlg').dialog('open').dialog('center').dialog('setTitle','添加');
			    $('#fm').form('clear');
			    urls = 'AddOutRoomMach.action';
			}  
		}
		//编辑
		function edit(){
			$("#boxid").attr("disabled",true);
			var row = $('#dg').datagrid("getSelected");
			if (row){
				$('#fm').form('clear');
				$('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑');
				$('#fm').form('load',row);
				urls = 'UpdateOutRoomMach.action?boxnum='+row.boxNumber;
			}else{
				$.messager.alert('操作提示','请选择要编辑的箱子?');
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
		            }else if(result.ErrorCode == 1){
		            	$.messager.alert('操作提示','此箱子无设备或不存在!');
		            }else if(result.ErrorCode == 2){
		            	$.messager.alert('操作提示','此设备序列号('+result.mpMachName+')未生产,不能发货!');
		            }else if(result.ErrorCode == 3){
						$.messager.alert('操作提示','设备已发货,不能再发货!');
		            }else if(result.ErrorCode == 4){
		            	$('#dlg').dialog('close');        
		                $('#dg').datagrid('reload');
						$.messager.alert('操作提示','更新成功!');
		            }else if(result.ErrorCode == 5){
						$.messager.alert('操作提示','更新失败!');
		            }else if(result.ErrorCode == 6){
						$.messager.alert('操作提示','此箱子已发货!');
		            }
		        }
		    });
		}
		
		//移除
		function destroy(){
		    var row = $('#dg').datagrid('getSelected');
		    if (row){
		        $.messager.confirm('提示','你确定要删除此箱子的所有发货吗?',function(r){
		            if (r){
		                $.post('DeleteOutRoomMach.action',{boxnum:row.boxNumber},function(result){
		                    if (result.ErrorCode == 0){
		                        $('#dg').datagrid('reload'); 
		                        $.messager.alert('操作提示','删除成功!');
		                    } else if(result.ErrorCode == 1){
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
			var boxnum1 = $("#boxnum").textbox("getValue");
			var sernum1 = $("#sernum").textbox("getValue");
			var sername1 = $("#sername").combobox("getValue");
			var serstate1 = $("#serstate").combobox("getValue");
			var outnum1 = $("#outnum").textbox("getValue");
			var outuser1 = $("#outuser").textbox("getValue");
			var outusercompany1 = $("#outusercompany").textbox("getValue");
			var outstarttime1 = $("#outstarttime").datetimebox("getValue");
			var outendtime1 = $("#outendtime").datetimebox("getValue");
			$('#dg').datagrid({ 
				queryParams: {
					boxNumber: boxnum1,
					serNumber: sernum1,
					machName : sername1,
					machState : serstate1,
					outRoomNumber : outnum1,
					customerName : outuser1,
					customerCompany : outusercompany1,
					starttime : outstarttime1,
					endtime : outendtime1
				},
				url : 'SelectOutRoomMachByPageParm.action',
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
		
		//批量添加
		function addmuch(){
			var row = $('#dg').datagrid("getSelected");
			$('#dlgg').dialog('open').dialog('center').dialog('setTitle','批量添加');
			$('#fmm').form('clear');  
		}
		//批量保存
		function savemuch(){
			var sernumstart = $('#sernumstart').val();
			var sernumend = $('#sernumend').val();
		    $('#fmm').form('submit',{
		        url: 'OutRoomMach_addmuch.action?sernumstart='+sernumstart+'&sernumend='+sernumend,
		        onSubmit: function(){
		            return $(this).form('validate');//验证通过则返回true,否则不能提交
		        },
		        success: function(result){
		            var result = eval('('+result+')');
		            if(result.success){
		                $('#dlgg').dialog('close');        
		                $('#dg').datagrid('reload');
		                $.messager.alert('操作提示','操作成功!');
		            }else if(result.failure){
		          		$.messager.alert('操作提示','序列号为'+result.addnum+'的设备不存在!');
		          		$('#dg').datagrid('reload');
		            }else if(result.failuree){
		          		$.messager.alert('操作提示','序列号为'+result.ormnum+'的设备已出货!');
		          		$('#dg').datagrid('reload');
		            }else if(result.errorr){
		          		$.messager.alert('操作提示','序列号输入有误,输入规则(开始<结束)!');        
		            }
		        }
		    });
		}
  
		//数据导出
		function exportExcel(){
			//var options = $("#dg").datagrid("getPager").data("pagination").options;  
			//var pagenum = options.pageNumber;  
			//var total = options.total;  
			//alert(pagenum+"-"+total);
			var boxnum1 = $("#boxnum").textbox("getValue");
			var sernum1 = $("#sernum").textbox("getValue");
			var sername1 = $("#sername").combobox("getValue");
			var serstate1 = $("#serstate").combobox("getValue");
			var outnum1 = $("#outnum").textbox("getValue");
			var outuser1 = $("#outuser").textbox("getValue");
			var outusercompany1 = $("#outusercompany").textbox("getValue");
			var outstarttime1 = $("#outstarttime").datetimebox("getValue");
			var outendtime1 = $("#outendtime").datetimebox("getValue");
			if(confirm("确认要导出Excel吗？")){
					location.href = "OutRoomMach_exportExcel.action?boxNumber="+boxnum1+"&serNumber="+sernum1+"&machName="+sername1+"&machState="+serstate1+"&outRoomNumber="+outnum1+"&customerName="+outuser1+"&customerCompany="+outusercompany1+"&starttime="+outstarttime1+"&endtime="+outendtime1;
					
					/* var value = {
							boxNumber: boxnum1,
							serNumber: sernum1,
							machName : sername1,
							machState : serstate1,
							outRoomNumber : outnum1,
							customerName : outuser1,
							customerCompany : outusercompany1,
							starttime : outstarttime1,
							endtime : outendtime1	
						}; */
					/* $.ajax({
							type: "POST",
							async : true,  //异步(true)请求,同步(false)请求
							dataType:"text",
							data: value,
							url: "OutRoomMach_exportExcel.action",
							success: function(){
								alert(123);
							},
							error:function(){
			                    alert("Web服务器内部错误!");
			                }
						}); */
			}
		}
	</script>
	
	<script type="text/javascript">
		$.extend($.fn.validatebox.defaults.rules, {
		    CHS: {
		        validator: function (value, param) {
		            return /^[\u0391-\uFFE5]+$/.test(value);
		        },
		        message: '请输入汉字'
		    }, 
		    mobile: {
		        validator: function (value, param) {
		            return /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$|(^(13[0-9]|15[0|3|6|7|8|9]|18[8|9])\d{8}$)/.test(value);
		        },
		        message: '电话号码不正确'
		    },
		    number: {
		        validator: function (value, param) {
		            return /^\d+$/.test(value);
		        },
		        message: '请输入数字'
		    },
		    time: {
		    	validator: function (value, param) {
		            return /^\d{4}-\d{1,2}-\d{1,2}$/.test(value);
		        },
		        message: '请输入正确日期格式'
		    }
		});
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
       
    <!--弹出框的表单设置  -->
	<div id="dlg" class="easyui-dialog"
		style="width:440px;height:530px;padding:20px 20px" closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post">
			<table style="margin-top: 15px;margin-left: 20px;">
				<tr>
				    <td style="text-align: right;font-weight: 500;">箱子编号</td>
					<td><input id="boxid" name="boxNumber" style="width: 210px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">发货日期:</td>
					<td><input name="outRoomDate" class="easyui-datetimebox" style="width: 210px;"></td>	
				</tr>	
				<tr>
					<td style="text-align: right;font-weight: 500;">发货单编号:</td>
					<td><input name="outRoomNumber" class="easyui-textbox" style="width: 210px;"></td>	
				</tr>	
				<tr>			
				    <td style="text-align: right;font-weight: 500;">发货批次:</td>
					<td><input name="outRoomBatch" class="easyui-textbox" style="width: 210px;"></td>
				</tr>
				<tr>			
				    <td style="text-align: right;font-weight: 500;">发货地址:</td>
					<td><textarea name="outRoomAdress" rows="3" style="width: 210px;"></textarea></td>
				</tr>
				<tr>
				    <td style="text-align: right;font-weight: 500;">发货人姓名:</td>
					<td><input name="outRoomUserName" class="easyui-textbox" required="true" style="width: 210px;"></td> 
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">发货人电话:</td>
					<td><input name="outRoomUserPhone" class="easyui-textbox" style="width: 210px;"></td>
				</tr>				
				<tr>
					<td style="text-align: right;font-weight: 500;">收货人姓名:</td>
					<td><input name="customerName" class="easyui-textbox" style="width: 210px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">收货人电话:</td>
					<td><input name="customerPhone" class="easyui-textbox" style="width: 210px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">收货人地址:</td>
					<td><textarea name="customerAdress" rows="3" style="width: 210px;"></textarea></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">收货人所在公司:</td>
					<td><textarea name="customerCompany" rows="2" style="width: 210px;"></textarea></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">收货人公司电话:</td>
					<td><input name="customerCompanyPhone" class="easyui-textbox" style="width: 210px;"></td>
				</tr>		
			</table>		
         </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="save()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    
    <!--弹出框的表单设置  -->
	<div id="dlgg" class="easyui-dialog"
		style="width:500px;height:460px;padding:10px 20px" closed="true" buttons="#dlg-buttonss">
        <form id="fmm" method="post">
            <table style="margin-top: 25px;margin-left: 25px;">
                <tr>
				    <td style="text-align: right;font-weight: 500;">*设备开始序列号:</td>
					<td><input id="sernumstart" class="easyui-textbox" required="true" style="width: 210px;"></td>
				</tr>
				<tr>
				    <td style="text-align: right;font-weight: 500;">*设备结束序列号:</td>
					<td><input id="sernumend" class="easyui-textbox" required="true" style="width: 210px;"></td>
				</tr>
            </table>
			<table style="margin-top: 7px;margin-left: 12px;">	
				<tr>
					<td style="text-align: right;font-weight: 500;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发货单编号:</td>
					<td><input name="outRoomNumber" class="easyui-textbox" style="width: 210px;"></td>	
				</tr>	
				<tr>			
				    <td style="text-align: right;font-weight: 500;">发货批次:</td>
					<td><input name="outRoomBatch" class="easyui-textbox" style="width: 210px;"></td>
				</tr>
				<tr>			
				    <td style="text-align: right;font-weight: 500;">所在区域:</td>
					<td><input id="ccc" name="areaName" class="easyui-textbox" style="width: 210px;"></td>
				</tr>
				<tr>
				    <td style="text-align: right;font-weight: 500;">发货人姓名:</td>
					<td><input name="outRoomUserName" class="easyui-textbox" required="true" style="width: 210px;"></td> 
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">发货人联系电话:</td>
					<td><input name="outRoomUserPhone" class="easyui-textbox" data-options="validType:'mobile'" style="width: 210px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">用户人姓名:</td>
					<td><input name="customerName" class="easyui-textbox" style="width: 210px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">用户人联系电话:</td>
					<td><input name="customerPhone" class="easyui-textbox" data-options="validType:'mobile'" style="width: 210px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">用户所在公司:</td>
					<td><textarea name="reportcompany" rows="2" style="width: 280px;"></textarea></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 500;">用户公司联系电话:</td>
					<td><input name="customerCompanyPhone" class="easyui-textbox" data-options="validType:'mobile'" style="width: 210px;"></td>
				</tr>		
			</table>		
         </form>
    </div>
    <div id="dlg-buttonss">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="savemuch()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgg').dialog('close')" style="width:90px">取消</a>
    </div>
</body>

</html>

