package in.hrms.core.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_work_histories")
public class EmployeeWorkHistories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee should not be null")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @NotBlank(message = "Company name is mandatory")
    private String companyName;

    @NotBlank(message = "Job title is mandatory")
    private String jobTitle;

    private String remark;

    @NotNull(message = "Start date is mandatory")
    private Date startDate;

    @NotNull(message = "End date is mandatory")
    private Date endDate;

    private String responsibilities;

    private String achievements;

    @Column(name = "reference_contact_no")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Reference contact no must be 10 digit")
    private String referenceContactNo;

    @Column(name = "reason_for_leaving")
    private String reasonForLeaving;

    @Column(name = "location")
    @NotBlank(message = "Company branch location is mandatory")
    private String location;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @OneToMany(mappedBy = "workHst")
    private List<EmployeeWorkHistoryDocuments> workHistoryDocuments;


}
