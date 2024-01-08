package uch.geotwo2spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uch.geotwo2spring.entity.ElemSchoolData;
import uch.geotwo2spring.entity.LardAdmSectSgg;
import uch.geotwo2spring.repository.LardAdmSectSggRepository;

import java.util.List;

@Service

public class LardAdmSectSggService {

    LardAdmSectSggRepository lardAdmSectSggRepository;

    @Autowired
    public LardAdmSectSggService(LardAdmSectSggRepository lardAdmSectSggRepository) {
        this.lardAdmSectSggRepository = lardAdmSectSggRepository;
    }

    public List<LardAdmSectSgg> showRegions() {
        return lardAdmSectSggRepository.findAll();
    }

}
