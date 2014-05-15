package grails.plugin.mailinglist.core



import org.springframework.dao.DataIntegrityViolationException

class MailingListController {

	def exportService
	def grailsApplication
	
	def index() {}

	def search(String mq) {
		def mailingListInstanceList = MailingListBase.findAllByEmailAddressLikeOrEmailDisplayNameLike("%" + mq + "%", "%" + mq + "%", [max: 30])
		if (!mailingListInstanceList) {
			mailingListInstanceList = MailingListBase.findAllByFirstNameLikeOrMiddleNameLikeOrLastNameLike("%" + mq + "%", "%" + mq + "%", "%" + mq + "%", [max: 30])
		}
		[ mailingListInstanceList: mailingListInstanceList]
	}

	def emailsearch(String mq) {
		def searchResults
		if (mq) {
			searchResults = [
				MailResults: trySearch1 { MailingListBase.search(mq, [max:10]) },
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
			log.debug "Search Error: $e.message", e
			return []
		}
	}

	def display() {
		def link = MailingListBase.get(params.id)
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

	def list() {
		String format=params.extension ?: 'html'
		params.max = Math.min(params.int('max') ?: 50, 10000)
		params.order = params.order ?: 'desc'
		params.offset = params.offset ?: '0'
		if ((format) &&(format != "html")) {
			response.contentType = grailsApplication.config.grails.mime.types[format]
			response.setHeader("Content-disposition", "attachment; filename=MailingListBase." + params.extension)
			exportService.export(format, response.outputStream,MailingListBase?.list(), [:], [:])
		}
		def model = [mailingListInstanceList: MailingListBase?.list(params), mailingListInstanceTotal: MailingListBase?.count()]
		if (request.xhr) {
			render (template: 'listing', model: model)
		}
		else {
			render (view: 'list', model: model)
		}
	}

	def create() {
		[mailingListInstance: new MailingListBase(params)]
	}

	def save(String emailAddress) {
		def categories = CategoryBase.get(params.categories.id)
		def found = MailingListBase.findByEmailAddressAndCategories(emailAddress, categories)
		def mailingListInstance = new MailingListBase(params)
		if (found) {
			flash.message = message(code: "ERROR - Could not add record EMAIL address $emailAddress already exists in $categories.name !!")
			render(view: "create", model: [mailingListInstance: mailingListInstance])
			return
		}

		if (!mailingListInstance.save(flush: true)) {
			render(view: "create", model: [mailingListInstance: mailingListInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'MailingListBase.label', default: 'MailingList'), mailingListInstance.id])
		redirect(action: "show", id: mailingListInstance.id)
	}

	def show(Long id) {
		def mailingListInstance = MailingListBase.get(id)
		if (!mailingListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'MailingListBase.label', default: 'MailingList'), id])
			redirect(action: "list")
			return
		}
		[mailingListInstance: mailingListInstance]
	}

	def edit(Long id) {
		def mailingListInstance = MailingListBase.get(id)
		if (!mailingListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'MailingListBase.label', default: 'MailingList'), id])
			redirect(action: "list")
			return
		}
		[mailingListInstance: mailingListInstance]
	}

	def update(Long id, Long version) {
		def mailingListInstance = MailingListBase.get(id)
		if (!mailingListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'MailingListBase.label', default: 'MailingList'), id])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (mailingListInstance.version > version) {
				mailingListInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
					[message(code: 'MailingListBase.label', default: 'MailingList')] as Object[],
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

		flash.message = message(code: 'default.updated.message', args: [message(code: 'MailingListBase.label', default: 'MailingList'), mailingListInstance.id])
		redirect(action: "show", id: mailingListInstance.id)
	}

	def delete(Long id) {
		def mailingListInstance = MailingListBase.get(id)
		if (!mailingListInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'MailingListBase.label', default: 'MailingList'), id])
			redirect(action: "list")
			return
		}
		try {
			mailingListInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'MailingListBase.label', default: 'MailingList'), id])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'MailingListBase.label', default: 'MailingList'), id])
			redirect(action: "show", id: id)
		}
	}
}
