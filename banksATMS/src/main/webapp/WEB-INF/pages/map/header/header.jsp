<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/css/map.css" />" rel="stylesheet">
</head>
<body>
<fmt:setBundle  basename ="res" var = "rb"/>

   <div id="headermain">
    <div id = "internat">
         <a href="?language=en"><spring:message code="map.english" text="default text" />
        </a>|<a href="?language=ru"><spring:message code="map.russian" text="default text" /></a>
       
    </div>>
   <div>
</body>
</html>