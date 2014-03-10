<!--  GSP Not used left in place for future usage or reverting  -->
<!--  This should post the form back to itself and then carry out modal closing and div refresh -->
<!--  The form components such as file upload or html content [ckeditor fields] does not seem to work with this  -->
<!--  or remote forms -->
<div class="modal fade" id="BuildModal${id}" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
		
    			<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">x</button>
					<h3>${title }</h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<g:render template="/${controller }/${callPage }"  model="[ccontroller: controller, formId:formId]"/>
					</div>
				</div>
		
				
		</div>
	</div>
</div>
				
<g:javascript>
$('#${formId}').submit(function() { 
    $.ajax({ 
        data: $(this).serialize(), 
        type: $(this).attr('method'),
        url: $(this).attr('action'), 
        success: function(response) { 
            $('#${formId}').html(response); 
            ${controller}CloseModal(); 
        }
    });
    return false; 
});		

$('#TESTING').submit(function() { 
     $.post('${createLink(controller:"MailingListUploader", action: "save")}', $('#${formId}').serialize(), function (data, textStatus) {
           $('#${formId}').html(data); 
            ${controller}CloseModal();
    });
   
    
});	

function ${controller}CloseModal() {
	$('#BuildModal${id}').dialog().dialog('close');
	$('body').removeClass('modal-open');
	$('.modal-backdrop').remove();
	var controller="${controller }";
		var divId="${divId }";
		$.get('${createLink(controller:"MailingListEmail", action: "getAjaxCall")}?ccontroller='+controller+'&divId='+divId,function(data){
			$('#${divId}').hide().html(data).fadeIn('slow');
		});
}
  
</g:javascript>