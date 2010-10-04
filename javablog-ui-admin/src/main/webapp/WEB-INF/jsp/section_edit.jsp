<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title><spring:message code="sections.edit.title"/></title>
 </head>
  <body>
	      <form:form commandName="section">
	      <table cellpadding = "0" cellspacing = "0" align="center" class="silver" width="80%">
	        <thead>
	          <th align="left" colspan="3">
				<img src="images/page_white_add.png" title="<spring:message code="controll.add"/>" alt="<spring:message code="controll.add"/>" border="0"/>
				<spring:message code="controll.add"/>	          	
			  </th>
	        </thead>
	        <tbody>
	          <tr>
	            <td align="left" style="padding:4px;">
	            	<b><spring:message code="section.name"/> *</b>
	            </td>
	            <td align="left" style="padding:4px;">
	            	<form:input path="name" size="40"/>
	            </td>
	            <td align="left" style="padding:4px;">
		            <div style="color:red;"><form:errors path="name"/></div>
	            </td>
	          </tr>
	          <tr>
	            <td align="left" style="padding:4px;">
	            	<b><spring:message code="section.url"/> *</b>
	            </td>
	            <td align="left" style="padding:4px;">
	            	<form:input path="url" size="40"/>
	            </td>
	            <td align="left" style="padding:4px;">
		            <div style="color:red;"><form:errors path="url"/></div>
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
