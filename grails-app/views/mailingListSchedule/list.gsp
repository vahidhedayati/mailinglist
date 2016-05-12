<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mailingListMini">
		<g:set var="entityName" value="${message(code: 'mailingListSchedule.label', default: 'MailingListSchedule')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
			<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		 <ul class="nav-pills pull-right">
				<li class="btn btn-default"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li class="btn btn-default"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		</ul>
	</div>	
		<div id="list-mailingListSchedule" class="content scaffold-list" role="mailingListMini">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="addedby" title="${message(code: 'mailingListSchedule.addedby.label', default: 'Addedby')}" />
						<g:sortableColumn property="dateCreated" title="${message(code: 'mailingListSchedule.dateCreated.label', default: 'Date Created')}" />
						<g:sortableColumn property="dateTime" title="${message(code: 'mailingListSchedule.dateTime.label', default: 'Date Time')}" />
						<g:sortableColumn property="emailMessage" title="${message(code: 'mailingListSchedule.emailMessage.label', default: 'Email Message')}" />
						<g:sortableColumn property="lastUpdated" title="${message(code: 'mailingListSchedule.lastUpdated.label', default: 'Last Updated')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mailingListScheduleInstance}" status="i" var="instance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${instance.id}">${fieldValue(bean: instance, field: "addedby")}</g:link></td>
						<td><g:formatDate date="${instance.dateCreated}" /></td>
						<td>${fieldValue(bean: instance, field: "dateTime")}</td>
						<td>${fieldValue(bean: instance, field: "emailMessage")}</td>
						<td><g:formatDate date="${instance.lastUpdated}" /></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${total}" />
			</div>

<div class="export">
  <span class="menuButton">
    <g:link  class="csv" controller="MailingListSchedule"  action="list"  params="${[max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'csv', extension:'csv' ]}"><g:message code="default.csv.label" default="CSV"/></g:link>
  </span>
  <span class="menuButton">
  <g:link  class="excel" controller="MailingListSchedule"  action="list"  params="${[max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'excel', extension:'excel' ]}"><g:message code="default.excel.label" default="EXCEL"/></g:link>
  </span>
  <span class="menuButton">
  <g:link  class="pdf" controller="MailingListSchedule"  action="list"  params="${[max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'pdf', extension:'pdf' ]}"><g:message code="default.pdf.label" default="PDF"/></g:link>
  </span>
  <span class="menuButton">
   <g:link  class="rtf" controller="MailingListSchedule"  action="list"  params="${[max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'rtf', extension:'rtf' ]}"><g:message code="default.rtf.label" default="RTF"/></g:link>
  </span>
  <span class="menuButton">
  <g:link  class="xml" controller="MailingListSchedule"  action="list"  params="${[max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'xml', extension:'xml' ]}"><g:message code="default.xml.label" default="XML"/></g:link>
  </span>
</div>
			
		</div>
	</body>
</html>
