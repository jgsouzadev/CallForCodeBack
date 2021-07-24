package eco.shared.infra.service;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Collector;
import eco.shared.infra.dto.CollectorDTO;

@Service
public interface CollectorService {

	public CollectorDTO getCollectorById(Long id) throws Exception;
	
	public CollectorDTO getCollectorByDocument(String document) throws Exception;
	
	public CollectorDTO createNewCollector(CollectorDTO collector);
	
}
