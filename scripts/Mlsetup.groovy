import grails.util.Metadata
import groovy.text.SimpleTemplateEngine

includeTargets << grailsScript("_GrailsArgParsing")

USAGE = """
<<<<<<< HEAD
    Mlsetup org.example.com 5
    org.example.com = The package name to install mailinglist classes to.
	5 = number of jobs to create for mailinglist 
=======
    grails mlsetup org.example.com 5
    org.example.com = The package name to install malinglist classes to.
	5 = number of jobs to create for mailinglist
>>>>>>> 533d6cd2275689f50e963404306d190764601a43
"""

target(mlsetup: 'Sets up a new mailing list project') {

	def (pack,amount) = parseArgs()
	def packdir = pack.replace('.', '/')

	// TODO -- Convention needs is so that MailingList is replaced to defined convention to match user needs
	// convention is just taken as input so that input format does not change in the future

	def engine = new SimpleTemplateEngine()
<<<<<<< HEAD
	
	// Domains
	def mailingTemplate = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/domain/default.groovy")).make(mlbind)
	def mtFrom = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/domain/default.groovy")).make(mlFrom)
	def mtCat = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/domain/default.groovy")).make(mlCat)
	def mtAtt = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/domain/default.groovy")).make(mlAtt)
	def mtSched = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/domain/default.groovy")).make(mlSched)
	def mtSend = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/domain/default.groovy")).make(mlSend)
	def mtTemp = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/domain/default.groovy")).make(mlTemp)
	
	
	//Controllers
	def EmailController = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/controllers/MailingListEmailController.groovy")).make(controllerConf)
	def MailingListAttachmentsController = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/controllers/MailingListAttachmentsController.groovy")).make(controllerConf)
	def MailingListCategoriesController = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/controllers/MailingListCategoriesController.groovy")).make(controllerConf)
	def MailingListScheduleController = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/controllers/MailingListScheduleController.groovy")).make(controllerConf)
	def MailingListController = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/controllers/MailingListController.groovy")).make(controllerConf)
	def MailingListSendersController = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/controllers/MailingListSendersController.groovy")).make(controllerConf)
	def MailingListTemplatesController = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/controllers/MailingListTemplatesController.groovy")).make(controllerConf)
	def MailingListUploaderController = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/controllers/MailingListUploaderController.groovy")).make(controllerConf)
	
	//Services
	def EmailService = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/services/MailingListEmailService.groovy")).make(controllerConf)
	def qss = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/services/QuartzStatusService.groovy")).make(controllerConf)
	
	//taglib
	def mltaglib = engine.createTemplate(new FileReader("${mailinglistPluginDir}/src/templates/taglib/MailingListTagLib.groovy")).make(controllerConf)
	
	
	
	println "Lets go los los"
	
=======

//	println "Lets go los los"

>>>>>>> 533d6cd2275689f50e963404306d190764601a43
	StringBuilder cad = new StringBuilder()
	StringBuilder cad1 = new StringBuilder()
	// Create jobs
	if (amount) {
		String jobPath = "$basedir/grails-app/jobs/$pack"
		mkdir(dir: "$basedir/$jobPath")

		amount.times { int i ->
			String jobName="ScheduleEmail${i}Job"
			println "Creating job ${i} job Name: $jobPath/${jobName}.groovy"
			def cjob = [ pack: pack, classname:jobName ]
			def mtJob = createTemplate(engine, 'jobs/ScheduleEmailJob.groovy', cjob)
			new File(basedir, "$jobPath/${jobName}.groovy").write(mtJob.toString())
			println "Generating EmailCheckerService Schedule Pool $jobName"
			cad.append('\t\t\t\t\tif (i == ').append(i).append(') {\n')
			cad.append('\t\t\t\t\t\t').append(jobName).append('.schedule(scheduledDate, paramsMap)\n')

			cad.append('\t\t\t\t\t\tsb.append("').append(jobName).append('")\n')
			cad.append('\t\t\t\t\t\treturn\n')
			cad.append('\t\t\t\t\t}\n')

			cad1.append('\t\t\t\t\tif (i==').append(i).append(') {\n')
			cad1.append('\t\t\t\t\t\t').append(jobName).append('.schedule(scheduledDate, params)\n')
			cad1.append('\t\t\t\t\t\tsb.append("').append(jobName).append('")\n')
			cad1.append('\t\t\t\t\t\tbreak\n')
			cad1.append('\t\t\t\t\t}\n')
		}
	}

	File dir = new File(mailinglistPluginDir, "src/templates/views")
	dir.eachFileRecurse{ f -> if (f.isDirectory()) println "Creating views folder: $f.name"}
	copy(todir: new File(basedir, 'grails-app/views')) {
		fileset dir: dir
	}

	StringBuilder imf = new StringBuilder()
	imf.append('<%@ page import="').append(pack).append('.MailingListCategories" %>\n')
	imf.append('<%@ page import="').append(pack).append('.MailingListAttachments" %>\n')
	imf.append('<%@ page import="').append(pack).append('.MailingListSenders" %>\n')
	imf.append('<%@ page import="').append(pack).append('.MailingListTemplates" %>\n')
	imf.append('<%@ page import="').append(pack).append('.MailingList" %>\n')
	new File(basedir, "grails-app/views/mailingList/_mailingListImport.gsp").write(imf.toString())

	println "Creating domain classes within your project: grails-app/domain/$packdir"
	mkdir(dir:"${basedir}/grails-app/domain/$packdir")

	generateDomainClass 'MailingList', packdir, basedir, engine, pack, 'MailingListBase'
	generateDomainClass 'MailingListCategories', packdir, basedir, engine, pack, 'CategoryBase'
	generateDomainClass 'MailingListAttachments', packdir, basedir, engine, pack, 'AttachmentsBase'
	generateDomainClass 'MailingListFrom', packdir, basedir, engine, pack, 'FromBase'
	generateDomainClass 'MailingListSchedule', packdir, basedir, engine, pack, 'ScheduleBase'
	generateDomainClass 'MailingListTemplates', packdir, basedir, engine, pack, 'TemplatesBase'
	generateDomainClass 'MailingListSenders', packdir, basedir, engine, pack, 'SendersBase'

	println "Creating controllers within your project: grails-app/controllers/$packdir"
	mkdir(dir:"${basedir}/grails-app/controllers/$packdir")
	new File(mailinglistPluginDir, 'src/templates/controllers').eachFile { File f ->
		if (f.name.endsWith('.groovy')) {
			generateController f.name, packdir, basedir, engine, pack
		}
	}
	
<<<<<<< HEAD
	
	//CSS copy
	cssdir = new File("${mailinglistPluginDir}/src/templates/css")
	cssdir2 = new File("${basedir}/web-app/")
	FileUtils.copyDirectoryToDirectory(cssdir,cssdir2)
	
	//Images
	imgdir = new File("${mailinglistPluginDir}/src/templates/images")
	imgdir2 = new File("${basedir}/web-app/")
	FileUtils.copyDirectoryToDirectory(imgdir,imgdir2)
	
	mkdir(dir:"${basedir}/grails-app/domain/${packdir}")
	
	mkdir(dir:"${basedir}/grails-app/controllers/${packdir}")
	println "Creating domain classes within your project: grails-app/domain/${packdir}"
	new File(basedir, "grails-app/domain/${packdir}/MailingList.groovy").write(mailingTemplate.toString())
	new File(basedir, "grails-app/domain/${packdir}/MailingListCategories.groovy").write(mtCat.toString())
	new File(basedir, "grails-app/domain/${packdir}/MailingListAttachments.groovy").write(mtAtt.toString())
	new File(basedir, "grails-app/domain/${packdir}/MailingListFrom.groovy").write(mtFrom.toString())
	new File(basedir, "grails-app/domain/${packdir}/MailingListSchedule.groovy").write(mtSched.toString())
	new File(basedir, "grails-app/domain/${packdir}/MailingListTemplates.groovy").write(mtTemp.toString())
	new File(basedir, "grails-app/domain/${packdir}/MailingListSenders.groovy").write(mtSend.toString())
	
	println "Creating controllers within your project: grails-app/controllers/${packdir}"
	new File(basedir, "grails-app/controllers/${packdir}/MailingListEmailController.groovy").write(EmailController.toString())
	new File(basedir, "grails-app/controllers/${packdir}/MailingListAttachmentsController.groovy").write(MailingListAttachmentsController.toString())
	new File(basedir, "grails-app/controllers/${packdir}/MailingListCategoriesController.groovy").write(MailingListCategoriesController.toString())
	new File(basedir, "grails-app/controllers/${packdir}/MailingListController.groovy").write(MailingListController.toString())
	new File(basedir, "grails-app/controllers/${packdir}/MailingListScheduleController.groovy").write(MailingListScheduleController.toString())
	new File(basedir, "grails-app/controllers/${packdir}/MailingListSendersController.groovy").write(MailingListSendersController.toString())
	new File(basedir, "grails-app/controllers/${packdir}/MailingListTemplatesController.groovy").write(MailingListTemplatesController.toString())
	new File(basedir, "grails-app/controllers/${packdir}/MailingListUploaderController.groovy").write(MailingListUploaderController.toString())
	
	println "Creating Services within your project: grails-app/services/${packdir}"
	mkdir(dir:"${basedir}/grails-app/services/${packdir}")
	new File(basedir, "grails-app/services/${packdir}/MailingListEmailService.groovy").write(EmailService.toString())
	new File(basedir, "grails-app/services/${packdir}/QuartzEmailCheckerService.groovy").write(qecs.toString())
	new File(basedir, "grails-app/services/${packdir}/QuartzStatusService.groovy").write(qss.toString())

	
	println "Creating Services within your project: grails-app/taglib/${packdir}"
	mkdir(dir:"${basedir}/grails-app/taglib/${packdir}")
	new File(basedir, "grails-app/taglib/${packdir}/MailingListTagLib.groovy").write(mltaglib.toString())
	
	println """Completed to finalise add :
	compile (":csv:0.3.1", ":quartz:1.0.1" , ":quartz-monitor:0.3-RC3",
		":ckeditor:3.6.6.1.1" , ":tiny-mce:3.4.9" , ":joda-time:1.4",
		":jquery-date-time-picker:0.1.1" , ":export:1.5" , ":mail:1.0.4",  
		":jquery-ui:1.10.3"
		)
  To your BuildConfig.groovy and refresh dependencies. 
=======
	println "Creating Services within your project: grails-app/services/$packdir"
	mkdir(dir:"${basedir}/grails-app/services/$packdir")

	def serviceConf = [pack: pack, amount: amount]

	def EmailService = createTemplate(engine, 'services/EmailService.groovy', serviceConf)
	new File(basedir, "grails-app/services/$packdir/EmailService.groovy").write(EmailService.toString())

	def qss = createTemplate(engine, 'services/QuartzStatusService.groovy', serviceConf)
	new File(basedir, "grails-app/services/$packdir/QuartzStatusService.groovy").write(qss.toString())

	def checkerConf = [pack: pack, amount: amount, jobMapping: cad, queueMapping: cad1]
	def qecs = createTemplate(engine, 'services/QuartzEmailCheckerService.groovy', checkerConf)
	new File(basedir, "grails-app/services/$packdir/QuartzEmailCheckerService.groovy").write(qecs.toString())

	println """\
Finished generating classes.
>>>>>>> 533d6cd2275689f50e963404306d190764601a43

Config.groovy configurations updates required - please refer to documentation."""
	}
}

private parseArgs() {
	args = args ? args.split('\n') : []
	if (2 == args.size()) {
		println "Using package ${args[0]} to create custom classes"
		println "Using numeric ${args[1]} to create amount of jobs"
		return [args[0], args[1] as int]
	}
	usage()
}

private void usage() {
	println "Usage:\n${USAGE}"
	exit(1)
}

<<<<<<< HEAD
setDefaultTarget 'Mlsetup'
=======
private createTemplate(SimpleTemplateEngine engine, relativePath, binding) {
	engine.createTemplate(new FileReader("$mailinglistPluginDir/src/templates/$relativePath")).make(binding)
}

private void generateController(String name, packdir, basedir, engine, String pack) {
	def binding = [pack: pack]
	def template = createTemplate(engine, 'controllers/' + name, binding)
	new File(basedir, "grails-app/controllers/$packdir/$name").write(template.toString())
}

private void generateDomainClass(String className, packdir, basedir, engine, String pack, String baseClassName) {
	def binding = [pack: pack, classname: className, baseclassname: baseClassName]
	def template = createTemplate(engine, 'domain/default.groovy', binding)
	new File(basedir, "grails-app/domain/$packdir/${className}.groovy").write(template.toString())
}

setDefaultTarget 'mlsetup'
>>>>>>> 533d6cd2275689f50e963404306d190764601a43
