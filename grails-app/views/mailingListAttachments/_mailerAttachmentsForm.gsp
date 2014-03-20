<g:modalForm

  id="ModalDynamixIFRAMEATTACH"
  formId="MyAttachmentForm"

  title="Attach file"

  divId="mailerAttachments"
  returnController="mailingListAttachments"
  

	fromPlugin="mailinglist"

  	modalTemplatePage="/mailingListAttachments/formiframe"
  
	submitController="mailingListAttachments" 
    submitAction="save"
    submitValue="Upload Attachment"
    modalTemplate='/modaldynamix/modaliframe'
    
  	domain="grails.plugin.mailinglist.core.AttachmentsBase"
  />