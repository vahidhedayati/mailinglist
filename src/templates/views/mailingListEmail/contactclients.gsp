<g:render template="/mailingList/mailingListImport"/>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		
		<!--  bootstrap-min for modal popup -->
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'ml-bootstrap-combined.min.css')}" type="text/css">
		
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mailingList.css')}" type="text/css">
		<g:set var="entityName" value="${message(code: 'ContactClients.label', default: 'Contact Clients')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		
<ckeditor:resources/>

	</head>
	<body>
	
	<g:render template="/mailingList/mainmenu"/>
	
	
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
				

			<!-- LOAD Bootstrap file required for modal pop up + css above called ml-bootstrap -->
           	<g:javascript src="bootstrap.min.js" />
           
 			
 	
 				
    <div class="tbutton">
 	 	<button href="#BuildModalTEMPLATES" class="btn btn-block btn-success" role="button" data-toggle="modal" title="Create New Template">
 		Generate Template?</button>
 		<g:render template="/mailingListModal/modalbasic" model="[formId:'TemplatesForm', title:'Generate Template',controller: 'mailingListTemplates', callPage: 'formAjax' , divId: 'mailerTemplates', id: 'TEMPLATES']" />
 	</div>
 	
 	
 	<div class="tbutton">
 		<button href="#BuildModalATTACH" class="btn btn-block btn-success" role="button" data-toggle="modal" title="Upload CSV">
 		Upload attachments?</button>
 		<g:render template="/mailingListModal/modalbasic" model="[formId:'AttachForm',title:'Attache a file', controller: 'mailingListAttachments', callPage: 'formAjax' , divId: 'mailerAttachments', id: 'ATTACH']" />
 	</div>
 	
 	<div class="tbutton">
 		 <button href="#BuildModalUPLOADS" class="btn btn-block btn-success" role="button" data-toggle="modal" title="Upload CSV">
 		Upload CSV?</button>
 		<g:render template="/mailingListModal/modalbasic" model="[formId:'UploadForm',title:'Upload CSV',controller: 'mailingListUploader', callPage: 'ajaxupload' , divId: 'mailerUploader', id: 'UPLOADS']" />
 	</div>
 	
 	<div class="tbutton">
 	<button href="#BuildModalSENDERS" class="btn btn-block btn-success" role="button" data-toggle="modal" title="Configure New Sender" onClick="runSendersCheck()">New Sender?</button>
 	
 	<!--  Clone the form below before attempting to retrieve it after closing it in _modalcreate.gsp -->
 	<g:javascript>
 	 	var myClone
 	 	function runSendersCheck() {
 	 		myClone=$('#mailerSenders1').clone();   
 	 	 	$('#mailerSenders1').show();
 	 	}
 	 </g:javascript>
 	 
		<div id="mailerSenders1">
 			<g:render template="/mailingListModal/modalcreate" model="[title:'Add Senders Email', controller: 'mailingListSenders', callPage: 'form' , divId: 'mailerSenders', id: 'SENDERS' ]" />
 		</div>
 		
 	</div>
 		

	<g:form action="confirmcontact" >

			<div id="contact-area">

		<g:render template="/mailingList/addedby"  model="[caller: 'params']"/>

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
	</div>
	
	<div class="fieldcontain ${hasErrors(bean: params, field: 'mailFrom', 'error')} required">
	<label for="mailFrom">
		<g:message code="manager.label" default="mailFrom" />
		<span class="required-indicator">*</span>
	</label>
	
	<div id="mailerSenders" style="display:inline-block;*display:inline;*zoom:1;">
		<g:render template="mailingListSendersDisplay" />
	</div>
	
  
	</div>
	
	
	
	
	<div class="fieldcontain ${hasErrors(bean: params, field: 'recipientToGroup', 'error')} ">
	<label for="recipientToGroup">
		<g:message code="recipientToGroup.label" default="To:" />
		<span class="required-indicator">*</span>
	</label>	
	
	
	<div id="mailerUploader" style="display:inline-block;*display:inline;*zoom:1;">
		<g:render template="mailingListUploaderDisplay" />
	</div>
  	</div>
	

	<div id="contact-area">
	<div class="fieldcontain ${hasErrors(bean: params, field: 'subject', 'error')} required">
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
	

	<div id="mailerAttachments" style="display:inline-block;*display:inline;*zoom:1;">
		<g:render template="mailingListAttachmentsDisplay" />
	</div>
  	</div>


			<div id="contact-area">
<g:if test="${params.emailMessage }">

		<g:if test="${params.mailingListTemplate}">
			<g:hiddenField name="mailingListTemplate" value="${params.mailingListTemplate }"/>
		</g:if>




<div class="fieldcontain ${hasErrors(bean: params, field: 'emailMessage', 'error')} required">
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
	
	
	<div id="mailerTemplates" style="display:inline-block;*display:inline;*zoom:1;">
		<g:render template="mailingListTemplatesDisplay" />
	</div>
  		
</div>



<div id="loadMessageBox"></div>
</g:else>
   


			
	<div class="fieldcontain ${hasErrors(bean: mailingListScheduleInstance, field: 'dateTime', 'error')} required">
	<label for="manager">
		<g:message code="dateTime.label" default="dateTime" />
	</label>
	<jqueryPicker:time name="dateTime" value="${curr }" />
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

	