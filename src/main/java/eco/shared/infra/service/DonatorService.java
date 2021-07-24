package eco.shared.infra.service;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Donator;
import eco.shared.infra.dto.DonatorDTO;
import eco.shared.infra.dto.SolicitationDTO;

@Service
public interface DonatorService {

	public Donator getUserByIdAndCpf(Long id, String document);
	
	public Donator createUser(DonatorDTO donator);
	
	public void removeUser(Long id, String document);
	
	public void openSolicitation(SolicitationDTO requestDTO) throws Exception;
	
}
