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

import in.hrms.core.enums.EmpSalaryCompCalculationType;

import java.util.Date;

@Data
@Entity
@Builder(toBuilder = true)
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_salary_details")
public class EmpSalaryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "structure_id")
    private EmpSalaryStructure salaryStructure;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private EmpSalaryComponent salaryComponent;

    @Enumerated(EnumType.STRING)
    @Column(name = "calculation_type")
    private EmpSalaryCompCalculationType calculationType;

    private Double percentage;

    @Column(length = 500)
    private String formula;

    @NotNull
    private Double value;


    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;
}
