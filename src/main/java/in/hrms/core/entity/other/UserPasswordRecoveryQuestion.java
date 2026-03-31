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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_password_recovery_question")
public class UserPasswordRecoveryQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "password_recovery_question_id")
    @NotNull(message = "Password Recovery Question should not be null")
    private PasswordRecoveryQuestion passwordRecoveryQuestion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User should not be null")
    private Users user;

    @Column(length = 2)
    private int sequence;

    @NotNull(message = "Answer should not be null")
    private String answer;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;
}
