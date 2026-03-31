package in.hrms.core.entity.configuration;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "module")
public class Modules {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "Name is Mandatory")
	@Column(length = 50)
	private String name;

	@Column(length = 150)
	private String description;

	@NotNull(message = "URL is Mandatory")
	private String url;

	@ManyToOne
	@JsonBackReference
	@NotNull(message = "Parent Module is Mandatory")
	@JoinColumn(name = "parent_module")
	private ParentModule parentModule;

	@NotNull(message = "Icon is Mandatory")
	private String icon;

	@Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
	private boolean isActive;

	private int sequence;

}
