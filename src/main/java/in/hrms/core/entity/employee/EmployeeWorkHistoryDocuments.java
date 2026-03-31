package in.hrms.core.entity.employee;

import in.hrms.core.entity.organization.Documents;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_work_history_documents")
public class EmployeeWorkHistoryDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "emp_work_history_id")
    private EmployeeWorkHistories workHst;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private Documents document;
}
