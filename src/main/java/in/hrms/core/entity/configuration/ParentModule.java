package in.hrms.core.entity.configuration;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "parent_module")
public class ParentModule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name is Mandatory")
	@Column(length = 50, unique = true)
	private String name;

	@Column(length = 150)
	private String description;

	@NotNull(message = "URL is Mandatory")
	private String url;

	@NotNull(message = "Icon is Mandatory")
	private String icon;

	private int sequence;

	@Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
	private boolean isActive;

	@JsonManagedReference
	@OneToMany(mappedBy = "parentModule", fetch = FetchType.LAZY)
	private List<Modules> modules;
}
