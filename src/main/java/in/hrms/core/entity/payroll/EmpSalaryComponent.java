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

import in.hrms.core.enums.EmpSalaryComponentType;
import in.hrms.core.enums.EmpStatutoryType;

import java.util.Date;

@Data
@Entity
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_salary_component")
public class EmpSalaryComponent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EmpSalaryComponentType type;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "statutory_type", nullable = false)
    private EmpStatutoryType statutoryType = EmpStatutoryType.NONE;

    @Column(name = "is_taxable", nullable = false)
    private Boolean isTaxable;

    @Column(name = "is_mandatory", nullable = false)
    private Boolean isMandatory = false;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

}
