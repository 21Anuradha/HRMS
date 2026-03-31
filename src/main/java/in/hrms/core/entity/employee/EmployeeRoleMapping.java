package in.hrms.core.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.organization.Role;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_role_mapping")
public class EmployeeRoleMapping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	@NotNull(message = "Employee should not be null")
	private Employees employees;

	@ManyToOne
	@JoinColumn(name = "role_id")
	@NotNull(message = "Role should not be null")
	private Role role;

	@Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 1")
	private boolean isActive;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false, updatable = false)
	private Date createdOn;

	@UpdateTimestamp
	@Column(name = "updated_on", nullable = false)
	private Date updatedOn;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "updated_by")
	private Long updatedBy;
}
