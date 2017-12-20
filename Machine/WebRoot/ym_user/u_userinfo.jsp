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
    
    <title>用户列表信息</title>
    
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
				<!-- <th data-options="field:'id',align:'center'" style="width: 8%;">用户编号</th> -->
				<th data-options="field:'userName',align:'center'" style="width: 15%;">用户名称</th> 
				<!-- <th data-options="field:'passWord',align:'center'" style="width: 12%;" >用户密码</th> -->
				<th data-options="field:'realName',align:'center'"  style="width: 15%;">真实姓名</th>
				<th data-options="field:'areaName',align:'center'"  style="width: 15%;">所属区域</th>
				<th data-options="field:'phone',align:'center'" style="width: 15%;">电话</th>
			    <th data-options="field:'email',align:'center'" style="width: 15%;">邮箱</th>
				<!-- <th data-options="field:'userType',align:'center'" style="width: 10%;">用户类型</th> -->
				<!-- <th data-options="field:'isDelete',align:'center'" style="width: 6%;">是否删除</th> -->
				<th data-options="field:'isEnable',align:'center'" style="width: 15%;">是否禁用(0非禁用;1禁用)</th> 
			</tr>
		</thead>       
	</table>
    <div id="toolbar">
    	<div style="margin: 5px 0 0 10px">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" onclick="adduser()">新增</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="editUser()">编辑</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" onclick="destroyuser()">移除</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" onclick="jyuser()">禁用</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" onclick="jcuser()">解禁</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" onclick="ckuserfun()">权限管理</a>                                       
        </div>
        <div style="margin: 5px 0 5px 10px">
	        <span>用户名：</span><input id="username" class="easyui-textbox" data-options="prompt: '用户名'" style="width: 150px;text-align: center;">                                                                               
	        <a href="javascript:void(0)" style="margin-left: 10px;" class="easyui-linkbutton" iconCls="icon-search" onclick="dosearch()">查询</a>
        </div>
    </div>
    
    <script type="text/javascript">
  
    	//分页查询加载
	    $('#dg').datagrid({
			url:'SelectByPage.action',
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
	  
    	//加载区域
	    $.getJSON('SelectAreaAll.action', function(json) {
			$('#cc').combobox({
			    data : json.rows,
			    valueField:'areaDescription',
			    textField:'areaName',
			    panelHeight:'auto'
			});
	    });  
	  
	    var urls;
	    //添加用户
	    function adduser(){
	    	$("#uname").val("").attr("disabled",false);
		    $('#dlg').dialog('open').dialog('center').dialog('setTitle','新增用户');
	        $('#fm').form('clear');
	        urls = 'Add.action';
	    }
		//编辑用户
	    function editUser(){
	    	$("#uname").attr("disabled",true);
	        var row = $('#dg').datagrid("getSelected");
	        if (row){
	    	    $('#fm').form('clear');
	            $('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑用户');
	            $('#fm').form('load',row);
	            urls = 'Update.action?id='+row.id;
	        }else{
	    	    $.messager.alert('提示','请选择要编辑的一行!');
	        }
	    } 
		//点击保存
	    function saveuser(){
		    var pw1 = $('#pw1').val();
		    var pw2 = $('#pw2').val();
		    if(pw1 == pw2){
			    $('#fm').form('submit',{
		            url: urls,
		            onSubmit: function(){
		                return $(this).form('validate');//验证通过则返回true,否则不能提交
		            },
		            success: function(data){
		                var result = eval('('+data+')');
		                if(result.ErrorCode == 0){
		                	$('#dlg').dialog('close');        
		                    $('#dg').datagrid('reload');
		                    $.messager.alert('操作提示','操作成功!');
		                }else if(result.ErrorCode == 1){
		                	$.messager.alert('操作提示','该用户名称已经存在,请另外输入名称!');
		                }else if(result.ErrorCode == 2){
		                	$.messager.alert('操作提示','编辑失败!');
		                }else if(result.ErrorCode == 3){
		                	$('#dlg').dialog('close');        
		                    $('#dg').datagrid('reload');
		                	$.messager.alert('操作提示','编辑成功!');
		                }
		            }
		        });
		    }else{
		    	$.messager.alert('操作提示','两次输入密码不一样!');
		    }
	    }
		//移除
	    function destroyuser(){
	        var row = $('#dg').datagrid('getSelected');
	        if (row){
	            $.messager.confirm('提示','你确定要删除这个用户吗?',function(r){
	                if (r){
	                    $.post('Deletee.action',{id:row.id},function(result){
	                    	//alert(result.ErrorCode);
	                    	if(result.ErrorCode == 0){
	                    		$('#dg').datagrid('reload');
			                	$.messager.alert('操作提示','删除成功!');
			                }else{
			                	$.messager.alert('操作提示','删除失败!');
			                }
	                    },'json');
	                }
	            });
	        }else{
	    	    $.messager.alert('操作提示','请选择要删除的用户!');
	        }
	    }
	    
		//禁用
	    function jyuser(){
	        var row = $('#dg').datagrid('getSelected');
	        if (row){
	            $.messager.confirm('Confirm','你确定要禁用这个用户吗?',function(r){
	                if (r){
	                    $.post('Disable.action',{id:row.id},function(result){
	                        if (result.ErrorCode == 0){
	                            $('#dg').datagrid('reload');
	                            $.messager.alert('操作提示','禁用成功!');
	                        }else if(result.ErrorCode == 1){
	                        	$.messager.alert('操作提示','禁用失败!');
	                        }
	                    },'json');
	                }
	            });
	        }else{
	    	    $.messager.alert('操作提示','请选择要禁用的用户!');
	        }
	    }
	  
		//解除禁用
	    function jcuser(){
	        var row = $('#dg').datagrid('getSelected');
	        if (row){
	            $.messager.confirm('Confirm','你确定要解除禁用这个用户吗?',function(r){
	                if (r){
	                    $.post('LiftBan.action',{id:row.id},function(result){
	                    	if (result.ErrorCode == 0){
	                            $('#dg').datagrid('reload');
	                            $.messager.alert('操作提示','解禁成功!');
	                        }else if(result.ErrorCode == 1){
	                        	$.messager.alert('操作提示','解禁失败!');
	                        }
	                    },'json');
	                }
	            });
	        }else{
	    	    $.messager.alert('操作提示','请选择要解除禁用的用户!');
	        }
	    }
	  
		//条件查询
	    function dosearch(){
		    var username1 = $("#username").textbox("getValue");
		    $('#dg').datagrid({ 
			    queryParams: {
					userName: username1,
			    },
		        url : 'SelectByPageParm.action',
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
	
	<script type="text/javascript">
		//验证重写
		$.extend($.fn.validatebox.defaults.rules, {
		    CHS: {
		        validator: function (value, param) {
		            return /^[\u0391-\uFFE5]+$/.test(value);
		        },
		        message: '请输入汉字'
		    }, 
		    mobile: {
		        validator: function (value, param) {
		            return /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/.test(value);
		        },
		        message: '手机号码不正确'
		    },
		    safepass: {
		        validator: function (value, param) {
		            return safePassword(value);
		        },
		        message: '密码由字母和数字组成，至少6位'
		    },
		});
	
		/* 密码由字母和数字组成，至少6位 */
		var safePassword = function (value) {
		    return !(/^(([A-Z]*|[a-z]*|\d*|[-_\~!@#\$%\^&\*\.\(\)\[\]\{\}<>\?\\\/\'\"]*)|.{0,5})$|\s/.test(value));
		};
	</script>
    
    <!--弹出框的表单设置  -->
	<div id="dlg" class="easyui-dialog"
		style="width:380px;height:360px;padding:10px 20px" closed="true"
		buttons="#dlg-buttons">
		<form id="fm" method="post">
			<table style="margin-top: 30px;margin-left: 30px;">
				<tr>
					<td style="text-align: right;font-weight: 600;">用户名称:</td>
					<td><input id="uname" name="userName" style="width: 165px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;">输入密码:</td>
					<td><input type="password" id="pw1" name="passWord" class="easyui-textbox" data-options="required:true" style="width: 165px;">
					</td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;">再次输入密码:</td>
					<td><input type="password" id="pw2" class="easyui-textbox" data-options="required:true" style="width: 165px;">
					</td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;">真实姓名:</td>
					<td><input name="realName" class="easyui-textbox" data-options="required:true,validType:'CHS'" style="width: 165px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;">所属区域:</td>
					<td><input id="cc" name="areaName" style="width: 165px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;">联系电话:</td>
					<td><input name="phone" class="easyui-textbox" data-options="validType:'mobile'" style="width: 165px;"></td>
				</tr>		
				<tr>
					<td style="text-align: right;font-weight: 600;">电子邮箱:</td>
					<td><input name="email" class="easyui-textbox" data-options="validType:'email'" style="width: 165px;"></td>
				</tr>							
			</table>
		</form>
	</div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveuser()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">取消</a>
    </div>
    
    <!--权限弹出框的表单设置  -->
	<div id="dlgg" class="easyui-dialog"
		style="width:550px;height:400px;padding:40px 20px;" closed="true" buttons="#dlg-buttonss">
        <form id="fmm" method="post">
			<table style="margin-top: 15px;margin-left: 50px;">
			    <tr>
					<td style="text-align: right;font-weight: 600;width: 100px;">*用户名称:</td>
					<td><input id="uuname" name="userName" style="width: 130px;"><input type="hidden" name="userName"></td>
					<td style="width: 130px;"></td>
					<td style="width: 120px;"></td>					
				</tr>	
			</table>
			<table style="margin-top: 15px;margin-left: 30px;">	
				<tr>
					<td style="text-align: right;font-weight: 600;"></td>
					<td><input onclick="allcheck();" value="all" type="checkbox" style="float: left;">全选/全不选</td>
					<td></td>
					<td></td>
				</tr>		
				<tr>
					<td style="text-align: right;font-weight: 600;">系统管理:</td>
					<td><input  type="checkbox" name="fy" value="1" style="float: left;">用户管理</td>
					<td><input  type="checkbox" name="fy" value="2" style="float: left;">区域管理</td>
					<td style="text-align: right;width: 50px;"></td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;">设备管理:</td>
					<td><input  type="checkbox" name="fy" value="11" style="float: left;">所有设备管理</td>
					<td><input  type="checkbox" name="fy" value="12" style="float: left;">生产管理</td>
					<td><input  type="checkbox" name="fy" value="13" style="float: left;">装箱管理</td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;"></td>
					<td><input  type="checkbox" name="fy" value="14" style="float: left;">出货管理</td>
				</tr>		
				<tr>
					<td style="text-align: right;font-weight: 600;">模块管理:</td>
					<td><input  type="checkbox" name="fy" value="31" style="float: left;">定位模块管理</td>
					<td><input  type="checkbox" name="fy" value="32" style="float: left;">通讯模块管理</td>
					<td><input  type="checkbox" name="fy" value="33" style="float: left;">WIFI模块管理</td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;">检测管理:</td>
					<td><input  type="checkbox" name="fy" value="41" style="float: left;">检测信息管理2016</td>
					<td><input  type="checkbox" name="fy" value="42" style="float: left;">检测信息管理2017</td>
					<td><input  type="checkbox" name="fy" value="43" style="float: left;">检测信息管理2018</td>
				</tr>
				<tr>
					<td style="text-align: right;font-weight: 600;"></td>
					<td><input  type="checkbox" name="fy" value="44" style="float: left;">终端SIM卡号管理</td>
					<td><input  type="checkbox" name="fy" value="45" style="float: left;">终端组装管理</td>
					<td><input  type="checkbox" name="fy" value="46" style="float: left;">红岩SIM卡号导入</td>
				</tr>													
			</table>		
         </form>
    </div>
    <div id="dlg-buttonss">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveuserfun()" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlgg').dialog('close')" style="width:90px">取消</a>
    </div>    
    
	<script type="text/javascript">
		//根据userId查询用户权限
	    function ckuserfun(){
	    	$("#uuname").attr("disabled",true);
	    	var row = $('#dg').datagrid("getSelected");
	    	if (row){
	    		$('#fmm').form('clear');
	    		$('#dlgg').dialog('open').dialog('center').dialog('setTitle','查看及修改权限');
	    		$('#fmm').form('load',row);
	    		//$("input[value='2']").trigger("click");	
	    		$.ajax({
	    			type : 'get',
	    			url : 'SelectFunByUserId.action?userid='+row.id,
	    			dataType : 'json',
	    			success:function(data){
	    				var str = data.funlist;
	    				for(var i=0; i<str.length;i++){
	    					$("input[value='"+str[i].id+"']").trigger("click");
	    				}
	    			}
	    		});
	        }else{
	      	    $.messager.alert('提示','请选择要管理的用户!');
	        }	
	    }
		//给用户添加或修改权限
	    function saveuserfun(){
	    	  var chk_value =[];    
	    	  $('input[name="fy"]:checked').each(function(){    
	    	      chk_value.push($(this).val());    
	    	  });   
	    	  if(chk_value.length==0){
	    		  $.messager.confirm('确认','此用户将未有任何权限!',function(r){    
	    			    if (r){ //确认   
	    			    	$('#fmm').form('submit',{		  
    			                url: 'AddUserFun.action?chk='+chk_value, 
    			                success: function(result){
    			                    var result = eval('('+result+')');
    			                    //alert(result.ErrorCode);
    			                    if(result.ErrorCode == 0){
    			                	    $('#dlgg').dialog('close');
    			                        //$.messager.alert('操作提示','操作成功!');
    			                    }else if(result.ErrorCode == 1){
    			                	    $.messager.alert('操作提示','用户名错误,操作失败!');
    			                    }
    			                }
    			            });    
	    			    }    
	    		  }); 
	    	  }else{
	    		  $('#fmm').form('submit',{		  
		              url: 'AddUserFun.action?chk='+chk_value, 
		              success: function(result){
		                  var result = eval('('+result+')');
		                  //alert(result.ErrorCode);
		                  if(result.ErrorCode == 0){
		                      $('#dlgg').dialog('close');
		                      $.messager.alert('操作提示','操作成功!');
		                  }else if(result.ErrorCode == 1){
		                	  $.messager.alert('操作提示','用户名错误,操作失败!');
		                  }
		              }
		          }); 
	    	  }
	    	  /* alert(chk_value.length==0 ?'你还没有选择任何内容！':chk_value); */     
	          
	    }
		// 全选/全不选
	    function allcheck(){
	    	$("input[name='fy']").prop("checked",$("input[value='all']").prop("checked"));
	    	/* for(var i=1; i<=30;i++){
	    		if(!$("input[value='"+i+"']").is(':checked')){
	    			$("input[value='"+i+"']").trigger("click");
	    		}	
	    	}  */
	    }
	</script>
    
  </body>
</html>
