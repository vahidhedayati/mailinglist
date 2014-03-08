
package $pack

import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException


class $classname {
	
	def emailService
	 
	static triggers = {}
	
	def execute(JobExecutionContext context) throws JobExecutionException {
		try{
			
			log.info("Job has been called, sending mail from "+$classname);
			//Call the sendEmail method in the email service
			emailService.sendEmail(context.mergedJobDataMap)
			
		}catch (Throwable e) {
			throw new JobExecutionException(e.getMessage(), e);
		}
	}
}