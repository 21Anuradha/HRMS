package in.hrms.core.entity.attendance;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "attendance_punch")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AttendancePunch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attendance_id", nullable = false)
    private AttendanceRecord attendanceRecord;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "punch_type")
    private AttendancePunchTypeEnum punchType;

    private String remark;

    @Column(name = "punch_time", nullable = false)
    private LocalDateTime punchTime;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @Column(length = 500)
    private String address;

    @Column(name = "ip_address", length = 45) // 45 chars supports IPv6 max length
    @Pattern(
            regexp = "^(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-fA-F]{0,4}:){2,7}[0-9a-fA-F]{0,4})$",
            message = "Invalid IP address format"
    )
    private String ipAddress;

    @Column(name = "device_info")
    private String deviceInfo;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

}