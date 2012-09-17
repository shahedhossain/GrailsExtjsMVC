package abc

import grails.converters.JSON
import abc.User

class UserController {

    def index() {
    }
    
    def add = {
        def json = request.JSON
        def user = new User(json)
        user.save()
        def success = [success:true]
        render success as JSON
    }
    
    def edit = {
        def model = User.get(params.id)
        [model:model]
    } 
    
    def list = {        
        def users = []
        def query = {
            if (params.sort){
                order(params.sort, params.dir)
            }
        }

        def criteria = User.createCriteria()
        params.limit = params.limit ? params.int('limit') : 10
        def list = criteria.list(query, max: params.limit, offset: params.start)
        list?.each{ u ->           
            def user = [id: u.id, name:u.name, email:u.email]
            users << user
        }        
        
        def fields = []
        fields << [name:'id', mapping:'id', type:'int']
        fields << [name:'name', mapping:'name', type:'string']
        fields << [name:'email', mapping:'email', type:'string']
        
        def count = list.totalCount
        def metaData = [fields:fields, totalProperty:'num', root:'data']
        def jsonData = [metaData:metaData, num:count, data:users, success:true]
        render jsonData as JSON
    }
   
    def update = {
        def json = request.JSON
        def model = User.get(json.id)
        model.properties = json
        
        def success = [success:false]
        
        if( model.validate()) {
            model.save()
            success = [success:true]
        }
        render success as JSON         
    }
    
    def delete = {
        def json = request.JSON
        def model = User.get(json.id)
        model.delete()
        def success = [success:true]
        render success as JSON
    }
    
    def save = {
        def d = new User(params) 
        d.save()
    }
}
