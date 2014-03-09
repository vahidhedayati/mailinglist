
<div id="searchResults" class="searchResults">
	<g:if test="${MalingList?.results}">
		<div id="returnPanel" class="resultsPane">
			<h2>Email Results</h2>
			<g:render template="/mailingList/emailList" model="[link:MalingList.results]"></g:render>

		</div>		
	</g:if>

</div>