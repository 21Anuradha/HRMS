package in.hrms.core.dto.employee;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEmergencyContactDetailsReqDto {

    @NotNull(message = "EmployeeId is mandatory")
    private Long employeeId;

    @NotNull(message = "Emergency Contact Relationship Id is mandatory")
    private Long emergencyContactRelationshipId;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Contact Number is mandatory")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile no must be 10 digit")
    @Column(name = "contact_no", nullable = false)
    private String contactNo;

    private String address;

    private Long createdBy;

    private Long updatedBy;

}

