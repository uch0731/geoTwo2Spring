package uch.geotwo2spring.controller;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.locationtech.jts.io.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import uch.geotwo2spring.dto.BuildingDto;
import uch.geotwo2spring.service.BuildingDataService;

import java.util.List;

@Controller
public class BuildingController {
    BuildingDataService buildingDataService;

    @Autowired
    public BuildingController(BuildingDataService buildingDataService) {
        this.buildingDataService = buildingDataService;
    }

    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @PostMapping("/map/point/buildings")
    @ResponseBody
    public List<BuildingDto> getBuildingInPointBuffer(@RequestBody double[] point) {
        System.out.println(point[0] + " " + point[1]);
        List<BuildingDto> result = buildingDataService.getBuildingIntersects(point);

        for(BuildingDto buildingDto : result) {
            System.out.println(buildingDto.getGid() + " " + buildingDto.getBuildingName());
        }

        return result;
    }
}
