package uch.geotwo2spring.dto;

import lombok.Builder;
import lombok.Data;
import uch.geotwo2spring.entity.LardAdmSectSgg;

@Data
@Builder
public class LardAdmSectSggDto {
    private Long gid;
    private String admSectC;
    private String sggNm;
    private String colAdmSe;
    private String the_geom;

    public LardAdmSectSggDto(Long gid, String admSectC, String sggNm, String colAdmSe, String the_geom) {
        this.gid = gid;
        this.admSectC = admSectC;
        this.sggNm = sggNm;
        this.colAdmSe = colAdmSe;
        this.the_geom = the_geom;
    }

    public static LardAdmSectSggDto toDTO(LardAdmSectSgg entity) {
        return LardAdmSectSggDto.builder()
                .gid(entity.getGid())
                .admSectC(entity.getAdmSectC())
                .sggNm(entity.getSggNm())
                .colAdmSe(entity.getColAdmSe())
                .the_geom(entity.getThe_geom().toString())
                .build();
    }

}
