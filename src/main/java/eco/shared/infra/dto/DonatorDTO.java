package eco.shared.infra.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DonatorDTO implements Serializable{
	
	private static final long serialVersionUID = 1105965765946102557L;

	private String cpf;
	private String password;
}
