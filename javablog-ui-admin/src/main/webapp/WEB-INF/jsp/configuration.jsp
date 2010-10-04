<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title><spring:message code="configuration.title"/></title>
 </head>
  <body>  
        <form:form commandName="config">
	      <table cellpadding = "0" cellspacing = "0" align="center" class="silver" width="80%">
	        <thead>
	          <th align="left" colspan="3"><div style="color:black;"><spring:message code="configuration.list"/></div></th>
	        </thead>
	        <tbody>
	          <tr>
	            <td align="left" style="padding:4px;">
	            	<b><spring:message code="configuration.default.author"/></b>
	            </td>
	            <td align="left" style="padding:4px;">
	            	<form:input path="defaultArticleAuthor" size="40"/>
	            </td>
	            <td align="left" style="padding:4px;">
		            <div style="color:red;"><form:errors path="defaultArticleAuthor"/></div>
	            </td>
	          </tr>

	          <tr>
	            <td align="left" style="padding:4px;">
	            	<b><spring:message code="configuration.mail.stmp.host"/></b>
	            </td>
	            <td align="left" style="padding:4px;">
	            	<form:input path="mailSmtpHost" size="40"/>
	            </td>
	            <td align="left" style="padding:4px;">
		            <div style="color:red;"><form:errors path="mailSmtpHost"/></div>
	            </td>
	          </tr>

	          <tr>
	            <td align="left" style="padding:4px;">
	            	<b><spring:message code="configuration.admin.email"/></b>
	            </td>
	            <td align="left" style="padding:4px;">
	            	<form:input path="adminEmail" size="40"/>
	            </td>
	            <td align="left" style="padding:4px;">
		            <div style="color:red;"><form:errors path="adminEmail"/></div>
	            </td>
	          </tr>

	          <tr>
	            <td align="left" style="padding:4px;">
	            	<b><spring:message code="configuration.mail.sender.address"/></b>
	            </td>
	            <td align="left" style="padding:4px;">
	            	<form:input path="mailSenderAddress" size="40"/>
	            </td>
	            <td align="left" style="padding:4px;">
		            <div style="color:red;"><form:errors path="mailSenderAddress"/></div>
	            </td>
	          </tr>

	          <tr>
	             <td colspan="2" align="center" style="padding:4px;">
	             	<input type="submit" value="<spring:message code="controll.save"/>"/>
	             </td>
	          </tr>
	        </tbody>
	      </table>
	      </form:form>
        
</body>
</html>
