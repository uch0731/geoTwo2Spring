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
import uch.geotwo2spring.dto.ElemSchoolDto;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "elemschooldata")

public class ElemSchoolData {

    @Id
    @Column(name = "gid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    @Column(name = "school_nm")
    private String school_nm;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "the_geom", columnDefinition = "geometry(Point, 4326)")
    private Geometry the_geom;

    public static ElemSchoolData toEntity(ElemSchoolDto dto) throws ParseException {
        return ElemSchoolData.builder()
                .gid(dto.getGid())
                .school_nm(dto.getSchoolName())
                .longitude(dto.getLongitude())
                .latitude(dto.getLatitude())
                .the_geom(new WKTReader().read(dto.getThe_geom()))
                .build();
    }
}