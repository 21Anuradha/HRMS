package in.hrms.core.entity.payroll;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.employee.Employees;
import in.hrms.core.entity.payroll.enums.PayrollEmployeeStatus;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payroll_employee", uniqueConstraints = @UniqueConstraint(columnNames = {"payroll_run_id", "employee_id"}))
public class PayrollEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payroll_run_id", nullable = false)
    private PayrollRun payrollRun;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "salary_structure_id", nullable = false)
    private EmpSalaryStructure salaryStructure;

    @Min(value = 0, message = "Payable days cannot be negative")
    @Max(value = 31, message = "Payable days cannot exceed maximum days in month")
    @NotNull(message = "Payable days is mandatory")
    @Column(name = "payable_days", nullable = false)
    private Double payableDays;

    @Column(name = "gross_earnings")
    @Builder.Default
    private Double grossEarnings = 0.0;

    @Builder.Default
    @Column(name = "total_deductions")
    private Double totalDeductions = 0.0;

    @Builder.Default
    @Column(name = "net_salary")
    private Double netSalary = 0.0;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PayrollEmployeeStatus status = PayrollEmployeeStatus.DRAFT;

    @OneToMany(mappedBy = "payrollEmployee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PayrollEmployeeComponent> components;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;
}