<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title><spring:message code="articles.title"/></title>
 </head>
  <body>  
    <div class="listTable">
    <form action="articles.shtml">
	    <b><spring:message code="section.name"/> :: </b>
	    <select id="sid" name="sid">
	    	<option value="-1"><spring:message code="pager.controll.all"/></option>
	     	<c:forEach var="sect" items="${sections}">
	     		<option value="${sect.id}" <c:if test="${sect.id == sid}">selected</c:if>>${sect.name}</option>
	     	</c:forEach>
	    </select>
	    <input type="submit" value="<spring:message code="controll.show"/>"/>
    </form>
    <hr>
      <table cellpadding = "0" cellspacing = "0" align="center" width="100%">
        <thead>
          <th align="left"  width="60%"><spring:message code="article.title"/></th>
          <th align="center"  width="15%"><spring:message code="article.author"/></th>
          <th align="center"  width="15%"><spring:message code="article.created"/></th>
          <th colspan="2"  width="10%" ><spring:message code="controll.buttons"/></th>
        </thead>
        <tbody>
	      <c:forEach var="article" items="${articles}">
	          <tr>
	            <td align="left">${article.title}</td>
	            <td align="center">${article.author}</td>
	            <td align="center"><fmt:formatDate value="${article.created}" pattern="dd-MM-yyyy HH:mm:ss"/></td>
	            <td align="center">
	            	<a href="edit_article.shtml?sid=${article.sectionId}&id=${article.id}">
	            		<img src="images/page_white_edit.png" title="<spring:message code="controll.edit"/>" alt="<spring:message code="controll.edit"/>" border="0">
	            	</a>
	            </td>
	            <td align="center">
	            	<a href="article.shtml?action=delete&aid=${article.id}" onclick="return confirm('<spring:message code="delete.confirm"/>')">
	            		<img src="images/page_white_delete.png" border="0" title="<spring:message code="controll.remove"/>" alt="<spring:message code="controll.remove"/>">
	            	</a>
	            </td>
	          </tr>
          </c:forEach>
          <c:if test="${sid != -1}">
	        <tr>
	          <td align="left" colspan="6">
	           <div class="addForm">
	             <form action="edit_article.shtml" method="GET">
	               <input type="hidden" name="sid" value="${sid}"/>
	               <input type="submit" value="<spring:message code="article.add"/>">
	             </form>
	          </div>
	         </td>
	        </tr>
	      </c:if>
        </tbody>
      </table>
      </div>     
</body>
</html>
