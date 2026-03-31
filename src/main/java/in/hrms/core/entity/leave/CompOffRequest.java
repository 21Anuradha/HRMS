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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comp_off_request")
public class CompOffRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee should not be null")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @NotNull
    @Column(name = "worked_date")
    private LocalDate workedDate;

    @Column(name = "request_date")
    private LocalDate requestDate;

    @Column(name = "earned_days")
    private Double earnedDays;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Enumerated(EnumType.STRING)
    private CompOffStatus status = CompOffStatus.PENDING;

    @Column(name = "approved_on")
    private LocalDateTime approvedOn;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

}
