package in.hrms.core.entity.attendance;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.employee.Employees;
import in.hrms.core.entity.shift.Shifts;
import in.hrms.core.enums.AttendanceRegularizationStatus;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attendance_regularization")
public class AttendanceRegularization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee should not be null")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @ManyToOne
    @NotNull(message = "Shift should not be null")
    @JoinColumn(name = "shift_id")
    private Shifts shift;

    @ManyToOne
    @JoinColumn(name = "work_mode_id")
    private AttendanceWorkMode workMode;

    @NotNull(message = "Check in time should not be null")
    @Column(name = "check_in")
    private LocalDateTime checkIn;

    @NotNull(message = "Check in time should not be null")
    @Column(name = "check_out")
    private LocalDateTime checkOut;

    private String reason;

    @Enumerated(EnumType.STRING)
    private AttendanceRegularizationStatus status = AttendanceRegularizationStatus.PENDING;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

    @OneToMany(mappedBy = "regularization", cascade = CascadeType.ALL)
    private List<AttendanceRegularizationApproval> approvals;
}
