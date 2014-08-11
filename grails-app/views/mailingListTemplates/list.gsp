<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')}" />
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
		<div id="list-mailingListTemplates" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="name" title="${message(code: 'mailingListTemplates.name.label', default: 'Name')}" />
						<g:sortableColumn property="addedby" title="${message(code: 'mailingListTemplates.addedby.label', default: 'Addedby')}" />

						<g:sortableColumn property="dateCreated" title="${message(code: 'mailingListTemplates.dateCreated.label', default: 'Date Created')}" />
						<g:sortableColumn property="lastUpdated" title="${message(code: 'mailingListTemplates.lastUpdated.label', default: 'Last Updated')}" />
					</tr>
				</thead>
				<tbody>
				

				<% def currentsize=mailingListTemplatesInstanceList?.size() %>
				<% def mtl %>
				<g:if test="${currentsize>1}">
				<%  mtl =mailingListTemplatesInstanceList?.sort{a,b-> a.name.compareTo(b.name)} %>
				</g:if>
				<g:else>
					<% mtl=mailingListTemplatesInstanceList %>
				</g:else>
		
		
				<g:each in="${mtl}" status="i" var="mailingListTemplatesInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
						<td><g:link action="show" id="${mailingListTemplatesInstance.id}">${fieldValue(bean: mailingListTemplatesInstance, field: "name")}</g:link></td>
						<td>${fieldValue(bean: mailingListTemplatesInstance, field: "addedby")}</td>
						
						<td><g:formatDate date="${mailingListTemplatesInstance.dateCreated}" /></td>
						<td><g:formatDate date="${mailingListTemplatesInstance.lastUpdated}" /></td>
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mailingListTemplatesInstanceTotal}" />
			</div>
<div class="export">
  <span class="menuButton">
    <g:link  class="csv" controller="MailingListTemplates"  action="list"  params="${[max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'csv', extension:'csv' ]}"><g:message code="default.csv.label" default="CSV"/></g:link>
  </span>
  <span class="menuButton">
  <g:link  class="excel" controller="MailingListTemplates"  action="list"  params="${[max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'excel', extension:'excel' ]}"><g:message code="default.excel.label" default="EXCEL"/></g:link>
  </span>
  <span class="menuButton">
  <g:link  class="pdf" controller="MailingListTemplates"  action="list"  params="${[max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'pdf', extension:'pdf' ]}"><g:message code="default.pdf.label" default="PDF"/></g:link>
  </span>
  <span class="menuButton">
   <g:link  class="rtf" controller="MailingListTemplates"  action="list"  params="${[max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'rtf', extension:'rtf' ]}"><g:message code="default.rtf.label" default="RTF"/></g:link>
  </span>
  <span class="menuButton">
  <g:link  class="xml" controller="MailingListTemplates"  action="list"  params="${[max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'xml', extension:'xml' ]}"><g:message code="default.xml.label" default="XML"/></g:link>
  </span>
</div>
		</div>
	</body>
</html>
