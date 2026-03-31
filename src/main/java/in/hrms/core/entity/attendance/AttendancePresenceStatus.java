package in.hrms.core.entity.attendance;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "attendance_presence_status")
public class AttendancePresenceStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    private String description;

    @Column(name = "is_active")
    private boolean isActive = true;

}
