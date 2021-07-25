package eco.shared.infra.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import eco.shared.domain.enums.TipoStatus;
import eco.shared.domain.models.Donator;
import eco.shared.domain.models.Solicitation;
import eco.shared.infra.dto.CollectorDTO;
import eco.shared.infra.dto.DonatorDTO;
import eco.shared.infra.dto.SolicitationDTO;
import eco.shared.infra.mapper.CollectorMapper;
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
	CollectorMapper collectorMapper;
	
	@Override
	public DonatorDTO getUserByCpf(String document) throws NotFoundException {
		Optional<Donator> donator = donatorRepository.findByCpf(document);
		optionalValidator(donator);
		return DonatorDTO.builder()
				.withCpf(donator.get().getCpf())
				.withSenha(donator.get().getSenha())
				.withNome(donator.get().getNomeUsuario())
				.withSobrenome(donator.get().getSobrenome())
				.withEmail(donator.get().getEmail())
				.build();
	}

	@Override
	public DonatorDTO getUserByEmail(String email) throws NotFoundException {
		Optional<Donator> donator = donatorRepository.findByEmail(email);
		optionalValidator(donator);
		return DonatorDTO.builder()
				.withCpf(donator.get().getCpf())
				.withSenha(donator.get().getSenha())
				.withNome(donator.get().getNomeUsuario())
				.withSobrenome(donator.get().getSobrenome())
				.withEmail(donator.get().getEmail())
				.build();
	}
	
	@Override
	public Donator createUser(DonatorDTO donator) {
		return donatorRepository.save(
				Donator.builder()
				.withCpf(donator.getCpf())
				.withSenha(donator.getSenha())
				.withNomeUsuario(donator.getNome())
				.withEmail(donator.getEmail())
				.withSobrenome(donator.getSobrenome())
				.withCriadoAt(LocalDate.now())
				.build()
				);
	}

	@Override
	public void removeUser(Long id) throws NotFoundException {
		Donator donator = this.getDonatorById(id);
		donator.setRemovidoAt(LocalDate.now());
		donatorRepository.saveAndFlush(donator);
	}

	@Override
	@Transactional
	public void openSolicitation(SolicitationDTO requestDTO) throws Exception {
		Donator donator = this.getDonatorById(requestDTO.getIdDonator());
		CollectorDTO collector = collectorService.getCollectorById(requestDTO.getIdCollector());
		
		Solicitation solicitation = Solicitation.builder()
				.withColetor(collectorMapper.map(collector)) 
				.withDonator(donator)
				.withDescricao(requestDTO.getDescricao())
				.withEmitidoAt(LocalDateTime.now())
				.withStatus(TipoStatus.AGUARDANDO)
				.build();
		
		solicitationService.save(solicitation);	
	}

	private void optionalValidator(Optional<?> optional) throws NotFoundException {
		if(optional.isEmpty())
			throw new NotFoundException("Usuário não encontrando");
	}
	
	
	private Donator getDonatorById(Long id) throws NotFoundException {
		Optional<Donator> donator = donatorRepository.findById(id);
		if(donator.isPresent())
			return donator.get();
		throw new NotFoundException("Doador não encontrado");
	}
}
