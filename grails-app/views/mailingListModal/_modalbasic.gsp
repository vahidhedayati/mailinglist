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


	