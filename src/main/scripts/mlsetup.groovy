import groovy.text.SimpleTemplateEngine
import groovy.transform.Field

/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@Field String  usageMessage = """
    grails mlsetup org.example.com 5
    org.example.com = The package name to install malinglist classes to.
	5 = number of jobs to create for mailinglist
"""

description 'Creates domain classes and updates config settings for the mailing list plugin', {
	usage usageMessage
	argument name: 'package',  description: 'The package to use for the domain classes', required: true
	argument name: '9',       description: 'Amount of mail schedules to create',         required: true
}
if (args.size() < 2) {
	error 'Usage:' + usageMessage
	return false
}
	String pack = args[0]
	int amount = args[1] as int
	def packdir = pack.replace('.', '/')

	def engine = new SimpleTemplateEngine()

	StringBuilder cad = new StringBuilder()
	StringBuilder cad1 = new StringBuilder()

	// Create jobs
	if (amount) {
		String jobPath = "grails-app/jobs/$pack"
		new File("$baseDir/$jobPath").mkdirs()
		amount.times { int i ->
			String jobName="ScheduleEmail${i}Job"
			println "Creating job ${i} job Name: $jobPath/${jobName}.groovy  aa"
			def cjob = [ pack: pack, classname:jobName ]
			render  template:'jobs/ScheduleEmailJob.groovy', destination: file( "$jobPath/${jobName}.groovy"), model: cjob

			println "Generating EmailCheckerService Schedule Pool $jobName"
			cad.append('\t\t\t\t\tif (i == ').append(i).append(') {\n')
			cad.append('\t\t\t\t\t\t').append(jobName).append('.schedule(scheduledDate?:cronExpression, paramsMap)\n')
			cad.append('\t\t\t\t\t\tsb.append("').append(jobName).append('")\n')
			cad.append('\t\t\t\t\t\tisStarted=true\n')
			cad.append('\t\t\t\t\t\treturn\n')
			cad.append('\t\t\t\t\t}\n')

			cad1.append('\t\t\t\t\tif (i==').append(i).append(') {\n')
			cad1.append('\t\t\t\t\t\t').append(jobName).append('.schedule(scheduledDate?:cronExpression, params)\n')
			cad1.append('\t\t\t\t\t\tsb.append("').append(jobName).append('")\n')
			cad1.append('\t\t\t\t\t\tisStarted=true\n')
			cad1.append('\t\t\t\t\t\treturn\n')
			cad1.append('\t\t\t\t\t}\n')			
		}
	}

	println "Creating domain classes within your project: grails-app/domain/$packdir"
	new File("${baseDir}/grails-app/domain/$packdir").mkdirs()
	
	generateDomainClass 'MailingList', packdir, baseDir, engine, pack, 'MailingListBase'
	generateDomainClass 'MailingListCategories', packdir, baseDir, engine, pack, 'CategoryBase'
	generateDomainClass 'MailingListAttachments', packdir, baseDir, engine, pack, 'AttachmentsBase'
	generateDomainClass 'MailingListSchedule', packdir, baseDir, engine, pack, 'ScheduleBase'
	generateDomainClass 'MailingListTemplates', packdir, baseDir, engine, pack, 'TemplatesBase'
	generateDomainClass 'MailingListSenders', packdir, baseDir, engine, pack, 'SendersBase'

	println "Creating Services within your project: grails-app/services/$packdir"
	new File("${baseDir}/grails-app/services/$packdir").mkdirs()
	
	def checkerConf = [pack: pack, amount: amount, jobMapping: cad, queueMapping: cad1]
	render  template:'services/QuartzEmailCheckerService.groovy',
		destination: file( "grails-app/services/$packdir/QuartzEmailCheckerService.groovy"),
		model: checkerConf

		render  template:'css/mailingList.css',
		destination: file( "grails-app/assets/stylesheets/mailingList.css")

		render  template:'css/bootstrap-datetimepicker.min.css',
		destination: file( "grails-app/assets/stylesheets/bootstrap-datetimepicker.min.css")
		//render  template:'js/bootstrap-datetimepicker.min.js',
		//destination: file( "grails-app/assets/javascripts/bootstrap-datetimepicker.min.js")

	println """\
		Finished generating classes.
		Config.groovy configurations updates required - please refer to documentation.
	"""


private void generateDomainClass(String className, packdir, baseDir, engine, String pack, String baseClassName) {
	def binding = [pack: pack, classname: className, baseclassname: baseClassName]
	render  template:'domain/default.groovy',
		destination: file( "grails-app/domain/$packdir/${className}.groovy"),
		model: binding
}
