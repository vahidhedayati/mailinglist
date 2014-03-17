package grails.plugin.mailinglist.core

import org.springframework.dao.DataIntegrityViolationException

class MailingListTemplatesController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {
		redirect(action: "list", params: params)
	}
	// This is to reload the ckeditor page 
	def ajaxupload() {}
	
	def loadMessageBox() {
		render(template: 'message', model: [ content: TemplatesBase.get(params.id)?.content ])
	}

	def list(Integer max) {
		params.max = Math.min(max ?: 50, 100)
		[mailingListTemplatesInstanceList: TemplatesBase.list(params), mailingListTemplatesInstanceTotal: TemplatesBase.count()]
	}

	def create() {
		[mailingListTemplatesInstance: new TemplatesBase(params)]
	}

	def loadtemplate() {
		[mailingListTemplatesInstance: new TemplatesBase(params)]
	}

	def save() {
		def mailingListTemplatesInstance = new TemplatesBase(params)
		if (!mailingListTemplatesInstance.save(flush: true)) {
			render(view: "create", model: [mailingListTemplatesInstance: mailingListTemplatesInstance])
			return
		}
		// Redirect to standard action we only pass params.ajax on a modal call
		if (!params.ajax){
			flash.message = message(code: 'default.created.message', args: [message(code: 'TemplatesBase.label', default: 'MailingListTemplates'), mailingListTemplatesInstance.id])
			redirect(action: "show", id: mailingListTemplatesInstance.id)
			
		}
		// We have params.ajax so lets render some text and let jquery handle the rest via javascript
		//redirect(url: request.getHeader('referer'))
		def g=new org.codehaus.groovy.grails.plugins.web.taglib.ApplicationTagLib() 
		def clink=g.createLink(controller: 'MailingListTemplates', action: 'ajaxupload')
		render "Record should now be saved. Create another Template: <a href="+clink+">Here</a>"	
	}

	def show(Long id) {
		def mailingListTemplatesInstance = TemplatesBase.get(id)
		if (!mailingListTemplatesInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'TemplatesBase.label', default: 'MailingListTemplates'), id])
			redirect(action: "list")
			return
		}

		[mailingListTemplatesInstance: mailingListTemplatesInstance]
	}

	def edit(Long id) {
		def mailingListTemplatesInstance = TemplatesBase.get(id)
		if (!mailingListTemplatesInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'TemplatesBase.label', default: 'MailingListTemplates'), id])
			redirect(action: "list")
			return
		}

		[mailingListTemplatesInstance: mailingListTemplatesInstance]
	}

	def update(Long id, Long version) {
		def mailingListTemplatesInstance = TemplatesBase.get(id)
		if (!mailingListTemplatesInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'TemplatesBase.label', default: 'MailingListTemplates'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (mailingListTemplatesInstance.version > version) {
				mailingListTemplatesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
					[message(code: 'TemplatesBase.label', default: 'MailingListTemplates')] as Object[],
					"Another user has updated this MailingListTemplates while you were editing")
				render(view: "edit", model: [mailingListTemplatesInstance: mailingListTemplatesInstance])
				return
			}
		}

		mailingListTemplatesInstance.properties = params

		if (!mailingListTemplatesInstance.save(flush: true)) {
			render(view: "edit", model: [mailingListTemplatesInstance: mailingListTemplatesInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'TemplatesBase.label', default: 'MailingListTemplates'), mailingListTemplatesInstance.id])
		redirect(action: "show", id: mailingListTemplatesInstance.id)
	}

	def delete(Long id) {
		def mailingListTemplatesInstance = TemplatesBase.get(id)
		if (!mailingListTemplatesInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'TemplatesBase.label', default: 'MailingListTemplates'), id])
			redirect(action: "list")
			return
		}

		try {
			mailingListTemplatesInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'TemplatesBase.label', default: 'MailingListTemplates'), id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'TemplatesBase.label', default: 'MailingListTemplates'), id])
			redirect(action: "show", id: id)
		}
	}
}
