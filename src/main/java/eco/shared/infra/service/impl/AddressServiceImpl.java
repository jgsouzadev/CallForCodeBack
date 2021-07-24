package eco.shared.infra.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Address;
import eco.shared.infra.dto.AddressDTO;
import eco.shared.infra.mapper.AddressMapper;
import eco.shared.infra.repository.AddressRepository;
import eco.shared.infra.service.AddressService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService{
	
	AddressRepository addressRepository;
	AddressMapper addressMapper;
	
	@Override
	public AddressDTO getAddressByCollectorId(Long id) {
		return addressMapper.map(addressRepository.getByCollectorId(id).get());
	}

	@Override
	public AddressDTO getAddressByCollectorDocument(String document) {
		return addressMapper.map(addressRepository.getByCollectorDocumento(document).get());
	}

	@Override
	@Transactional
	public Address saveAddress(AddressDTO address) {
		return addressRepository.save(addressMapper.map(address));
	}
}
