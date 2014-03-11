<g:render template="/mailingListModal/modalForm" model="[title:title, controller: controller, callPage: callPage , divId: divId, id: id ]" />
  				
<g:javascript>
function ${controller}CloseModal() {
	$('#BuildModal${id}').dialog().dialog('close');
  	$(".modal-backdrop").hide();
  	$('#${divId}1').hide().append(myClone);
        
	<g:if test="${!disablecheck.equals('true') }">
		var controller="${controller }";
		var divId="${divId }";
		$.get('${createLink(controller:"MailingListEmail", action: "getAjaxCall")}?ccontroller='+controller+'&divId='+divId,function(data){
			$('#${divId}').hide().html(data).fadeIn('slow');
		});
	</g:if>	
}
</g:javascript>