package in.hrms.core.entity.attendance;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "attendance_work_mode")
public class AttendanceWorkMode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code; // e.g., WFH, CLIENT_SITE

    private String description;

    @Column(name = "is_active")
    private boolean isActive = true;
}