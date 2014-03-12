
<g:form name="${formId }" id="1"  controller="MailingListTemplates" action="save" onload="CKStart()">
<fieldset class="form">
	<g:hiddenField name="ajax" value="yes"/>
	<div class="fieldcontain ${hasErrors(bean: mailingListTemplatesInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="mailingListTemplates.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${mailingListTemplatesInstance?.name}"/>
	</div>

	<g:render template="/mailingList/addedby"  model="[caller: 'mailingListTemplatesInstance']"/>


	<div class="fieldcontain ${hasErrors(bean: mailingListTemplatesInstance, field: 'content', 'error')} ">
	<label for="content">
		<g:message code="mailingListTemplates.content.label" default="Content" />	
	</label>
	
	<div class="tbutton" id="mailerTemplates2">
		<ckeditor:editor name="content" id="myCKEditor" height="200px" width="100%">
		</ckeditor:editor>
	</div>
	</div>
	
	
	</fieldset>
	<fieldset class="buttons">
		<g:submitButton name="create" onclick="CKupdate()" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
	</fieldset>
</g:form>

<g:javascript>	
    function CKupdate(){
     	CKEDITOR.instances.myCKEditor.updateElement();
     	
	}
</g:javascript>


