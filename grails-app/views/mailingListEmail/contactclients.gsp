<%@ page import="grails.plugin.mailinglist.core.CategoryBase" %>
<%@ page import="grails.plugin.mailinglist.core.SendersBase" %>
<%@ page import="grails.plugin.mailinglist.core.ScheduleBase" %>
<%@ page import="grails.plugin.mailinglist.core.TemplatesBase" %>
<%@ page import="grails.plugin.mailinglist.core.MailingListBase" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="mailingListMini">
		<g:set var="entityName" value="${message(code: 'ContactClients.label', default: 'Contact Clients')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<ckeditor:resources/>
	</head>
	<body>
	<div class="container">
	<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		 
	</div>	
	<g:hasErrors bean="${mailingListScheduleInstance}">
		<ul class="errors" role="alert">
			<g:eachError bean="${mailingListScheduleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
			</g:eachError>
		</ul>
	</g:hasErrors>
	<h1><g:message code="default.contactgroup.label" args="[entityName]" default='Define Schedule to Contact Mailing Group' /></h1>
	<g:if test="${flash.message}">
		<div class="message" role="status">${flash.message}</div>
	</g:if>
	

     <md:genModalButton
   	id="ModalDynamixSELFPOST"
   	divId="mailerTemplates1"
   	title="Create New Template"
   	value="New Template"
   	style='btn btn-primary'
     />


     <md:genModalButton
   	id="ModalDynamixIFRAMEUPLOADS"
   	divId="mailerUploader1"
   	title="Upload CSV Mail To Group?"
   	value="Upload CSV"
   	style='btn btn-danger'
     />
      <md:genModalButton
	  id="ModalDynamixIFRAMEATTACH"
	  divId="mailerAttachments1"
	  title="New Attachment?"
	  value="New Attachment"
	  style='btn btn-warning'
	/>

   	<md:genModalButton
   	id="ModalDynamixRemoteFORM"
   	divId="mailerSenders1"
   	title="New Email From field"
   	value="New Sender"
   	style='btn btn-success'
	/>

<div style="clear:both;"></div>

	<g:form action="confirmcontact" >
	
	<div id="contact-area">
		<g:render template="/mailingList/addedby"  model="[caller: 'params']"/>
		<div class="fieldcontain ${hasErrors(bean: params, field: 'sendType', 'error')} ">
		<label for="sendType">
			<g:message code="sendType.label" default="sendType" />
		<span class="required-indicator">*</span>
		</label>
		<g:select id="sendType" name="sendType" value="${params.sendType }"
          from="${['bulk':'bulk', 'individual':'individual']}"
          optionKey="key" optionValue="value"
          required="required"      
           />
           <g:message code="default.bulk.message.label" default="Bulk = one email with all users in one line and put it in BCC field "/><br/>
           <g:message code="default.individual.message.label" default="Individual = will create 1 email per user and send To each user"/>
		</div>
	</div>
	<div class="fieldcontain ${hasErrors(bean: params, field: 'mailFrom', 'error')} " required="required">
	<label for="mailFrom">
		<g:message code="mailFrom.label" default="mailFrom" />
		<span class="required-indicator">*</span>
	</label>
	<div id="mailerSenders" style="display:inline-block;*display:inline;*zoom:1;">
	<g:render template="/mailingListSenders/mailerSendersDisplay" />
	</div>
	</div>
	<div class="fieldcontain ${hasErrors(bean: params, field: 'recipientToGroup', 'error')} ">
	<label for="recipientToGroup">
		<g:message code="recipientToGroup.label" default="To:" />
		<span class="required-indicator">*</span>
	</label>	
	<div id="mailerUploader" style="display:inline-block;*display:inline;*zoom:1;">
		<g:render template="/mailingListUploader/mailerUploaderDisplay" />
	</div>
  	</div>
	

	<div id="contact-area">
	<div class="fieldcontain ${hasErrors(bean: params, field: 'subject', 'error')}" required="required">
	<label for="subject">
		<g:message code="subject.label" required="" default="subject" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="subject" value="${params?.subject}" size="60" />
	</div>
	
