package in.hrms.core.entity.logs;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import in.hrms.core.entity.employee.Users;
import in.hrms.core.enums.PasswordResetTypeEnum;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "password_history")
public class PasswordHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull(message = "User should not be null")
	private Users user;

	@NotNull(message = "Old Password should not be null")
	@Column(name = "old_password", columnDefinition = "TEXT")
	private String oldPassword;

	@NotNull(message = "New Password should not be null")
	@Column(name = "new_password", columnDefinition = "TEXT")
	private String newPassword;

	@Column(name = "change_type")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Change Type should not be null")
	private PasswordResetTypeEnum changeType;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false, updatable = false)
	private Date createdOn;

}