package eco.shared.infra.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import eco.shared.domain.models.Donator;
import eco.shared.infra.dto.DonatorDTO;
import eco.shared.infra.repository.DonatorRepository;
import eco.shared.infra.service.DonatorService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DonatorServiceImpl implements DonatorService{
	
	DonatorRepository donatorRepository;
	
	@Override
	public Donator getUserByIdAndCpf(Long id, String document) {
		return donatorRepository.findByIdAndCpf(id, document);
	}

	@Override
	public Donator createUser(DonatorDTO donator) {
		return donatorRepository.save(
				Donator.builder()
				.withCpf(donator.getCpf())
				.withPassword(donator.getPassword())
				.withCreatedAt(LocalDate.now())
				.build()
				);
	}

	@Override
	public void removeUser(Long id, String document) {
		Donator donator = this.getUserByIdAndCpf(id, document);
		donator.setDeletedAt(LocalDate.now());
		donatorRepository.saveAndFlush(donator);
	}

}
