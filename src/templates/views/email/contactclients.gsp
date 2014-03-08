<g:render template="/mailingList/mailingListImport"/>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ContactClients.label', default: 'Contact Clients')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
<ckeditor:resources/>

	</head>
	<body>
	<div id="nav3"  class="nav3" role="navigation">
	<ul id="nav">
	
		<li><a class="home" href="${createLink(uri: '/MailingList/index')}">Schedule Announcement</a></li>		

	</ul>
	</div>
	<g:hasErrors bean="${mailingListScheduleInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${mailingListScheduleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
				<h1><g:message code="default.contact.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
				

		

	<g:form action="confirmcontact" >

			<div id="contact-area">
<div class="fieldcontain ${hasErrors(bean: params, field: 'addedby', 'error')} ">
	<g:hiddenField name="addedby" value="${session.username}"/>
</div>



	<div class="fieldcontain ${hasErrors(bean: params, field: 'sendType', 'error')} ">
	<label for="sendType">
		<g:message code="manager.label" default="sendType" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="sendType" name="sendType" value="${params.sendType }"
          from="${['bulk':'bulk', 'individual':'individual']}"
          optionKey="key" optionValue="value"
          noSelection="['bulk': 'bulk']"
          required=""
          
           />
           [ Bulk = one email with <b>all users in one line</b> and put it in <b>BCC</b> field, ] <br> 
           [ Individual = will create 1 email per user and send <b>To</b> each user ]
	</div>
	
		
	<div class="fieldcontain ${hasErrors(bean: params, field: 'mailFrom', 'error')} ">
	<label for="mailFrom">
		<g:message code="manager.label" default="mailFrom" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mailFrom" name="mailFrom" value="${params.mailFrom }"
          from="${MailingListSenders?.list()}"
          optionKey="emailAddress" optionValue="emailAddress"
          noSelection="['': 'Please choose From field']"
          required=""
           />
	</div>
	
	</div>
	
	<div class="fieldcontain ${hasErrors(bean: params, field: 'recipientToGroup', 'error')} ">
	<label for="recipientToGroup">
		<g:message code="recipientToGroup.label" default="To:" />
		<span class="required-indicator">*</span>
	</label>	
	
	<g:each in="${MailingListCategories?.list()}" var="cat"> 
		<g:if test="${params.recipientToGroup.getClass().isArray()}">
			
			
				<g:if test="${params.recipientToGroup.contains(cat.id.toString())}">
	
  					<div class="tbutton">|<g:checkBox name="recipientToGroup" value="${cat.id}" checked="true" /> ${cat.name} </div>
			  	</g:if>
  				<g:else>
  					<div class="tbutton">-|<g:checkBox name="recipientToGroup" value="${cat.id}" checked="false" /> ${cat.name} </div>
			  	
  				</g:else>	
  			
  		</g:if>
  		<g:else>
  			<g:if test="${params.recipientToGroup}">
  				<g:if test="${ params.recipientToGroup.toString().equals(cat.id.toString())}">
  					<div class="tbutton"><g:checkBox name="recipientToGroup" value="${cat.id}" checked="true" /> ${cat.name} </div>
			  	</g:if>
  				<g:else>
  					<div class="tbutton"><g:checkBox name="recipientToGroup" value="${cat.id}" checked="false" /> ${cat.name} </div>
			  </g:else>
			 </g:if>
			 <g:else>
				<div class="tbutton"><g:checkBox name="recipientToGroup" value="${cat.id}" checked="false" /> ${cat.name} </div>
			 </g:else> 
  		</g:else>		
  			
	</g:each>
	
	</div>
	

					<div id="contact-area">
	<div class="fieldcontain ${hasErrors(bean: params, field: 'subject', 'error')} ">
	<label for="subject">
		<g:message code="manager.label" default="subject" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="subject" value="${params?.subject}" size="60" />
	</div>
	
</div>
	
<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error')} ">
	<label for="attachments">
		<g:message code="mailingListSchedule.attachments.label" default="Attachments" />
		<br/>
		</label>
	
		<g:each in="${MailingListAttachments?.list()}" var="attach"> 
		<g:if test="${attach.attachment.size() > 0 }">
		<g:if test="${params.attachments.getClass().isArray()}">
			
				<g:if test="${params.attachments.contains(attach.id.toString())}">
	
  					<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="true" /> ${attach.name} </div>
			  	</g:if>
  				<g:else>
  					<div class="tbutton"><g:checkBox name="attachments" value="${attach.id}" checked="false" /> ${attach.name} </div>
			  	
  				</g:else>	
  			
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
<g:if test="${params.emailMessage }">

		<g:if test="${params.mailingListTemplate}">
			<g:hiddenField name="mailingListTemplate" value="${params.mailingListTemplate }"/>
		</g:if>




<div class="fieldcontain ${hasErrors(bean: params, field: 'emailMessage', 'error')} ">
	<label for="manager">
		<g:message code="emailMessage.label" default="Message" />
	</label>

			
<ckeditor:resources/>
<div id=formmsg>
<ckeditor:editor 
name="emailMessage" height="300px" width="140%">
${params.emailMessage }
</ckeditor:editor>
</div>
	
</div>

</g:if>
<g:else>

<div class="fieldcontain ${hasErrors(bean: params, field: 'mailingListScheduleInstance', 'error')} required">
	<label for="mailingListTemplates">
		<g:message code="mailingListTemplates.label" default="Template" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="mailingListTemplates" name="mailingListTemplate" from="${MailingListTemplates?.list()}" optionKey="id" required="" value="${params.mailingListTemplates}" class="many-to-one"
		noSelection="['': 'Please choose Template']"
		required=""
		onchange="${remoteFunction (
		controller: 'Email',
		action: 'loadMessageBox',
		params: "'id=' + this.value",
		update: 'loadMessageBox'
	)}"
	/>
</div>


<div id="loadMessageBox"></div>
</g:else>
   


			
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'dateTime', 'error')} ">
	<label for="manager">
		<g:message code="dateTime.label" default="dateTime" />
	</label>
	<jqueryPicker:time name="dateTime" value="${params?.dateTime ?: curr }" />
	</div>
	
	
	
		
	<div class="fieldcontain ${hasErrors(bean: params, field: 'setDate', 'error')} ">
	<label for="setDate">
		<g:message code="setDate.label" default="Issue/Resolve Date:" />
		<span class="required-indicator">*</span>
	</label>
	<jqueryPicker:date name="setDate" value="${params.setDate }" />
	</div>	
		
		
	<div class="fieldcontain ${hasErrors(bean: params, field: 'setTime', 'error')} ">
	<label for="setTime">
		<g:message code="setTime.label" default="Issue/Resolve Time:" />
		<span class="required-indicator">*</span>
	</label>
	<joda:timePicker name="setTime" value="" />
	</div>
	
	
	
	<div class="fieldcontain ${hasErrors(bean: params, field: 'send', 'error')} ">
	<label for="Trigger">
	<g:message code="dateTime.label" default="Trigger" />
	</label>
	<g:submitButton name="Send Email" id="loginbtn" class="loginbtn" value="${message(code: 'default.button.SendEmail.label', default: 'Preview')}" />
	</div>
	
	</div>	
	</g:form>
</body></html>
