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

import in.hrms.core.entity.configuration.FamilyRelationship;
import in.hrms.core.enums.GenderEnum;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "emp_family_details")
public class EmployeeFamilyDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee should not be null")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @NotBlank(message = "Family member is mandatory")
    @Column(name = "family_member_name")
    private String familyMemberName;

    @NotNull(message = "Gender is mandatory")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @NotNull(message = "DOB is mandatory")
    private Date dob;

    @Column(name = "is_dependent", nullable = false)
    @NotNull(message = "IsDependent is mandatory")
    private boolean isDependent;

    @Column(name = "contact_no", length = 10)
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile no must be 10 digit")
    private String contactNo;

    @ManyToOne
    @NotNull(message = "Relationship is mandatory")
    @JoinColumn(name = "relationship_id")
    private FamilyRelationship relationship;

    @NotBlank(message = "Occupation is mandatory")
    private String occupation;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

    @OneToMany(mappedBy = "employeeFamilyDetails")
    private List<EmployeeFamilyDetailsDocuments> empFamilyDtlDocuments;
}
