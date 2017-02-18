
 <ul id="mailMenu" class="nav-pills">
		<li ><g:link controller="mailingList" class="btn btn-default" action="index"><g:message code="default.menu.label" default="Menu"/></g:link></li>
		<li><g:link controller="mailingListEmail"   class="btn btn-danger" action="index"><g:message code="default.email.person.label" default="Contact Person"/></g:link></li>
		<li ><g:link controller="mailingListEmail" class="btn btn-success" action="contactclients"><g:message code="default.email.group.label" default="Contact Group"/></g:link></li>
		<li><g:link controller="MailingListSchedule"  class="btn btn-info" action="br" params="${[s:'oa',viewtype:'na']}"><g:message code="default.schedule.label" default="Schedule Logs"/></g:link></li>
		<li ><a  class="btn btn-default" href="${createLink(uri: '/quartz/list')}"><g:message code="default.quartz.label" default="Quartz"/></a></li>
	</ul>


