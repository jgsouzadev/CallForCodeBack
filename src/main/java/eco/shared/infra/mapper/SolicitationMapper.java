package eco.shared.infra.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import eco.shared.domain.models.Solicitation;
import eco.shared.infra.dto.SolicitationDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SolicitationMapper {

	private ModelMapper modelMapper;
	
	public SolicitationDTO map(final Solicitation solicitation) {
		return modelMapper.map(solicitation, SolicitationDTO.class);
	}
	
	public Solicitation map(final SolicitationDTO solicitation) {
		return modelMapper.map(solicitation, Solicitation.class);
	}
}
