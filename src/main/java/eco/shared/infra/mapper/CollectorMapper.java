package eco.shared.infra.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import eco.shared.domain.models.Collector;
import eco.shared.infra.dto.CollectorDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CollectorMapper {

	private ModelMapper modelMapper;
	
	public CollectorDTO map(final Collector collector) {
		return modelMapper.map(collector, CollectorDTO.class);
	}
	
	public Collector map(final CollectorDTO collector) {
		return modelMapper.map(collector, Collector.class);
	}
}
