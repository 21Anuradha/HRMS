package in.hrms.core.entity.broadcast;

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
