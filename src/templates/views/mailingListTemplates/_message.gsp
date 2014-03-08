
	<div class="fieldcontain ${hasErrors(bean: params, field: 'content', 'error')} ">
	<label for="manager">
		<g:message code="content.label" default="content" />
	</label>

			
<ckeditor:resources/>
<div id=formmsg>


<ckeditor:editor 
name="content" height="300px" width="100%">


${content}

</ckeditor:editor>




</div>
	
</div>

