package $pack

import grails.util.Holders

import org.springframework.dao.DataIntegrityViolationException

class MailingListController {
	def exportService
//	def grailsApplication  
	
	def addExcept(list) {
		list << 'index' << 'list' << 'show' << 'emailsearch' << 'display' << 'trySearch1' << 'search'
	}
	
	//static allowedMethods = [save: "POST", update: "POST", delete: "POST", ]
	
	
	def index()  { 
		
		render template: 'mailingList'
		
	}
	def search = { 
		def mq=params.mq ?: null
		def mailingListInstanceList=MailingList?.findAllByEmailAddressLikeOrEmailDisplayNameLike("%"+mq+"%", "%"+mq+"%" , [max:30])
		if (!mailingListInstanceList) {
			mailingListInstanceList=MailingList?.findAllByFirstNameLikeOrMiddleNameLikeOrLastNameLike("%"+mq+"%", "%"+mq+"%", "%"+mq+"%"  , [max:30])
		}
		[ mailingListInstanceList: mailingListInstanceList]
	}
	
	def emailsearch = {
		def mq = params.mq ?: null
		def searchResults
		if(mq) {
			searchResults = [
				MailResults: trySearch1 { MailingList.search(mq, [max:10]) },
				mq: mq.encodeAsHTML()
			]	
		}
		render (template: "/mailResults", model: [ searchResults:searchResults ])
	}
	
	private def trySearch1(Closure callable) {
		try {
			return callable.call()
		}
		catch(Exception e) {
			log.debug "Search Error: "+e.message, e
			return []
		}
	}

	def display = {
		def link = MailingList.get(params.id)
		if(link) {
			
			if(request.xhr) {
				render(template:"emailList", model:[ link:link])
			}
			else {
				render( view:"show", model:[mailingListInstance:link])
			}
		}
		else {
			response.sendError 404
		}
	}

    def list(Integer max) {
		params.max = Math.min(params.int('max') ?: 50, 10000)
		def pageSizes=params.pageSizes
		if (pageSizes==null) {pageSizes='10'}
		def order=params.order
		if ((order==null) || (order=='')) {
			order="desc"
		}
		
		def offset=params.offset
		if (offset==null) { offset=0; }
		
		if(params?.format && params.format != "html"){ 
			
			def config = Holders.config
			response.contentType = config.grails.mime.types[params.format] 
			response.setHeader("Content-disposition", "attachment; filename=MailingList."+params.extension+"")
			exportService.export(params.format, response.outputStream,MailingList.list(), [:], [:])
		}
		def file
		def ftype
		if(request.xhr){	
			ftype='template'
			file='listing'
			render (template: 'listing', model:[mailingListInstanceList: MailingList.list(params), mailingListInstanceTotal: MailingList.count()] )
			
		}else{
			file='listing'
			ftype='view'
			render (view: 'list', model:[mailingListInstanceList: MailingList.list(params), mailingListInstanceTotal: MailingList.count()] )
		}
    }

    def create() {
        [mailingListInstance: new MailingList(params)]
    }

    def save() {
		def email=params.emailAddress
		def cid=params.mlcategories.id
		def Categories=MailingListCat.findById(params.mlcategories.id)
		def found=MailingList.findByEmailAddressAndMlcategories(email, Categories)
		def mailingListInstance = new MailingList(params)
		if (!found) {
			if (!mailingListInstance.save(flush: true)) {
				render(view: "create", model: [mailingListInstance: mailingListInstance])
				return
			}
			flash.message = message(code: 'default.created.message', args: [message(code: 'mailingList.label', default: 'MailingList'), mailingListInstance.id])
			redirect(action: "show", id: mailingListInstance.id)
		}else{
			flash.message = message(code: 'ERROR - Could not add record EMAIL address '+email+' already exists in '+Categories.name+' !!')
			render(view: "create", model: [mailingListInstance: mailingListInstance])
			return
		}
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
