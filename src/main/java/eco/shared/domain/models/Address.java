package eco.shared.domain.models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import eco.shared.domain.enums.EnumEstado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ADDRESS")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "logradouro")
	private String logradouro;
	
	@Column(name = "complemento")
	private String complemento;
	
	@Column(name = "cep")
	private String cep;

	@Column(name = "numero")
	private String numero;

	@Column(name = "uf")
	@Enumerated(EnumType.STRING)
	private EnumEstado uf; 

	@Column(name = "LATITUDE")
	private String latitude;
	
	@Column(name = "LONGITUDE")
	private String longitude;

	@OneToOne(mappedBy = "address")
	private Collector coletor;

}
