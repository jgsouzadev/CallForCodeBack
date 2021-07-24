package eco.shared.infra.service;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Collector;

@Service
public interface CollectorService {

	public Collector getCollectorById(Long id) throws Exception;
	
}
