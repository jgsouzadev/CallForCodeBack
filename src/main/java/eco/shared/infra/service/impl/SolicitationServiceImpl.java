package eco.shared.infra.service.impl;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Solicitation;
import eco.shared.infra.repository.SolicitationRepository;
import eco.shared.infra.service.SolicitationService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitationServiceImpl implements SolicitationService{
	
	SolicitationRepository solicitationRepository;

	@Override
	public Solicitation save(Solicitation solicitation) throws Exception {
		return solicitationRepository.save(solicitation);
	}

	
	
}
