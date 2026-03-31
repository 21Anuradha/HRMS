package in.hrms.core.entity.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import in.hrms.core.entity.employee.EmployeeRoleMapping;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	@NotNull(message = "Name should not be null")
	private String name;

	@Column(length = 150)
	private String description;

	@NotNull(message = "Created By should not be null")
	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 0")
	private boolean isActive;

	@Column(name = "status", columnDefinition = "TINYINT(1) DEFAULT 1")
	private boolean status;

	@CreationTimestamp
	@Column(name = "created_on", updatable = false, nullable = false)
	private Date createdOn;

	@OneToMany(mappedBy = "role")
	private List<RoleModuleMapping> roleModuleMappings;

	@OneToMany(mappedBy = "role")
	private List<EmployeeRoleMapping> userRoleMappings;
}
