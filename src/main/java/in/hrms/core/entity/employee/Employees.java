package in.hrms.core.entity.employee;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.configuration.BloodGroups;
import in.hrms.core.entity.configuration.EmployeeStatus;
import in.hrms.core.entity.organization.Documents;
import in.hrms.core.enums.GenderEnum;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Mobile no is mandatory")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile no must be 10 digit")
    @Column(name = "mobile_no", length = 10, nullable = false, unique = true)
    private String mobileNo;

    @ManyToOne
    @JoinColumn(name = "blood_group_id")
    @NotNull(message = "Blood Group is mandatory")
    private BloodGroups bloodGroup;

    @Email(message = "Invalid personal mail Id")
    @Column(name = "personal_mail_id", nullable = false)
    private String personalMailId;

    @Column(name = "home_phone")
    private String homePhone;

    @ManyToOne
    @JoinColumn(name = "profile_image")
    private Documents profileImg;

    @NotNull(message = "Gender is mandatory")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "date_of_birth")
    @NotNull(message = "DOB is mandatory")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "status")
    @NotNull(message = "Employee status should not be null")
    private EmployeeStatus status;

    @Column(name = "aadhar_no")
    private String aadharNo;

    @Column(name = "pan_no")
    private String panNo;

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
//
//    @OneToOne(mappedBy = "employee")
//    private Employees employee;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeWorkHistories> workHistories;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeEducations> educationDetails;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeFamilyDetails> employeeFamilyDetails;

    @OneToMany(mappedBy = "employees")
    private List<EmployeeRoleMapping> employeeRoleMappings;

    @OneToMany(mappedBy = "employee")
    private List<EmployeePersonalDocuments> employeePersonalDocuments;

    @OneToOne(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
    private EmployeeOfficialDetails employeeOfficialDetails;

    @OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<EmployeeEmergencyContactDetails> emergencyContactDetails;

    @OneToOne(mappedBy = "employee")
    private HRManager hrManager;

    @OneToOne(mappedBy = "employee")
    private FinanceManager financeManager;

    @OneToOne(mappedBy = "employees")
    private Users users;


}
