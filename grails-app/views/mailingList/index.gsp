<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mailingList.css')}" type="text/css">
		<g:set var="entityName" value="${message(code: 'mailingList.label', default: 'MailingList')}" />
		<title><g:message code="default.admin.menu.label" args="[entityName]" default="Welcome to ${entityName}" /></title>
	</head>
	<body>
		<g:render template="/mailingList/mainmenu" />
		<div class=clearall></div>
		<div id="the_box" role="complementary">
			<ul><li><div class="internalbtn">		
			<div id="scheduler-logo"><div class=app-detail><h4><g:message code="default.schedule.title.label" default="Schedule Email"/></h4></div></div>
			<div class="internalbtn"><g:link controller="mailingListEmail" class="list" action="index"><g:message code="default.email.person.label" default="Email a person" /></g:link></div>
			<div class="internalbtn"><g:link controller="mailingListEmail" class="list" action="contactclients"><g:message code="default.email.group.label" default="Contact Clients"  /></g:link></div>
			<div class="internalbtn"><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'oa',viewtype:'na']}"><g:message code="default.incomplete.label" default="Incomplete" args="[entityName]" /></g:link></div>
			<div class="internalbtn"><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'od',viewtype:'na']}"><g:message code="default.completed.label" default="Completed" args="[entityName]" /></g:link></div>
			<div id="templates-logo"><div class=app-detail><h4><g:message code="default.templates.title.label" default="Templates"/></h4></div></div>
			<div class="internalbtn"><g:link controller="MailingListTemplates" class="create" action="create"><g:message code="default.create.template.label" default="Create Email Template" /></g:link></div>
			<div class="internalbtn"><g:link controller="MailingListTemplates" class="create" action="loadtemplate"><g:message  code="default.create.from.existing.template.label" default="Create From existing Template" /></g:link></div>
			<div class="internalbtn"><g:link controller="MailingListTemplates" class="list" action="list"><g:message  code="default.list.template.label" default="List Email Templates"/></g:link></div>
			<div class="clearall"></div>
			<div id="attachment-logo"><div class=app-detail><h4><g:message code="default.attachments.title.label" default="Email Attachments"/></h4></div></div>
			<div class="internalbtn"><g:link controller="MailingListAttachments" class="create" action="create"><g:message code="default.add.attachments.label" default="Add Attachments"/></g:link></div>
			<div class="internalbtn"><g:link controller="MailingListAttachments" class="list" action="list"><g:message code="default.list.attachments.label" default="List Attachments"/></g:link></div>
			</div></li></ul>
		</div>
				
		<div id="the_box" role="complementary">
		<ul><li><div class="internalbtn">		
		<div id="mailinglistcat-logo"><div class=app-detail><h4><g:message code="default.categories.title.label" default="Categories (Binds to Email Address)"/></h4></div></div>
			<div class="internalbtn"><g:link controller="MailingListCategories" class="create" action="create"><g:message code="default.create.category.label" default="Create Category" /></g:link></div>
			<div class="internalbtn"><g:link controller="MailingListCategories" class="list" action="list"><g:message code="default.list.category.label" default="List Categories"/></g:link></div>
			<div class="clearall"></div>
			<div id="csv-logo"><div class=app-detail><h4><g:message code="default.csv.uploader.title.label" default="CSV Contacts Uploader"/></h4></div></div>
			<div class="internalbtn"><g:link controller="MailingListUploader" class="list" action="index"><g:message code="default.upload.csv.label" default="Upload CSV"/></g:link></div>
			<div class="clearall"></div>
			<div id="mailinglistsenders-logo"><div class=app-detail><h4><g:message code="default.configure.senders.title.label" default="Configure Senders (From)"/></h4></div></div>
			<div class="internalbtn"><g:link controller="MailingListSenders" class="create" action="create"><g:message code="default.create.senders.label" default="Create Email Sender"/></g:link></div>
			<div class="internalbtn"><g:link controller="MailingListSenders" class="list" action="list"><g:message code="default.list.senders.label" default="List Email Senders"/></g:link></div>
			<div class="clearall"></div>
			<div id="mailinglist-logo"><div class=app-detail><h4><g:message code="default.mailinglist.title.label" default="MailingList (All Email Addresses)"/></h4></div></div>
			<div class="internalbtn"><g:link controller="MailingList" class="create" action="create"><g:message code="default.create.email.label" default="Create Email"/></g:link></div>
			<div class="internalbtn"><g:link controller="MailingList" class="list" action="list"><g:message code="default.list.email.label" default="List Emails"/></g:link></div>
		</div></li></ul>
		
		<div id="sentResults" class="the_box">
		<g:if test="${scheduleCompleted}">
		<div id="returnPanel" class="resultsPane">
			<g:render template="/mailingList/scheduleCompleted" model="[sc:scheduleCompleted, total: total]"></g:render>
		</div>		
		</g:if>
	</div></div>
</body>
</html>
	
