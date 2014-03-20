	<g:select id="mailingListTemplates" name="mailingListTemplate" from="${returnResult  ?: grails.plugin.mailinglist.core.TemplatesBase.list()}" optionKey="id" required="" value="${params.mailingListTemplates}" class="many-to-one"
		noSelection="['': 'Please choose Template']"
		required=""
		onchange="${remoteFunction (
		controller: 'MailingListEmail',
		action: 'loadMessageBox',
		params: "'id=' + this.value",
		update: 'loadMessageBox'
	)}"
	/>