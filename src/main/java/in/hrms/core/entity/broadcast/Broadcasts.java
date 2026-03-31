package in.hrms.core.entity.broadcast;

import jakarta.persistence.*;
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
@Table(name = "broadcasts")
public class Broadcasts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Title is mandatory")
    @JoinColumn(name = "title_id")
    private BroadcastTitle title;

    private String description;

    @NotNull(message = "Message is mandatory")
    private String message;

    @ManyToOne
    @NotNull(message = "Broadcast Type is mandatory")
    @JoinColumn(name = "type_id")
    private BroadcastType broadcastType;

    @Column(name = "expires_at")
    private Date expiresAt;

    @ManyToOne
    @JoinColumn(name = "target_type_id")
    private BroadcastTargetType targetType;

    @OneToMany(mappedBy = "broadcast", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BroadcastDocuments> documents;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

    @NotNull
    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;
}
