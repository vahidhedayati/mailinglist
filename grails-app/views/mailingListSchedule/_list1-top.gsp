<table>
	<thead>
		<tr>
			<g:sortableColumn property="id" title="${message(code: 'links.id.label', default: 'ID')}" />
			<g:sortableColumn property="mailFrom" title="${message(code: 'links.sender.label', default: 'Sender')}" />
			<g:sortableColumn property="mailFrom" title="${message(code: 'links.mailFrom.label', default: 'From')}" />
			<g:sortableColumn property="recipientToList" title="${message(code: 'links.recipientToList.label', default: 'To')}" />
			<g:sortableColumn property="subject" title="${message(code: 'links.subject.label', default: 'subject')}" />
			<g:sortableColumn property="emailMessage" title="${message(code: 'links.emailMessage.label', default: 'Message')}" />
			<g:sortableColumn property="scheduleName" title="${message(code: 'links.scheduleName.label', default: 'scheduleID')}" />
			<g:sortableColumn property="dateTime" title="${message(code: 'links.dateTime.label', default: 'date/Time')}" />
			<g:sortableColumn property="sendType" title="${message(code: 'links.sendType.label', default: 'send Type')}" />
			<g:sortableColumn property="scheduleStatus" title="${message(code: 'links.scheduleStatus.label', default: 'Status')}" />
			<g:sortableColumn property="dateCreated" title="${message(code: 'links.dateCreated.label', default: 'Created')}" />
			<g:sortableColumn property="execDate" title="${message(code: 'links.execDate.label', default: 'execDate')}" />
			<g:sortableColumn property="Actions" title="${message(code: 'Actions', default: 'Actions')}" />
		</tr>
	</thead>
	<tbody>
	<g:each in="${mailingListScheduleInstance}" status="i" var="instance">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
		<td>${fieldValue(bean: instance, field: "id")}</td>
		<td>${fieldValue(bean: instance, field: "addedby")}</td>
		<td>${fieldValue(bean: instance, field: "mailFrom")}</td>
			<td>
			<mailinglist:loadPopUp id="${instance?.recipientToGroup }" 
			scriptCall="recipientToGroup"
			controller="CategoryBase"
			retController="MailingListCategories"
			retValue="name"
			action="show" 
			/>
			${fieldValue(bean: instance, field: "recipientToList")} 
			${fieldValue(bean: instance, field: "recipientBCCList")}
			${fieldValue(bean: instance, field: "recipientCCList")}
		</td>
		<td>${fieldValue(bean: instance, field: "subject")}</td>
		<td>
		<mailinglist:loadPopUp id="${instance?.mailingListTemplate }" 
			scriptCall="mailingListTemplate"
			controller="TemplatesBase"
			retController="MailingListTemplates"
			retValue="name"
			action="show" 
			/>
		</td>
		<td>
			<mailinglist:loadPopUp id="${instance?.id }" 
			scriptCall="MailingListSchedule"
			controller="ScheduleBase"
			retController="MailingListSchedule"
			retValue="id"
			action="showmsg" 
			/>
		
			<g:if test="${instance.scheduleName}">
				<quartzutils:find jobName="${instance.scheduleName}" />
			</g:if>
		</td>
		<td>${fieldValue(bean: instance, field: "dateTime")}
		<g:if test="${instance.setDate && instance.setTime}">
			<br/>
		 	${fieldValue(bean: instance, field: "setDate")} - ${fieldValue(bean: instance, field: "setTime")}
		 </g:if>
		 <g:if test="${instance.cronExpression}">
		 	<br/><mailinglist:translateCronExpress cronExpression="${instance?.cronExpression}"/>
		 	[${instance.cronExpression}]
		 </g:if>
		 
		</td>
		<td>${fieldValue(bean: instance, field: "sendType")}</td>
		<td><g:message code="mailinglist.status.${instance.scheduleStatus}"/> </td>
		
		
		<td><button id=boxbtn><prettytime:display date="${instance.dateCreated}" /></button></td>
		
		
		
		<g:if test="${instance.scheduleName}">
                     <quartzutils:jobRunningTime jobName="${instance.scheduleName}" />
                 </g:if>
                 <g:else>
			<td></td>
		</g:else>

		<td>
		<g:if test="${instance.scheduleStatus==grails.plugin.mailinglist.core.ScheduleBase.SCHEDULE_RUNNING ||instance.scheduleStatus==grails.plugin.mailinglist.core.ScheduleBase.CRON}">
		<g:link controller="MailingListSchedule"  action="modSchedule" id="${instance.id}" params="${[calltype:'cancel', jobName:instance.scheduleName ]}" >
			<g:if test="${enduser?.verifyAppVersion().equals('resources')}">
				<img src="${resource(dir: 'images', file: 'stop.png')}" data-tooltip="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}" alt="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}"/>
			</g:if>	
			<g:else>
				<asset:image src="stop.png" alt="Grails" data-tooltip="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}" alt="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}"/>
			</g:else>
		</g:link>
		<a  href="${createLink(uri: '/quartz/pause?jobName='+meta(name:'app.name')+'.'+instance.scheduleName+'&jobGroup=GRAILS_JOBS')}">
			<g:if test="${enduser?.verifyAppVersion().equals('resources')}">
				<img src="${resource(dir: 'images', file: 'pause.png')}" data-tooltip="${message(code: 'default.pause.job.label', default: 'Pause job')}" alt="${message(code: 'default.pause.job.label', default: 'Pause job')}"/>
			</g:if>
			<g:else>
				<asset:image src="pause.png" alt="Grails" data-tooltip="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}" alt="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}"/>
			</g:else>
		</a>	
						
		<quartzutils:displayResume jobName="${instance.scheduleName}"  />
		<a  href="${createLink(uri: '/quartz/runNow?jobName='+meta(name:'app.name')+'.'+instance.scheduleName+'&jobGroup=GRAILS_JOBS')}">
			<g:if test="${enduser?.verifyAppVersion().equals('resources')}">
				<img src="${resource(dir: 'images', file: 'run.png')}" data-tooltip="${message(code: 'default.run.job.label', default: 'Run job')}"  alt="${message(code: 'default.run.job.label', default: 'Run job')}"/>
			</g:if>
			<g:else>
				<asset:image src="run.png" alt="Grails" data-tooltip="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}" alt="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}"/>
			</g:else>
		</a>			 
		</g:if>
		</td>
		</tr>
	</g:each>
	</tbody>
</table>
