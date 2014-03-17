
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
			<link rel="stylesheet" href="${resource(dir: 'css', file: 'mailingList.css')}" type="text/css">
		<g:set var="entityName" value="${message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-mailingListTemplates" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default=""/></a>
			<g:render template="/mailingList/mainmenu" />

		<div id="create-mailingListTemplates" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			output is as follows<br>
			
			${output}
			
			</div>

			</body>
			
			</html>