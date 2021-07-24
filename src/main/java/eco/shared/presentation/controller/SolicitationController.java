package eco.shared.presentation.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eco.shared.domain.enums.TipoStatus;
import eco.shared.infra.dto.SolicitationDTO;
import eco.shared.infra.service.SolicitationService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/solicitations")
@AllArgsConstructor
public class SolicitationController {

	private SolicitationService solicitationService;
	
	@PutMapping
	public ResponseEntity<Boolean> alterarStatus(TipoStatus status, SolicitationDTO solicitation) throws NotFoundException {
		return ResponseEntity.ok(solicitationService.alterarStatusSolicitacao(solicitation, status));
	}
	
	@GetMapping("/donators")
	public ResponseEntity<List<SolicitationDTO>> buscarPorDoador(Long donatorId) {
		return ResponseEntity.ok(solicitationService.buscarSolicitacaoPorPessoaFisica(donatorId));
	}

	@GetMapping("/collectors")
	public ResponseEntity<List<SolicitationDTO>> buscarPorColetor(Long coletorId) {
		return ResponseEntity.ok(solicitationService.buscarSolicitacaoPorEmpresa(coletorId));
	}
	
}
