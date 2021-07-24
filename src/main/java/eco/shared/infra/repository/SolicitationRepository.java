package eco.shared.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eco.shared.domain.models.Solicitation;

@Repository
public interface SolicitationRepository extends JpaRepository<Solicitation, Long>{

}
