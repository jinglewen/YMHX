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
    
    <title>成都亿盟恒信科技有限公司</title>
    
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="shortcut icon" href="images/aoretec.png">
    <link rel="stylesheet" type="text/css" href="bootstrap/bootstrap-min.css"> 
    <link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">   
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css"> 
	<link rel="stylesheet" type="text/css" href="easyui/themes/color.css">
	<script type="text/javascript" src="easyui/jquery.min.js"></script>   
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="common/machindex.js"></script>

	<style type="text/css">	
		#aa a {
			text-decoration:none;
			color: black;
			margin-left: 40px;
			padding-top: 6px;
			padding-bottom: 4px;
			display:block;
		}
		#northSty {
			height: 80px;
			background: url("images/logo.jpg") no-repeat;
			background-color: #3768B4;
		}
		#aa a:hover{
			color: #912CEE;
		}
		#mbd a{
			color: red;
		}
	</style>
  </head>
  
<body class="easyui-layout">
    
    <!-- 头部 -->
    <div data-options="region:'north',border:false" id="northSty">
    	<div style="width:13%;text-align: center;float: left;margin: 22 0 0 25;">
    		<span style="color: white;font-size: 14px;">亿盟恒信</span><br>
    		<span style="color: white;font-size: 13px;">AORE TECHNOLOGY</span>
    	</div>
    	<div style="width: 70%;text-align: center;float: left;margin-top: 25px;">
    		<span style="font-size: 1.6em;font-style: oblique;color: white;">亿盟恒信生产管理系统</span>
    	</div>
    	<div id="mbd" style="width: 17%;text-align: center;float: right;">
    		<span style="margin-left: 20px;color: white;">欢迎您：</span><a href="javascript:void(0)" id="mb" class="easyui-menubutton" data-options="menu:'#mm',plain:true">${sessionScope.userinfo.getUserName()}</a>   
    		<div id="mm" style="width:100px;">   
			    <div data-options="iconCls:'icon-clear'"><a href="exitLogin.jsp" style="text-decoration: none;">退出系统</a></div>
			</div> 
    	</div>
    </div> 
    
    
    <!-- 左边菜单栏 -->
    <div data-options="region:'west',title:'菜单导航'" style="width:15%;">	
    	<!-- 折叠面板 -->
    	<div id="aa" class="easyui-accordion" data-options="multiple:true" style="overflow-y:auto;">
		    <c:if test="${sessionScope.u_list.size() > 0}">	         
			    <div title="系统管理" data-options="iconCls:'icon-man',selected:true,collapsed:false" style="padding-top: 5px;padding-bottom: 5px;">   
			        <c:forEach items="${sessionScope.u_list}" var="ufun">
			        	<a href="javascript:${ufun.getFunUrl()}();"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;${ufun.getFunName()}</a>   
			    	</c:forEach>
			    </div>
		    </c:if>
		    <c:if test="${sessionScope.m_list.size() > 0}">	         
			    <div title="设备管理" data-options="iconCls:'icon-large-shapes',selected:true,collapsed:false" style="padding-top: 5px;padding-bottom: 5px;">   
			        <c:forEach items="${sessionScope.m_list}" var="mfun">
			        	<a href="javascript:${mfun.getFunUrl()}();"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;${mfun.getFunName()}</a>   
			    	</c:forEach>
			    </div>
		    </c:if>
		    <c:if test="${sessionScope.p_list.size() > 0}">	         
			    <div title="模块管理" data-options="iconCls:'icon-large-shapes'" style="padding-top: 5px;padding-bottom: 5px;">   
			        <c:forEach items="${sessionScope.p_list}" var="pfun">
			        	<a href="javascript:${pfun.getFunUrl()}();"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;${pfun.getFunName()}</a>   
			    	</c:forEach>
			    </div>
		    </c:if>
		    <c:if test="${sessionScope.t_list.size() > 0}">	  
			    <div title="检测管理" data-options="iconCls:'icon-large-shapes',selected:true,collapsed:false" style="padding-top: 5px;padding-bottom: 5px;">   
			        <c:forEach items="${sessionScope.t_list}" var="tfun">
			        	<a href="javascript:${tfun.getFunUrl()}();"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;${tfun.getFunName()}</a>   
			    	</c:forEach>
			    </div>
		    </c:if>

		    <!-- <div title="用户管理" data-options="iconCls:'icon-man',selected:true,collapsed:false" style="padding-top: 5px;padding-bottom: 5px;">   
		        <a href="javascript:u_userinfo();"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;用户信息管理</a>
		        <a href="javascript:viod();"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;区域信息管理</a>   
		    </div>   
		    <div title="设备管理" data-options="iconCls:'icon-large-shapes',selected:true,collapsed:false" style="padding-top: 5px;padding-bottom: 5px;">   
		        <a href="javascript:m_mach();"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;所有设备管理</a>    
		    </div>   
		    <div title="模块管理" data-options="iconCls:'icon-large-shapes',selected:true,collapsed:false" style="padding-top: 5px;padding-bottom: 5px;">   
		        <a href="javascript:viod();"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;定位模块管理</a>    
		    </div>
		    <div title="检测管理" data-options="iconCls:'icon-large-shapes',selected:true,collapsed:false" style="padding-top: 5px;padding-bottom: 5px;">   
		        <a href="javascript:viod();"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;检测信息管理</a>    
		    </div> -->   
		</div>
    </div>
       
    
    <!-- 中部 -->   
    <div data-options="region:'center'" style="background:#eee;">
    	<!-- 选项卡 -->
	    <div id="tabsdiv" class="easyui-tabs" data-options="fit:true" >      
		    <!-- 例如欢迎界面! -->          
			<div title="欢迎界面">
			    <div style="margin-top: 280px;font-size: 2em;color: #EE7AE9;text-align: center;">欢迎进入设备后台管理系统</div>
			    <div style="font-size: 2em;color: #EE7AE9; text-align: center;">Welcome to the equipment background management system</div>              			    
			</div>      
		</div> 
    </div>
    
    
    <script type="text/javascript">
    	var lastTime = new Date().getTime();
        var currentTime = new Date().getTime();
        var timeOut = 60 * 60 * 1000; //设置超时时间： 60分钟
    	//页面预加载
    	$(function(){
    		 /* 鼠标移动事件 */
            $(document).mouseover(function(){
                lastTime = new Date().getTime(); //更新操作时间

            });
    	});
    	
    	function testTime(){
            currentTime = new Date().getTime(); //更新当前时间
            if(currentTime - lastTime > timeOut){ //判断是否超时
            	window.location.href = "exitLogin.jsp";
            	/* $.messager.alert('确认', '由于长时间未做任何操作，请重新登录！','info',function(){
            		window.location.href = "login.jsp";
            	});	 */
				/* $.messager.confirm('确认', '由于长时间未做任何操作，请重新登录！',function(r){
					if (r){
					    window.location.href = "login.jsp";
					}
				});  */
            }
        }

        /* 定时器  间隔1秒检测是否长时间未操作页面  */
        window.setInterval(testTime, 1000);
    	
    </script>
</body>
</html>
