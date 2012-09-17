package abc

import embed.AuditUser

class District {

    String nameEn
    String nameBn
    
    AuditUser audit = new AuditUser()
    static embedded = ['audit']    
    
    static constraints = {
        nameEn blank: false, size: 5..30, unique: true
        nameEn blank: true, size: 0..60, unique: false, nullable: true
    }
    
    static mapping = {
        table 't01i001'
        id column: 'F_ID', precision: 4, scale: 0
        nameEn column: 'F_NAME_EN', length: 30
        nameBn column: 'F_NAME_BN', length: 60
        version column: 'F_REVISION'
    }
       
    def authUserService
    int insertIndex = 0
    int updateIndex = 0
    static transients = ['authUserService', 'insertIndex', 'updateIndex']    
       
    def beforeInsert = {
        audit.entryUser = authUserService.user()
        audit.entryDate = new Date();
    }
    
    def beforeUpdate = {
        audit.reviseUser = authUserService.user()
        audit.reviseDate = new Date();
    }
   
    def afterInsert = {
        if(insertIndex == 0){
            def user = audit.entryUser
            def date = audit.entryDate
            log.info "POST INSERT => ENTERER: ${user} ENTERED: ${date}"
        }
        insertIndex++
    }
    
    def afterUpdate = {
        if(updateIndex == 0){
            def user = audit.reviseUser
            def date = audit.reviseDate
            log.info "POST UPDATE => REVISE: ${user} REVISED: ${date}"
        }
        updateIndex++
    }
    
}
