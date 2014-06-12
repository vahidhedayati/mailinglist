<div id="nav3"  class="nav3" role="navigation">
	<ul id="nav">
		<li><g:link controller="mailingList" class="list" action="index"><g:message code="default.menu.label" default="Menu"/></g:link></li>
		<li><g:link controller="mailingListEmail" class="list" action="index"><g:message code="default.email.person.label" default="Contact Person"/></g:link></li>
		<li><g:link controller="mailingListEmail" class="list" action="contactclients"><g:message code="default.email.group.label" default="Contact Group"/></g:link></li>
		<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'oa',viewtype:'na']}"><g:message code="default.outstanding.label" default="Outstanding"/></g:link></li>
		<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'oc',viewtype:'na']}"><g:message code="default.cancelled.label" default="Cancelled"/></g:link></li>
		<li><g:link controller="MailingListSchedule" class="list" action="br" params="${[s:'od',viewtype:'na']}"><g:message code="default.completed.label" default="Completed"/></g:link></li>
		<li><a href="${createLink(uri: '/quartz/list')}"><g:message code="default.quartz.label" default="Quartz"/></a></li>
	</ul>
</div>	