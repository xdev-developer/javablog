<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
   <title>${currentSection.name} / <spring:message code="articles.list.title"/> / <spring:message code="website.name"/> </title>
 </head>
<body>
<c:forEach items="${currentSection.articles}" var="article">
		      <div class="titleBox">
		      	<a href="/sections/${article.section.url}/"><b>${article.section.name}</b></a>
		      	 / <a href="/sections/${article.section.url}/${article.id}/">${article.title}</a>
		      	 <span><fmt:formatDate value="${article.created}" pattern="dd-MM-yyyy HH:mm:ss"/></span>
		      </div>
			      <div class="content">
			      	${article.text}
 				      	<a href="/sections/${article.section.url}/${article.id}/" class="more"> more...</a>
			      </div>
      		  <div class="comments"><a href="/sections/${article.section.url}/${article.id}/#comments">comments(${article.commentsCount})</a></div>
		      <br><br>
</c:forEach>
</body>
</html>