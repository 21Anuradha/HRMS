package in.hrms.core.entity.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.employee.Employees;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @NotBlank(message = "Department code is mandatory")
    private String code;

    @NotBlank(message = "Department name is mandatory")
    private String name;

    private String description;

    @Column(name = "status", columnDefinition = "TINYINT(1) DEFAULT 1", nullable = false)
    private boolean status;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 0", nullable = false)
    private boolean isActive;

//    @NotNull(message = "HOD should not be null")
    @ManyToOne
    @JoinColumn(name = "hod")
    private Employees hod;

    @ManyToOne
    @JoinColumn(name = "deputy_hod")
    private Employees deputyHod;

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
