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
import uch.geotwo2spring.dto.LardAdmSectSggDto;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lard_adm_sect_sgg")
public class LardAdmSectSgg {

    @Id
    @Column(name = "gid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gid;

    @Column(name = "the_geom", columnDefinition = "geometry(MultiPolygon, 4326)")
    private Geometry the_geom;

    @Column(name = "adm_sect_c")
    private String admSectC;

    @Column(name = "sgg_nm")
    private String sggNm;

    @Column(name = "col_adm_se")
    private String colAdmSe;

    public static LardAdmSectSgg toEntity(LardAdmSectSggDto dto) throws ParseException {
        return LardAdmSectSgg.builder()
                .the_geom(new WKTReader().read(dto.getThe_geom()))
                .admSectC(dto.getAdmSectC())
                .sggNm(dto.getSggNm())
                .colAdmSe(dto.getColAdmSe())
                .build();
    }
}