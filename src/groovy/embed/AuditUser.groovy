package embed

class AuditUser {
    
    Integer entryUser
    Date entryDate
    
    Date reviseDate
    Integer reviseUser
        
    static constraints = {        
        entryUser nullable: true
        entryDate nullable: true
        reviseUser nullable: true        
        reviseDate nullable: true        
    }
    
    static mapping = {
        entryUser column: 'F_REGISTER_USER', precision: 4, scale: 0
        entryDate column: 'F_REGISTER_DATE'
        reviseUser column: 'F_REVISION_USER', precision: 4, scale: 0
        reviseDate column: 'F_REVISION_DATE'
    }
    
}

