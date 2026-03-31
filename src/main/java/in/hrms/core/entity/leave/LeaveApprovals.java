package in.hrms.core.entity.leave;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.employee.Employees;
import in.hrms.core.enums.LeaveStatus;
import in.hrms.core.enums.TimeSlot;

import java.time.LocalDate;
import java.util.Date;

import static in.hrms.core.enums.LeaveStatus.PENDING;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Leave_approvals")
public class LeaveApprovals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Leave request should not be null")
    @JoinColumn(name = "leave_request_id")
    private LeaveRequest leaveRequest;

    @NotNull(message = "Start Date should not be null")
    @Column(name = "start_date")
    private LocalDate startDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Start time slot should not be null")
    @Column(name = "start_time_slot")
    private TimeSlot startTimeSlot;

    @NotNull(message = "End Date should not be null")
    @Column(name = "end_date")
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "End time slot should not be null")
    @Column(name = "end_time_slot")
    private TimeSlot endTimeSlot;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "approver_id")
    private Employees approver;

    @Column(name = "approval_remark")
    private String approvalRemark;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Leave status should not be null")
    private LeaveStatus status = PENDING;

    @Column(name = "approval_date_time")
    private LocalDate approvalDateTime;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;
}
