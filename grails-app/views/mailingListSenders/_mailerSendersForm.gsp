<md:modalForm
  	id="ModalDynamixRemoteFORM"
  	formId="MySendersForm"
  	title="Create new mailFrom field"
  	divId="mailerSenders"
  	returnController="mailingListSenders"

  	modalTemplatePage="/mailingListSenders/form"
	submitController="mailingListSenders" 
    submitAction="save"
    submitValue="Create new Sender"
    modalTemplate='/modaldynamix/modalRemoteForm'
  	domain="grails.plugin.mailinglist.core.SendersBase"
            height="15em"         
            width="30em"         
            bodyheight="15em"     
            bodywidth='98%'     
            overflow="hidden"   
            position="fixed"    
            top="0"    
            margintop='10em' 
            marginright='auto' 
            left='auto'        
            right='auto'       
            iframescrolling='auto' 
            iframetransparency='true' 
            iframezoom='1'  
            iframewidth='100%' 
            iframeheight='100%'  
            iframemargin='0'     
            iframepadding='0'    
  />
