package in.hrms.core.entity.other;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.enums.PassRecovQuestDataTypeEnum;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "password_recovery_question")
public class PasswordRecoveryQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Question is mandatory")
    private String question;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isActive;

    @NotNull(message = "Sata Type should be Mandatory")
    @Column(name = "data_type")
    @Enumerated(EnumType.STRING)
    private PassRecovQuestDataTypeEnum dataType;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;
}
