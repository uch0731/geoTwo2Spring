package uch.geotwo2spring.dto;

import lombok.Builder;
import lombok.Data;
import uch.geotwo2spring.entity.ElemSchoolData;
import uch.geotwo2spring.entity.LardAdmSectSgg;

@Data
@Builder
public class LardAdmSectSggDto {
    private Long gid;
    private String the_geom;
    private String admSectC;
    private String sggNm;
    private String colAdmSe;

    public LardAdmSectSggDto(Long gid, String the_geom, String admSectC, String sggNm, String colAdmSe) {
        this.gid = gid;
        this.the_geom = the_geom;
        this.admSectC = admSectC;
        this.sggNm = sggNm;
        this.colAdmSe = colAdmSe;
    }

    public static LardAdmSectSggDto toDTO(LardAdmSectSgg entity) {
        return LardAdmSectSggDto.builder()
                .gid(entity.getGid())
                .the_geom(entity.getThe_geom().toString())
                .admSectC(entity.getAdmSectC())
                .sggNm(entity.getSggNm())
                .colAdmSe(entity.getColAdmSe())
                .build();
    }
}
