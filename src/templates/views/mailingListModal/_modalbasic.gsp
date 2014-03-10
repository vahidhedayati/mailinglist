<div class="modal fade" id="BuildModal${id}" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
		
    			<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">x</button>
					<h3>${title }</h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<g:render template="/${controller }/${callPage }"  model="[ccontroller: controller]"/>
					</div>
				</div>
		
				
		</div>
	</div>
</div>
				
<g:javascript>
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