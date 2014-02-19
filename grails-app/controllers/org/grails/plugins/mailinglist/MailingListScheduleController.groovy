package org.grails.plugins.mailinglist

import org.quartz.Scheduler;
import org.springframework.dao.DataIntegrityViolationException

class MailingListScheduleController{
	def  quartzStatusService
	Scheduler quartzScheduler
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	
	def showmsg() { 
		def record= MailingListSchedule?.findById(params.id)
		if (record){
			render record?.emailMessage 
		}
    }
	
	def br (Integer max,  String s, String viewtype) {
		def userchoice=params.userchoice
		def FoundHistory
		def pageSizes=params.pageSizes
		if (pageSizes==null) {pageSizes='10'}
		def envid=params.envid
		if (envid==null) {envid='' }
		params.max = Math.min(params.int('max') ?: 50, 100)
		def total=0
		def order=params.order
		if ((order==null) || (order=='')) {
			order="desc"
		}
		def sortby=params.sortby
		if ((sortby==null) || (sortby=='')){
			sortby="lastUpdated"
		}
		def offset=params.offset
		if (offset==null) { offset=0; }
		def inputid=params.id
		def max1=""
		def divupdate=''
		if (!s) { s='oa' }
		if (s.equals('u')) {
			FoundHistory = MailingListSchedule?.findAllByAddedby( params.id, [sort: ""+sortby+"", order:""+order+"", offset:""+offset+"", max:""+params.max+""] )
			total =MailingListSchedule?.countByAddedby(params.id)
		}else if (s.equals('oa')) {
			 FoundHistory = MailingListSchedule?.findAllByScheduleCompleteAndScheduleCancelled(false,false, [sort: ""+sortby+"", order:""+order+"", offset:""+offset+"", max:""+params.max+""] )
			 total = MailingListSchedule?.countByScheduleComplete(false)
		}else if (s.equals('od')) {
			FoundHistory = MailingListSchedule?.findAllByScheduleComplete(true, [sort: ""+sortby+"", order:""+order+"", offset:""+offset+"", max:""+params.max+""] )
			total = MailingListSchedule?.countByScheduleComplete(true)
		}else if (s.equals('oc')) {
			FoundHistory = MailingListSchedule?.findAllByScheduleCancelled(true, [sort: ""+sortby+"", order:""+order+"", offset:""+offset+"", max:""+params.max+""] )
			total = MailingListSchedule?.countByScheduleCancelled(true)
		}
		String file='list2'
		params.template="mini-main"
		if(!request.xhr){
			params.template="main"
		}	
		if ((viewtype==null) || (viewtype=='')) {	viewtype="normal"}
		divupdate='siteContent'
		render(view:file, model: [now: new Date(),scheduler: quartzScheduler,divupdate: divupdate, evid:envid, pageSizes:pageSizes, offset:offset, viewtype:viewtype, max:max, userchoice: userchoice,deploymentInfoHistoryInstanceList: FoundHistory, deploymentInfoHistoryInstanceTotal: total, inputid:inputid, s: s, order: order, sortby:sortby ,action: 'br', template:params.template])
	}
	
	def modSchedule()  { 
		def cid=params.id
		def calltype=params.calltype
		def jobName=params.jobName
		StringBuilder sb=new StringBuilder()
		if (calltype) {
			if (cid) {
				def cr=MailingListSchedule?.findById(cid)
				if (cr) {
					cr.each { crec ->
						if (calltype.equals('cancel')) {
							sb.append('MailingListSchedule row marked as Cancelled ')
							crec.scheduleCancelled=true
						}
						if (calltype.equals('complete')) {
							sb.append('MailingListSchedule row marked as completed ')
							crec.scheduleComplete=true
						}
						cr.save(flush:true)
					}
				}
			}
			if (jobName) {
				
				def ag=quartzStatusService.find(jobName)
				params.triggerName=quartzStatusService.ret_triggerName
				params.triggerGroup=quartzStatusService.ret_triggerGroup
				params.jobName=quartzStatusService.ret_jobName
				if (params.triggerName && params.triggerGroup) {
					
					def sres=quartzStatusService.stop(params)
					sb.append(' | '+sres)
				}
			}		
		}
		flash.message = sb.toString()
		redirect(url: request.getHeader('referer'))
	}
	
    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [mailingListScheduleInstanceList: MailingListSchedule.list(params), mailingListScheduleInstanceTotal: MailingListSchedule.count()]
    }

    def show(Long id) {
        def mailingListScheduleInstance = MailingListSchedule.get(id)
        if (!mailingListScheduleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'mailingListSchedule.label', default: 'MailingListSchedule'), id])
            redirect(action: "list")
            return
        }

        [mailingListScheduleInstance: mailingListScheduleInstance]
    }

}
