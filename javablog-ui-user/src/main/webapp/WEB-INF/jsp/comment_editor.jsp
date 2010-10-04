<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
   <title>${article.title} / ${article.section.name} / <spring:message code="website.name"/> </title>
 </head>
<body>
       <div class="titleBox"><a href="/sections/${article.section.url}/"><b>${article.section.name}</b></a> / ${article.title}<span><fmt:formatDate value="${article.created}" pattern="dd-MM-yyyy HH:mm"/></span></div>
	   <div class="article_content">
	    ${article.text}
	    <br/>
	    <div class="author"><spring:message code="article.author"/> : <b>${article.author}</b></div>
	    <br>
	   </div>
      <br/>
	<security:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
	    <div align="center">
		    <div class="titleBox"><spring:message code="article.comments.edit.comment"/></div>
		    <form action="/comment/" method="post" id="commentform">
		      <textarea cols ="90%" rows = 8 class="comment_area" name="comment" id="comment">${comment.text}</textarea>
		      <div class="spacer"></div>
		      <div align="center"><input type="submit" value = "<spring:message code="article.comments.edit.comment"/>" class="comment_add_btn"></div>
		      <input name="aid" id ="aid" value="${article.id}" type="hidden">
		      <input name="cid" id ="cid" value="${comment.id}" type="hidden">
		      <input name="action" id ="action" value="save" type="hidden">
		   </form>
	   </div>
   </security:authorize>
</body>
</html>