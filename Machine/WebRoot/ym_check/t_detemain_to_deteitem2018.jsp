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
    
    <title>detectionitem2018.jsp</title>
    
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
  
    <div style="width: 100%; height: 100%;">
    	<table style="width: 100%;" class="gridtable">
    				<tr>
    				  <!-- <th style="width: 20%;">附表编号</th> -->
    				  <th style="width: 27%;">检测项目</th>	
    				  <th style="width: 27%;">检测结果</th>	
    				  <!-- <th style="width: 28%;">检测项目ID</th> -->	
    				  <th style="width: 26%;">检测状态</th>		
    				</tr>
		    <c:forEach items="${requestScope.deteitem2018}" var="item">
				    <tr>
				      <%-- <td>${item.getId()}</td> --%>
				      <c:if test="${item.getAssayType() == -1}">
				      	<td>无</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 0}">
				      	<td>检测刹车信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 1}">
				      	<td>检测近光灯信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 2}">
				      	<td>检测远光灯信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 3}">
				      	<td>检测喇叭信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 4}">
				      	<td>检测左转弯灯信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 5}">
				      	<td>检测右转弯灯信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 6}">
				      	<td>检测雾灯信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 7}">
				      	<td>检测车门信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 8}">
				      	<td>检测劫警信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 9}">
				      	<td>检测照明信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 10}">
				      	<td>检测倒车信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 11}">
				      	<td>检测主电源电压</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 12}">
				      	<td>检测天线连接 </td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 13}">
				      	<td>检测卫星颗数</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 14}">
				      	<td>电话卡入网状态</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 15}">
				      	<td>检测网络信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 16}">
				      	<td>检测摄像头状态</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 17}">
				      	<td>读取IC卡信息</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 18}">
				      	<td>检测脉冲速度</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 19}">
				      	<td>检测K线信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 20}">
				      	<td>检测AD信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 21}">
				      	<td>检测CAN信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 22}">
				      	<td>检测串口1</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 23}">
				      	<td>检测E口</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 24}">
				      	<td>检测F口</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 25}">
				      	<td>USB插入检测</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 26}">
				      	<td>检测铁电存储器工作状态</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 27}">
				      	<td>检测外部flash工作状态</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 28}">
				      	<td>检测外部RTC工作状态</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 29}">
				      	<td>检测MIC工作状态</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 30}">
				      	<td>检测喇叭工作状态</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 31}">
				      	<td>检测蜂鸟器工作状态</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 32}">
				      	<td>外部AD1输入</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 33}">
				      	<td>外部AD2输入</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 34}">
				      	<td>外部AD3输入</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 35}">
				      	<td>外部AD4输入</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 36}">
				      	<td>检测ACC信号</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 37}">
				      	<td>SD卡检测</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 38}">
				      	<td>打印机测试</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 39}">
				      	<td>TTS语音测试</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 40}">
				      	<td>摄像头测试</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 41}">
				      	<td>灾备测试</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 42}">
				      	<td>硬盘测试</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 43}">
				      	<td>WIFI测试</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 44}">
				      	<td>踩离合测试</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 45}">
				      	<td>水暖测试</td>
				      </c:if>
				      <c:if test="${item.getAssayType() == 46}">
				      	<td>空调测试</td>
				      </c:if>
				      
				      <%-- <td style="width: 12%;">${item.getAssayType()}</td> --%>
				      <c:if test="${fn:contains(item.getResult(), 'Failed')}">  
				      	<td id="tdresult">${item.getResult()}</td>
				      </c:if>
				      <c:if test="${fn:contains(item.getResult(), 'Pass')}"> 
				      	<td>${item.getResult()}</td>
				      </c:if>
				      <c:if test="${fn:contains(item.getResult(), '天线')}"> 
				      	<td>${item.getResult()}</td>
				      </c:if>
				      <c:if test="${fn:contains(item.getResult(), '超时')}"> 
				      	<td>${item.getResult()}</td>
				      </c:if>				      
				      <c:if test="${fn:length(item.getResult()) <= 1}">
				      	<td>${item.getResult()}</td>
				      </c:if>
				      
				      <%-- <td>${item.getDetectionMainId()}</td> --%>
				      <td>${item.getState()}</td>
				    </tr>
		    </c:forEach>
	    </table>
    </div>  

  </body>
</html>
