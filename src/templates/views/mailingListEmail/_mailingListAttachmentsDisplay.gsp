
		<g:each in="${mlAttach}" var="attach"> 
			<g:if test="${attach.attachment.size() > 0 }">
				<g:if test="${params.attachments.getClass().isArray()}">
					<g:if test="${params.attachments.contains(attach.id.toString())}">
						<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="true" /> ${attach.name} </div>
			  		</g:if>
  					<g:else>
  						<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="false" /> ${attach.name} </div>
  					</g:else>	
  				</g:if>
  				<g:else>
  					<g:if test="${params.attachments}">
  						<g:if test="${ params.attachments.toString().equals(attach.id.toString())}">
  							<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="true" /> ${attach.name} </div>
			  			</g:if>
  						<g:else>
  							<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="false" /> ${attach.name} </div>
			  			</g:else>
			 		</g:if>
			 	<g:else>
					<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="false" /> ${attach.name} </div>
			 	</g:else> 
  			</g:else>		
  		</g:if>
	</g:each>