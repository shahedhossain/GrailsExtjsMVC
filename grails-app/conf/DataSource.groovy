dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "grailsapp"
    password = "grailsapp"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}
hibernate {
    connection.autoReconnect = true
    connection.useUnicode = true
    connection.characterEncoding = 'UTF-8'
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
    show_sql = true
    format_sql = true
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/grailsapp?autoReconnect=true&useUnicode=true&characterEncoding=utf-8"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/grailsapp?autoReconnect=true&useUnicode=true&characterEncoding=utf-8"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://localhost:3306/grailsapp?autoReconnect=true&useUnicode=true&characterEncoding=utf-8"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
