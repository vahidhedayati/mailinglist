	<div   class="nav" role="navigation">
	<ul>
	
	<li><g:link controller="mailingList" class="list" action="index"><g:message code="Mailing List Menu" args="[entityName]" /></g:link></li>
	<li><g:link controller="mailingListEmail" class="list" action="index"><g:message code="Contact Person" args="[entityName]" /></g:link></li>
	<li><g:link controller="mailingListEmail" class="list" action="contactclients"><g:message code="Contact Group" args="[entityName]" /></g:link></li>
	<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'oa',viewtype:'na']}"><g:message code="Outstanding" args="[entityName]" /></g:link></li>
	<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'sc',viewtype:'na']}"><g:message code="Cancelled" args="[entityName]" /></g:link></li>
	<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'cs',viewtype:'na']}"><g:message code="Completed" args="[entityName]" /></g:link></li>
	<li><a href="${createLink(uri: '/quartz/list')}"><g:message code="Quartz Schedules"/></a></li>
	
</ul>

</div>	