package abc

import grails.converters.JSON
import grails.converters.XML

import abc.District
import abc.Thana

class DistrictController {

    def districtService
    def reportService
    
    def index = {
        def dis = District.get(1);
        def auth = dis.audit
        districtService.saveThana()        
        render "EU : ${auth.entryUser} ED: ${auth.entryDate}"
    }
    
    def path = {
        //ServletContextHolder.servletContext.getRealPath("/")
        def xpath = servletContext.getRealPath("/")
        render "Path :${xpath}"
    }
    
    def pdf = {
        def bytes = reportService.pdf()
//        response.contentType = 'application/pdf'
//        response.setHeader('Content-disposition', 'attachment; filename=District.pdf')
        response.outputStream << bytes
    }
    
    def extjs = {
        
    }
    
    def combo = {
        
    }
    
    def grid = {
        
    }
    
    def xgrid = {
        
    }
    
    def mform = {
        
    }
    
    def radio = {
        
    }
    
    def form = {
        
    }
    
    def xform = {
        
    }
    
    def save = {
        log.info "EN :${params.nameEn} BN :${params.nameBn}"
        def dis = new District(nameEn:params.nameEn,nameBn:params.nameBn)
        dis.audit.entryUser = 1
        dis.audit.entryDate = new Date()
        dis.save()
//        District.withSession{ session ->
//            session.save(dis)
//        }
        def success = [success:true]
        render success as JSON
    }
    
    def comp = {
        def fields = []
        fields << [xtype:'textfield', title: 'label1', name: 'textfield1']
        fields << [xtype:'textfield', title: 'label2', name: 'textfield2']
        fields << [xtype:'textfield', title: 'label2', name: 'textfield2']
        
        def jsonData = [success:true, data:fields]
        log.info "comp requested"
        render jsonData as JSON
    }
        
    def store = {
        def districts = []
        District.getAll()?.each{ d ->           
            def district = [id: d.id, nameEn:d.nameEn, nameBn:d.nameBn]
            districts << district
        }        
        
        def fields = []
        fields << [name:'id', mapping:'id', type:'int']
        fields << [name:'nameEn', mapping:'nameEn', type:'string']
        fields << [name:'nameBn', mapping:'nameBn', type:'string']
        
        def count = District.count()
        def metaData = [fields:fields, totalProperty:'num', root:'data']
        def jsonData = [metaData:metaData, num:count, data:districts]
        render jsonData as JSON
    }
    
    def mstore = {
        def districts = []
        District.getAll()?.each{ d ->           
            def district = [id: d.id, nameEn:d.nameEn, nameBn:d.nameBn]
            districts << district
        }

        def thanas = []
        Thana.getAll()?.each{ t ->           
            def thana = [id: t.id, nameEn:t.nameEn, nameBn:t.nameBn]
            thanas << thana
        }        
        
        def jsonData = [districts:districts, thanas:thanas]
        render jsonData as JSON
    }
    
    def data = {
        def districts = []
        District.getAll()?.each{ d ->           
            def thanas = []
            Thana.getAll()?.each{ t ->
                def thana = [id: t.id, nameEn: t.nameEn, nameBn: t.nameBn]
                thanas << thana
            }
            def district = [id: d.id, nameEn: d.nameEn, nameBn: d.nameBn, thanas: thanas]
            districts << district
        }        
        def result = [districts: districts]            
        render result as JSON
    }
    
    def xml = {
        render(contentType: 'text/xml') {           
            districts(){               
                District.getAll()?.each{ d ->
                    district(id: d.id, nameEn: d.nameEn, nameBn: d.nameBn){
                        Thana.getAll()?.each { t ->
                            thana(id:t.id, nameEn: t.nameEn, nameBn: t.nameBn)
                        }
                    }
                }          
            }        
        }
    }
}
