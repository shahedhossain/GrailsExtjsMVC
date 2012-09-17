package abc

class TaskReminderJob {
    
    static tiggers = {
        cron name: 'RDPCron', cronExpression: "0 0/1 * * * ?", timeZone: TimeZone.getTimeZone("BST")
    }    

    def execute() {
        log.info "RDP Cron"
    }
}
