package abc
import abc.FormativeService

class FormativeJob {
       
    static tiggers = {
        cron name: 'FormativeCron', cronExpression: "0 0/5  * * * ?", timeZone: TimeZone.getTimeZone("BST")
    }
    
    def formativeService
    
    def execute() {
        formativeService.executeJob()        
    }
	
}


