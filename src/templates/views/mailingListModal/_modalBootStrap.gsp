<div class="modal fade" id="myModal" role="dialog" aria-hidden="true" >
	<div class="modal-dialog">
		<div class="modal-content" style="width:60em;height:50em;overflow:auto;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">x</button>
				<h3></h3>
			</div>

			<div class="modal-body" style="width:100%;height:100%; ">

			</div>
		</div>
	</div>
</div>

<g:javascript>
	$('a.btn').on('click', function(e) {
		e.preventDefault();
		var url = $(this).attr('href');
		$(".modal-body").html('<iframe width="100%" height="100%" frameborder="0" scrolling="no" allowtransparency="false" src="'+url+'"></iframe>');
    });
</g:javascript>