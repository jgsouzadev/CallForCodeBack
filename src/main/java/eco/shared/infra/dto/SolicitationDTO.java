package eco.shared.infra.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SolicitationDTO implements Serializable{
	
	private static final long serialVersionUID = -3729527084169167329L;
	private String protocolo;
	private Long idCollector;
	private Long idDonator;
	private String description;
}
