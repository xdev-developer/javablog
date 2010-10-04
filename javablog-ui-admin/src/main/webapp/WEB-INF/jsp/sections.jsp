<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title><spring:message code="sections.title"/></title>
 </head>
  <body>        
         <div class="listTable">
	      <table cellpadding = "0" cellspacing = "0" align="center" width="100%">
	        <thead>
	          <th align="center"  width="60%"><spring:message code="section.name"/></th>
	          <th align="center"  width="20%"><spring:message code="section.url"/></th>
	          <th align="center"  width="10%"><spring:message code="section.articles.count"/></th>
	          <th colspan="2"  width="10%" ><spring:message code="controll.buttons"/></th>
	        </thead>
	        <tbody>
	        <c:forEach var="section" items="${sections}">
	          <tr>
	            <td align="left">${section.name}</td>
	            <td align="left">${section.url}</td>
	            <td align="left">${section.articlesCount}</td>
	            <td align="center">
	            	<a href="edit_section.shtml?sid=${section.id}">
	            		<img src="images/page_white_edit.png" title="<spring:message code="controll.edit"/>" alt="<spring:message code="controll.edit"/>" border="0">
	            	</a>
	            </td>
	            <td align="center">
	            	<a href="section.shtml?action=delete&sid=${section.id}" onclick="return confirm('<spring:message code="delete.confirm"/>')">
	            		<img src="images/page_white_delete.png" border="0" title="<spring:message code="controll.remove"/>" alt="<spring:message code="controll.remove"/>">
	            	</a>
	            </td>
	          </tr>
	         </c:forEach>
	        <tr>
	          <td align="left" colspan="6">
	           <div class="addForm">
	             <form action="edit_section.shtml" method="GET">
	               <input type="submit" value="<spring:message code="controll.add"/>">
	             </form>
	          </div>
	         </td>
	        </tr>
	         
	        </tbody>
	      </table>
	    </div>
</body>
</html>
