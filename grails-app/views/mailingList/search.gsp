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
			<td><g:link action="show" id="${mailingListInstance?.id}">${mailingListInstance?.emailAddress}</g:link></td>
			<td>${mailingListInstance?.emailDisplayName}</td>
			<td>${mailingListInstance?.categories?.name}</td>
			<td>${mailingListInstance?.firstName}</td>
			<td>${mailingListInstance?.lastName}</td>
			<td><prettytime:display date="${mailingListInstance?.dateCreated}" /></td>
		</tr>
	</g:each>
	</tbody>
</table>