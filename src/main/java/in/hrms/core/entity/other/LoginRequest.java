package in.hrms.core.entity.other;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import in.hrms.core.entity.employee.Users;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login_request")
public class LoginRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User should not be null")
    private Users user;

    //remove this column
    @Column(name = "mobile_no")
    //@NotNull(message = "Mobile no is mandatory")
    private String mobileNo;

    @Column(name = "login_id")
    @NotNull(message = "Login Id is mandatory")
    private String loginId;

    @Column(name = "is_logged_in", columnDefinition = "TINYINT(1) DEFAULT 0")
    private boolean isLoggedIn;

    @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
    @Column(name = "ip_address")
    private String ipAddress;

    @CreationTimestamp
    @Column(name = "created_on", nullable = false, updatable = false)
    private Date createdOn;
}
