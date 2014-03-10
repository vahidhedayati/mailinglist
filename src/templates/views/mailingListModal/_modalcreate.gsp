<div class="modal fade" id="BuildModal${id}" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		
    		<g:formRemote name="urlParams" class="form-horizontal" url="[controller:controller, action:'save']"
              update="BuildModal${id}"  onComplete="${controller}CloseModal()"
              >
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">x</button>
					<h3>${title }</h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<g:render template="/${controller }/${callPage }"/>
						 <g:submitToRemote class="myformsubmit" url="[controller:controller, action:'save']" update="BuildModal${id}" onComplete="${controller}CloseModal()" value="Create" />
					</div>
				</div>
				</g:formRemote>
				
		</div>
	</div>
</div>
				
<g:javascript>
	
function ${controller}CloseModal() {
	$('#BuildModal${id}').dialog().dialog('close');
	$('body').removeClass('modal-open');
	$('.modal-backdrop').remove();
	<g:if test="${!disablecheck.equals('true') }">
		var controller="${controller }";
		var divId="${divId }";
		$.get('${createLink(controller:"MailingListEmail", action: "getAjaxCall")}?ccontroller='+controller+'&divId='+divId,function(data){
			$('#${divId}').hide().html(data).fadeIn('slow');
		});
	</g:if>	
}
</g:javascript>