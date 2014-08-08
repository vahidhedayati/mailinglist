<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
			<link rel="stylesheet" href="${resource(dir: 'css', file: 'mailingList.css')}" type="text/css">
		<g:set var="entityName" value="${message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
			<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		
	</div>	
		<div id="create-mailingListTemplates" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

<div class="heading">
<g:message code="default.category.name.upload.label" default="Define category name, browse and Upload A CSV file"/>
</div>			
<p><g:message code="default.upload.methods.label" default="You can upload two types of CSV files which are your exported outlook contact lists."/></p>
<p><b><g:message code="default.two.field.csv.label" default="1: 2 field CSV file"/></b><br/>
<b><g:message code="default.two.field.csv.fields.label" default="E-mail Display Name,E-mail Address"/></b><br>
<g:message code="default.two.field.csv.fields.details.label" default="The fields must be in the above format and the first line must be a heading since it ignores the first line of the CSV file"/>
</p>
<br/><br/>
<p><b><g:message code="default.seven.field.csv.label" default="2: 7 field CSV file"/></b><br/>
<b><g:message code="default.seven.field.csv.fields.label" default="'Title','First Name','Middle Name','Last Name','Categories','E-mail Address','E-mail Display Name'"/>
</b><br>
<g:message code="default.seven.field.csv.fields.details.label" default="The fields must be in the above format and the first line must be a heading since it ignores the first line of the csv file"/>
</p>

<g:uploadForm action="upload">
<div class="fieldcontain ${hasErrors(bean: params, field: 'catname', 'error')} ">
	<label for="catname">
		<g:message code="manager.label" default="Mailing List Name" />
	</label>
	<input type="text" name="catname">
	</div>
	<div class="fieldcontain ${hasErrors(bean: params, field: 'file', 'error')} ">
	<label for="file">
		<g:message code="manager.label" default="Choose File" />
	</label>
    <input type="file" name="file">
    </div>
    <g:submitButton name="upload" value="Upload"/>
</g:uploadForm>
</div>
</body>
</html>