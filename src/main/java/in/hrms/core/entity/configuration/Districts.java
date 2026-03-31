package in.hrms.core.entity.configuration;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "districts")
public class Districts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "State is mandatory")
    @JoinColumn(name = "state_id")
    private States state;

    @NotBlank(message = "District name is mandatory")
    private String name;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive;
}