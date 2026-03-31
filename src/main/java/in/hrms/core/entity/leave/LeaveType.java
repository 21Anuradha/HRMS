package in.hrms.core.entity.leave;

import java.util.List;

import in.hrms.core.enums.AccrualPeriod;
import in.hrms.core.enums.AccrualType;
import in.hrms.core.enums.LeaveTypeGenderApplicable;
import in.hrms.core.enums.YearApplicable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "leave_type")
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "days_per_year", length = 3, nullable = false)
    private int daysPerYear = 0;

    @Column(name = "carry_forward_limit", nullable = false)
    private Integer carryForwardLimit = 0;

    @Column(name = "encashment_allowed", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean encashmentAllowed = false;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender_applicable", nullable = false, length = 10)
    private LeaveTypeGenderApplicable genderApplicable = LeaveTypeGenderApplicable.ALL;

    @Column(name = "requires_approval", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean requiresApproval = true;

    @Column(name = "is_paid", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean isPaid = true;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean isActive = true;

    @OneToMany(mappedBy = "leaveType")
    private List<LeaveTypeDocuments> leaveTypeDocuments;

    @Enumerated(EnumType.STRING)
    @Column(name = "accrual_period", nullable = false)
    private AccrualPeriod accrualPeriod;

    @Enumerated(EnumType.STRING)
    @Column(name = "accrual_type", nullable = false)
    private AccrualType accrualType;

    @Enumerated(EnumType.STRING)
    @Column(name = "year_applicable", nullable = false)
    private YearApplicable yearApplicable;

}
