package eco.shared.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eco.shared.domain.models.Donator;

@Repository
public interface DonatorRepository extends JpaRepository<Donator, Long>{
	
	public Donator findByIdAndCpf(Long id, String document);
	
}
