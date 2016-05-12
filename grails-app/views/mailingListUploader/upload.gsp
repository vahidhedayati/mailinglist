<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mailingListMini">
		<g:set var="entityName" value="${message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
			<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		
	</div>	
		<div id="create-mailingListTemplates" class="content scaffold-create" role="mailingListMini">
		<h1><g:message code="default.upload.result.label" args="[entityName]"  default="Upload result"/></h1>
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:message code="default.upload.output.label" default="output is as follows"/><br>
		${output}
		</div>
	</body>
</html>