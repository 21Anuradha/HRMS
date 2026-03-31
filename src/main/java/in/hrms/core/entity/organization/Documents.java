package in.hrms.core.entity.organization;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.configuration.DocumentTypes;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documents")
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_name")
    @NotNull(message = "File name should not be null")
    private String fileName;

    @Column(name = "file_path")
    @NotNull(message = "File path should not be null")
    private String filePath;

    private String version;

    @Column(name = "file_type")
    private String fileType;

    private String description;

    @ManyToOne
    @JoinColumn(name = "document_type_id")
    @NotNull(message = "Document type should not be null")
    private DocumentTypes documentType;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "is_verified", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isVerified;

    @Column(name = "is_active", columnDefinition = "boolean default true")
    private boolean isActive = true;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Date updatedOn;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "updated_by", nullable = false)
    private Long updatedBy;

}
