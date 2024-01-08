package uch.geotwo2spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import uch.geotwo2spring.dto.ElemSchoolDto;
import uch.geotwo2spring.dto.LardAdmSectSggDto;
import uch.geotwo2spring.service.ElemSchoolDataService;
import uch.geotwo2spring.service.LardAdmSectSggService;

import java.util.List;

@RestController
public class SchoolController {
    private final ElemSchoolDataService elemSchoolDataService;

    @Autowired
    public SchoolController(ElemSchoolDataService elemSchoolDataService) {
        this.elemSchoolDataService = elemSchoolDataService;
    }

    //초등학교 데이터를 모두 보여주는 메서드
    @GetMapping("/all/elemschool")
    public List<ElemSchoolDto> showAllElemSchool() {
        return elemSchoolDataService.showSchools();
    }

    //지역 이름을 입력받아 해당 지역의 초등학교 데이터를 보여주는 메서드
    @GetMapping("/{regionName}/schools")
    public List<ElemSchoolDto> getElemSchoolsByRegion(@PathVariable String regionName) {
        return elemSchoolDataService.getElemSchoolsByRegion(regionName);
    }
}
