package in.hrms.core.entity.broadcast;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "broadcast_documents")
public class BroadcastDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Document name is mandatory")
    @Column(name = "doc_name")
    private String docName;

//    @NotNull(message = "Document path is mandatory")
    @Column(name = "doc_path")
    private String docPath;

    private String caption;

    @ManyToOne
    @NotNull(message = "Broadcast id is mandatory")
    @JoinColumn(name = "broadcast_id")
    private Broadcasts broadcast;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

}
