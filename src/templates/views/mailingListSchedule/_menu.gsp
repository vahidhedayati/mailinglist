<div id="nav3"  class="nav3" role="navigation">
<ul id="nav">
	<li><g:link controller="email" class="list" action="contactclients"><g:message code="Contact Clients" args="[entityName]" /></g:link>
</li>
	<li class="nav5"><button id="nav" onclick="<g:remoteFunction controller="MailingListSchedule"  action="br" update="siteContent"  id=""  params="${[s:'oa',viewtype:'na']}"/>">Announcement Cron</button></li>
	
	<li><a href="${createLink(uri: '/quartz/list')}"><g:message code="Quartz Schedules"/></a></li>
	<li class="nav5"><button id="nav"  onclick="<g:remoteFunction controller="MailingListSchedule"  action="br" update="siteContent"  id=""  params="${[s:'acdo',viewtype:'na']}"/>">Outstanding Queries</button></li>
	<li class="nav5"><button id="nav"  onclick="<g:remoteFunction controller="MailingListSchedule"  action="br" update="siteContent"  id=""  params="${[s:'sc',viewtype:'na']}"/>">Schedules Cancelled</button></li>
	<li class="nav5"><button id="nav" onclick="<g:remoteFunction controller="MailingListSchedule"  action="br" update="siteContent"  id=""  params="${[s:'cs',viewtype:'na']}"/>">Completed Schedules</button></li>
</ul>
</div>