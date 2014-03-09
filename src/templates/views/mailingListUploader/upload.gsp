
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-mailingListTemplates" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default=""/></a>
		<div id="nav3" class="nav3" role="navigation">
			<ul id="nav">
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>

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