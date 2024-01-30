package uch.geotwo2spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uch.geotwo2spring.entity.LardAdmSectSgg;

import java.util.List;

@Repository
public interface LardAdmSectSggRepository extends JpaRepository<LardAdmSectSgg, Long> {
    @Query(value = "SELECT lass.*" +
            "FROM elemschooldata e, lard_adm_sect_sgg lass " +
            "WHERE e.school_nm = :schoolName AND ST_Intersects(e.the_geom , lass.the_geom)", nativeQuery = true)
    List<LardAdmSectSgg> findIntersectingRegionsBySchoolName(@Param("schoolName")String schoolName);

    @Query(value = "select ST_Area(the_geom) area " +
            "from lard_adm_sect_sgg lass " +
            "where lass.sgg_nm = :sggNm", nativeQuery = true)
    List<Double> findAreaByRegion(@Param("sggNm")String sggNm);

}
