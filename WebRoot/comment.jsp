<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'comment.jsp' starting page</title>
    
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
    welcome:<s:property value="#request.username"/><br>
    <s:textarea name="text" cols="100" rows="10" label="please write" labelposition="left"></s:textarea>
    <table align="center" width="90%">
    <s:iterator value="#request.list" id="l">
    
    	<tr>
    		<td><s:property value="#l.user.username"/></td>
    		<td><s:property value="#l.comment"/></td>
    		<td><s:property value="#l.timestamp"/></td>
    	</tr>
    
    </s:iterator>
    </table>
  </body>
</html>
