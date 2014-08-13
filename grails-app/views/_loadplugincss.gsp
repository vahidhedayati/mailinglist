<g:if test="${gfolder.equals("resources") }">
	<link rel="stylesheet" href="${createLink(uri: '/css/mailingList.css')}" type="text/css">
</g:if>
<g:else>
	<asset:stylesheet href="mailingList.css" />
</g:else>