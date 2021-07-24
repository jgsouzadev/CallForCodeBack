package eco.shared.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import eco.shared.domain.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{


	@Query("SELECT ad FROM #{#entityName} ad WHERE ad.coletor.id = :id")
	Optional<Address> getByCollectorId(Long id);
	
	@Query("SELECT ad FROM #{#entityName} ad WHERE ad.coletor.documento = :documento")
	Optional<Address> getByCollectorDocumento(String documento);
	

}
