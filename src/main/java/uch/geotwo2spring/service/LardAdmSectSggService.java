package uch.geotwo2spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uch.geotwo2spring.dto.ElemSchoolDto;
import uch.geotwo2spring.dto.LardAdmSectSggDto;
import uch.geotwo2spring.entity.ElemSchoolData;
import uch.geotwo2spring.entity.LardAdmSectSgg;
import uch.geotwo2spring.repository.LardAdmSectSggRepository;

import java.util.ArrayList;
import java.util.List;

@Service

public class LardAdmSectSggService {

    LardAdmSectSggRepository lardAdmSectSggRepository;

    @Autowired
    public LardAdmSectSggService(LardAdmSectSggRepository lardAdmSectSggRepository) {
        this.lardAdmSectSggRepository = lardAdmSectSggRepository;
    }

    public List<LardAdmSectSggDto> makeEntityListtoDtoList(List<LardAdmSectSgg> LardAdmSectSggArrayList) {
        List<LardAdmSectSggDto> lardAdmSectSggDtoArrayList = new ArrayList<>();

        for (int i = 0; i < LardAdmSectSggArrayList.size(); i++) {
            lardAdmSectSggDtoArrayList.add(LardAdmSectSggDto.toDTO(LardAdmSectSggArrayList.get(i)));
        }

        return lardAdmSectSggDtoArrayList;
    }

    public List<LardAdmSectSggDto> showRegions() {
        List<LardAdmSectSgg> lardAdmSectSggArrayList = lardAdmSectSggRepository.findAll();

        return makeEntityListtoDtoList(lardAdmSectSggArrayList);
    }

    public List<LardAdmSectSggDto> getRegionBySchool(String schoolName) {
        List<LardAdmSectSgg> lardAdmSectSggArrayList = lardAdmSectSggRepository.findIntersectingRegionsBySchoolName(schoolName);

        return makeEntityListtoDtoList(lardAdmSectSggArrayList);
    }
}
