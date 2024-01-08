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

    @GetMapping("/show/all/elemschool")
    public List<ElemSchoolData> showAllElemSchool() {
        System.out.println(elemSchoolDataService.showSchools().get(0).getThe_geom().toString());
        return elemSchoolDataService.showSchools();
    }

    @GetMapping("/show/all/region")
    public List<LardAdmSectSgg> showAllRegion() {
        return lardAdmSectSggService.showRegions();
    }

    @GetMapping("/show/1/elemschool")
    public String showElemSchool() throws ParseException {
        String a  = "POINT (127.027339 37.497942)";
        Geometry g = new GeometryFactory().createPoint(new Coordinate(127.027339, 37.497942));
        Geometry g2 = new WKTReader().read(a);

        System.out.println(a);
        System.out.println(g);
        System.out.println(g.toString());
        System.out.println(g2);
        System.out.println(g2.toString());

        return elemSchoolDataService.showSchools().get(0).getThe_geom().toString();
    }

    @GetMapping("hello")
    public List<String> showHello() {
        System.out.println("Hello");
        ArrayList<String> hello = new ArrayList<>();
        hello.add("Hello");
        return hello;
    }
}
