package $pack


class MailingListUploaderController  {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

     def index() {}

    def upload() {
		def output=""
		def file = request.getFile('file')
		def allLines = file?.inputStream?.toCsvReader()?.readAll()
		output +="upload a CSV - : Category name: "+params.catname+"<br/>"
		int i=0;
		
		def cid=MailingListCategories.findOrSaveWhere(name: params.catname)
		cid.addedby=session.user
		cid.save(flush:true)
		int rtype=0
		allLines.each { tokens ->
			i++
			if (i==1) {
				rtype=countSubstring(",",tokens.toString().trim())
				println "CSV Containing <"+rtype+"> commas: "
				if (rtype==1) {
					println "2 field CSV file"
				}else{
					println "8 field CSV file"
				}
			}
			if (i>1) {
				def title,fname,mname,sname,suffix,categories,email,display=''
				try {
					
				
					if (rtype==1) {
						if  (tokens[0]) {  title=tokens[0] }
						if  (tokens[1]) {fname=tokens[1]}
						output += "email: "+fname+" |  DisplayName:"+title
						if (!title) { title=''}
						if (!fname) { fname=''}
						//def MailingList=MailingListUploaderController.classLoader.loadClass('MailingListUploaderController').newInstance()
						def findlrh=MailingListCategories.findByEmailAddressAndCategories(email,cid)
						if (!findlrh) {
							def newEntry=new MailingList(title: '', firstName: '', middleName: '',lastName: '', suffix: '',
							emailAddress: fname,emailDisplayName:title,siteid: '', mlcategories:cid, addedby: session.user  )
							if (! newEntry.save(flush: true)) {
								output += "<div class=red>Error saving MailingList record</div> <br/> "
							} else {
								output +="<div class=green>New entry : "+fname+" added as record :"+newEntry.id+"</div><br/>"
							}
						}else{
							output +="<div class=red>Record "+fname+" already exists ! not adding again !</div><br/>"
						}
					}else{
					   if  (tokens[0]) {  title=tokens[0] }
					   if  (tokens[1]) {fname=tokens[1]}
					   
					   
					   if  (tokens[2]) {mname=tokens[2]}
					   if  (tokens[3]) {sname=tokens[3]}
					   if  (tokens[4]) {suffix=tokens[4]}
					   if  (tokens[5]) {categories=tokens[5]}
					   if  (tokens[6]) {email=tokens[6]}
					   if  (tokens[7]) {display=tokens[7]}

					
					output += "Title: "+title+" |  Fname:"+fname+" | Mname: "+mname+" | Sname: "+sname+" | Suffix: "+suffix+" | Categories: "+categories+" | Email: "+email+" | Display Email: "+display
					if  (!categories )  { categories='' }
					if (!title) { title=''}
					if (!fname) { fname=''}
					if (!sname) { sname='' }
					if (!mname) { mname=''}
					if (!suffix) { suffix=''}
					if (!email) { email='' }
					if (!display) { display=''}
					def findlrh=MailingList.where {
						title==title && firstName==fname && middleName==mname && lastName==sname && emailAddress==email && emailDisplayName==display				
					}
					if (!findlrh) {
						
						def newEntry=new MailingList(title: title, firstName: fname, middleName: mname,lastName: sname,
						suffix: suffix,emailAddress: email,emailDisplayName:display,mlcategories:cid, siteid: categories, addedby: session.user  )
						if (! newEntry.save(flush: true)) {
							output += "<div class=red>Error saving MailingList record</div> <br/> "
						} else {
							output +="<div class=green>New entry : "+title+" added as record :"+newEntry.id+"</div><br/>"
						}
					}else{
						output +="<div class=red>Record "+title+" already exists ! not adding again !</div><br/>"
					}
				}
			 } catch (ArrayIndexOutOfBoundsException e) { output += "issue here: "+e }
			}
		}
		[output:output]
    }	
	
	
	def export() { 
		def mcat=MailingListCategories.findById(params.id)
		def etype=params.etype
		if (!etype) { etype='2' }
		mcat.mailinglist.each { ml -> 
			def title=ml.title
			def firstName=ml.firstName
			def middleName=ml.middleName
			def lastName=ml.lastName
			def emailAddress=ml.emailAddress
			def emailDisplayName=ml.emailDisplayName
			def addedby=ml.addedby
			if (etype.equals('2')) {}
		}
		
	}
	public static int countSubstring(String subStr, String str){
		return (str.length() - str.replace(subStr, "").length()) / subStr.length()
	}
}
