<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <title><spring:message code="users.title"/></title>
 </head>
  <body>  
      <div class="listTable">
	      <table cellpadding = "0" cellspacing = "0" align="center" width="100%">
	        <thead>
	          <th align="center"  width="20%"><spring:message code="user.username"/></th>
	          <th align="center"  width="20%"><spring:message code="user.email"/></th>
	          <th align="center"  width="20%"><spring:message code="user.registered"/></th>
	          <th align="center"  width="20%"><spring:message code="user.lastlogin"/></th>
	          <th align="center"  width="10%"><spring:message code="user.enabled"/></th>
	          <th colspan="2"  width="10%" ><spring:message code="controll.buttons"/></th>
	        </thead>
	        <tbody>
	        <c:forEach var="user" items="${users}">
	          <tr>
	            <td align="left">${user.username}</td>
	            <td align="left">${user.email}</td>
	            <td align="center"><fmt:formatDate value="${user.registered}" pattern="dd-MM-yyyy HH:mm:ss"/></td>
	            <td align="center"><fmt:formatDate value="${user.lastLogin}" pattern="dd-MM-yyyy HH:mm:ss"/></td>
	            <td align="center">${user.enabled}</td>
	            <td align="center">
	            	<a href="user.shtml?action=changeStatus&id=${user.id}">
	            		<c:choose>
		            		<c:when test="${user.enabled}">
		            			<img src="images/status_online.png" title="<spring:message code="users.change.status"/>" alt="<spring:message code="users.change.status"/>" border="0">
		            		</c:when>
		            		<c:otherwise>
		            			<img src="images/status_offline.png" title="<spring:message code="users.change.status"/>" alt="<spring:message code="users.change.status"/>" border="0">
		            		</c:otherwise>
	            		</c:choose>
	            	</a>
	            </td>
	            <td align="center">
	            	<a href="user.shtml?action=delete&id=${user.id}" onclick="return confirm('<spring:message code="delete.confirm"/>')">
	            		<img src="images/page_white_delete.png" border="0" title="<spring:message code="controll.remove"/>" alt="<spring:message code="controll.remove"/>">
	            	</a>
	            </td>
	          </tr>
	         </c:forEach>
	        </tbody>
	      </table>
	    </div>
</body>
</html>
