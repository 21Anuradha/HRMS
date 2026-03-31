package in.hrms.core.entity.other;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import in.hrms.core.entity.employee.Employees;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "information_security_tests")
public class InformationSecurityTests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @NotNull(message = "Employee should not be null")
    private Employees employee;

    @Column(name = "is_passed", columnDefinition = "boolean default false", nullable = false)
    private boolean isPassed;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @OneToMany(mappedBy = "informationSecurityTest", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<InformationSecurityTestDetails> informationSecurityTestDetails;
}
