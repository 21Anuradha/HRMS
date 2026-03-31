package in.hrms.core.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "emp_educations")
public class EmployeeEducations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee should not be null")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @NotBlank(message = "Institute name is mandatory")
    private String institute;

    @NotBlank(message = "Qualification type is mandatory")
    @Column(name = "qualification_type")
    private String qualificationType;

    @NotBlank(message = "Course type is mandatory")
    @Column(name = "course_type")
    private String courseType;

    @NotBlank(message = "Course is mandatory")
    private String course;

    @Column(name = "course_specialization")
    private String courseSpecialization;

    @Column(name = "year_of_passing", length = 4)
    private String yearOfPassing;

    @Column(name = "month_of_passing", length = 2)
    private String monthOfPassing;

    private String grade;

    private Double percentage;

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

    @Column(name = "updated_by", nullable = false)
    private Long updatedBy;

    @OneToMany(mappedBy = "empEducations")
    private List<EmployeeEducationalDocuments> educationalDocuments;

}
