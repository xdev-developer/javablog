<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
   <title>${article.title} / ${currentSection.name} / <spring:message code="website.name"/> </title>
 </head>
<body>
       <div class="titleBox"><a href="/sections/${currentSection.url}/"><b>${currentSection.name}</b></a> / ${article.title}<span><fmt:formatDate value="${article.created}" pattern="dd-MM-yyyy HH:mm"/></span></div>
	   <div class="article_content">
	    ${article.text}
	    <br/>
	    <div class="author"><spring:message code="article.author"/> : <b>${article.author}</b></div>
	    <br>
	   </div>
      <br/>
     <c:set var="isFirst" value="true"/> 
     <div class="spacer"></div>
     <a name="comments"><b><spring:message code="article.comments"/></b></a> <spring:message code="article.comments.by.theme"/> <b>${article.title}</b>(${article.commentsCount})
     <ol class="commentlist">
      <c:forEach items="${comments}" var="comment">
      	<c:choose>
	      	<c:when test="${isFirst}">
		        <li class="alt">
  	            <c:set var="isFirst" value="false"/>
		    </c:when>
	        <c:otherwise>
	          <li class="">
	          <c:set var="isFirst" value="true"/>
	        </c:otherwise>
        </c:choose>
           <b>${comment.author}</b> <spring:message code="article.comments.user.type"/>:
           <security:authorize ifAnyGranted="ROLE_ADMIN">
                <a href="/comment/${comment.id}/edit">
            		<img src="/images/page_white_edit.png" title="<spring:message code="controll.edit"/>" alt="<spring:message code="controll.edit"/>" border="0">
            	</a>
            	<a href="/comment/${comment.id}/delete" onclick="return confirm('<spring:message code="delete.confirm"/>');">
            		<img src="/images/page_white_delete.png" title="<spring:message code="controll.remove"/>" alt="<spring:message code="controll.remove"/>" border="0">
            	</a>
		 </security:authorize>
           <hr>
    	   	 <p>${comment.text}</p>
	    	 <small style="text-align:right;">
            	<fmt:formatDate value="${comment.createdDate}" pattern="dd-MM-yyyy HH:mm"/>
	    	 </small>
        </li>
     </c:forEach>
    </ol>
	<a name="last_comment"></a>
	<security:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
	    <div align="center">
		    <div class="titleBox"><spring:message code="article.comments.post.comment"/></div>
		    <form action="/comment/" method="post" id="commentform">
		      <textarea cols ="90%" rows = 8 class="comment_area" name="comment" id="comment"></textarea>
		      <div class="spacer"></div>
		      <div align="center"><input type="submit" value = "<spring:message code="article.comments.post.comment"/>" class="comment_add_btn"></div>
		      <input name="aid" id ="aid" value="${article.id}" type="hidden">
		      <input name="action" id ="action" value="add" type="hidden">
		   </form>
	   </div>
   </security:authorize>
</body>
</html>