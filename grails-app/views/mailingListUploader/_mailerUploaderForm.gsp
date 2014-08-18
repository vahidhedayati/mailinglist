<g:modalForm

  id="ModalDynamixIFRAMEUPLOADS"
  formId="MyCSVForm"

  title="Upload CSV"

  divId="mailerUploader"
  returnController="mailingListUploader"
  

	fromPlugin="mailinglist"

  	modalTemplatePage="/mailingListUploader/formuploader"
  
	submitController="mailingListUploader" 
    submitAction="save"
    submitValue="Upload Attachment"
    modalTemplate='/modaldynamix/modaliframe'
    
  	domain="grails.plugin.mailinglist.core.CategoryBase"
  	
  	  height="40em"         
            width="50em"         
            bodyheight="40em"    
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
