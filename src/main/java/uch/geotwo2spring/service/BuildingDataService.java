package uch.geotwo2spring.service;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.Polygon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uch.geotwo2spring.dto.BuildingDto;
import uch.geotwo2spring.entity.BuildingData;
import uch.geotwo2spring.repository.BuildingDataRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuildingDataService {
    BuildingDataRepository buildingDataRepository;

    @Autowired
    public BuildingDataService(BuildingDataRepository buildingDataRepository) {
        this.buildingDataRepository = buildingDataRepository;
    }
    public List<BuildingDto> makeEntityListtoDtoList(List<BuildingData> buildingDataArrayList) {
        List<BuildingDto> buildingDtoArrayList = new ArrayList<>();

        for (int i = 0; i < buildingDataArrayList.size(); i++) {
            buildingDtoArrayList.add(BuildingDto.toDTO(buildingDataArrayList.get(i)));
        }

        return buildingDtoArrayList;
    }
    public List<BuildingDto> getBuildingIntersects(double[] point) {
        double bufferDistance = 0.001;
        GeometryFactory geometryFactory = new GeometryFactory();
        Point target = geometryFactory.createPoint(new Coordinate(point[0], point[1]));
        Polygon buffer = (Polygon) target.buffer(bufferDistance);
        buffer.setSRID(4326);

        System.out.println(buffer);
        List<BuildingData> buildingList = buildingDataRepository.findBuildingInPolygon(buffer);
        return makeEntityListtoDtoList(buildingList);
    }
}
