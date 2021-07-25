package eco.shared.infra.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import eco.shared.domain.enums.EnumEstado;
import eco.shared.domain.models.Collector;
import eco.shared.infra.dto.CollectorDTO;

@Repository
public interface CollectorRepository extends JpaRepository<Collector, Long>{

	Optional<Collector> findTop1ByDocumento(String document);	
	
	@Query("SELECT new eco.shared.infra.dto.CollectorDTO(cl.address.latitude, "
			+ " cl.address.longitude, cl.nomeEmpresa "
			+ ") FROM #{#entityName} cl WHERE cl.address.uf = :estado")
	List<CollectorDTO> getCollectorsWithLongLatByEstado(EnumEstado estado);
	
}
