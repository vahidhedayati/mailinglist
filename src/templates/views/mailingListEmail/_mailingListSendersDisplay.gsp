

	<g:select id="mailFrom" name="mailFrom" value="${params.mailFrom }"
          from="${mlSenders}"
          optionKey="emailAddress" optionValue="emailAddress"
          noSelection="['': 'Please choose From field']"
          required=""
           />
	
	
	
	