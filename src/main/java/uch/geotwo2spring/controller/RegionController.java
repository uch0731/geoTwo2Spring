package uch.geotwo2spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uch.geotwo2spring.dto.LardAdmSectSggDto;
import uch.geotwo2spring.service.LardAdmSectSggService;

import java.util.HashMap;
import java.util.List;

@RestController
public class RegionController {

   LardAdmSectSggService lardAdmSectSggService;

   @Autowired
   public RegionController(LardAdmSectSggService lardAdmSectSggService) {
       this.lardAdmSectSggService = lardAdmSectSggService;
   }

    //지역 데이터를 모두 보여주는 메서드
    @GetMapping("/all/region")
    public List<LardAdmSectSggDto> showAllRegion() {
        return lardAdmSectSggService.showRegions();
    }

    //학교 데이터를 입력받아 학교가 속한 지역을 알려주는 메서드
    @GetMapping("/{schoolName}/region")
    public List<LardAdmSectSggDto> getRegionBySchool(@PathVariable String schoolName) {
        return lardAdmSectSggService.getRegionBySchool(schoolName);
    }

    //지역을 입력받아 지역의 크기 알려주는 메서드
    @GetMapping("/{region}/area")
    public HashMap<String, Double> getAreaByRegion(@PathVariable String region) {
        return lardAdmSectSggService.getAreaByRegion(region);
    }
}
