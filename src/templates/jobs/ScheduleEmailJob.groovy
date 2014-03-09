package $pack

import org.quartz.JobExecutionContext
import org.quartz.JobExecutionException

class $classname {

<<<<<<< HEAD
	def mailingListEmailService
=======
	def emailService
>>>>>>> 544363da5849928de70a35ebf8fd0c407454da49

	static triggers = {}

	def execute(JobExecutionContext context) throws JobExecutionException {
		try {
			log.info("Job has been called, sending mail from \$classname")
			//Call the sendEmail method in the email service
<<<<<<< HEAD
			mailingListEmailService.sendEmail(context.mergedJobDataMap)
=======
			emailService.sendEmail(context.mergedJobDataMap)
>>>>>>> 544363da5849928de70a35ebf8fd0c407454da49
		}
		catch (Throwable e) {
			throw new JobExecutionException(e.message, e)
		}
	}
}
