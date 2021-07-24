package eco.shared.infra.service;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Donator;
import eco.shared.infra.dto.DonatorDTO;
import eco.shared.infra.dto.SolicitationDTO;
import javassist.NotFoundException;

@Service
public interface DonatorService {

	public DonatorDTO getUserByCpf(String document) throws NotFoundException;
	
	public DonatorDTO getUserByEmail(String email) throws NotFoundException;
	
	public Donator createUser(DonatorDTO donator);
	
	void removeUser(Long id) throws NotFoundException;	
	
	public void openSolicitation(SolicitationDTO requestDTO) throws Exception;

	
}
