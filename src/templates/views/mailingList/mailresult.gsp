
<div id="searchResults" class="searchResults">
	<g:if test="${MailingList?.results}">
		<div id="returnPanel" class="resultsPane">
			<h2>Email Results</h2>
			<g:render template="/mailingList/emailList" model="[link:MailingList.results]"></g:render>

		</div>		
	</g:if>

</div>
