package in.hrms.core.entity.organization;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.configuration.*;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "organization_details")
public class OrganizationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Registration number is mandatory")
    @Column(name = "registration_no")
    private String registrationNo;

    @NotBlank(message = "GST number is mandatory")
    @Column(name = "gst_no", length = 15)
    private String gstNo;

    @NotBlank(message = "CIN number is mandatory")
    @Column(name = "cin_no", length = 21)
    private String cinNo;

    @NotBlank(message = "PAN number is mandatory")
    @Column(name = "pan_no", length = 10)
    private String panNo;

    @Email(message = "Invalid mail Id")
    private String email;

    @NotBlank(message = "Mobile no is mandatory")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile no must be 10 digit")
    @Column(name = "mobile_no", length = 10, nullable = false, unique = true)
    private String mobileNo;

    @Column(name = "website")
    private String website;

    @NotBlank(message = "Address is mandatory")
    private String address;

    /*@ManyToOne
    @NotNull(message = "City is mandatory")
    @JoinColumn(name = "city_id")
    private Cities city;*/

    @NotBlank(message = "City Name is mandatory")
    @Column(name = "city")
    private String city;

    @ManyToOne
    @NotNull(message = "District is mandatory")
    @JoinColumn(name = "district_id")
    private Districts district;

    @ManyToOne
    @NotNull(message = "State is mandatory")
    @JoinColumn(name = "state_id")
    private States state;

    @ManyToOne
    @NotNull(message = "Country is mandatory")
    @JoinColumn(name = "country_id")
    private Countries country;

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

    @OneToMany(mappedBy = "organizationDetail")
    private List<OrganizationDocuments> documents;

}
