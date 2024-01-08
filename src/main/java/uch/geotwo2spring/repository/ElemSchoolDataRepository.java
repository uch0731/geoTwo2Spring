package uch.geotwo2spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uch.geotwo2spring.entity.ElemSchoolData;

import java.util.List;

@Repository
public interface ElemSchoolDataRepository extends JpaRepository<ElemSchoolData, Long> {

    @Query(value = "SELECT e.* " +
            "FROM elemschooldata e, lard_adm_sect_sgg lass " +
            "WHERE lass.sgg_nm = :sggNm AND ST_Intersects(e.the_geom, lass.the_geom)", nativeQuery = true)
    List<ElemSchoolData> findIntersectingSchoolsBySggNm(@Param("sggNm") String sggNm);
}