</div>
	
<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'attachments', 'error')} ">
	<label for="attachments">
		<g:message code="mailingListSchedule.attachments.label" default="Attachments" /><br/>
	</label>
	<div id="mailerAttachments" style="display:inline-block;*display:inline;*zoom:1;">
		<g:render template="/mailingListAttachments/mailerAttachmentsDisplay" />
	</div>
  	</div>
	<div id="contact-area">
	<g:if test="${params.emailMessage }">
		<g:if test="${params.mailingListTemplate}">
			<g:hiddenField name="mailingListTemplate" value="${params.mailingListTemplate }"/>
		</g:if>
		<div class="fieldcontain ${hasErrors(bean: params, field: 'emailMessage', 'error')}" required="required">
		<label for="manager">
			<g:message code="emailMessage.label" default="Message" />
		</label>
		<ckeditor:resources/>
		<div id=formmsg>
			<ckeditor:editor name="emailMessage" height="300px" width="140%">
				${params.emailMessage }
			</ckeditor:editor>
			</div>
		</div>
	</g:if>
	<g:else>
		<div class="fieldcontain ${hasErrors(bean: params, field: 'mailingListScheduleInstance', 'error')}"  required="required">
		<label for="mailingListTemplates">
			<g:message code="mailingListTemplates.label" default="Template" />
			<span class="required-indicator">*</span>
		</label>
		<div id="mailerTemplates" style="display:inline-block;*display:inline;*zoom:1;">
			<g:render template="/mailingListTemplates/mailerTemplatesDisplay" />
		</div>
		</div>
		<div id="loadMessageBox"></div>
	</g:else>
   			
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'dateTime', 'error')}">
		<label for="manager">
			<g:message code="dateTime.label" default="dateTime" />
		</label>

			<g:field  type="text" name="dateTime"  data-format="dd/MM/yyyy hh.mm" value="${current}" />

	</div>
	
	<div class="fieldcontain ${hasErrors(bean: params, field: 'cronExpression', 'error')}">
		<label for="cronExpression">
			<g:message code="cronExpression.label" default="cronExpression" />
		</label>
		<g:textField name="cronExpression" value="${params?.cronExpression}"/>
	</div>
		
	<div class="fieldcontain ${hasErrors(bean: params, field: 'setDate', 'error')} ">
		<label for="setDate">
			<g:message code="setDate.label" default="Issue/Resolve Date:" />
			<span class="required-indicator">*</span>
		</label>

			<input type="text" name="setDate" id="setDate"  value="${params.setDate}" />
		<span class="add-on">
			<i data-time-icon="icon-time" data-date-icon="icon-calendar">
			</i>
		</span>

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
		<g:submitButton name="Send Email" id="loginbtn" class="loginbtn" value="${message(code: 'default.button.preview.label', default: 'Preview')}" />
	</div>
	
	
	</div>
	</g:form>
</div>
	<div style="clear:both;"></div>


	<div id="mailerTemplates1" style="display:none;">
		<g:render template="/mailingListTemplates/mailerTemplatesForm" />
	</div>
	<div id="mailerUploader1" style="display:none;">
		<g:render template="/mailingListUploader/mailerUploaderForm" />
	</div>

	<div id="mailerAttachments1" style="display:none;">
		<g:render template="/mailingListAttachments/mailerAttachmentsForm" />
	</div>
	<div id="mailerSenders1" style="display:none;">
		<g:render template="/mailingListSenders/mailerSendersForm" />
	</div>

	<g:javascript>


  	$().ready(function() {  
		$('#setDate').datetimepicker({
			language: 'en',
			pickDate: true,            // disables the date picker
			pickTime: true,            // disables de time picker

		});
		$('#dateTime').datetimepicker({
			language: 'en',
			pickDate: true,            // disables the date picker
			pickTime: true,            // disables de time picker
		});
	});

   	$('form').submit(function() {  
     		$('#select2 option').each(function(i) {  
      			$(this).attr("selected", "selected");  
     		});  
    	});  
    </g:javascript>
</body></html>

	
