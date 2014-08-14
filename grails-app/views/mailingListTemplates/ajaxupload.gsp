<html>
	<head>
	
			<g:if test="${mailinglist.verifyAppVersion().equals('resources')}">
				<meta name='layout' content="mailingListMini"/>
			</g:if>	
			<g:else>
				<meta name='layout' content="mailingListMiniAssets"/>
			</g:else>
		
		<g:set var="entityName" value="${message(code: 'MailingListSchedule.label', default: 'MailingList Schedule')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body >
	<div id="mailerTemplates1">
		<g:render template="/mailingListModal/modalbasicSelfPost" model="[formId:'TemplatesForm', title:'Generate Template',controller: 'mailingListTemplates', callPage: 'formAjax' , divId: 'mailerTemplates', id: 'TEMPLATES']" />
 	</div>
</body>
</html>

