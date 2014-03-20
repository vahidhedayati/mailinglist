
	<g:each in="${returnValue ?: grails.plugin.mailinglist.core.CategoryBase.list()}" var="cat"> 
		<g:if test="${params.recipientToGroup.getClass().isArray()}">
			
			
				<g:if test="${params.recipientToGroup.contains(cat.id.toString())}">
	
  					<div class="tbutton">|<g:checkBox name="recipientToGroup" value="${cat.id}" checked="true" /> ${cat.name} </div>
			  	</g:if>
  				<g:else>
  					<div class="tbutton">-|<g:checkBox name="recipientToGroup" value="${cat.id}" checked="false" /> ${cat.name} </div>
			  	
  				</g:else>	
  			
  		</g:if>
  		<g:else>
  			<g:if test="${params.recipientToGroup}">
  				<g:if test="${ params.recipientToGroup.toString().equals(cat.id.toString())}">
  					<div class="tbutton"><g:checkBox name="recipientToGroup" value="${cat.id}" checked="true" /> ${cat.name} </div>
			  	</g:if>
  				<g:else>
  					<div class="tbutton"><g:checkBox name="recipientToGroup" value="${cat.id}" checked="false" /> ${cat.name} </div>
			  </g:else>
			 </g:if>
			 <g:else>
				<div class="tbutton"><g:checkBox name="recipientToGroup" value="${cat.id}" checked="false" /> ${cat.name} </div>
			 </g:else> 
  		</g:else>		
  			
	</g:each>