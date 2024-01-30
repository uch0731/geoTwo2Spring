package uch.geotwo2spring.controller;

import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import uch.geotwo2spring.dto.LardAdmSectSggDto;
import uch.geotwo2spring.entity.LardAdmSectSgg;
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
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/{schoolName}/region")
    @ResponseBody
    public List<LardAdmSectSggDto> getRegionBySchool(@PathVariable String schoolName) {
        System.out.println("컨트롤러" + lardAdmSectSggService.getRegionBySchool(schoolName));
        return lardAdmSectSggService.getRegionBySchool(schoolName);
    }

    //지역을 입력받아 지역의 크기 알려주는 메서드
    @GetMapping("/{region}/area")
    public HashMap<String, Double> getAreaByRegion(@PathVariable String region) {
        return lardAdmSectSggService.getAreaByRegion(region);
    }

    //지역정보를 post로 입력받아 db에 저장
    @PostMapping("/save/region")
    public void saveElemSchool(@RequestBody LardAdmSectSggDto lardAdmSectSggDto) throws ParseException {
        System.out.println(lardAdmSectSggDto.toString());
        lardAdmSectSggService.saveLardAdmSectSggData(LardAdmSectSgg.toEntity(lardAdmSectSggDto));
    }
}
