package org.grails.plugins.mailinglist

import org.springframework.dao.DataIntegrityViolationException

class MailingListTemplatesController  {

	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }
	def loadMessageBox= {
		def mlt=MailingListTemplates?.get(params.id)
		def content=mlt?.content
		render(template: 'message', model: [ content: content ])
	}
    def list(Integer max) {
        params.max = Math.min(max ?: 50, 100)
        [mailingListTemplatesInstanceList: MailingListTemplates.list(params), mailingListTemplatesInstanceTotal: MailingListTemplates.count()]
    }

    def create() {
        [mailingListTemplatesInstance: new MailingListTemplates(params)]
    }

	def loadtemplate() {
		[mailingListTemplatesInstance: new MailingListTemplates(params)]
	}
    def save() {
        def mailingListTemplatesInstance = new MailingListTemplates(params)
        if (!mailingListTemplatesInstance.save(flush: true)) {
            render(view: "create", model: [mailingListTemplatesInstance: mailingListTemplatesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'), mailingListTemplatesInstance.id])
        redirect(action: "show", id: mailingListTemplatesInstance.id)
    }

    def show(Long id) {
        def mailingListTemplatesInstance = MailingListTemplates.get(id)
        if (!mailingListTemplatesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'), id])
            redirect(action: "list")
            return
        }

        [mailingListTemplatesInstance: mailingListTemplatesInstance]
    }

    def edit(Long id) {
        def mailingListTemplatesInstance = MailingListTemplates.get(id)
        if (!mailingListTemplatesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'), id])
            redirect(action: "list")
            return
        }

        [mailingListTemplatesInstance: mailingListTemplatesInstance]
    }

    def update(Long id, Long version) {
        def mailingListTemplatesInstance = MailingListTemplates.get(id)
        if (!mailingListTemplatesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (mailingListTemplatesInstance.version > version) {
                mailingListTemplatesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'mailingListTemplates.label', default: 'MailingListTemplates')] as Object[],
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

        flash.message = message(code: 'default.updated.message', args: [message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'), mailingListTemplatesInstance.id])
        redirect(action: "show", id: mailingListTemplatesInstance.id)
    }

    def delete(Long id) {
        def mailingListTemplatesInstance = MailingListTemplates.get(id)
        if (!mailingListTemplatesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'), id])
            redirect(action: "list")
            return
        }

        try {
            mailingListTemplatesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'mailingListTemplates.label', default: 'MailingListTemplates'), id])
            redirect(action: "show", id: id)
        }
    }
}
