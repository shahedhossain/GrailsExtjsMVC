class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
                        lang = 'en'
		}
                        
                name lang:"/$lang/$controller/$action?/$id?" {
                        constraints {
                            lang(matches:/en|bn/)
                        }               
                }
                
                name app:"/app" (controller:'application', action:'index'){
                        format = 'js'
                }

                name extjs:"/app/$controller/$action" {
                        format = 'js'
                        constraints {
                            controller(matches:/controller|model|store/)
                        }
                }
                                
                name view:"/app/view/$action/$operation" (controller:'view'){
                        format = 'js'
                }
                
                name viewport:"/app/view/Viewport" (controller:'view', action:'viewport'){
                        format = 'js'
                }
                
                name news:"/news/$year?/$month?/$day?/$id?" (controller:'news', action:'show') {
                        constraints {
                            year(matches:/\d{4}/)
                            month(matches:/[1-9]{1}|[1]{1}[0-2]{1}/)
                            day(matches:/[1-9]{1}|[12]{1}[0-9]{1}|[3]{1}[01]{1}/)
                        }
                }

        
//                 "/"(controller:'home',action:'index') 

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
