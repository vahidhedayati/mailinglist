package $pack

import org.springframework.dao.DataIntegrityViolationException

class MailingListSendersController   {
	
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [mailingListSendersInstanceList: MailingListSenders.list(params), mailingListSendersInstanceTotal: MailingListSenders.count()]
    }

    def create() {
        [mailingListSendersInstance: new MailingListSenders(params)]
    }

    def save() {
        def mailingListSendersInstance = new MailingListSenders(params)
        if (!mailingListSendersInstance.save(flush: true)) {
            render(view: "create", model: [mailingListSendersInstance: mailingListSendersInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'mailingListSenders.label', default: 'MailingListSenders'), mailingListSendersInstance.id])
        redirect(action: "show", id: mailingListSendersInstance.id)
    }

    def show(Long id) {
        def mailingListSendersInstance = MailingListSenders.get(id)
        if (!mailingListSendersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListSenders.label', default: 'MailingListSenders'), id])
            redirect(action: "list")
            return
        }
        [mailingListSendersInstance: mailingListSendersInstance]
    }

    def edit(Long id) {
        def mailingListSendersInstance = MailingListSenders.get(id)
        if (!mailingListSendersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListSenders.label', default: 'MailingListSenders'), id])
            redirect(action: "list")
            return
        }

        [mailingListSendersInstance: mailingListSendersInstance]
    }

    def update(Long id, Long version) {
        def mailingListSendersInstance = MailingListSenders.get(id)
        if (!mailingListSendersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListSenders.label', default: 'MailingListSenders'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (mailingListSendersInstance.version > version) {
                mailingListSendersInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'mailingListSenders.label', default: 'MailingListSenders')] as Object[],
                          "Another user has updated this MailingListSenders while you were editing")
                render(view: "edit", model: [mailingListSendersInstance: mailingListSendersInstance])
                return
            }
        }

        mailingListSendersInstance.properties = params

        if (!mailingListSendersInstance.save(flush: true)) {
            render(view: "edit", model: [mailingListSendersInstance: mailingListSendersInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'mailingListSenders.label', default: 'MailingListSenders'), mailingListSendersInstance.id])
        redirect(action: "show", id: mailingListSendersInstance.id)
    }

    def delete(Long id) {
        def mailingListSendersInstance = MailingListSenders.get(id)
        if (!mailingListSendersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListSenders.label', default: 'MailingListSenders'), id])
            redirect(action: "list")
            return
        }

        try {
            mailingListSendersInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'mailingListSenders.label', default: 'MailingListSenders'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'mailingListSenders.label', default: 'MailingListSenders'), id])
            redirect(action: "show", id: id)
        }
    }
}
