package in.hrms.core.entity.employee;

import in.hrms.core.entity.organization.Documents;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_personal_documents")
public class EmployeePersonalDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @NotNull(message = "Employee is mandatory")
    private Employees employee;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @NotNull(message = "Document is mandatory")
    private Documents document;


}
