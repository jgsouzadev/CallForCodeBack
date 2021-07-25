package eco.shared.infra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eco.shared.domain.enums.EnumEstado;
import eco.shared.infra.dto.CollectorDTO;

@Service
public interface CollectorService {

	public CollectorDTO getCollectorById(Long id) throws Exception;
	
	public CollectorDTO getCollectorByDocument(String document) throws Exception;
	
	public CollectorDTO createNewCollector(CollectorDTO collector);
	
	public List<CollectorDTO> getCollectorsByRangeOfLatiLong(double latitude, double longitude, EnumEstado estado);
}
