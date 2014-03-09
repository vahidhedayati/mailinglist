

<div class="fieldcontain ${hasErrors(bean: mailingListCatInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="mailingListCat.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${mailingListCatInstance?.name}"/>
</div>


<g:render template="/mailingList/addedby"  model="[caller: 'mailingListCatInstance']"/>

<div class="fieldcontain ${hasErrors(bean: mailingListCatInstance, field: 'mailinglist', 'error')} ">
	<label for="mailinglist">
		<g:message code="mailingListCat.mailinglist.label" default="Mailinglist" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mailingListCatInstance?.mailinglist?}" var="m">
    <li><g:link controller="mailingList" action="show" id="${m.id}">${m?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="mailingList" action="create" params="['mailingListCat.id': mailingListCatInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'mailingList.label', default: 'MailingList')])}</g:link>
</li>
</ul>

</div>

