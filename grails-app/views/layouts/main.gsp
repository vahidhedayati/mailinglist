<%@ page import="java.util.Random " %>

<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Announcements"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<g:javascript library="application"/>	
		<g:javascript library="jquery"/>	
		<g:javascript library="jquery-ui"/>
		<g:layoutHead/>
		<r:require module="export"/>
		<r:layoutResources />
		<mailinglist:loadbootstrap/>
	</head>
	<body>
		<div id=basic1>
		<div id="grailsLogo" role="banner">
			<a href="${createLink(uri: '/')}">
				<img src="${resource(dir: 'images', file: 'kuoni_alpha.png')}" alt="XML Team Announcement Tool"/>
			</a>	
			<div  id=hselectopt>
				<extlink:selectPref id='autolinkUpdater' noSelection="['': 'Link Config']"  />
			</div>
			<div id=hh>
				<g:if test="${session.user}">			
					<g:link controller="Admin" class="admin" action="welcome">
					<g:message code="Admin" code="Admin Menu" args="[entityName]"/></g:link>
					<g:if test="${session.lastPlace &&  session.redirectit.equals('yes')}">
						<g:set var="redirectit" value="no"  scope="session" />	
						<g:set var="lastPlace" value=""  scope="session" />
						<g:javascript>
							window.location.href = "${session.lastPlace}";
						</g:javascript>
						<g:set var="redirectit" value="no"  scope="page" />	
						<g:set var="lastPlace" value=""  scope="page" />
					</g:if>	
				</g:if>
			</div>
				
			<%  def rn = new Random().nextInt(25) %>
			<div id="spinner" class="spinner-${rn}" style="display:none;">
				<img src="${createLinkTo(dir:'images',file:'spinner'+rn+'.gif')}" alt="Spinner" />
			</div>
			<div class=clearall ></div>
		</div>
		<div id="searchPanel"></div>
		<div id="returnPanel"></div>
		</div>
		<div id="siteContent">
		<g:layoutBody/>
		</div>
		<div id=basic2>
		<div class="footer" role="contentinfo">  &copy; 2013 Kuoni kportal written by <a href="mailto:vahid.hedayati@gta-travel.com">Vahid Hedayati</a> : [ Version <g:meta name="app.version"/> Built with Grails <g:meta name="app.grails.version"/> ]  
		- [ 	<g:link class="tbutton" controller="contactUs"  action="index" >Having issues? Contact Us</g:link> ]
		</div>
		<div id="loginBox" class="loginBox">
			<g:if test="${session?.user}">
				<g:render template="/auth/welcomeMessage"></g:render>
			</g:if>
			<g:else>
				<g:render template="/auth/loginForm"></g:render>				
			</g:else>
		</div>
	</div>
	<r:layoutResources />
	</body>
</html>
