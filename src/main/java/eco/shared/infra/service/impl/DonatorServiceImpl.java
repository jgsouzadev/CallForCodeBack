package eco.shared.infra.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import eco.shared.domain.enums.TipoStatus;
import eco.shared.domain.models.Collector;
import eco.shared.domain.models.Donator;
import eco.shared.domain.models.Solicitation;
import eco.shared.infra.dto.DonatorDTO;
import eco.shared.infra.dto.SolicitationDTO;
import eco.shared.infra.repository.DonatorRepository;
import eco.shared.infra.service.CollectorService;
import eco.shared.infra.service.DonatorService;
import eco.shared.infra.service.SolicitationService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DonatorServiceImpl implements DonatorService{
	
	DonatorRepository donatorRepository;
	CollectorService collectorService;
	SolicitationService solicitationService;
	
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

	@Override
	public void openSolicitation(SolicitationDTO requestDTO) throws Exception {
		Donator donator = this.getDonatorById(requestDTO.getIdDonator());
		Collector collector = collectorService.getCollectorById(requestDTO.getIdCollector());
		
		Solicitation solicitation = Solicitation.builder()
				.withCollector(collector) 
				.withDonator(donator)
				.withDescription(requestDTO.getDescription())
				.withEmittedAt(LocalDateTime.now())
				.withStatus(TipoStatus.AGUARDANDO)
				.build();
		
		solicitationService.save(solicitation);
		
	}

	
	private Donator getDonatorById(Long id) throws NotFoundException {
		Optional<Donator> donator = donatorRepository.findById(id);
		if(donator.isPresent())
			return donator.get();
		
		throw new NotFoundException("Doador não encontrado");
	}
}
