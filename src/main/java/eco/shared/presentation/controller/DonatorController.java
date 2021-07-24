package eco.shared.presentation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donator")
public class DonatorController {

	@GetMapping
	public String HelloWorld() {
		return "Hello World";
	}
	
}
