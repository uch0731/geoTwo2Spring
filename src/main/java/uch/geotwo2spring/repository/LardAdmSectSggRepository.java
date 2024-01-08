package uch.geotwo2spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uch.geotwo2spring.entity.LardAdmSectSgg;

@Repository
public interface LardAdmSectSggRepository extends JpaRepository<LardAdmSectSgg, Long> {

}
