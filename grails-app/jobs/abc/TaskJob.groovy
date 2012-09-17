package abc

class TaskJob {
    static triggers = {
      simple repeatInterval: 5000l
    }

    def execute() {
        log.info "Task simple"
    }
}
