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

import com.fasterxml.jackson.annotation.JsonFormat;

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

	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "CD_PASSWORD")
	private String password;
	
	@Column(name = "DT_CREATED")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdAt;

	@Column(name = "DT_REMOVED")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate deletedAt;

	@OneToMany(mappedBy = "donator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Solicitation> solicitations = new HashSet<>();
}
