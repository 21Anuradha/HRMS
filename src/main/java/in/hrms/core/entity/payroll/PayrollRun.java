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

import in.hrms.core.entity.payroll.enums.PayrollRunStatus;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payroll_run",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_conf_month_year",
                columnNames = {"payroll_configuration_id", "pay_month", "pay_year"}
        ))
public class PayrollRun {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "payroll_configuration_id")
    private PayrollConfiguration payrollConfiguration;

    @NotNull
    @Column(name = "period_start", nullable = false)
    private LocalDate periodStart;

    /** Payroll period end (e.g. 2025-09-30) */
    @NotNull
    @Column(name = "period_end", nullable = false)
    private LocalDate periodEnd;

    /** Scheduled pay date */
    @NotNull
    @Column(name = "pay_date", nullable = false)
    private LocalDate payDate;

    @Column(name = "pay_month", length = 2, nullable = false)
    private Integer payMonth;

    @Column(name = "pay_year", length = 4, nullable = false)
    private Integer payYear;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private PayrollRunStatus status = PayrollRunStatus.DRAFT;

    @Column(name = "is_locked", nullable = false)
    private Boolean isLocked = false;

    @Column(name = "total_employees")
    private Integer totalEmployees;

    @Column(name = "total_gross")
    private Double totalGross;

    @Column(name = "total_deductions")
    private Double totalDeductions;

    @Column(name = "total_net")
    private Double totalNet;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

}
