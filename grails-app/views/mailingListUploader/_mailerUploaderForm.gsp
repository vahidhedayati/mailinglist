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
  />