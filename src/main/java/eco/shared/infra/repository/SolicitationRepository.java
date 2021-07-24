package eco.shared.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eco.shared.domain.models.Solicitation;

public interface SolicitationRepository extends JpaRepository<Solicitation, Long>{

}
