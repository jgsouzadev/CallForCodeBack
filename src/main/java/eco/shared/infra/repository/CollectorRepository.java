package eco.shared.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eco.shared.domain.models.Collector;

@Repository
public interface CollectorRepository extends JpaRepository<Collector, Long>{

	@EntityGraph(value = "address", type = EntityGraph.EntityGraphType.FETCH)
	Optional<Collector> findByDocumento(String document);
	
}
