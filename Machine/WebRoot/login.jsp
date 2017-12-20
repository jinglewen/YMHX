<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%   
   response.setHeader("Pragma","no-cache");   
   response.setHeader("Cache-Control","no-cache");   
   response.setDateHeader("Expires", 0);   
   response.setHeader("Cache-Control", "no-store");   
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员后台登陆</title>
    
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="shortcut icon" href="images/aoretec.png">
	<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/themes/color.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>  
 
     <style type="text/css">
        .lil{
           float: left;
           line-height: 30px;
           margin-left: 5px;
           list-style: none;
        }
     </style>     
  </head>
  
  <body>
    <div style="width: 900px;height: 450px;margin-left: 260px;margin-top: 130px;">
    
        <div style="width: 734px;height: 67px;background-color: white;background-image: url('images/jt2.png');float: left;"></div>
		<div style="width: 166px;height: 67px;float: left;">
			<div style="width: 166px;height: 68px;margin-top: 17px;background-image: url('images/jt3.png');background-repeat: no-repeat;text-align: center;padding-top: 8px;">
				<a href="login.jsp" style="text-decoration: none;">帮助中心</a>
			</div>
		</div>

        <div style="width: 554px;height: 309px;background-image: url('images/hezuo.jpg');float: left;"></div> 
	    <div style="width: 342px;height: 307px;background-color: #EDF5FF;float: right;border: 1px solid #ACC3E4;border-radius: 5px ">
	        <div style="width: 322px;height: 30px;padding-left: 20px;margin-top: 38px;"><span style="font-size: 15px;">管理员后台登录</span></div>
			
			<form id="fm">
				<table style="margin-left: 40px;margin-top: 35px;">
					<tr>
						<td align="right">用户名：</td>
						<td><input type="text" id="UserName" placeholder="请输入用户名" style="width: 150px;height: 25px;border: 1px solid #ccc"><span style="color: red;margin-left: 10px;" id="showUserNameMsg"></span></td>						
					</tr>
					<tr>
						<td align="right">密码：</td>
						<td><input type="password" id="PassWord" placeholder="请输入密码" style="width: 150px;height: 25px;border: 1px solid #ccc"><span style="color: red;margin-left: 10px;" id="showPassWordMsg"></span></td>
					</tr>
					<tr>
						<td align="right">验证码：</td>
						<td><input type="text" id="validatecode" style="width: 70px;height: 31px">
						<img id="loginform:vCode" style="position: relative;top: 12px;width: 75px;height: 31px;" src="validatecode.jsp" onclick="javascript:document.getElementById('loginform:vCode').src='validatecode.jsp?'+Math.random();" /><span style="color: red;margin-left: 10px;" id="showVCodeMsg"></span></td>
					</tr>
				</table>
				
				<input type="button" onclick="login()" value="登录" style="background-color: #4696EB;width: 70px;height: 30px;margin-left: 95px;margin-top: 15px;border: none;color: white;border-radius:5px;">
			</form>	
			
			<div style="color: red;position: relative;left: 95px;top: 5px;" id="showMsg"></div>
			
		</div>
		<div style="width: 900px;height: 80px;float: left;">
			<div style="width: 900px;height: 30px;margin-top: 10px;background-color: #EAF3FF;">
				<ul>
					<li class="lil" style="margin-left: 355px;"><a href="login.jsp" style="text-decoration: none;margin-right: 5px;">关于我们</a>|</li>
					<li class="lil"><a href="login.jsp" style="text-decoration: none;margin-right: 5px;">服务条款</a>|</li>
					<li class="lil"><a href="login.jsp" style="text-decoration: none;margin-right: 5px;">帮助中心</a>|</li>
				</ul>
			</div>
			<div style="width: 900px;height: 30px;background-image: url('images/jt4.png');"></div>
		</div>
	</div>
	<script type="text/javascript">
		if(window.name!="hasLoad"){    
		    location.reload();    
		    window.name = "hasLoad";    
		}else{    
		    window.name="";    
		} 
		document.onkeydown = function (e) {
            var event = e || window.event;
            var code = event.keyCode || event.which || event.charCode;
            if (code == 13) {
                login();
            }
        }
		function login() {
			$("#showMsg").html("");
			$("#showUserNameMsg").html("");
			$("#showPassWordMsg").html("");
			$("#showVCodeMsg").html("");
			var userName = $("#UserName").val();
			var passWord = $("#PassWord").val();
			var vCode = $("#validatecode").val().toLowerCase();
			
			if(userName == "") {
				$("#showUserNameMsg").html("请输入用户名");
				$('#UserName').focus();
			}else if(passWord == "") {
				$("#showPassWordMsg").html("请输入密码");
				$('#PassWord').focus();
			}else if(vCode == "") {
				$("#showVCodeMsg").html("请输入验证码");
				$('#validatecode').focus();
			}else {
				var userInfo = {
					UserName: userName,
					PassWord: passWord,
					vCode: vCode,
				};
				$.ajax({
					url: "UserLogin.action",
					type: "post",
					dataType: "json",
					data: userInfo,
					success: function(result) {
						if(result.ErrorCode == 0){
		              		window.location.href = "ym_user/machindex.jsp";
		                }else if(result.ErrorCode == 1){
		                	$("#showMsg").html("账户名与密码不匹配，请重新输入");
		                	$('#UserName').focus();
		                }else if(result.ErrorCode == 2){
		                	$("#showMsg").html("您输入的账号已被禁用");
		                }else if(result.ErrorCode == 3){
		                	$("#showMsg").html("您输入的账号已被删除");
		                }else if(result.ErrorCode == 4){
		                	$("#showMsg").html("您还无任何权限,请联系管理员索要权限再登录");
		                }else if(result.ErrorCode == 500){
		                	$("#showMsg").html("验证码输入不正确");
		                	$('#validatecode').focus();
		                }
					},
					error: function () {
						$.messager.alert('提示','服务器内部错误！');
					}
				});
			}
		}
	</script>
  </body>
</html>
