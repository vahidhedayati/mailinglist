
 <ul class="nav-pills">
		<li class="btn btn-default"><g:link controller="mailingList"  action="index"><g:message code="default.menu.label" default="Menu"/></g:link></li>
		<li class="btn btn-danger"><g:link controller="mailingListEmail"  action="index"><g:message code="default.email.person.label" default="Contact Person"/></g:link></li>
		<li class="btn btn-success"><g:link controller="mailingListEmail"  action="contactclients"><g:message code="default.email.group.label" default="Contact Group"/></g:link></li>
		<li class="btn btn-primary"><g:link controller="MailingListSchedule"  action="br" params="${[s:'oa',viewtype:'na']}"><g:message code="default.schedule.label" default="Schedule Logs"/></g:link></li>
		<li class="btn btn-default"><a href="${createLink(uri: '/quartz/list')}"><g:message code="default.quartz.label" default="Quartz"/></a></li>
	</ul>


