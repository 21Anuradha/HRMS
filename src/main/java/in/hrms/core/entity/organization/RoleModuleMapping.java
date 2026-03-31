package in.hrms.core.entity.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.configuration.Modules;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role_module_mapping")
public class RoleModuleMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	@NotNull(message = "Role should not be null")
	private Role role;

	@JoinColumn(name = "module_id")
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull(message = "Module should not be null")
	private Modules module;

	@Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 1")
	private boolean isActive;

	@NotNull(message = "Created By Should not be null")
	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "updated_by")
	private Long updatedBy;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false, updatable = false)
	private Date createdOn;

	@UpdateTimestamp
	@Column(name = "updated_on", nullable = false)
	private Date updatedOn;

}
