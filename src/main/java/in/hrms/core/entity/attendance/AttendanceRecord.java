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
import in.hrms.core.entity.shift.ShiftRoster;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "attendance_record",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"employee_id", "shift_roster_id", "check_in_dt"})
        }
)
public class AttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_roster_id")
    private ShiftRoster shiftRoster;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate;

    @Column(name = "check_in_dt", nullable = false)
    private LocalDateTime checkInDateTime;

    @Column(name = "check_out_dt")
    private LocalDateTime checkOutDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "current_status")
    private AttendanceCurrentStatusEnum currentStatus;

    @Column(name = "break_hours")
    private Double breakHours;

    @Column(name = "work_hours")
    private Double workHours;

    @Column(name = "overtime_hours")
    private Double overtimeHours;

    @ManyToOne
    @JoinColumn(name = "work_mode_id")
    private AttendanceWorkMode workMode;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "presence_status")
    private AttendancePresenceStatusEnum presenceStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AttendanceRemark remark;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AttendanceSource source;

    @Column(length = 200)
    private String description;

    @OneToMany(mappedBy = "attendanceRecord", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AttendancePunch> attendancePunches;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by", nullable = false)
    private Long updatedBy;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

}
