package uch.geotwo2spring.repository;

import org.locationtech.jts.geom.Polygon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uch.geotwo2spring.entity.BuildingData;

import java.util.List;

@Repository
public interface BuildingDataRepository extends JpaRepository<BuildingData, Long> {
    @Query(value = "SELECT * FROM building WHERE ST_Intersects(the_geom, :polygon)", nativeQuery = true)
    List<BuildingData> findBuildingInPolygon(@Param("polygon") Polygon polygon);
}
