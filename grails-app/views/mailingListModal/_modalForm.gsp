<div class="modal fade" id="BuildModal${id}" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
		</g:if>
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">x</button>
			<h3>${title }</h3>
		</div>
		<div class="form-group">
			
    		<g:formRemote id="${controller}" name="urlParams" class="form-horizontal" url="[controller:controller, action:'save']"
              update="BuildModal${id}"  onComplete="${controller}CloseModal()">
              
				<g:render template="/${controller }/${callPage }"/>
			
			 	<g:submitToRemote class="myformsubmit" url="[controller:controller, action:'save']" update="BuildModal${id}" onComplete="${controller}CloseModal()" value="Create" />
								
			</g:formRemote>
		</div>
	</div>
	</div>
</div>
		
<script>
$(document).ready(function() {
 $('a').on('click', function(e) {
	 alert(e);
		e.preventDefault();
		var url = $(this).attr('href');
		$(".modal-body").html('<iframe width="100%" height="100%" frameborder="0" scrolling="no" allowtransparency="false" src="'+url+'"></iframe>');
  });
});
</script>