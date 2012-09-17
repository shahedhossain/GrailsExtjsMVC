package ext

class ViewController {

    def user() {
        response.setContentType('text/javascript')
        response.setCharacterEncoding('UTF-8')
        def extview = "${params.operation}.${params.format}"
        extview = "${params.action}/${extview}"
        [extview:extview.toLowerCase()]
    }
    
    def viewport() {
        response.setContentType('text/javascript')
        response.setCharacterEncoding('UTF-8')
    }
}
