package in.hrms.core.entity.broadcast;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "broadcast_target_type")
public class BroadcastTargetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Broadcast target type name is mandatory")
    private String name;

    private String description;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "targetType")
    private List<Broadcasts> broadcasts;

}
