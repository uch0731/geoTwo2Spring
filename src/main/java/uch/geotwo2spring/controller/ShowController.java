package uch.geotwo2spring.controller;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import uch.geotwo2spring.dto.ElemSchoolDto;
import uch.geotwo2spring.dto.LardAdmSectSggDto;
import uch.geotwo2spring.entity.ElemSchoolData;
import uch.geotwo2spring.entity.LardAdmSectSgg;
import uch.geotwo2spring.service.ElemSchoolDataService;
import uch.geotwo2spring.service.LardAdmSectSggService;


import java.util.ArrayList;
import java.util.List;

@RestController
public class ShowController {
    private final ElemSchoolDataService elemSchoolDataService;
    private final LardAdmSectSggService lardAdmSectSggService;

    @Autowired
    public ShowController(ElemSchoolDataService elemSchoolDataService, LardAdmSectSggService lardAdmSectSggService) {
        this.elemSchoolDataService = elemSchoolDataService;
        this.lardAdmSectSggService = lardAdmSectSggService;
    }

    //초등학교 데이터를 모두 보여주는 메서드
    @GetMapping("/show/all/elemschool")
    public List<ElemSchoolDto> showAllElemSchool() {
        return elemSchoolDataService.showSchools();
    }

    //지역 데이터를 모두 보여주는 메서드
    @GetMapping("/show/all/region")
    public List<LardAdmSectSggDto> showAllRegion() {
        return lardAdmSectSggService.showRegions();
    }
}
