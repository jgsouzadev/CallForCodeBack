package eco.shared.domain.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_COLLECTOR")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(setterPrefix = "with")
@NamedEntityGraph(name = "address", attributeNodes = {@NamedAttributeNode("address") })
public class Collector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DOCUMENTO")
	private String documento;
	
	@Column(name = "NM_EMPRESA")
	private String nomeEmpresa;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "DT_CRIADA")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoAt;

	@Column(name = "isOng")
	private Boolean isOng;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ENDERECO")
	private Address address;
	
	@OneToMany(mappedBy = "coletor",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Solicitation> solicitations = new HashSet<>();
	
	
	
}
