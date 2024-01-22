package uch.geotwo2spring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import uch.geotwo2spring.dto.BuildingDto;



@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "building")
public class BuildingData {
    @Id
    @Column(name = "gid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    @Column(name = "buld_nm")
    private String buildingName;

    @Column(name = "gro_flo_co")
    private Double groundFloorCount;

    @Column(name = "und_flo_co")
    private Double undergroundFloorCount;

    @Column(name = "the_geom", columnDefinition = "geometry(MultiPolygon, 4326)")
    private Geometry the_geom;

    public static BuildingData toEntity(BuildingDto dto) throws ParseException {
        return BuildingData.builder()
                .buildingName(dto.getBuildingName())
                .groundFloorCount(dto.getGroundFloorCount())
                .undergroundFloorCount(dto.getUndergroundFloorCount())
                .the_geom(new WKTReader().read(dto.getThe_geom()))
                .build();
    }

}
