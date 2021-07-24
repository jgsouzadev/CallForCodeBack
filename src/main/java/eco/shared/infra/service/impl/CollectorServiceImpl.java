package eco.shared.infra.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Collector;
import eco.shared.infra.repository.CollectorRepository;
import eco.shared.infra.service.CollectorService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CollectorServiceImpl implements CollectorService{
	
	CollectorRepository collectorRepository;

	@Override
	public Collector getCollectorById(Long id) throws NotFoundException{
		Optional<Collector> collector = collectorRepository.findById(id);
		if(collector.isPresent()) 
			return collector.get();
		
		throw new NotFoundException("Collector não encontrado");
	}
	
}
