package abc

import org.codehaus.groovy.grails.plugins.jasper.JasperExportFormat
import org.codehaus.groovy.grails.plugins.jasper.JasperReportDef

class ReportService {

    def jasperService
    def pdf() {
        def reportDef = new JasperReportDef(name:'R01I001001.jasper', fileFormat:JasperExportFormat.PDF_FORMAT)
        def bytes = jasperService.generateReport(reportDef).toByteArray()
        return bytes
    }
}
