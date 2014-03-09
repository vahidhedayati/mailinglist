package $pack

import org.springframework.dao.DataIntegrityViolationException

class MailingListController {

	//static allowedMethods = [save: "POST", update: "POST", delete: "POST", ]

	def exportService

	def index() {
		render template: 'mailingList'
	}

	def search(String mq) {
		def mailingListInstanceList = MailingList.findAllByEmailAddressLikeOrEmailDisplayNameLike("%" + mq + "%", "%" + mq + "%", [max: 30])
		if (!mailingListInstanceList) {
			mailingListInstanceList = MailingList.findAllByFirstNameLikeOrMiddleNameLikeOrLastNameLike("%" + mq + "%", "%" + mq + "%", "%" + mq + "%", [max: 30])
		}
		[ mailingListInstanceList: mailingListInstanceList]
	}

	def emailsearch(String mq) {
		def searchResults
		if (mq) {
			searchResults = [
				MailResults: trySearch1 { MailingList.search(mq, [max:10]) },
				mq: mq.encodeAsHTML()
			]
		}
		render (template: "/mailResults", model: [ searchResults:searchResults ])
	}

	private trySearch1(Closure callable) {
		try {
			return callable.call()
		}
		catch(e) {
			log.debug "Search Error: \$e.message", e
			return []
		}
	}

	def display() {
		def link = MailingList.get(params.id)
		if (!link) {
			response.sendError 404
			return
		}

		if (request.xhr) {
			render(template:"emailList", model:[ link:link])
		}
		else {
			render( view:"show", model:[mailingListInstance:link])
		}
	}

	def list(String format) {
		params.max = Math.min(params.int('max') ?: 50, 10000)
		params.order = params.order ?: 'desc'
		params.offset = params.offset ?: '0'

		if (format != "html") {
			response.contentType = grailsApplication.config.grails.mime.types[format]
			response.setHeader("Content-disposition", "attachment; filename=MailingList." + params.extension)
			exportService.export(format, response.outputStream,MailingList.list(), [:], [:])
		}

		def model = [mailingListInstanceList: MailingList.list(params), mailingListInstanceTotal: MailingList.count()]

		if (request.xhr) {
			render (template: 'listing', model: model)
		}
		else {
			render (view: 'list', model: model)
		}
	}

	def create() {
		[mailingListInstance: new MailingList(params)]
	}

	def save(String emailAddress) {
		def categories = MailingListCat.get(params.mlcategories.id)
		def found = MailingList.findByEmailAddressAndMlcategories(emailAddress, categories)
		def mailingListInstance = new MailingList(params)
		if (found) {
			flash.message = message(code: "ERROR - Could not add record EMAIL address \$emailAddress already exists in \$categories.name !!")
			render(view: "create", model: [mailingListInstance: mailingListInstance])
			return
		}

		if (!mailingListInstance.save(flush: true)) {
			render(view: "create", model: [mailingListInstance: mailingListInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'mailingList.label', default: 'MailingList'), mailingListInstance.id])
		redirect(action: "show", id: mailingListInstance.id)
	}

	def show(Long id) {
		def mailingListInstance = MailingList.get(id)
		if (!mailingListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingList.label', default: 'MailingList'), id])
			redirect(action: "list")
			return
		}
		[mailingListInstance: mailingListInstance]
	}

	def edit(Long id) {
		def mailingListInstance = MailingList.get(id)
		if (!mailingListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingList.label', default: 'MailingList'), id])
			redirect(action: "list")
			return
		}
		[mailingListInstance: mailingListInstance]
	}

	def update(Long id, Long version) {
		def mailingListInstance = MailingList.get(id)
		if (!mailingListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingList.label', default: 'MailingList'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (mailingListInstance.version > version) {
				mailingListInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
					[message(code: 'mailingList.label', default: 'MailingList')] as Object[],
					"Another user has updated this MailingList while you were editing")
				render(view: "edit", model: [mailingListInstance: mailingListInstance])
				return
			}
		}

		mailingListInstance.properties = params
		if (!mailingListInstance.save(flush: true)) {
			render(view: "edit", model: [mailingListInstance: mailingListInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [message(code: 'mailingList.label', default: 'MailingList'), mailingListInstance.id])
		redirect(action: "show", id: mailingListInstance.id)
	}

	def delete(Long id) {
		def mailingListInstance = MailingList.get(id)
		if (!mailingListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingList.label', default: 'MailingList'), id])
			redirect(action: "list")
			return
		}
		try {
			mailingListInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'mailingList.label', default: 'MailingList'), id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'mailingList.label', default: 'MailingList'), id])
			redirect(action: "show", id: id)
		}
	}
}
