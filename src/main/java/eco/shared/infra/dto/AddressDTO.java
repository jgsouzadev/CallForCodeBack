package eco.shared.infra.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import eco.shared.domain.enums.EnumEstado;
import eco.shared.domain.models.Collector;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(setterPrefix = "with")
public class AddressDTO implements Serializable{
	
	private static final long serialVersionUID = 3951326094372460941L;
	private String cidade;
	private String logradouro;
	private String complemento;
	private String cep;
	private String numero;
	private EnumEstado uf; 
	private String latitude;
	private String longitude;
	@JsonIgnore
	private Collector collector;
	
}
