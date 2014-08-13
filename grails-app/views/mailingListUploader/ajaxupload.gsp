<html>
	<head>
	
		<g:if test="${!request.xhr }">
    		<meta name='layout' content="main"/>
    	</g:if>
		<g:else>
			<g:if test="${mailinglist.verifyAppVersion().equals('resources')}">
				<meta name='layout' content="mailingListMini"/>
			</g:if>	
			<g:else>
				<meta name='layout' content="mailingListMiniAssets"/>
			</g:else>
		</g:else>
		
    	<g:set var="entityName" value="${message(code: 'MailingListSchedule.label', default: 'MailingList Schedule')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body >
	
	
	
	
<p> You can upload two types of CSV files which are your exported outlook contact lists. 
</p>

<p><b>1> 2 field CSV file</b><br/>
<b>E-mail Display Name,E-mail Address</b><br>
The fields must be in the above format and the first line must be a heading since it ignores the first line of the csv file
</p>
<br/><br/>

<p><b>2> 7 field CSV file</b><br/>
<b>"Title","First Name","Middle Name","Last Name","Categories","E-mail Address","E-mail Display Name" </b><br>

The fields must be in the above format and the first line must be a heading since it ignores the first line of the csv file

</p>

<g:uploadForm  name="${params?.formId }" id="1" id="1" controller="MailingListUploader" action="upload">
<g:hiddenField name="ajax" value="yes"/>
<div class="fieldcontain ${hasErrors(bean: params, field: 'catname', 'error')} ">
	<label for="catname">
		<g:message code="manager.label" default="Mailing List Name" />
	</label>
	<input type="text" name="catname">
	</div>
	
	<div class="fieldcontain ${hasErrors(bean: params, field: 'file', 'error')} ">
	<label for="file">
		<g:message code="manager.label" default="Choose File" />
	</label>
    <input type="file" name="file">
    </div>
    <g:submitButton name="upload" value="Upload" />
</g:uploadForm>

			

</body>
</html>


