<div id="nav3"  class="nav3" role="navigation">
	<ul id="nav">
		<li><g:link controller="mailingList" class="list" action="index"><g:message code="Menu" args="[entityName]" /></g:link></li>
		<li><g:link controller="mailingListEmail" class="list" action="index"><g:message code="Contact Person" args="[entityName]" /></g:link></li>
		<li><g:link controller="mailingListEmail" class="list" action="contactclients"><g:message code="Contact Group" args="[entityName]" /></g:link></li>
		<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'oa',viewtype:'na']}"><g:message code="Outstanding" args="[entityName]" /></g:link></li>
		<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'oc',viewtype:'na']}"><g:message code="Cancelled" args="[entityName]" /></g:link></li>
		<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'od',viewtype:'na']}"><g:message code="Completed" args="[entityName]" /></g:link></li>
		<li><a href="${createLink(uri: '/quartz/list')}"><g:message code="Quartz"/></a></li>
	</ul>
</div>	