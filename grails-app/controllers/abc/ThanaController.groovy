package abc

import grails.converters.JSON
import grails.converters.XML

import abc.District
import abc.Thana

class ThanaController {

    def index() {
    
    }
    
    def store() {
        def districts = []
        def query = {
            if (params.sort){
                order(params.sort, params.dir)
            }
        }
        def criteria = District.createCriteria();
        params.limit = params.limit ? params.int('limit') : 10
        def list = criteria.list(query, max: params.limit, offset: params.start)
        
        list?.each{ d ->           
            def district = [id: d.id, nameEn:d.nameEn, nameBn:d.nameBn]
            districts << district
        }        
        
        def fields = []
        fields << [name:'id', mapping:'id', type:'int']
        fields << [name:'nameEn', mapping:'nameEn', type:'string']
        fields << [name:'nameBn', mapping:'nameBn', type:'string']
        
        def count = list.totalCount
        def metaData = [fields:fields, totalProperty:'num', root:'data']
        def jsonData = [metaData:metaData, num:count, data:districts]
        log.info "<<<<<Lang>>>>>> : ${params.lang}"
        render jsonData as JSON
    }
    
    def extmvc() {
        
    }
}
