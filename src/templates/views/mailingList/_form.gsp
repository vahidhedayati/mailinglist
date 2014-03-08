
<g:render template="/import"/>



<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'addedby', 'error')} ">
	<g:hiddenField name="addedby" value="${session.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="mailingList.title.label" default="Title" />
		
	</label>
	<g:textField name="title" value="${mailingListInstance?.title}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'firstName', 'error')} ">
	<label for="firstName">
		<g:message code="mailingList.firstName.label" default="First Name" />
		
	</label>
	<g:textField name="firstName" value="${mailingListInstance?.firstName}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'middleName', 'error')} ">
	<label for="middleName">
		<g:message code="mailingList.middleName.label" default="Middle Name" />
		
	</label>
	<g:textField name="middleName" value="${mailingListInstance?.middleName}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'lastName', 'error')} ">
	<label for="lastName">
		<g:message code="mailingList.lastName.label" default="Last Name" />
		
	</label>
	<g:textField name="lastName" value="${mailingListInstance?.lastName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'emailAddress', 'error')} ">
	<label for="emailAddress">
		<g:message code="mailingList.emailAddress.label" default="Email Address" />
		
	</label>
	<g:field type="email" name="emailAddress" value="${mailingListInstance?.emailAddress}"/>
</div>


<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'emailDisplayName', 'error')} ">
	<label for="emailDisplayName">
		<g:message code="mailingList.emailDisplayName.label" default="Email Display Name" />
		
	</label>
	<g:textField name="emailDisplayName" value="${mailingListInstance?.emailDisplayName}"/>
</div>



<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'categories', 'error')} required">
	<label for="categories">
		<g:message code="mailingList.categories.label" default="categories" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="categories" name="categories.id" from="${MailingListCategories?.list()}" optionKey="id" required="" value="${mailingListInstance?.categories?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'siteid', 'error')} ">
	<label for="siteid">
		<g:message code="mailingList.siteid.label" default="Siteid" />
		
	</label>
	<g:textField name="siteid" value="${mailingListInstance?.siteid}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: mailingListInstance, field: 'suffix', 'error')} ">
	<label for="suffix">
		<g:message code="mailingList.suffix.label" default="Suffix" />
		
	</label>
	<g:textField name="suffix" value="${mailingListInstance?.suffix}"/>
</div>
