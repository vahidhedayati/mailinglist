package $pack

class MailingListUploaderController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	def index() {}

	def upload() {
		StringBuilder output = new StringBuilder()
		output.append("upload a CSV - : Category name: ").append(params.catname).append("<br/>")

		def cid = MailingListCategories.findOrSaveWhere(name: params.catname)
		cid.addedby = session.user
		cid.save(flush:true)

		int rtype = 0
		int i = 0
		request.getFile('file')?.inputStream?.toCsvReader()?.readAll().each { tokens ->
			i++
			if (i == 1) {
				rtype = countSubstring(",", tokens.toString().trim())
				log.info "CSV Containing <\$rtype> commas: "
				if (rtype == 1) {
					log.info "2 field CSV file"
				}
				else {
					log.info "7 field CSV file"
				}
			}

			if (i > 1) {
				String title
				String fname
				String mname
				String sname
				String categories
				String email
				String display = ''
				try {
					if (rtype == 1) {
						if (tokens[0]) { title=tokens[0] }
						if (tokens[1]) { fname=tokens[1] }
						output.append("email: ").append(fname).append(" | DisplayName:").append(title)
						if (!title) { title=''}
						if (!fname) { fname=''}
						//def MailingList=MailingListUploaderController.classLoader.loadClass('MailingListUploaderController').newInstance()
						def findlrh=MailingList.findByEmailAddressAndCategories(email,cid)
						if (!findlrh) {
							def newEntry = new MailingList(title: '', firstName: '', middleName: '', lastName: '', emailAddress: fname,
							                               emailDisplayName: title, categories: cid, addedby: session.user)
							if (!newEntry.save(flush: true)) {
								output.append("<div class=red>Error saving MailingList record</div> <br/> ")
							}
							else {
								output.append("<div class=green>New entry : ").append(fname).append(" added as record :").append(newEntry.id).append("</div><br/>")
							}
						}
						else {
							output.append("<div class=red>Record ").append(fname).append(" already exists ! not adding again !</div><br/>")
						}
					}
					else {
						if (tokens[0]) { title=tokens[0] }
						if (tokens[1]) { fname=tokens[1] }
						if (tokens[2]) { mname=tokens[2] }
						if (tokens[3]) { sname=tokens[3] }
						if (tokens[4]) { categories=tokens[4] }
						if (tokens[5]) { email=tokens[5] }
						if (tokens[6]) { display=tokens[6] }

						output.append("Title: ").append(title)
						output.append(" | Fname:").append(fname)
						output.append(" | Mname: ").append(mname)
						output.append(" | Sname: ").append(sname)
						output.append(" | Categories: ").append(categories)
						output.append(" | Email: ").append(email)
						output.append(" | Display Email: ").append(display)
						if (!categories ) { categories='' }
						if (!title) { title = '' }
						if (!fname) { fname = '' }
						if (!sname) { sname = '' }
						if (!mname) { mname = '' }
						if (!email) { email = '' }
						if (!display) { display = '' }
						def findlrh = MailingList.where {
							title == title && firstName == fname && middleName == mname &&
							lastName == sname && emailAddress == email && emailDisplayName == display
						}
						if (!findlrh) {
							def newEntry = new MailingList(title: title, firstName: fname, middleName: mname, lastName: sname,
							                               emailAddress: email, emailDisplayName: display,
							                               categories: cid, addedby: session.user)
							if (!newEntry.save(flush: true)) {
								output.append("<div class=red>Error saving MailingList record</div> <br/> ")
							}
							else {
								output.append("<div class=green>New entry : ").append(title).append(" added as record :").append(newEntry.id).append("</div><br/>")
							}
						}
						else {
							output.append("<div class=red>Record ").append(title).append(" already exists ! not adding again !</div><br/>")
						}
					}
				}
				catch (ArrayIndexOutOfBoundsException e) {
					output.append("issue here: ").append(e)
				}
			}
		}

		[output:output.toString()]
	}

	def export() {
		MailingListCategories.get(params.id).mailinglist.each { ml ->
			def title = ml.title
			def firstName = ml.firstName
			def middleName = ml.middleName
			def lastName = ml.lastName
			def emailAddress = ml.emailAddress
			def emailDisplayName = ml.emailDisplayName
			def addedby = ml.addedby
		}
	}

	private int countSubstring(String subStr, String str) {
		return (str.length() - str.replace(subStr, "").length()) / subStr.length()
	}
}
