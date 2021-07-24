package eco.shared.infra.service;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Solicitation;

@Service
public interface SolicitationService {

	public Solicitation save(Solicitation solicitation) throws Exception;
	
}
