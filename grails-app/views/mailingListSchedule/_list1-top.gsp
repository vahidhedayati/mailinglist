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
			<g:sortableColumn property="scheduleCancelled" title="${message(code: 'links.scheduleCancelled.label', default: 'Cancelled')}" />
			<g:sortableColumn property="scheduleComplete" title="${message(code: 'links.scheduleComplete.label', default: 'Completed')}" />
			<g:sortableColumn property="dateCreated" title="${message(code: 'links.dateCreated.label', default: 'Created')}" />
			<g:sortableColumn property="execDate" title="${message(code: 'links.execDate.label', default: 'execDate')}" />
			<g:sortableColumn property="Actions" title="${message(code: 'Actions', default: 'Actions')}" />
		</tr>
	</thead>
	<tbody>
	<g:each in="${deploymentInfoHistoryInstanceList}" status="i" var="deployInstance">
		<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
		<td>${fieldValue(bean: deployInstance, field: "id")}</td>
		<td>${fieldValue(bean: deployInstance, field: "addedby")}</td>
		<td>${fieldValue(bean: deployInstance, field: "mailFrom")}</td>
			<td>
			<mailinglist:loadPopUp id="${deployInstance?.recipientToGroup }" 
			scriptCall="recipientToGroup"
			controller="CategoryBase"
			retController="MailingListCategories"
			retValue="name"
			action="show" 
			/>
			${fieldValue(bean: deployInstance, field: "recipientToList")} 
			${fieldValue(bean: deployInstance, field: "recipientBCCList")}
			${fieldValue(bean: deployInstance, field: "recipientCCList")}
		</td>
		<td>${fieldValue(bean: deployInstance, field: "subject")}</td>
		<td>
		<mailinglist:loadPopUp id="${deployInstance?.mailingListTemplate }" 
			scriptCall="mailingListTemplate"
			controller="TemplatesBase"
			retController="MailingListTemplates"
			retValue="name"
			action="show" 
			/>
		</td>
		<td>
			<mailinglist:loadPopUp id="${deployInstance?.id }" 
			scriptCall="MailingListSchedule"
			controller="ScheduleBase"
			retController="MailingListSchedule"
			retValue="id"
			action="showmsg" 
			/>
		
			<g:if test="${deployInstance.scheduleName}">
				<quartzutils:find jobName="${deployInstance.scheduleName}" />
			</g:if>
		</td>
		<td>${fieldValue(bean: deployInstance, field: "dateTime")}<br/>
		 ${fieldValue(bean: deployInstance, field: "setDate")} - ${fieldValue(bean: deployInstance, field: "setTime")}
		</td>
		<td>${fieldValue(bean: deployInstance, field: "sendType")}</td>
		<td>${deployInstance.scheduleCancelled.toString()}</td>
		<td>${deployInstance.scheduleComplete.toString()}</td>
		
		
		<td><button id=boxbtn><prettytime:display date="${deployInstance.dateCreated}" /></button></td>
		
		
		
		<g:if test="${deployInstance.scheduleName}">
                     <quartzutils:jobRunningTime jobName="${deployInstance.scheduleName}" />
                 </g:if>
                 <g:else>
			<td></td>
		</g:else>

		<td>
		<g:if test="${deployInstance.scheduleCancelled.toString().equals('false') && deployInstance.scheduleComplete.toString().equals('false')  }">
		<g:link controller="MailingListSchedule"  action="modSchedule" id="${deployInstance.id}" params="${[calltype:'cancel', jobName:deployInstance.scheduleName ]}" >
			<g:if test="${mailinglist.verifyAppVersion().equals('resources')}">
				<img src="${resource(dir: 'images', file: 'stop.png')}" data-tooltip="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}" alt="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}"/>
			</g:if>	
			<g:else>
				<asset:image src="stop.png" alt="Grails" data-tooltip="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}" alt="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}"/>
			</g:else>
		</g:link>
		<a  href="${createLink(uri: '/quartz/pause?jobName='+meta(name:'app.name')+'.'+deployInstance.scheduleName+'&jobGroup=GRAILS_JOBS')}">
			<g:if test="${mailinglist.verifyAppVersion().equals('resources')}">
				<img src="${resource(dir: 'images', file: 'pause.png')}" data-tooltip="${message(code: 'default.pause.job.label', default: 'Pause job')}" alt="${message(code: 'default.pause.job.label', default: 'Pause job')}"/>
			</g:if>
			<g:else>
				<asset:image src="pause.png" alt="Grails" data-tooltip="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}" alt="${message(code: 'default.stop.cancel.label', default: 'Stop/Cancel Schedule')}"/>
			</g:else>
		</a>	
						
		<quartzutils:displayResume jobName="${deployInstance.scheduleName}"  />
		<a  href="${createLink(uri: '/quartz/runNow?jobName='+meta(name:'app.name')+'.'+deployInstance.scheduleName+'&jobGroup=GRAILS_JOBS')}">
			<g:if test="${mailinglist.verifyAppVersion().equals('resources')}">
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