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

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Leave_balance")
public class LeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee should not be null")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @ManyToOne
    @NotNull(message = "Leave Type should not be null")
    @JoinColumn(name = "leave_type_id")
    private LeaveType leaveType;

    @Column(name = "year", nullable = false, length = 4)
    private String year;

    @Column(name = "total", nullable = false)
    private Double total = 0.0;

    @Column(name = "used", nullable = false)
    private Double used = 0.0;

    @Column(name = "balance", nullable = false)
    private Double balance = 0.0;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;
}
