package in.hrms.core.entity.other;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import in.hrms.core.entity.employee.Users;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "forget_password_request")
public class ForgetPasswordRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull(message = "User should not be null")
	private Users user;

	@Column(name = "no_of_passwd_recov_quest", nullable = false)
	private int noOfPasswdRecovQuestions;

	@Column(name = "no_of_ans_matched", nullable = false)
	private int noOfAnswerMatched;

	@Column(name = "is_all_ans_correct")
	private boolean isAllAnsCorrect;

	@Column(columnDefinition = "tinyint(1) default 0")
	private int status;

	@CreationTimestamp
	@Column(name = "created_on", nullable = false, updatable = false)
	private Date createdOn;

}
