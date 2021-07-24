package eco.shared.infra.repository;

import java.util.Optional;

import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eco.shared.domain.models.Donator;

@Repository
public interface DonatorRepository extends JpaRepository<Donator, Long>{
	
	public Optional<Donator> findByCpf(String document);
	
	public Optional<Donator> findByEmail(String document);
	
}
