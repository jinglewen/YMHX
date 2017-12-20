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
    
    <title>设备详细信息</title>

    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		tr td{
			text-align: center;
		}
		table.gridtable {
			font-family: verdana,arial,sans-serif;
			font-size:11px;
			color:#333333;
			border-width: 1px;
			border-color: #666666;
			border-collapse: collapse;
		}
		table.gridtable th {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #dedede;
		}
		table.gridtable td {
			border-width: 1px;
			padding: 8px;
			border-style: solid;
			border-color: #666666;
			background-color: #ffffff;
		}
		#tdresult{
			color: red;
			font-size: 1.1em;
		}
	</style>

  </head>
    
  <body>	
 <c:if test="${requestScope.listpro.size() > 0}">
 <c:forEach items="${requestScope.listpro}" var="pro">
 <div>设备序列号:${pro.getSerNumber()} &nbsp;&nbsp;设备型号:${pro.getMachName()} &nbsp;&nbsp;设备状态:<span style="color: red;">${pro.getMachState()}</span></div>       
  <p>--------<span style="font-weight: 600;">设备出厂信息</span>---------------------------------------------------------------------------------------------------------------</p>
  <table style="width: 100%;" class="gridtable">
  	<tr>
	  <th style="width: 9%;">单板ID</th>
	  <th style="width: 9%;">通讯模块</th>	
	  <th style="width: 9%;">定位模块</th>
	  <th style="width: 9%;">终端ID</th>
	  <th style="width: 9%;">生产商ID</th>	
	  <th style="width: 9%;">主服务器IP1</th>
	  <th style="width: 9%;">主服务器IP2</th>
	  <th style="width: 9%;">主服务器IP3</th>	
	</tr>
    <tr>
       <td>${pro.getDetectionId()}</td>
       <td>${pro.getPhModule()}</td>
       <td>${pro.getPsModule()}</td>
       <td>${pro.getTerminalId()}</td>
       <td>${pro.getManufacturerId()}</td>
       <td>${pro.getMainnetIp1()}</td>
       <td>${pro.getMainnetIp2()}</td>
       <td>${pro.getMainnetIp3()}</td>
    </tr>
    <tr>
       <th style="width: 9%;">备服务器IP1</th>
	   <th style="width: 9%;">备服务器IP2</th>
	   <th style="width: 9%;">备服务器IP3</th>
       <th style="width: 9%;">省ID</th>
       <th style="width: 9%;">市县ID</th>
       <th style="width: 9%;">TCP端口1</th>
       <th style="width: 9%;">TCP端口2</th>
       <th style="width: 9%;">TCP端口3</th>
    </tr>
    <tr>
       <td>${pro.getSecondnetIp1()}</td>
       <td>${pro.getSecondnetIp2()}</td>
       <td>${pro.getSecondnetIp3()}</td>
       <td>${pro.getProvinceId()}</td>
       <td>${pro.getCityId()}</td>
       <td>${pro.getTcpprot1()}</td>
       <td>${pro.getTcpprot2()}</td>
       <td>${pro.getTcpprot3()}</td>
    </tr>
	<tr>
       <th style="width: 9%;">UDP端口1</th>
       <th style="width: 9%;">UDP端口2</th>
       <th style="width: 9%;">UDP端口3</th>
       <th style="width: 9%;">APN名称</th>
       <th style="width: 9%;">APN用户名</th>
       <th style="width: 9%;">APN密码</th>
       <th style="width: 9%;">硬件版本</th>
       <th style="width: 9%;">软件版本</th>
    </tr>
    <tr>
       <td>${pro.getUdpprot1()}</td>
       <td>${pro.getUdpprot2()}</td>
       <td>${pro.getUdpprot3()}</td>
       <td>${pro.getApnname()}</td>
       <td>${pro.getApnuserName()}</td>
       <td>${pro.getApnpassWrod()}</td>
       <td>${pro.getHardwareversion()}</td>
       <td>${pro.getSoftwareversion()}</td>
    </tr>
    <tr>
       <th style="width: 9%;">通讯模式1</th>
       <th style="width: 9%;">通讯模式2</th>
       <th style="width: 9%;">通讯模式3</th>
       <th style="width: 9%;">车牌号</th>
       <th style="width: 9%;">车牌颜色</th>
       <th style="width: 9%;">SIM卡号</th>
       <th style="width: 9%;">生产日期</th>
       <th style="width: 9%;">生产人</th>
    </tr>
    <tr>
       <td>${pro.getPhoneModel1()}</td>
       <td>${pro.getPhoneMode2()}</td>
       <td>${pro.getPhoneModel3()}</td>
       <td>${pro.getCarplateNum()}</td>
       <td>${pro.getCarplateColor()}</td>
       <td>${pro.getSimcard()}</td>
       <td>${pro.getProductDate()}</td>
       <td>${pro.getProductUserName()}</td>
    </tr>
   </table>                                     
 </c:forEach>  
 </c:if>

 

  </body>
</html>
