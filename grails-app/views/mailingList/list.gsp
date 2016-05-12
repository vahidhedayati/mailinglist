<html>
	<head>
		<meta name="layout" content="mailingListMini">
		<g:set var="entityName" value="${message(code: 'mailingList.label', default: 'MailingList')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<div class="envtabs  navbar">
		<g:render template="/mainmenu"  />
		 <ul class="nav-pills pull-right">
				<li class="btn btn-default"><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
				<li class="btn btn-default"><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
		</ul>
	</div>	
	
		<div id="list-mailingList" class="content scaffold-list" role="mailingListMini">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			
			<div class=heading1>
			<g:message code="default.search.label" default="Search"/>:
			<g:remoteField name="mq"  id="searchform"  update="emailSearch" paramName="mq" url="[controller:'MailingList', action:'search']"></g:remoteField>
			</div>
			<div class="clearall"></div>
			<ul class="tab_opt">
  				<li><g:select   class="top_form1"  name="sortby" from="${['lastUpdated', 'firstName','lastName','dateCreated','categories','emailDisplayName','emailAddress','addedby']}"   value="${sortby}" onchange="${remoteFunction(action:'list', params:'\'id='+inputid+'\'+\'&envid='+envid+'\'+\'&sortby=\' + escape(this.value) +\'&s='+s+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params?.max+'\'+\'&offset='+offset+'\'+\'&order='+order+'\'+\'&viewtype=na\'',update : divupdate)}"/> </li>	
				<li><g:select   class="top_form1" name="order" from="${['asc', 'desc']}"  value="${order}" onchange="${remoteFunction(action:'list', params:'\'id='+inputid+'\'+\'&order=\' + escape(this.value) +\'&s='+s+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params?.max+'\'+\'&envid='+envid+'\'+\'&offset='+offset+'\'+\'&sortby='+sortby+'\'+\'&viewtype=na\'',update : divupdate)}"/></li>
				<li><g:select   class="top_form1" name="s" from="${allcat}"  optionKey="id" optionValue="name" value="${s}" onchange="${remoteFunction(action:'list', params:'\'id=\' + escape(this.value) +\'&s=c&order='+order+'\'+\'&pageSizes='+pageSizes+'\'+\'&max='+params?.max+'\'+\'&envid='+envid+'\'+\'&offset='+offset+'\'+\'&sortby='+sortby+'\'+\'&viewtype=na\'',update : divupdate)}"/></li>
			</ul>
		<div id="emailSearch" class="emailSearch">
		</div>
		<div id="searchResults"></div>
		<div id="returnPanel">
		</div>
		<div id="mailingListContent">
			<g:render template="listing" model="[params:params, mailingListInstanceList: mailingListInstanceList]"></g:render>
		</div>
	</div>
	</body>
</html>
