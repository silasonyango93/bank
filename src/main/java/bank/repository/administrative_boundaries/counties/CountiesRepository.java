package bank.repository.administrative_boundaries.counties;

import bank.entity.administrative_boundaries.counties.CountiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountiesRepository extends JpaRepository<CountiesEntity, Long> {
}
