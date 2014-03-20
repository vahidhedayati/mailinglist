<g:modalForm

  id="ModalDynamixRemoteFORM"
  formId="MySendersForm"

  title="Create new mailFrom field"

  divId="mailerSenders"
  returnController="mailingListSenders"
  

	fromPlugin="mailinglist"

  	modalTemplatePage="/mailingListSenders/form"
  
	submitController="mailingListSenders" 
    submitAction="save"
    submitValue="Create new Sender"
    modalTemplate='/modaldynamix/modalRemoteForm'
    
  	domain="grails.plugin.mailinglist.core.SendersBase"
  />