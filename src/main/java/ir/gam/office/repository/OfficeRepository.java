package ir.gam.office.repository;

import ir.gam.office.model.Office;
import ir.gam.office.model.OfficeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office,Long> {

}
