package in.hrms.core.entity.attendance;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import in.hrms.core.entity.employee.Employees;
import in.hrms.core.entity.shift.Shifts;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "attendance_regularization_approval")
public class AttendanceRegularizationApproval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "approved_by", nullable = false)
    private Employees approvedBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AttendanceRegularizationApprovalStatus status;

    @Column(name = "remark")
    private String remark;

    @ManyToOne
    @NotNull(message = "Shift should not be null")
    @JoinColumn(name = "shift_id")
    private Shifts shift;

    @NotNull(message = "Check in time should not be null")
    @Column(name = "check_in")
    private LocalDateTime checkIn;

    @NotNull(message = "Check in time should not be null")
    @Column(name = "check_out")
    private LocalDateTime checkOut;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regularization_id", nullable = false)
    private AttendanceRegularization regularization;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

}