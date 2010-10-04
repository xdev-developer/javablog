<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
   <title><spring:message code="register.title"/> / <spring:message code="website.name"/></title>
</head>
<body>
	<script>
	var ballonShowed = false;
	$.fn.qtip.styles.errorBalloon = { // Last part is the name of the style
			   width: 200,
			   background: '#f94825',
			   color: 'black',
			   textAlign: 'center',
			   border: {
			      width: 7,
			      radius: 5,
			      color: '#f94825'
			   },
			   tip: 'bottomLeft',
			   name: 'dark' // Inherit the rest of the attributes from the preset dark style
			}
	
	function showBalloon(elementName, errorMessage){
		if(ballonShowed)return;
		ballonShowed = true;
		$('#' + elementName).qtip({
			 content: errorMessage,
			 show: { ready: true },
			 hide: false,
			 api: {
			      onRender: function() {
			         this.elements.target.bind('click', this.destroy);
			      }
			 },
			 style:'errorBalloon',
			 position: {
			      corner: {
			         target: 'topRight',
			         tooltip: 'bottomRight'
			      }
			   }
		});
	}
	
	function submitForm(){
		$('#register').submit();
	}	
	</script>
	
	<form:form commandName="register">
	<table cellpadding="10" cellspacing = "0" align="center" width="70%" class="register">
	  <thead>
        <tr>
   		  <th colspan = 2 height="35" width="10%"><spring:message code="register.form.title"/></th>
   		</tr>
   	  </thead>
   	  <tbody>
        <tr>
          <td height="30px" width="50%">
          	<div class="req_name"><b><spring:message code="register.enter.username"/></b> * </div>
          	<div class ="reg_info"><spring:message code="register.enter.username.descr"/></div>
          </td>
          <td align = "right">
          	<form:input path="username"/>
          	<c:set var="usernameError"><form:errors path="username"/></c:set>
			<c:if test="${not empty usernameError}">
				<script>
					showBalloon('username', '${usernameError}');
				</script>
			</c:if>          	
          </td>
        </tr>
        <tr>
          <td height="30px" width="50%">
          	<div class="req_name"><b><spring:message code="register.enter.password"/></b> * </div>
          	<div class ="reg_info"><spring:message code="register.enter.password.descr"/></div>
          </td>
          <td align = "right">
          	<form:password path="password" showPassword="true" />
          	<c:set var="passwordError"><form:errors path="password"/></c:set>
			<c:if test="${not empty passwordError}">
				<script>
					showBalloon('password', '${passwordError}');
				</script>
			</c:if>          	
          </td>
        </tr>
        <tr>
          <td height="30px" width="50%">
          	<div class="req_name"><b><spring:message code="register.retype.password"/></b> * </div>
          	<div class ="reg_info"><spring:message code="register.retype.password.descr"/></div>
          </td>
          <td align = "right">
          	<form:password path="retypePassword" showPassword="true"/>
          	<c:set var="retypePasswordError"><form:errors path="retypePassword"/></c:set>
			<c:if test="${not empty retypePasswordError}">
				<script>
					showBalloon('retypePassword', '${retypePasswordError}');
				</script>
			</c:if>          	
          </td>
        </tr>
        <tr>
          <td height="30px" width="50%">
            <div class="req_name"><b><spring:message code="register.enter.email"/></b> * </div>
          	<div class ="reg_info"><spring:message code="register.enter.email.descr"/></div>
          </td>
          <td align = "right">
          	<form:input path="email"/>
          	<c:set var="emailError"><form:errors path="email"/></c:set>
			<c:if test="${not empty emailError}">
				<script>
					showBalloon('email', '${emailError}');
				</script>
			</c:if>          	
          </td>
        </tr>
		  <tr>
		   	<td height="30px" colspan=2 align="center">
		   		<div class="sent_btn">
		   			<a href="javascript:submitForm();"><spring:message code="register.register"/></a>
		   		</div>
		   	</td>
		  </tr> 
		</tbody>         
      </table>
    </form:form>
</body>
</html>