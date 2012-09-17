package abc

import org.springframework.transaction.annotation.Transactional
import abc.Thana

@Transactional
class DistrictService {
    
    def saveThana() {
        def thana = new Thana(nameEn:'Dhaka', nameBn:'Dhaka')
        thana.save()
//        thana.save(failOnError:true)
        
        thana = Thana.get(1);
        log.info "name: ${thana.nameEn}"
    }
}
