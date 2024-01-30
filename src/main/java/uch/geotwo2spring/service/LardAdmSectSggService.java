package uch.geotwo2spring.service;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uch.geotwo2spring.dto.LardAdmSectSggDto;
import uch.geotwo2spring.entity.LardAdmSectSgg;
import uch.geotwo2spring.repository.LardAdmSectSggRepository;

import java.util.ArrayList;
import java.util.HashMap;
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

    public HashMap<String, Double> getAreaByRegion(String sggNm) {
        List<Double> area = lardAdmSectSggRepository.findAreaByRegion(sggNm);
        HashMap<String, Double> areaMap = new HashMap<>();
        areaMap.put(sggNm, area.get(0));
        return areaMap;
    }

    public void saveLardAdmSectSggData (LardAdmSectSgg lardAdmSectSggData) {
        lardAdmSectSggRepository.save(lardAdmSectSggData);
    }

    public List<LardAdmSectSggDto> getRegionIntersects(double[] coordinates) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Point target = geometryFactory.createPoint(new Coordinate(coordinates[0], coordinates[1]));
        target.setSRID(4326);
        List<LardAdmSectSgg> regionList = lardAdmSectSggRepository.findRegionIntersects(target);
        return makeEntityListtoDtoList(regionList);
    }

    public List<LardAdmSectSggDto> getRegionIntersects(double[][][] coordinates) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate[] polygonCoordinates = new Coordinate[coordinates[0].length];

        for (int i = 0; i < coordinates[0].length; i++) {
            polygonCoordinates[i] = new Coordinate(coordinates[0][i][0], coordinates[0][i][1]);
        }

        LinearRing linearRing = geometryFactory.createLinearRing(polygonCoordinates);
        Polygon polygon = geometryFactory.createPolygon(linearRing);
        polygon.setSRID(4326);

        System.out.println(polygon);
        List<LardAdmSectSgg> regionList = lardAdmSectSggRepository.findRegionIntersects(polygon);
        return makeEntityListtoDtoList(regionList);
    }
}
