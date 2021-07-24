package eco.shared.infra.service;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Address;
import eco.shared.infra.dto.AddressDTO;

@Service
public interface AddressService {

	public AddressDTO getAddressByCollectorId(Long id);
	
	public AddressDTO getAddressByCollectorDocument(String document);
	
	public Address saveAddress(AddressDTO address);
	
	
}
