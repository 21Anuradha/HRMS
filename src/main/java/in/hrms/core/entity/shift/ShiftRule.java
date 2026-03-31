package in.hrms.core.entity.shift;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shift_rules")
public class ShiftRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_id", nullable = false)
    private Shifts shift;

//    @NotNull
//    @Column(name = "shift_name", nullable = false, unique = true)
//    private ShiftRuleType shiftRuleType;

    /* @Column(name = "break_minutes")
     private Integer breakMinutes;   // optional lunch/dinner break duration

     @Column(name = "grace_minutes")
     private Integer graceMinutes;   // tolerance for late entry

     @Column(name = "is_rotational")
     private Boolean isRotational = false;

 */
    @Column(name = "is_active", columnDefinition = "boolean default true")
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

}
