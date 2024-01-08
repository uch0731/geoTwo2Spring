package uch.geotwo2spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import uch.geotwo2spring.entity.ElemSchoolData;

@Repository
public interface ElemSchoolDataRepository extends JpaRepository<ElemSchoolData, Long> {
}
