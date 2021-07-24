package eco.shared.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eco.shared.domain.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
