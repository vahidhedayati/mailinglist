<g:render template="/mailingListModal/modalForm" model="[title:title, controller: controller, callPage: callPage , divId: divId, id: id ]" />
  				
<g:javascript>
<!-- ('#BuildModal{id}').dialog().dialog('close');-->
 
function ${controller}CloseModal() {
 	var myClone=$('#BuildModal${id}').clone();   
    $('#BuildModal${id}').dialog().dialog('close');
  	$(".modal-backdrop").hide();
  	$('body').removeClass('modal-open');	
	//var myCloner = myClone.clone();
  	$('#${divId}1').hide().append(myClone);
     //$('body').append(myClone);
        
	<g:if test="${!disablecheck.equals('true') }">
		var controller="${controller }";
		var divId="${divId }";
		$.get('${createLink(controller:"MailingListEmail", action: "getAjaxCall")}?ccontroller='+controller+'&divId='+divId,function(data){
			$('#${divId}').hide().html(data).fadeIn('slow');
		});
	</g:if>	
}
</g:javascript>