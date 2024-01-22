package uch.geotwo2spring.service;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.LinearRing;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uch.geotwo2spring.dto.BuildingDto;
import uch.geotwo2spring.dto.ElemSchoolDto;
import uch.geotwo2spring.entity.BuildingData;
import uch.geotwo2spring.entity.ElemSchoolData;
import uch.geotwo2spring.repository.ElemSchoolDataRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElemSchoolDataService {
    ElemSchoolDataRepository elemSchoolDataRepository;
    @Autowired
    public ElemSchoolDataService(ElemSchoolDataRepository elemSchoolDataRepository) {
        this.elemSchoolDataRepository = elemSchoolDataRepository;
    }

    public List<ElemSchoolDto> makeEntityListtoDtoList(List<ElemSchoolData> elemSchoolDataArrayList) {
        List<ElemSchoolDto> elemSchoolDtoArrayList = new ArrayList<>();

        for (int i = 0; i < elemSchoolDataArrayList.size(); i++) {
            elemSchoolDtoArrayList.add(ElemSchoolDto.toDTO(elemSchoolDataArrayList.get(i)));
        }

        return elemSchoolDtoArrayList;
    }

    public List<ElemSchoolDto> showSchools() {
        List<ElemSchoolData> elemSchoolDataArrayList = elemSchoolDataRepository.findAll();

        return makeEntityListtoDtoList(elemSchoolDataArrayList);
    }

    public List<ElemSchoolDto> getElemSchoolsByRegion(String regionName) {
        List<ElemSchoolData> elemSchoolDataArrayList = elemSchoolDataRepository.findIntersectingSchoolsBySggNm(regionName);

        return makeEntityListtoDtoList(elemSchoolDataArrayList);
    }

    public boolean checkSchoolRegion(String schoolName, String regionName) {
        List<Boolean> check = elemSchoolDataRepository.checkSchoolRegion(schoolName, regionName);
        return check.get(0);
    }

    public void saveElemSchoolData(ElemSchoolData elemSchoolData) {
        elemSchoolDataRepository.save(elemSchoolData);
    }

    public List<ElemSchoolDto> getSchoolsIntersects(double[] coordinates) {
        double bufferDistance = 0.001;
        GeometryFactory geometryFactory = new GeometryFactory();
        Point target = geometryFactory.createPoint(new Coordinate(coordinates[0], coordinates[1]));
        Polygon buffer = (Polygon) target.buffer(bufferDistance);
        buffer.setSRID(4326);

        System.out.println(buffer);
        List<ElemSchoolData> schoolList = elemSchoolDataRepository.findSchoolInPolygon(buffer);
        return makeEntityListtoDtoList(schoolList);
    }

    public List<ElemSchoolDto> getSchoolsIntersects(double[][][] coordinates) {

        GeometryFactory geometryFactory = new GeometryFactory();

        // 폴리곤 생성
        Coordinate[] polygonCoordinates = new Coordinate[coordinates[0].length];
        for (int i = 0; i < coordinates[0].length; i++) {
            polygonCoordinates[i] = new Coordinate(coordinates[0][i][0], coordinates[0][i][1]);
        }
        LinearRing linearRing = geometryFactory.createLinearRing(polygonCoordinates);
        Polygon polygon = geometryFactory.createPolygon(linearRing);
        polygon.setSRID(4326);

        System.out.println(polygon);
        List<ElemSchoolData> schoolList = elemSchoolDataRepository.findSchoolInPolygon(polygon);
        return makeEntityListtoDtoList(schoolList);
    }
}
