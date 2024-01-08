package uch.geotwo2spring.dto;

import lombok.Builder;
import lombok.Data;
import uch.geotwo2spring.entity.ElemSchoolData;

@Data
@Builder
public class ElemSchoolDto {
    private Long gid;
    private String schoolName;
    private Double longitude;
    private Double latitude;
    private String the_geom;

    public ElemSchoolDto(Long gid, String schoolName, Double longitude, Double latitude, String the_geom) {
        this.gid = gid;
        this.schoolName = schoolName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.the_geom = the_geom;
    }

    public static ElemSchoolDto toDTO(ElemSchoolData entity) {
        return ElemSchoolDto.builder()
                .gid(entity.getGid())
                .schoolName(entity.getSchoolName())
                .longitude(entity.getLongitude())
                .latitude(entity.getLatitude())
                .the_geom(entity.getThe_geom().toString())
                .build();
    }
}
