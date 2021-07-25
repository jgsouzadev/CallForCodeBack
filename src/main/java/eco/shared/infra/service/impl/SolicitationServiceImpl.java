package eco.shared.infra.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import eco.shared.domain.enums.TipoStatus;
import eco.shared.domain.models.Solicitation;
import eco.shared.infra.dto.SolicitationDTO;
import eco.shared.infra.mapper.SolicitationMapper;
import eco.shared.infra.repository.SolicitationRepository;
import eco.shared.infra.service.SolicitationService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitationServiceImpl implements SolicitationService{
	
	private final SolicitationRepository solicitationRepository;
	private final SolicitationMapper mapper;

	@Override
	@Transactional
	public Solicitation save(Solicitation solicitation) throws Exception {
		return solicitationRepository.save(solicitation);
	}

	@Override
	@Transactional
	public Boolean alterarStatusSolicitacao(SolicitationDTO solicitation, TipoStatus status) throws NotFoundException {
		Optional<Solicitation> soli = solicitationRepository.findById(solicitation.getIdSolicitacao());
		if(soli.isEmpty())
			throw new NotFoundException("Pedido não encontrado");
		
		soli.get().setStatus(status);
		try {
			solicitationRepository.save(soli.get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public List<SolicitationDTO> buscarSolicitacaoPorEmpresa(Long collectorId) {
		List<SolicitationDTO> listagem = solicitationRepository.getListaPorEmpresa(collectorId)
				.stream().map(sol -> 
					mapper.map(sol) 
					).collect(Collectors.toList());
		
		return listagem.isEmpty() ? new ArrayList<SolicitationDTO>() : listagem; 
	}

	@Override
	@Transactional
	public List<SolicitationDTO> buscarSolicitacaoPorPessoaFisica(Long donatorId) {
		List<SolicitationDTO> listagem = solicitationRepository.getListaPorDoador(donatorId)
				.stream().map(sol -> 
					mapper.map(sol) 
					).collect(Collectors.toList());
		
		return listagem.isEmpty() ? new ArrayList<SolicitationDTO>() : listagem; 
	}

	
	
	
}
