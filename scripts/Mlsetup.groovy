import groovy.text.SimpleTemplateEngine

includeTargets << grailsScript("_GrailsArgParsing")

USAGE = """
    grails mlsetup org.example.com 5
    org.example.com = The package name to install malinglist classes to.
	5 = number of jobs to create for mailinglist
"""

overwriteAll = false
target(mlsetup: 'Sets up a new mailing list project') {

	def (pack,amount) = parseArgs()
	def packdir = pack.replace('.', '/')

	// TODO -- Convention needs is so that MailingList is replaced to defined convention to match user needs
	// convention is just taken as input so that input format does not change in the future

	def engine = new SimpleTemplateEngine()

//	println "Lets go los los"

	StringBuilder cad = new StringBuilder()
	StringBuilder cad1 = new StringBuilder()
	// Create jobs
	if (amount) {
		String jobPath = "grails-app/jobs/$pack"
		//mkdir(dir: "$basedir/$jobPath")
		localmkdir("$basedir/$jobPath")
		
		amount.times { int i ->
			String jobName="ScheduleEmail${i}Job"
			println "Creating job ${i} job Name: $jobPath/${jobName}.groovy"
			def cjob = [ pack: pack, classname:jobName ]
			def mtJob = createTemplate(engine, 'jobs/ScheduleEmailJob.groovy', cjob)
			
			//new File(basedir, "$jobPath/${jobName}.groovy").write(mtJob.toString())
			writeToFile("$jobPath/${jobName}.groovy", mtJob.toString())
			
			println "Generating EmailCheckerService Schedule Pool $jobName"
			cad.append('\t\t\t\t\tif (i == ').append(i).append(') {\n')
			cad.append('\t\t\t\t\t\t').append(jobName).append('.schedule(scheduledDate, paramsMap)\n')

			cad.append('\t\t\t\t\t\tsb.append("').append(jobName).append('")\n')
			cad.append('\t\t\t\t\t\tisStarted=true\n')
			cad.append('\t\t\t\t\t\treturn\n')
			cad.append('\t\t\t\t\t}\n')

			cad1.append('\t\t\t\t\tif (i==').append(i).append(') {\n')
			cad1.append('\t\t\t\t\t\t').append(jobName).append('.schedule(scheduledDate, params)\n')
			cad1.append('\t\t\t\t\t\tsb.append("').append(jobName).append('")\n')
			cad1.append('\t\t\t\t\t\tisStarted=true\n')
			cad1.append('\t\t\t\t\t\treturn\n')
			cad1.append('\t\t\t\t\t}\n')
		}
	}
	
	/*copy(file:"$mailinglistPluginDir/src/templates/js/bootstrap.min.js", 
			tofile: "$basedir/web-app/js/bootstrap.min.js", overwrite: false)*/
	
	File dir = new File(mailinglistPluginDir, "src/templates/views")
	dir.eachFileRecurse{ 
		f -> if (f.isDirectory()) {
			if (!okToWrite("${basedir}/grails-app/views/$f.name")) {
				return
			}	
			println "Creating views folder: $f.name"
			dir = new File(mailinglistPluginDir, "src/templates/views/$f.name")
			copy(todir: new File(basedir, 'grails-app/views/'+f.name)) {
				fileset dir: dir
			}
		} 
	 }
	
	
	
	/*
	File dir2 = new File(mailinglistPluginDir, "src/templates/images")
	dir2.eachFileRecurse{ 
		f -> if (f.isDirectory()) { 
			if (!okToWrite("${basedir}/web-app/images/$f.name")) {
				return
			}
			println "Creating css folder: $f.name"
			dir2 = new File(mailinglistPluginDir, "src/templates/images/$f.name")
			copy(todir: new File(basedir, 'web-app/images'+f.name)) {
				fileset dir: dir2
			}
		}		
	}
	*/
	
	
/*
	StringBuilder imf = new StringBuilder()
	imf.append('<%@ page import="').append(pack).append('.MailingListCategories" %>\n')
	imf.append('<%@ page import="').append(pack).append('.MailingListAttachments" %>\n')
	imf.append('<%@ page import="').append(pack).append('.MailingListSenders" %>\n')
	imf.append('<%@ page import="').append(pack).append('.MailingListTemplates" %>\n')
	imf.append('<%@ page import="').append(pack).append('.MailingList" %>\n')
	//new File(basedir, "grails-app/views/mailingList/_mailingListImport.gsp").write(imf.toString())
	writeToFile("grails-app/views/mailingList/_mailingListImport.gsp", imf.toString())*/

	
	println "Creating domain classes within your project: grails-app/domain/$packdir"
	//mkdir(dir:"${basedir}/grails-app/domain/$packdir")
	localmkdir("${basedir}/grails-app/domain/$packdir")
	
	generateDomainClass 'MailingList', packdir, basedir, engine, pack, 'MailingListBase'
	generateDomainClass 'MailingListCategories', packdir, basedir, engine, pack, 'CategoryBase'
	generateDomainClass 'MailingListAttachments', packdir, basedir, engine, pack, 'AttachmentsBase'
	//generateDomainClass 'MailingListFrom', packdir, basedir, engine, pack, 'FromBase'
	generateDomainClass 'MailingListSchedule', packdir, basedir, engine, pack, 'ScheduleBase'
	generateDomainClass 'MailingListTemplates', packdir, basedir, engine, pack, 'TemplatesBase'
	generateDomainClass 'MailingListSenders', packdir, basedir, engine, pack, 'SendersBase'
	
	
/*
	println "Creating controllers within your project: grails-app/controllers/$packdir"
	//mkdir(dir:"${basedir}/grails-app/controllers/$packdir")
	localmkdir("${basedir}/grails-app/controllers/$packdir")
	new File(mailinglistPluginDir, 'src/templates/controllers').eachFile { File f ->
		if (f.name.endsWith('.groovy')) {
			generateController f.name, packdir, basedir, engine, pack
		}
	}
	*/
	
	/*
	println "Creating Taglib within your project: grails-app/taglib/$packdir"
	
	//mkdir(dir:"${basedir}/grails-app/taglib/$packdir")
	localmkdir("${basedir}/grails-app/taglib/$packdir")
	*/

	
	
		
	println "Creating Services within your project: grails-app/services/$packdir"
	//mkdir(dir:"${basedir}/grails-app/services/$packdir")
	localmkdir("${basedir}/grails-app/services/$packdir")
	
	
	def checkerConf = [pack: pack, amount: amount, jobMapping: cad, queueMapping: cad1]
	def qecs = createTemplate(engine, 'services/QuartzEmailCheckerService.groovy', checkerConf)
	//new File(basedir, "grails-app/services/$packdir/QuartzEmailCheckerService.groovy").write(qecs.toString())
	writeToFile("grails-app/services/$packdir/QuartzEmailCheckerService.groovy",qecs.toString())

	println """\
Finished generating classes.

Config.groovy configurations updates required - please refer to documentation."""
	
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


okToWrite = { String dest ->
	def file = new File(dest)
	if (overwriteAll || !file.exists()) {
		return true
	}
	
	String propertyName = "file.overwrite.$file.name"
	ant.input(addProperty: propertyName, message: "$dest exists, ok to overwrite?",  validargs: 'y,n,a', defaultvalue: 'y')
	
	if (ant.antProject.properties."$propertyName" == 'n') {
		return false
	}
	
	if (ant.antProject.properties."$propertyName" == 'a') {
		overwriteAll = true
	}
	true
}	

localmkdir = { String dir ->
	if (!okToWrite(dir)) {
		return
	}
	def folders = new File(dir)
	folders.mkdirs()
}


writeToFile= { String file, String content ->
	if (!okToWrite(file)) {
		return
	}
	new File(basedir, "$file").write(content.toString())
}


	
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
