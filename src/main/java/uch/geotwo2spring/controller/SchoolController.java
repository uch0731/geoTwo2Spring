package uch.geotwo2spring.controller;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import uch.geotwo2spring.dto.BuildingDto;
import uch.geotwo2spring.dto.ElemSchoolDto;
import uch.geotwo2spring.dto.LardAdmSectSggDto;
import uch.geotwo2spring.entity.ElemSchoolData;
import uch.geotwo2spring.repository.ElemSchoolDataRepository;
import uch.geotwo2spring.service.ElemSchoolDataService;
import uch.geotwo2spring.service.LardAdmSectSggService;

import java.util.HashMap;
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
    @GetMapping("/{regionName}/school")
    public List<ElemSchoolDto> getElemSchoolsByRegion(@PathVariable String regionName) {
        return elemSchoolDataService.getElemSchoolsByRegion(regionName);
    }

    //학교 이름과 지역이름을 입력받아 학교가 위치한 곳이 해당 지역인지 알려주는 메서드
    @GetMapping("/{schoolName}/{regionName}/check")
    public boolean checkSchoolRegion(@PathVariable String schoolName, @PathVariable String regionName) {
        return elemSchoolDataService.checkSchoolRegion(schoolName, regionName);
    }

    //학교정보를 post로 입력받아 db에 저장
    @PostMapping("/save/elemschool")
    public void saveElemSchool(@RequestBody ElemSchoolDto elemSchoolDto) throws ParseException {
        elemSchoolDataService.saveElemSchoolData(ElemSchoolData.toEntity(elemSchoolDto));
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/map/point/schools")
    @ResponseBody
    public List<ElemSchoolDto> getSchoolsInPointBuffer(@RequestBody double[] point) {
        System.out.println(point[0] + " " + point[1]);
        List<ElemSchoolDto> result = elemSchoolDataService.getSchoolsIntersects(point);

        for(ElemSchoolDto elemSchoolDto : result) {
            System.out.println(elemSchoolDto.getGid() + " " + elemSchoolDto.getSchoolName());
        }

        return result;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/map/polygon/schools")
    @ResponseBody
    public List<ElemSchoolDto> getSchoolsInPolygon(@RequestBody double[][][] polygon) {
        for(double[][] d : polygon) {
            for (double[] dd : d) {
                System.out.println(dd[0] + " " + dd[1]);
            }
        }
        List<ElemSchoolDto> result = elemSchoolDataService.getSchoolsIntersects(polygon);
        for(ElemSchoolDto elemSchoolDto : result) {
            System.out.println(elemSchoolDto.getGid() + " " + elemSchoolDto.getSchoolName());
        }

        return result;
    }
}
