

	<g:select id="mailFrom" name="mailFrom" value="${params.mailFrom }"
          from="${returnResult ?: grails.plugin.mailinglist.core.SendersBase.list()}"
          optionKey="emailAddress" optionValue="emailAddress"
          noSelection="['': 'Please choose From field']"
          required=""
           />
	
	
	
	