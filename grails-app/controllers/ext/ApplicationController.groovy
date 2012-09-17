package ext

class ApplicationController {

    def index() {
        response.setContentType('text/javascript')
        response.setCharacterEncoding('UTF-8')
        def appFolder = "${request.contextPath}/app"
        [appFolder:appFolder]
    }
    
}
