package eco.shared.infra.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DonatorDTO implements Serializable{
	
	private static final long serialVersionUID = 1105965765946102557L;

	private Long id;
	private String cpf;
	private String senha;
	private String nome;
	private String email;
	private String sobrenome;
	
}
