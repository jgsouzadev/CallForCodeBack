package eco.shared.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eco.shared.domain.models.Donator;
import eco.shared.infra.dto.DonatorDTO;
import eco.shared.infra.dto.SolicitationDTO;
import eco.shared.infra.service.DonatorService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/donators")
@AllArgsConstructor
public class DonatorController {

	@Autowired
	private DonatorService donatorService;
	
	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<DonatorDTO> getUserByCpfAndId(@PathVariable String cpf) throws NotFoundException {
		return ResponseEntity.ok(donatorService.getUserByCpf(cpf));
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<DonatorDTO> getUserByEmail(@PathVariable String email) throws NotFoundException {
		return ResponseEntity.ok(donatorService.getUserByEmail(email));
	}
	
	@PostMapping("/store")
	public ResponseEntity<Donator> createNewUser(@RequestBody DonatorDTO donator) {
		return ResponseEntity.ok(donatorService.createUser(donator));
	}
	
	@PutMapping("/{id}/cpf/{cpf}")
	public ResponseEntity<Void> removeUserById(@PathVariable Long id, @PathVariable String cpf) throws NotFoundException {
		donatorService.removeUser(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/order")
	public ResponseEntity<Void> openSolicitation(@RequestBody SolicitationDTO solicitation) throws Exception {
		donatorService.openSolicitation(solicitation);
		return ResponseEntity.noContent().build();
	}

	
}
