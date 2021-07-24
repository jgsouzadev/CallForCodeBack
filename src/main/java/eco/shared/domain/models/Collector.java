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
public class Collector {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "DOCUMENT")
	private String document;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "DT_CREATED")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate createdAt;

	@Column(name = "isOng")
	private Boolean isOng;
	
	@JoinColumn(name = "ADDRESS")
	@OneToOne(mappedBy = "collector", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Address address;
	
	@OneToMany(mappedBy = "collector", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Solicitation> solicitations = new HashSet<>();
	
}
