package in.hrms.core.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.configuration.Bands;
import in.hrms.core.entity.organization.Departments;
import in.hrms.core.entity.organization.Designations;
import in.hrms.core.enums.InfoSecTestStatusEnum;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_official_details")
public class EmployeeOfficialDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull(message = "Employee is mandatory")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @NotNull(message = "Department is mandatory")
    private Departments department;

    @ManyToOne
    @NotNull(message = "Band is mandatory")
    @JoinColumn(name = "band_id")
    private Bands band;

    @ManyToOne
    @JoinColumn(name = "designation_id")
    @NotNull(message = "Designation is mandatory")
    private Designations designation;

    @ManyToOne
    @NotNull(message = "RM is mandatory")
    @JoinColumn(name = "reporting_manager")
    private Employees reportingManager;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "admin_manager")
    private Employees adminManager;

    @NotNull
    @Column(name = "employee_code", unique = true)
    private String employeeCode;

    @Column(name = "official_mail_id")
    private String officialMailId;

    @Column(name = "date_of_joining")
    @NotNull(message = "Date of joining is mandatory")
    private LocalDate dateOfJoining;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "info_sec_test_status", nullable = false)
    private InfoSecTestStatusEnum infoSecTestStatus = InfoSecTestStatusEnum.PENDING;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by", nullable = false)
    private Long updatedBy;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

}
