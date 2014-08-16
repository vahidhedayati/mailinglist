

<g:form name="${attrs.formId }" id="1"  controller="MailingListTemplates" action="save" onload="CKStart()">
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
	
	
	
	<div id="resizable" style="overflow: hidden; max-height:25em;">
		<ckeditor:editor name="content" id="myCKEditor" height="25em" width="100%" >
		</ckeditor:editor>
      </div>

	
	<fieldset class="buttons">
		<g:submitButton name="create" onclick="CKupdate()" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
	</fieldset>
</g:form>
<g:javascript>	

function CKStart(){
  var editor = CKEDITOR.replace( 'myCKEditor', {
	autoGrow_onStartup: false,
        resize_enabled: false,
	height: '25em'
        
    });
}
 function CKupdate(){
  CKEDITOR.instances.myCKEditor.updateElement();
 }
</g:javascript>


