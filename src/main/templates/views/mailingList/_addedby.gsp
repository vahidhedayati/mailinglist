<!--  ADDEDBY Field in all the forms within MailingList -->
<!--  define a value for who the active user is currently set to session.username -->
<div class="fieldcontain ${hasErrors(bean: params, field: ''+caller+'', 'error')} ">
	<g:hiddenField name="addedby" value="${session.username}"/>
</div>