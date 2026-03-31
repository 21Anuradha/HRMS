package in.hrms.core.entity.leave;

import in.hrms.core.entity.configuration.DocumentTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "leave_type_documents")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveTypeDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "leave_type_id", nullable = false)
    private LeaveType leaveType;

    @ManyToOne
    @JoinColumn(name = "document_type_id", nullable = false)
    private DocumentTypes documentType;

    @Column(name = "is_mandatory", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isMandatory = false;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean isActive = true;
}
