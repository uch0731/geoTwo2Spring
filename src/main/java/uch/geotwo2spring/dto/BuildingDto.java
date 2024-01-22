package uch.geotwo2spring.dto;

import lombok.Builder;
import lombok.Data;
import uch.geotwo2spring.entity.BuildingData;

@Data
@Builder
public class BuildingDto {
    private Long gid;
    private String buildingName;
    private Double groundFloorCount;
    private Double undergroundFloorCount;
    private String the_geom;

    public BuildingDto(Long gid, String buildingName, Double groundFloorCount, Double undergroundFloorCount, String the_geom) {
        this.gid = gid;
        this.buildingName = buildingName;
        this.groundFloorCount = groundFloorCount;
        this.undergroundFloorCount = undergroundFloorCount;
        this.the_geom = the_geom;
    }

    public static BuildingDto toDTO(BuildingData entity) {
        return BuildingDto.builder()
                .gid(entity.getGid())
                .buildingName(entity.getBuildingName())
                .groundFloorCount(entity.getGroundFloorCount())
                .undergroundFloorCount(entity.getUndergroundFloorCount())
                .the_geom(entity.getThe_geom().toString())
                .build();
    }
}
