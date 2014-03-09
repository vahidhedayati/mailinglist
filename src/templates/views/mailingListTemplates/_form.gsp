
<head>
<ckeditor:resources/>
</head>

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
	
<div class=tbutton>

<ckeditor:editor 
name="content" height="300px" width="100%">
${mailingListTemplatesInstance?.content}
</ckeditor:editor>
</div>
</div>
