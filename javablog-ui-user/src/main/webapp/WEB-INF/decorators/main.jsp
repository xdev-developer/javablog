<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
   <title><decorator:title default="JavaBlog :: Home"/></title>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
   <meta http-equiv="Content-Style-Type" content="text/css"/>

   <!--[if IE]>
	<link href="/css/main_IE.css" rel="Stylesheet" type="text/css">
   <![endif]-->
   <!--[if IE]><![if !IE]><![endif]-->
    <link href="/css/main.css" rel="Stylesheet" type="text/css"/>
   <!--[if IE]><![endif]><![endif]-->
   
   <script src="/js/jquery-1.3.2.min.js" type="text/javascript"></script>
   <script src="/js/jquery.qtip-1.0.0-rc3.min.js" type="text/javascript"></script>
   <!-- TinyMCE -->
   <script type="text/javascript" src="/tiny_mce/tiny_mce.js"></script>
   <script type="text/javascript">
       	tinyMCE.init({
       		mode : "textareas",
       		theme : "simple",
       		height : "200",
       		width : "100%",
       		language:"ru",
       		force_br_newlines : true,
       		content_css : "/css/main.css"
       	});
   </script>
   <!-- /TinyMCE -->   
</head>
<body>
	<table border=0 style="margin: 0 auto; height:100%;" width="100%" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="3" valign="top" style="height:190px;">
		<table class="header" border=0 style="height:100%;" width="100%" cellpadding="0" cellspacing="0">
		      <tr>
		       <td class="logo" valing="top"></td>
		       <td class="title"><spring:message code="website.name"/></td>
		       <td class="u_menu" valign="top">
		       	 <div class="login">
		       	 
		       	 	<security:authorize ifAnyGranted="ROLE_ANONYMOUS">
			       	 	<a href="/signin/">login</a> | <a href="/register/">register</a>
		       	 	</security:authorize>
		       	 	
		       	 	<security:authorize ifAnyGranted="ROLE_USER,ROLE_ADMIN">
		       	 		<a href="<c:url value="/j_spring_security_logout"/>">Logout [ <security:authentication property="principal.username"/> ]</a>
		       	 	</security:authorize>

		       	 </div> 
		         <div class = "find">
		          <form action="#" >
		          <input type="text" /><input type="image" src="/images/find_btn.gif" title="find_btn" class="find_btn"/>
		          </form>
		         </div>
		       </td>
		      </tr>
		</table>
    </td>
  </tr>
  <tr>
    <td style="width:170px;" valign="top" align="left">
    <!-- menu -->
    <div class="sidebox-l">
	     <div class="boxhead"><div class="bhtitle"><spring:message code="menu.sections"/></div></div>
	     <div class="boxbody">
	       <div class="content">
	        <div class="listmenu">
	          <ul>
	          	  <li><a href="/home/"><spring:message code="menu.home"/></a></li>
	          	  <c:forEach items="${sections}" var="section">
	          	  	  <c:if test="${section.articlesCount > 0}">
		              	<li><a href="/sections/${section.url}/">${section.name}</a></li>
		              </c:if>
	              </c:forEach>
	          </ul>
	         </div>   
 		   </div>
       </div>
       <div class="boxFooter"></div>
   </div>
    <c:if test="${mostCommentedArticles != null}">
	    <div class="sidebox-l">
		     <div class="boxhead"><div class="bhtitle"><spring:message code="menu.article.top"/></div></div>
		     <div class="boxbody">
		       <div class="content">
		       <div class="listmenu">
	          <ul>
				<c:forEach items="${mostCommentedArticles}" var="topArticle" varStatus="status">
					<li><a href="/sections/${topArticle.section.url}/${topArticle.id}/">${status.index}. ${topArticle.title}</a></li>
				</c:forEach>          
	          </ul>
	         </div>   
	  		   </div>
	       </div>
	       <div class="boxFooter"></div>
	   </div>
   </c:if>
    </td>
    <!-- Content -->
    <td valign="top" align="left" height="100%" style="width:100%">
    	<div class="content">
    		<decorator:body/>
    	</div>
    </td>
      <td style="width:170px;" valign="top" align="left">
     <c:if test="${news != null}">
	      <div class="sidebox-r">
		     <div class="boxhead"><div class="bhtitle"><spring:message code="menu.news"/></div></div>
	       <div class="boxbody">
	         <div class="content">
	           <div class="listmenu">
	            <ul>
	              <li><a href="#"></a></li>
	              <li><a href="#"></a></li>
	            </ul>
	           </div>   
	    	  </div>
	       </div>
	      <div class="boxFooter"></div>
	</c:if>
    </td>
  </tr>
  <tr>
    <td style="height:35px; background-color:#312d27;" colspan="3" valign="center">
    	<div class="footer"><a href=""><spring:message code="website.copyright"/></a></div>
    </td>
  </tr>
</table>
</body>
</html>