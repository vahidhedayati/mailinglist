package kportal

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;



class ScheduleEmail1Job {
	def emailService
	static triggers = {}
	def execute(JobExecutionContext context) throws JobExecutionException {
		try{
			log.debug("Job has been called, sending mail");
			//Call the sendEmail method in the email service
			emailService.sendEmail(context.mergedJobDataMap)
		}catch (Throwable e) {
			throw new JobExecutionException(e.getMessage(), e);
		}
	}
}
