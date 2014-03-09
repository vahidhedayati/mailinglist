	<div   class="nav" role="navigation">
	<ul>
	
	<li><g:link controller="mailingList" class="list" action="index"><g:message code="Mailing List Menu" args="[entityName]" /></g:link></li>
	<li><g:link controller="mailingListEmail" class="list" action="contactclients"><g:message code="Contact Clients" args="[entityName]" /></g:link></li>
	<li><g:link controller="mailingListEmail" class="list" action="contactclients"><g:message code="Contact Clients" args="[entityName]" /></g:link></li>
	<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'oa',viewtype:'na']}"><g:message code="Outstanding" args="[entityName]" />Local Queue</g:link>
	<li><a href="${createLink(uri: '/quartz/list')}"><g:message code="Quartz Schedules"/></a></li>
	<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'acdo',viewtype:'na']}"><g:message code="Outstanding" args="[entityName]" /></g:link>
	<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'sc',viewtype:'na']}"><g:message code="Cancelled" args="[entityName]" /></g:link>
	<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'cs',viewtype:'na']}"><g:message code="Completed" args="[entityName]" /></g:link>
</ul>
</div>	