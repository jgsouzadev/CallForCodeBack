package eco.shared.infra.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import eco.shared.domain.models.Address;
import eco.shared.infra.dto.AddressDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class AddressMapper {

	private ModelMapper modelMapper;
	
	public AddressDTO map(final Address Address) {
		return modelMapper.map(Address, AddressDTO.class);
	}
	
	public Address map(final AddressDTO Address) {
		return modelMapper.map(Address, Address.class);
	}
}
