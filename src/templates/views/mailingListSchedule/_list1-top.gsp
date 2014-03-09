
		
			<table>
				<thead>
					<tr>
						<g:sortableColumn property="id" title="${message(code: 'links.id.label', default: 'ID')}" />
					
						<g:sortableColumn property="mailFrom" title="${message(code: 'links.mailFrom.label', default: 'From')}" />
						<g:sortableColumn property="recipientToGroup" title="${message(code: 'links.recipientToGroup.label', default: 'ToGrp ID')}" />
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
					<td>${fieldValue(bean: deployInstance, field: "mailFrom")}</td>
				
						<td>
						<mailinglist:loadPopUp id="${deployInstance.recipientToGroup }" 
						scriptCall="recipientToGroup"
						controller="MailingListCategories"
						action="show" 
						/></td>
					
					<td>
					${fieldValue(bean: deployInstance, field: "recipientToList")} 
					${fieldValue(bean: deployInstance, field: "recipientBCCList")}
					${fieldValue(bean: deployInstance, field: "recipientCCList")}
					</td>
					<td>${fieldValue(bean: deployInstance, field: "subject")}</td>

					
					

					
					<td>
					<mailinglist:loadPopUp id="${deployInstance.mailingListTemplate }" 
						scriptCall="mailingListTemplate"
						controller="MailingListTemplates"
						action="show" 
						/>
						
						<mailinglist:loadPopUp id="${deployInstance.id }" 
						scriptCall="MailingListSchedule"
						controller="MailingListSchedule"
						action="showmsg" 
						/>
								
		
					</td>
					<td>	
						<g:if test="${deployInstance.scheduleName}">
							<quartzutils:find jobName="${deployInstance.scheduleName}" />
						</g:if>
					</td>
					
					<td>${fieldValue(bean: deployInstance, field: "dateTime")}<br/>
					 ${fieldValue(bean: deployInstance, field: "setDate")} - ${fieldValue(bean: deployInstance, field: "setTime")}
					</td>

					<td>${fieldValue(bean: deployInstance, field: "sendType")}</td>
					<td><button id=boxbtnlink onclick="<g:remoteFunction controller="MailingListSchedule"   action="br"    params="${[id:deployInstance.addedby, sortby:sortby, order:order, s:'u', envid:envid, viewtype:viewtype, offset:offset, max:params.max,pageSizes:pageSizes,divupdate:divupdate ]}" update="${divupdate }"  />">
					<user:returnRealUser userId="${deployInstance.addedby}"></user:returnRealUser>
					</button></td>
				
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
						<img src="${resource(dir: 'images', file: 'stop.png')}" data-tooltip="Stop job from running again" alt="Stop & cancel Schedule"/>	
					</g:link>
					<a  href="${createLink(uri: '/quartz/pause?jobName='+meta(name:'app.name')+'.'+deployInstance.scheduleName+'&jobGroup=GRAILS_JOBS')}">
								<img src="${resource(dir: 'images', file: 'pause.png')}" data-tooltip="Pause job schedule" alt="pause now"/>
							</a>	
									
					<quartzutils:displayResume jobName="${deployInstance.scheduleName}"  />
					<a  href="${createLink(uri: '/quartz/runNow?jobName='+meta(name:'app.name')+'.'+deployInstance.scheduleName+'&jobGroup=GRAILS_JOBS')}">
								<img src="${resource(dir: 'images', file: 'run.png')}" data-tooltip="Run now"  alt="Run now"/>
							</a>			 
					</g:if>
					
				
					</td>
							
								
					</tr>
				</g:each>
				</tbody>
			</table>