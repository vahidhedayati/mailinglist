This is soon to be hopefully a plugin for grails - the purpose is to email a person or multiple people (from DB)

The workings is that emails are scheduled as a dynamic quartz job using date time for when to run - 

The jobs are added to A DB, if completed scheduleComplete set to true otherwise it is set to false and upon you application start in your main application bootstrap if you included:

		class BootStrap {
			..
			EmailController ec=new EmailController()

				..
				def getEmails=MailingListSchedule.findAllByScheduleCompleteAndScheduleCancelled(false,false)
				getEmails.each {  params ->
						if ( (params.dateTime) && (params.emailMessage)) {
							println "RESCHEDULING MAIL QUEUE  "+params?.id+" -- 			"+params?.mailFrom+"---"+params?.recipientToGroup+"--"+params?.recipientToList
						ec.rescheduleit(params)
						}
				}
	
			..

		}
		
		
This would retrigger incomplete jobs on DB upon your application restart - whether it was restarted during a running schedule or if it was a future schedule from time of restart.


There are 21 Dynamic Schedules defined that can be used for the queuing.


TODO - This is part of one of the main applications I am developing and was using the jquery date time, since moving it to kickstart - I have changed how date/time is shown and will fix the gsp pages soon.

