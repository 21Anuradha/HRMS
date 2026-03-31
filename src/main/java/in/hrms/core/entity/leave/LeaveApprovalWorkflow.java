package in.hrms.core.entity.leave;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
@Table(
        name = "leave_approval_workflow",
        uniqueConstraints = @UniqueConstraint(columnNames = {"leave_type_id", "approval_level"})
)
public class LeaveApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "leave_type_id", nullable = false)
    private LeaveType leaveType;

    @Column(name = "no_of_days")
    private int noOfDays;

    @Column(name = "approval_level", nullable = false)
    private int approvalLevel;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "approval_type")
    private LeaveApprovalTypeEnum approvalType;

    private String description;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean isActive;
}