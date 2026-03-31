package in.hrms.core.entity.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department_budget")
public class DepartmentBudget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Financial year is mandatory")
    @JoinColumn(name = "financial_year_id")
    private FinancialYear financialYear;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @NotNull(message = "Department is mandatory")
    private Departments departments;

    @NotNull(message = "Amount is mandatory")
    private Double amount;

    @NotNull(message = "Remark is mandatory")
    private String remark;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 1", nullable = false)
    private Boolean isActive;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by", nullable = false)
    private Long updatedBy;

}
