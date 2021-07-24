package eco.shared.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import eco.shared.infra.dto.CollectorDTO;
import eco.shared.infra.service.CollectorService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/collectors")
@AllArgsConstructor
public class CollectorController {

	@Autowired
	private CollectorService collectorService;

	@GetMapping("/{id}")
	public ResponseEntity<CollectorDTO> getCollectorById(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(collectorService.getCollectorById(id));
	}
	
	@GetMapping("/document/{document}")
	public ResponseEntity<CollectorDTO> getCollectorByDocument(@PathVariable String document) throws Exception {
		return ResponseEntity.ok(collectorService.getCollectorByDocument(document));
	}
	
	@PostMapping
	public ResponseEntity<CollectorDTO> storeNewCollector(@RequestBody CollectorDTO collector) {
		return ResponseEntity.ok(collectorService.createNewCollector(collector));
	}
	
}
