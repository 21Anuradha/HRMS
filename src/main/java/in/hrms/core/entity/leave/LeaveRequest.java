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
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import static in.hrms.core.enums.LeaveStatus.PENDING;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leave_request")
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee should not be null")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "leave_type_id")
    @NotNull(message = "Leave type should not be null")
    private LeaveType leaveType;

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

    private String reason;

    @Column(name = "approval_remark")
    private String approvalRemark;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @NotNull(message = "Status should not be null")
    private LeaveStatus status = LeaveStatus.PENDING;

    @Builder.Default
    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

    @OneToMany(mappedBy = "leaveRequest")
    private List<LeaveRequestDocuments> leaveRequestDocuments;

}