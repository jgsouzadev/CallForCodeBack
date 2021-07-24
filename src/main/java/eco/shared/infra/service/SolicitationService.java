package eco.shared.infra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import eco.shared.domain.enums.TipoStatus;
import eco.shared.domain.models.Solicitation;
import eco.shared.infra.dto.SolicitationDTO;
import javassist.NotFoundException;

@Service
public interface SolicitationService {

	public Solicitation save(Solicitation solicitation) throws Exception;
	
	public Boolean alterarStatusSolicitacao(SolicitationDTO solicitation, TipoStatus status) throws NotFoundException;
	
	public List<SolicitationDTO> buscarSolicitacaoPorEmpresa(Long collectorId);
	
	public List<SolicitationDTO> buscarSolicitacaoPorPessoaFisica(Long donatorId);
	
}
