<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <script type="text/javascript" src="easyui/jquery.min.js"></script>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		
		#div1{
			width: 100px;
			height: 100px;
			background-color: #eee;
			position: relative;
		}
		#div2{
			width: 50px;
			height: 50px;
			background-color: red;
			position: absolute;
			left: 0px;
			bottom: 0px;
		}
		.dialog{
			width: 200px;
			height: 200px;
			background-color: black;
			position: absolute;
			left: 40%;
			top: 40%;
			z-index: 1000;
			display: none;
		}
		.dialog_head{
			width: 100%;
			height: 20px;
			background-color: blue;
			position: absolute;
			left: 0px;
			top: 0px;
		}
		.dialog_head a{
			color: white;
			text-decoration: none;
			float: right;
		}
		.add_dialog{
			display: block;
		}
		.dialog_head:HOVER {
			cursor: move;
		}
	</style>
	
  </head>
  
<body>
    
    <div id="div1">
    	<div id="div2"></div>
    </div>
    <input type="button" value="点击" onclick="adddialog();">
    <div class="dialog">
    	<div class="dialog_head">
    		<a href="javascript:removedialog();">×</a>
    	</div>
    </div>
    
    <script type="text/javascript">
    	//弹出框的显示与隐藏
		function adddialog(){
			$(".dialog").addClass("add_dialog");
		}
		function removedialog(){
			$(".dialog").removeClass("add_dialog");
		}
		
		//页面预加载	
		$(document).ready(function(){
			//拖拽div的实现方法
			$(".dialog").mousedown(function(e){ //e鼠标事件 
				$(this).css("cursor","move");//改变鼠标指针的形状 
				var offset = $(this).offset();//DIV在页面的位置 
				var x = e.pageX - offset.left;//获得鼠标指针离DIV元素左边界的距离 
				var y = e.pageY - offset.top;//获得鼠标指针离DIV元素上边界的距离 
				$(document).bind("mousemove",function(ev){//绑定鼠标的移动事件，因为光标在DIV元素外面也要有效果，所以要用doucment的事件，而不用DIV元素的事件 
					$(".dialog").stop();//加上这个之后 
					var _x = ev.pageX - x;//获得X轴方向移动的值 
					var _y = ev.pageY - y;//获得Y轴方向移动的值 
					$(".dialog").animate({left:_x+"px",top:_y+"px"},10); 
				}); 
			}); 
			$(document).mouseup(function(){ 
				$(".dialog").css("cursor","default"); 
				$(this).unbind("mousemove"); 
			}); 
		});
		
	</script>
	
</body>
</html>
