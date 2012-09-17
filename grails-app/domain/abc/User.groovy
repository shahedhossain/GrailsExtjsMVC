package abc

class User {
    
    String name
    String email

    static constraints = {
        name blank: false, size: 5..30, unique: true
        email blank: true, size: 0..60, unique: false, nullable: true
    }
    
    static mapping = {
         table 'user'
        id column: 'F_ID', precision: 4, scale: 0
        name column: 'F_NAME', length: 30
        email column: 'F_EMAIL', length: 60
        version column: 'F_REVISION'
    }
}
