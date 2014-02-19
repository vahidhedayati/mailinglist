
<!DOCTYPE html>
<html>
	<head>
	
		<meta name="layout" content="main">
		
		<g:set var="entityName" value="${message(code: 'environments.label', default: 'Environments')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
<ckeditor:resources/>

	</head>
	<body>
	
	<div id="nav3"  class="nav3" role="navigation">
	<ul id="nav">
		<li><a class="home" href="${createLink(uri: '/admin/welcome#mailinglist')}">Schedule Announcement</a></li>			
	
	</ul>
	</div>	

		<div id="create-mailingList" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${mailingListScheduleInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${mailingListScheduleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>

	<g:form action="scheduleEmail" >
			<div id="contact-area">
<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'addedby', 'error')} ">
	<g:hiddenField name="addedby" value="${session.username}"/>
</div>

		
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'mailFrom', 'error')} ">
	<label for="manager">
		<g:message code="manager.label" default="mailFrom" />
	</label>
	<g:textField name="mailFrom"  readonly="readonly" value="${session?.usersemail }"/>
	</div>
	
	
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientToList', 'error')} ">
	<label for="manager">
		<g:message code="recipientToList.label" default="To:" />
	</label>
			<g:textField name="recipientToList" value="${params?.recipientToList}"/>
	</div>
	
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientCCList', 'error')} ">
	<label for="manager">
		<g:message code="recipientCCList.label" default="CC:" />
				
	</label>
	<g:textField name="recipientCCList" value="${params?.recipientCCList}"/>
	</div>
		<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'recipientBCCList', 'error')} ">
	<label for="manager">
		<g:message code="recipientBCCList.label" default="BCC:" />
	
	</label>
		<g:textField name="recipientBCCList" value="${params?.recipientBCCList}"/>	
	</div>	
		
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'subject', 'error')} ">
	<label for="manager">
		<g:message code="manager.label" default="subject" />
	</label>
	<g:textField name="subject" value="${params?.subject}" size="50"/>
	</div>
	
	
	</div>
	
<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error')} ">
	<label for="attachments">
		<g:message code="mailingListSchedule.attachments.label" default="Attachments" />
		<br/>
		</label>
	
		<g:each in="${kportal.MailingListAttachments.list()}" var="attach"> 
		<g:if test="${attach.attachment.size() > 0 }">
		<g:if test="${params.attachments.getClass().isArray()}">
			<g:each in="${params.attachments }" var="rgg">
				<g:if test="${rgg.toString().equals(attach.id.toString())}">
	
  					<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="true" /> ${attach.name} </div>
			  	</g:if>
  				<g:else>
  					<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="false" /> ${attach.name} </div>
			  	
  				</g:else>	
  			</g:each>
  		</g:if>
  		<g:else>
  			<g:if test="${params.attachments}">
  				<g:if test="${ params.attachments.toString().equals(attach.id.toString())}">
  					<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="true" /> ${attach.name} </div>
			  	</g:if>
  				<g:else>
  					<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="false" /> ${attach.name} </div>
			  </g:else>
			 </g:if>
			 <g:else>
				<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="false" /> ${attach.name} </div>
			 </g:else> 
  		</g:else>		
		
  			
  			
  		</g:if>
	</g:each>
	
</div>
	
	
			<div id="contact-area">
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'emailMessage', 'error')} ">
	<label for="manager">
		<g:message code="emailMessage.label" default="emailMessage" />
	</label>
	

<textarea class="ckeditor" cols="40" id="cktexty" 
name="emailMessage" rows="10">
${params?.emailMessage}
</textarea> 
</div>



		
<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'dateTime', 'error')} ">
	<label for="manager">
		<g:message code="dateTime.label" default="dateTime" />
	</label>
	<jqueryPicker:time name="dateTime" value="{params?.dateTime ?: current }" />
	</div>

	<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
				
		</div>		
			</g:form>
			</div>
	

</body></html>
