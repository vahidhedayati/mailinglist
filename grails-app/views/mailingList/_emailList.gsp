
<ul>
	<g:each in="${link?}" var="l">
		  <li>
		    	<g:remoteLink  	update="returnPanel" 
						  		controller="MailingList" 
						  		action="display" 
  					  			id="${l.id}" >
  					  			 ${l.emailAddress }
  				</g:remoteLink>
  		</li>
  	
	</g:each>
</ul>
