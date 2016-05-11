<md:modalForm
  	id="ModalDynamixIFRAMEATTACH"
  	formId="MyAttachmentForm"
  	title="Attach file"
  	divId="mailerAttachments"
  	returnController="mailingListAttachments"

  	modalTemplatePage="/mailingListAttachments/formiframe"
	submitController="mailingListAttachments" 
    submitAction="save"
    submitValue="Upload Attachment"
    modalTemplate='/modaldynamix/modaliframe'
  	domain="grails.plugin.mailinglist.core.AttachmentsBase"
  	
  	  height="25em"         
            width="30em"         
            bodyheight="25em"    
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
