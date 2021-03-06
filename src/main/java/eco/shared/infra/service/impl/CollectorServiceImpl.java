package eco.shared.infra.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.gavaghan.geodesy.Ellipsoid;
import org.gavaghan.geodesy.GeodeticCalculator;
import org.gavaghan.geodesy.GlobalPosition;
import org.springframework.stereotype.Service;

import eco.shared.domain.enums.EnumEstado;
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
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class CollectorServiceImpl implements CollectorService {

	CollectorRepository collectorRepository;
	CollectorMapper mapper;
	AddressService addressService;

	@Override
	@Transactional
	public CollectorDTO getCollectorById(Long id) throws NotFoundException {
		Optional<Collector> collector = collectorRepository.findById(id);
		if (collector.isPresent()) {
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
		if (collector.isPresent()) {
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
		return Collector.builder().withCriadoAt(LocalDate.now()).withDocumento(collector.getDocumento())
				.withIsOng(collector.getIsOng()).withEmail(collector.getEmail()).withSenha(collector.getSenha())
				.withNomeEmpresa(collector.getNomeEmpresa()).build();
	}

	@Override
	public List<CollectorDTO> getCollectorsByRangeOfLatiLong(double latitude, double longitude, EnumEstado estado) {
		List<CollectorDTO> collectores = collectorRepository.getCollectorsWithLongLatByEstado(estado);
		
		log.info("Latitude: " + latitude + "Longitude: " + longitude);
		return collectores.stream()
				.filter(collect -> calculadoraRange(latitude, longitude, collect))
				.collect(Collectors.toList());
	}
	
	private boolean calculadoraRange(double latitude, double longitude, CollectorDTO collect) {
		
		double distancia = this.calculaDistancia(latitude, longitude,Double.parseDouble(collect.getAddress().getLatitude()), 
				Double.parseDouble(collect.getAddress().getLongitude()));
		
		log.info("A distancia: " + distancia);
		log.info("Latitude: " + Double.parseDouble(collect.getAddress().getLatitude()));
		log.info("Longitude: " + Double.parseDouble(collect.getAddress().getLongitude()));
		return distancia > -5000 && distancia < 5000 ? true : false ;
	}

	private double calculaDistancia(double lat1, double lon1, double lat2, double lon2) {

		GeodeticCalculator geoCalc = new GeodeticCalculator();
		
		Ellipsoid reference = Ellipsoid.WGS84;

		GlobalPosition userPos = new GlobalPosition(lat1, lon1, 0.0); // Point B
		GlobalPosition pointA = new GlobalPosition(lat2, lon2, 0.0); // Point A

		
		double distance = geoCalc.calculateGeodeticCurve(reference, userPos, pointA).getEllipsoidalDistance(); // Distance between Point A and Point B
		log.info("A distancia entre os pontos: " + distance);
		return distance;
	}

}
