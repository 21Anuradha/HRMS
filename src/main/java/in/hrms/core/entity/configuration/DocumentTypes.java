package in.hrms.core.entity.configuration;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "document_types")
public class DocumentTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Document name is mandatory")
    private String name;

    private String description;

    @ManyToOne
    @NotNull(message = "Document category is mandatory")
    @JoinColumn(name = "document_category_id")
    private DocumentCategories documentCategory;

    @Column(name = "is_mandatory", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean isMandatory;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive;

}
