package eco.shared.infra.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import eco.shared.domain.enums.TipoStatus;
import eco.shared.domain.models.Address;
import eco.shared.domain.models.Collector;
import eco.shared.infra.dto.AddressDTO;
import eco.shared.infra.dto.CollectorDTO;
import eco.shared.infra.mapper.CollectorMapper;
import eco.shared.infra.repository.CollectorRepository;
import eco.shared.infra.service.AddressService;
import eco.shared.infra.service.CollectorService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CollectorServiceImpl implements CollectorService{
	
	CollectorRepository collectorRepository;
	CollectorMapper mapper;
	AddressService addressService;

	@Override
	@Transactional
	public CollectorDTO getCollectorById(Long id) throws NotFoundException{
		Optional<Collector> collector = collectorRepository.findById(id);
		if(collector.isPresent()) {
			CollectorDTO collectorDTO = mapper.map(collector.get());			
			collectorDTO.setAddress(addressService.getAddressByCollectorId(id));
			return collectorDTO;
		}

		
		throw new NotFoundException("Collector não encontrado");
	}

	@Override
	@Transactional
	public CollectorDTO getCollectorByDocument(String document) throws Exception {
		Optional<Collector> collector = collectorRepository.findTop1ByDocumento(document);
		if(collector.isPresent()) {
			CollectorDTO collectorDTO = mapper.map(collector.get());
			collectorDTO.setAddress(addressService.getAddressByCollectorDocument(document));
			return collectorDTO;
		}
			
		throw new NotFoundException("Collector não encontrado");
	}

	@Override
	@Transactional
	public CollectorDTO createNewCollector(CollectorDTO collector) {
		Address address = addressService.saveAddress(collector.getAddress());
		Collector collectorMapped = this.mapDTO(collector);
		collectorMapped.setAddress(address);
		collectorRepository.save(collectorMapped);
		return collector;	
	}
	
	private Collector mapDTO(CollectorDTO collector) {
		return Collector
				.builder()
				.withCriadoAt(LocalDate.now())
				.withDocumento(collector.getDocumento())
				.withIsOng(collector.getIsOng())
				.withSenha(collector.getSenha())
				.withNomeEmpresa(collector.getNomeEmpresa())
				.build();
	}

	@Override
	public List<CollectorDTO> getCollectorsByRangeOfLatiLong(double latitude, double longitude, double elevacao,
			TipoStatus status) {
		
		return null;
	}
	
}
