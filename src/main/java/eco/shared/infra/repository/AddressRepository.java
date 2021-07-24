package eco.shared.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eco.shared.domain.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
