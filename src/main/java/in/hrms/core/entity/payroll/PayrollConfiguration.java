package in.hrms.core.entity.payroll;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.payroll.enums.PayrollFrequency;
import in.hrms.core.entity.payroll.enums.PayrollType;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Builder
@Entity
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payroll_configuration")
public class PayrollConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "config_code", nullable = false, unique = true, length = 50)
    private String configCode;

    @Column(name = "config_name", nullable = false, length = 100)
    private String configName;

    @Enumerated(EnumType.STRING)
    @Column(name = "frequency", nullable = false)
    private PayrollFrequency frequency = PayrollFrequency.MONTHLY;

    @Min(1)
    @Max(31)
    @Column(name = "period_start_day", nullable = false)
    private Integer periodStartDay;

    @Min(1)
    @Max(31)
    @Column(name = "period_end_day")
    private Integer periodEndDay;

    @Min(1)
    @Max(31)
    @Column(name = "cutoff_day")
    private Integer cutoffDay;

    @Min(1)
    @Max(31)
    @Column(name = "default_pay_day", nullable = false)
    private Integer defaultPayDay;

    @Enumerated(EnumType.STRING)
    @Column(name = "payroll_type", nullable = false)
    private PayrollType payrollType = PayrollType.REGULAR;

    @Column(name = "is_end_of_month")
    private Boolean isEndOfMonth = true;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 1", nullable = false)
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "created_on", updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on")
    private Date updatedOn;
}