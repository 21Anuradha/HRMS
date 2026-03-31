package in.hrms.core.entity.payroll;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.enums.EmpSalaryCompCalculationType;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payroll_employee_component")
public class PayrollEmployeeComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payroll_employee_id", nullable = false)
    private PayrollEmployee payrollEmployee;

    @ManyToOne
    @JoinColumn(name = "component_id", nullable = false)
    private EmpSalaryComponent component;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "calculation_type")
    private EmpSalaryCompCalculationType calculationType;

    private Double percentage;

    @Column(name = "formula", length = 500)
    private String formula;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;
}