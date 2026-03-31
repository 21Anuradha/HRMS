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
@Table(name = "product_configuration")
public class ProductConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Product name must not be blank")
    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @NotNull(message = "Product logo should not be null")
    private String logo;

    @NotBlank(message = "Product version must not be blank")
    @Column(name = "version", nullable = false, length = 20)
    private String version;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "merchant_code", nullable = false)
    private String merchantCode;

    @Column(name = "merchant_url", nullable = false)
    private String merchantUrl;

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

}
