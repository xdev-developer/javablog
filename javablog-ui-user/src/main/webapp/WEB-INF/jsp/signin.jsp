<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
   <title><spring:message code="signin.title"/> / <spring:message code="website.name"/></title>
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
	</script>
     
	<form name="f" action="<c:url value='/j_spring_security_check'/>" method="POST">
	<table border=0 cellpadding="8" cellspacing = "0" align="center" width="35%" class="register">
        <tr>
   		  <th  colspan = 3 height="35" class="t_info"  width="10%"><spring:message code="signin.form.title"/></th>
   		</tr>
        <tr>
          <td class = "t_info"><b><spring:message code="signin.username"/></b></td>
          <td class = "t_data" colspan = 2>
	          <input type='text' id="j_username" name='j_username'  value='${SPRING_SECURITY_LAST_USERNAME}' />
              <c:if test="${not empty param.login_error}">
	           	<script>
					showBalloon('j_username', '<spring:message code="incorrect.user.username"/>');
				</script>
	          </c:if>
          </td>
        </tr>
        <tr>
          <td class = "t_info"><b><spring:message code="signin.password"/></b>
          </td>
          <td class = "t_data"  colspan = 2>
          	<input type='password' name='j_password'>         	
          </td>
        </tr>
        <tr>
          <td class = "t_info" width="40%">&nbsp;</td>
          <td class = "t_data" width="20%"><input type="submit" value="<spring:message code="signin.ok.button"/>"/></td>
          <td class = "t_data" width="40%">&nbsp;</td>
        </tr>
      </table>
    </form>
     
</body>
</html>