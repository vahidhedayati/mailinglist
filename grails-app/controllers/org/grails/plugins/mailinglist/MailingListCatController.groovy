package org.grails.plugins.mailinglist

import org.springframework.dao.DataIntegrityViolationException

class MailingListCatController {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 50, 100)
        [mailingListCatInstanceList: MailingListCat.list(params), mailingListCatInstanceTotal: MailingListCat.count()]
    }

    def create() {
        [mailingListCatInstance: new MailingListCat(params)]
    }

    def save() {
        def mailingListCatInstance = new MailingListCat(params)
        if (!mailingListCatInstance.save(flush: true)) {
            render(view: "create", model: [mailingListCatInstance: mailingListCatInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'mailingListCat.label', default: 'MailingListCat'), mailingListCatInstance.id])
        redirect(action: "show", id: mailingListCatInstance.id)
    }

    def show(Long id) {
        def mailingListCatInstance = MailingListCat.get(id)
        if (!mailingListCatInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListCat.label', default: 'MailingListCat'), id])
            redirect(action: "list")
            return
        }

        [mailingListCatInstance: mailingListCatInstance]
    }

    def edit(Long id) {
        def mailingListCatInstance = MailingListCat.get(id)
        if (!mailingListCatInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListCat.label', default: 'MailingListCat'), id])
            redirect(action: "list")
            return
        }

        [mailingListCatInstance: mailingListCatInstance]
    }

    def update(Long id, Long version) {
        def mailingListCatInstance = MailingListCat.get(id)
        if (!mailingListCatInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListCat.label', default: 'MailingListCat'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (mailingListCatInstance.version > version) {
                mailingListCatInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'mailingListCat.label', default: 'MailingListCat')] as Object[],
                          "Another user has updated this MailingListCat while you were editing")
                render(view: "edit", model: [mailingListCatInstance: mailingListCatInstance])
                return
            }
        }

        mailingListCatInstance.properties = params

        if (!mailingListCatInstance.save(flush: true)) {
            render(view: "edit", model: [mailingListCatInstance: mailingListCatInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'mailingListCat.label', default: 'MailingListCat'), mailingListCatInstance.id])
        redirect(action: "show", id: mailingListCatInstance.id)
    }

    def delete(Long id) {
        def mailingListCatInstance = MailingListCat.get(id)
        if (!mailingListCatInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListCat.label', default: 'MailingListCat'), id])
            redirect(action: "list")
            return
        }

        try {
            mailingListCatInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'mailingListCat.label', default: 'MailingListCat'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'mailingListCat.label', default: 'MailingListCat'), id])
            redirect(action: "show", id: id)
        }
    }
}
