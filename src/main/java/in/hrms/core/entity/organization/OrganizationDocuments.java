package in.hrms.core.entity.organization;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization_documents")
public class OrganizationDocuments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "organization_details_id")
    private OrganizationDetails organizationDetail;

    @OneToOne
    @JoinColumn(name = "logo")
    private Documents logo;

    @OneToOne
    @JoinColumn(name = "pan")
    private Documents pan;

    @OneToOne
    @JoinColumn(name = "gst")
    private Documents gst;

    @OneToOne
    @JoinColumn(name = "cin")
    private Documents cin;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 0", nullable = false)
    private boolean isActive;

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
