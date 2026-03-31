package in.hrms.core.entity.leave;

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
@Table(name = "leave_request_documents",
        uniqueConstraints = @UniqueConstraint(columnNames = {"leave_request_id", "document_id"}))
public class LeaveRequestDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "leave_request_id")
    @NotNull(message = "Leave request is mandatory")
    private LeaveRequest leaveRequest;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @NotNull(message = "Document is mandatory")
    private Documents document;

}
