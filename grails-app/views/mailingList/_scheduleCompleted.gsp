<div id="the_box" role="complementary">
	<ul>
		<li>
		<div class="internalbtn"><h3>
		<g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'od',viewtype:'na']}">
		<g:message	code="default.total.sent.label" default="Total Sent: ${total }" args="[total]"/></g:link></h3></div>
	<g:each in="${sc?}" var="l">
		<div class="internalbtn">	
	
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
			<br><b><g:message code="default.to.label" default="To"/>:</b> ${l?.recipientToList }   
		</g:if>	
		<g:if test="${l.recipientBCCList }"> 
			<b><g:message code="default.bcc.label" default="BCC"/>:</b> ${l?.recipientBCCList }   
		</g:if>	
		<g:if test="${l.recipientCCList }"> 
			<b><g:message code="default.cc.label" default="CC"/>:</b> ${l?.recipientCCList }   
		</g:if>
		
		</div>
		<div class="mail-id">
		<b><g:message code="default.sent.label" default="Sent"/>:</b>
		<prettytime:display date="${l.dateCreated}" /> 
		</div>
		<div class="mail-subject">
			<b><g:message code="default.subject.label" default="Subject"/>:</b> ${l.subject}<br/>
			<b><g:message code="default.message.label" default="Msg"/>:</b>	<mailinglist:loadPopUp id="${l?.id }" 
						scriptCall="MailingListSchedule"
						controller="ScheduleBase"
						retController="MailingListSchedule"
						retValue="id"
						action="showmsg" 
						/>
		</div>
		<div class="mail-completed">
			<g:message code="mailinglist.status.${l.scheduleStatus}"/> 
		</div>	
  	</div>
	</g:each>
	</li>
</ul>
</div>
