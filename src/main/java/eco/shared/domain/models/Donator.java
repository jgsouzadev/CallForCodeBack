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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;

import eco.shared.domain.annotations.NotAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_DONATOR")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Donator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CPF", unique = true)
	private String cpf;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "NM_USUARIO")
	private String nomeUsuario;
	
	@Column(name = "SOBRENOME")
	private String sobrenome;
	
	@Column(name = "EMAIL", unique = true)
	private String email;
	
	@Column(name = "DT_CRIADA")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoAt;

	@Column(name = "DT_REMOVIDO")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate removidoAt;

	@OneToMany(mappedBy = "donator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@NotAudit
	private Set<Solicitation> solicitations = new HashSet<>();
}
