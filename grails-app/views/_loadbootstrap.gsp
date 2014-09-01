<!--  This simply loads in the bootstrap css and js - css modified chunk at top removed 
to stop meddling with existing body/p tags from default grails or any other site  -->


<g:if test="${enduser?.verifyAppVersion().equals('resources')}">
	<link rel="stylesheet" href="${createLink(uri: '/css/bootstrap.min.css')}" type="text/css">
	<link rel="stylesheet" href="${createLink(uri: '/css/mailingList.css')}" type="text/css">
	<script src="${createLink(uri: '/js/bootstrap.min.js')}" type="text/javascript"></script>
</g:if>
<g:else>
  	<asset:javascript src="jquery-ui.min.js"/>
  	<asset:javascript src="jquery-ui-timepicker-addon.js"/>
	<asset:javascript src="jquery-ui-timepicker-addon-i18n.min.js"/>
	<asset:stylesheet href="bootstrap.min.css" />
	<asset:javascript src="bootstrap.min.js"/>
	<asset:stylesheet href="mailingList.css" />
	<asset:stylesheet href="jquery-ui-timepicker-addon.css" />
	<asset:stylesheet href="jquery-ui.css" />
</g:else>

