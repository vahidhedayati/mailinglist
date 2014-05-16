Total completed record: ${total}

	<ul id="the_box">
	<g:each in="${sc?}" var="l">

		  <li>
	
		<div class="mail-from">
		${l.mailFrom} ->
		<g:if test="${l.recipientToGroup }"> 
			<mailinglist:loadPopUp id="${l?.recipientToGroup }" 
				scriptCall="recipientToGroup"
				controller="CategoryBase"
				retController="MailingListCategories"
				retValue="name"
				action="show" 
			/>
		</g:if>	
		<g:if test="${l.recipientToList }"> 
			<b>To:</b> ${l?.recipientToList }   
		</g:if>	
		<g:if test="${l.recipientBCCList }"> 
			<b>BCC:</b> ${l?.recipientBCCList }   
		</g:if>	
		<g:if test="${l.recipientCCList }"> 
			<b>CC:</b> ${l?.recipientCCList }   
		</g:if>
		
		</div>
		<div class="mail-id">
		<b>Sent:</b>  <prettytime:display date="${l.dateCreated}" /> 
		</div>
		<div class="mail-subject">
			<b>Subject:</b> ${l.subject}<br/>
			<b>Msg:</b>	<mailinglist:loadPopUp id="${l?.id }" 
						scriptCall="MailingListSchedule"
						controller="ScheduleBase"
						retController="MailingListSchedule"
						retValue="id"
						action="showmsg" 
						/>
		</div>
		<div class="mail-completed">
		<b>Completed:</b>	${l.scheduleComplete.toString()} |
		<b>Cancelled:</b> ${l.scheduleCancelled.toString()}
		</div>	
		

  		</li>
  	
	</g:each>
</ul>
