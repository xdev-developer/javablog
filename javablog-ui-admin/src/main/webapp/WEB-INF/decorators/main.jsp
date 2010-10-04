<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<html>
  <head>
    <title><decorator:title default="Admin panel"/></title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
    <meta http-equiv="Expires" content="0"/>
    <meta http-equiv="Cache-Control" content="no-cache"/> 
    <meta http-equiv="Pragma" content="no-cache"/>
    <link href="css/adm.css" rel="Stylesheet" type="text/css" />
    
    <!-- TinyMCE -->
    <script type="text/javascript" src="tiny_mce/tiny_mce.js"></script>
    <script type="text/javascript">
    	tinyMCE.init({
    		mode : "textareas",
    		theme : "advanced",
    		language:"ru",
    		plugins : "safari,pagebreak,style,layer,table,save,advhr,advimage,advlink,emotions,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template",
      		theme_advanced_buttons1 : "save,newdocument,|,bold,italic,underline,strikethrough,|,justifyleft,justifycenter,justifyright,justifyfull,styleselect,formatselect,fontselect,fontsizeselect",
    		theme_advanced_buttons2 : "cut,copy,paste,pastetext,pasteword,|,search,replace,|,bullist,numlist,|,outdent,indent,blockquote,|,undo,redo,|,link,unlink,anchor,image,cleanup,help,code,|,insertdate,inserttime,preview,|,forecolor,backcolor",
    		theme_advanced_buttons3 : "tablecontrols,|,hr,removeformat,visualaid,|,sub,sup,|,charmap,iespell,media,advhr,|,print,|,ltr,rtl,|,fullscreen",
    		theme_advanced_buttons4 : "insertlayer,moveforward,movebackward,absolute,|,styleprops,|,cite,abbr,acronym,del,ins,attribs,|,visualchars,nonbreaking,pagebreak",
    		theme_advanced_toolbar_location : "top",
    		theme_advanced_toolbar_align : "left",
    		theme_advanced_statusbar_location : "bottom",
       		width : "100%",
       		height : "500",
    		content_css : "css/adm.css",
    	});
    </script>
    <!-- /TinyMCE -->
 </head>
 
  <body>
  <table height="100%" width="100%" border=0 cellpadding="0" cellspacing="0">
    <tr>
      <!-- Header -->
      <td colspan = "2" height="192px" valign="top">
      <div id ="header">
        <div id="logo"><div id="logo_text"><spring:message code="logo"/></div></div>
      </div>
      </td>
    </tr>
    <tr>
      <!-- Menu -->
      <td width="170px" valign="top" style="padding-top:5px;">
      		<table height="99%" width="170px" border = 0 cellpadding="0" cellspacing="0" valing="top">
				<tr>
			  		<td height="31px"><div id = "menuHead"><spring:message code="menu.header"/></div></td>
			    </tr>
			    <tr>
			    	<td valign="top">
			        	<div id = "menuContent">
			                <ul>
			                  <li><a href="sections.shtml"><spring:message code="menu.sections"/></a></li>
			                  <li><a href="articles.shtml"><spring:message code="menu.articles"/></a></li>
			                  <li><a href="users.shtml"><spring:message code="menu.users"/></a></li>
			                  <li><a href="configuration.shtml"><spring:message code="menu.configuration"/></a></li>
			                </ul>
			              </div>
			              <div id = "menuBottom">&nbsp;</div>
			        </td>
			    </tr>
			</table>
      </td>
      <!-- Content -->
      <td valign="top" width="100%" height="100%">
        <div id="content">
        	<decorator:body/>
	    </div>
      </td>
    </tr>
    <tr>
      <!-- Footer -->
      <td colspan = "2"  height="35px">
        <div id="footer" align="center" valign="center">
          <div id="copy"><spring:message code="copyright"/></div> 
        </div>
      </td>
    </tr>
  </table>
  </body>
</html>
