package in.hrms.core.entity.other;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import in.hrms.core.entity.configuration.OtpRequestType;

import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "otp")
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "otp_req_type_id")
    @NotNull(message = "Otp Request Type is null")
    private OtpRequestType otpRequestType;

    @NotNull(message = "OTP is mandatory")
    private String otp;

    @NotNull(message = "Mobile No should not be empty")
    @Column(name = "mobile_no", nullable = false)
    private String mobileNo;

    @NotNull(message = "Reference should not be null")
    private Long reference;

    @Column(name = "is_active", columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "created_on", updatable = false, nullable = false)
    private Date createdOn;
}
