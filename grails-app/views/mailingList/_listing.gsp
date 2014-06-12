<table>
	<thead>
		<tr>
			<g:sortableColumn property="emailAddress" title="${message(code: 'mailingList.emailAddress.label', default: 'Email Address')}" />
			<g:sortableColumn property="emailDisplayName" title="${message(code: 'mailingList.emailDisplayName.label', default: 'Email Display Name')}" />
			<g:sortableColumn property="categories" title="${message(code: 'mailingList.categories.label', default: 'Category')}" />
			<g:sortableColumn property="firstName" title="${message(code: 'mailingList.firstName.label', default: 'First Name')}" />
			<g:sortableColumn property="lastName" title="${message(code: 'mailingList.lastName.label', default: 'Last Name')}" />
			<g:sortableColumn property="dateCreated" title="${message(code: 'mailingList.dateCreated.label', default: 'Date Created')}" />
		</tr>
	</thead>
	<tbody>
	<g:each in="${mailingListInstanceList}" status="i" var="mailingListInstance">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
			<td><g:link action="show" id="${mailingListInstance.id}">${fieldValue(bean: mailingListInstance, field: "emailAddress")}</g:link></td>
			<td>${fieldValue(bean: mailingListInstance, field: "emailDisplayName")}</td>
			<td><a onclick="<g:remoteFunction action="list"    params="${[id:mailingListInstance?.categories?.id, sortby:sortby, order:order, s:'c', envid:envid, viewtype:viewtype, offset:offset, max:params.max,pageSizes:pageSizes,divupdate:divupdate,total:mailingListInstanceTotal ]}" update="${divupdate }"  />">
			${mailingListInstance?.categories?.name}</a></td>
			<td>${fieldValue(bean: mailingListInstance, field: "firstName")}</td>
			<td>${fieldValue(bean: mailingListInstance, field: "lastName")}</td>
			<td><prettytime:display date="${mailingListInstance.dateCreated}" /></td>
		
		</tr>
	</g:each>
	</tbody>
</table>

<div class="export">
  <span class="menuButton">
    <g:link  class="csv" controller="MailingList"  action="list"  params="${[max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'csv', extension:'csv' ]}"><g:message code="default.csv.label" default="CSV"/></g:link>
  </span>
  <span class="menuButton">
  <g:link  class="excel" controller="MailingList"  action="list"  params="${[max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'excel', extension:'excel' ]}"><g:message code="default.excel.label" default="EXCEL"/></g:link>
  </span>
  <span class="menuButton">
  <g:link  class="pdf" controller="MailingList"  action="list"  params="${[max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'pdf', extension:'pdf' ]}"><g:message code="default.pdf.label" default="PDF"/></g:link>
  </span>
  <span class="menuButton">
   <g:link  class="rtf" controller="MailingList"  action="list"  params="${[max: params?.max, s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'rtf', extension:'rtf' ]}"><g:message code="default.rtf.label" default="RTF"/></g:link>
  </span>
  <span class="menuButton">
  <g:link  class="xml" controller="MailingList"  action="list"  params="${[max: params?.max,  s:s, order:params?.order, pageSizes:params?.pageSizes, sortby:params?.sortby, offset:params?.offset, id:params?.id ,format:'xml', extension:'xml' ]}"><g:message code="default.xml.label" default="XML"/></g:link>
  </span>
</div>
		
	<div class="pagination">                           
 		<util:remotePaginate controller="MailingList" action="list" params="[max: params?.max,  pageSizes:pageSizes, sortby:sortby, offset:offset]" total="${mailingListInstanceTotal}" update="${divupdate}"   max="${params?.max}" pageSizes="[10:'10 Per Page', 20: '20 Per Page', 50:'50 Per Page',100:'100 Per Page',250:'250 Per Page',500:'500 Per Page',1000:'1000 Per Page']" /> 

	</div>