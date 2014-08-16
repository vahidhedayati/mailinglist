<g:if test="${gfolder.equals("resources") }">
	<link rel="stylesheet" href="${createLink(uri: '/css/mailingList.css')}" type="text/css">
</g:if>
<g:else>
	 <asset:javascript src="jquery-ui.min.js"/>
        <asset:javascript src="jquery-ui-timepicker-addon.js"/>
        <asset:javascript src="jquery-ui-timepicker-addon-i18n.min.js"/>
        <asset:stylesheet href="mailingList.css" />
        <asset:stylesheet href="jquery-ui-timepicker-addon.css" />
        <asset:stylesheet href="jquery-ui.css" />
</g:else>
