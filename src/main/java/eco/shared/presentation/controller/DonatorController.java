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
import eco.shared.infra.service.DonatorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/donators")
@AllArgsConstructor
public class DonatorController {

	@Autowired
	private DonatorService donatorService;
	
	@GetMapping("/{id}/cpf/{cpf}")
	public ResponseEntity<Donator> getUserByCpfAndId(@PathVariable Long id, @PathVariable String cpf) {
		return ResponseEntity.ok(donatorService.getUserByIdAndCpf(id, cpf));
	}
	
	@PostMapping("/store")
	public ResponseEntity<Donator> createNewUser(@RequestBody DonatorDTO donator) {
		return ResponseEntity.ok(donatorService.createUser(donator));
	}
	
	@PutMapping("/{id}/cpf/{cpf}")
	public ResponseEntity<Void> removeUserByCpfAndId(@PathVariable Long id, @PathVariable String cpf) {
		donatorService.removeUser(id, cpf);
		return ResponseEntity.noContent().build();
	}

	
}
