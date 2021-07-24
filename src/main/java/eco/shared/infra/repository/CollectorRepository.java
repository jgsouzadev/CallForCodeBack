package eco.shared.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eco.shared.domain.models.Collector;

public interface CollectorRepository extends JpaRepository<Collector, Long>{

}
