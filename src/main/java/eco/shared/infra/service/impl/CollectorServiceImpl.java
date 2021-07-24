package eco.shared.infra.service.impl;

import eco.shared.domain.models.Donator;
import eco.shared.infra.repository.CollectorRepository;
import eco.shared.infra.service.CollectorService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CollectorServiceImpl implements CollectorService{
	
	CollectorRepository collectorRepository;
	
}
