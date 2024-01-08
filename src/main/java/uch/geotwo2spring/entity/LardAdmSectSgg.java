package uch.geotwo2spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Geometry;

@Getter
@Setter
@Entity
@Table(name = "lard_adm_sect_sgg")
public class LardAdmSectSgg {

    @Id
    @Column(name = "gid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    @JsonIgnore
    @Column(name = "the_geom", columnDefinition = "geometry(MultiPolygon, 4326)")
    private Geometry geometry;

    @Column(name = "adm_sect_c")
    private String admSectC;

    @Column(name = "sgg_nm")
    private String sggNm;

    @Column(name = "col_adm_se")
    private String colAdmSe;

    // 생성자, Getter 및 Setter 메서드
}