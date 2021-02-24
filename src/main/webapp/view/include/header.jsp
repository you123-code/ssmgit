<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/global_color.css" /> 
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
        <%--<script>
        	$(function(){
        		$(".index_off").css("");
        	})
        </script>--%>
      
      
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
        当前登录用户: ${sessionScope.admin.aname }
            <!-- <img src="../images/logo.png" alt="logo" class="left"/> -->
            <a href="${pageContext.request.contextPath}/view/login.jsp">[退出]</a>
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
             <c:forEach items="${sessionScope.admin.lp}"  var="priv">
                <li><a href="${pageContext.request.contextPath}${priv.purl}" class="${priv.pclass}_off"></a></li>
               <%--  <li><jsp:forward page ="${pageContext.request.contextPath}${priv.purl}"/></li>--%>
            </c:forEach>
            </ul>
        </div>