package in.hrms.core.entity.broadcast;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "broadcast_target")
public class BroadcastTarget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//    @ManyToOne
//    @JoinColumn(name = "broadcast_id")
//    @NotNull(message = "Broadcast is mandatory")
//    private Broadcasts broadcasts;

    @ManyToOne
    @JoinColumn(name = "broadcast_target_type_id")
    private BroadcastTargetType broadcastTargetType;

    private String description;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive;

}
