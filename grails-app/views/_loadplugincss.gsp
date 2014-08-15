<g:if test="${gfolder.equals("resources") }">
	<link rel="stylesheet" href="${createLink(uri: '/css/mailingList.css')}" type="text/css">
</g:if>
<g:else>
	<asset:stylesheet href="mailingList.css" />
	<asset:stylesheet href="jquery-ui-timepicker-addon.css" />
	<asset:stylesheet href="jquery-ui.css" />
  	<asset:javascript src="jquery-ui.min.js"/>
  	<asset:javascript src="jquery-ui-timepicker-addon.js"/>
</g:else>
