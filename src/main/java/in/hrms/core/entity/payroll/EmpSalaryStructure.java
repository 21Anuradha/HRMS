package in.hrms.core.entity.payroll;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.configuration.Currency;
import in.hrms.core.entity.employee.Employees;
import in.hrms.core.entity.payroll.enums.EmpSalaryStructureStatus;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_salary_structure")
public class EmpSalaryStructure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee should not be null")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @OneToMany(mappedBy = "salaryStructure")
    private List<EmpSalaryDetails> empSalaryDetails;

    @ManyToOne
    @JoinColumn(name = "payroll_configuration_id", nullable = false)
    private PayrollConfiguration payrollConfiguration;

    @NotNull(message = "Effective from is mandatory")
    @Column(name = "effective_from")
    private Date effectiveFrom;

    @Column(name = "effective_to")
    private Date effectiveTo;

    @Column(name = "total_ctc", nullable = false)
    private Double totalCtc;

    @NotNull
    @Column(name = "monthly_ctc", nullable = false)
    private Double monthlyCtc;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    @Column(length = 200)
    private String remark;

    @NotNull
    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EmpSalaryStructureStatus status = EmpSalaryStructureStatus.ACTIVE;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

}
