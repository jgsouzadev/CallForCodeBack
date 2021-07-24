package eco.shared.domain.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import eco.shared.domain.enums.TipoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_SOLICITATION")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Solicitation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JoinColumn(name = "ID_DOADOR")
	@ManyToOne
	private Donator donator;
	
	@JoinColumn(name = "ID_COLETOR")
	@ManyToOne
	private Collector coletor;
	
	@Column(name = "DT_EMITIDA")
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime emitidoAt;
	
	@Column(name = "DESC_PEDIDO")
	private String descricao;
	
	@Column(name ="STATUS")
	private TipoStatus status;
	
	
}
