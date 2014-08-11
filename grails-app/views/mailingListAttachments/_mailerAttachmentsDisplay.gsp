		<div class="inline">
			<g:select name="select1" id="select1" from="${returnResult ?: grails.plugin.mailinglist.core.AttachmentsBase.list()}" multiple="multiple" optionKey="id" optionValue="name" size="5"  class="many-to-many"/>
	 <br>
			<a href="#" id="add">add &gt;&gt;</a>
		  
		</div>
		
		<div class="inline">
			<select  name="attachments" multiple id="select2"></select>
		<br>
		 	<a href="#" id="remove">&lt;&lt; remove</a>  
		 	
		</div>
		
<g:javascript>
    $().ready(function() {  
     $('#add').click(function() {  
      return !$('#select1 option:selected').remove().appendTo('#select2');  
     });  
     $('#remove').click(function() {  
      return !$('#select2 option:selected').remove().appendTo('#select1');  
     });  
    });  	
</g:javascript>