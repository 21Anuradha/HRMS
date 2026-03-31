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
@Table(name = "emp_family_documents")
public class EmployeeFamilyDetailsDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "emp_family_details_id")
    @NotNull(message = "Employee is mandatory")
    private EmployeeFamilyDetails employeeFamilyDetails;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @NotNull(message = "Document is mandatory")
    private Documents document;
}
