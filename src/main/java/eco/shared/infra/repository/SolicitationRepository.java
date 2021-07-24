package eco.shared.infra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import eco.shared.domain.models.Solicitation;

@Repository
public interface SolicitationRepository extends JpaRepository<Solicitation, Long>{

	
	@Query("SELECT sol FROM #{#entityName} sol WHERE sol.coletor.id = :collectorId")
	List<Solicitation> getListaPorEmpresa(Long collectorId);
	

	@Query("SELECT sol FROM #{#entityName} sol WHERE sol.donator.id = :doadorId")
	List<Solicitation> getListaPorDoador(Long doadorId);
}
