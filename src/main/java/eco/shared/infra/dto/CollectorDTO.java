package eco.shared.infra.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Data
public class CollectorDTO implements Serializable{
	
	private static final long serialVersionUID = 1105965765946102557L;

	private Long id;
	private String documento;
	private String senha;
	private Boolean isOng;
	private String email;
	private AddressDTO address;
	private String nomeEmpresa;
}
