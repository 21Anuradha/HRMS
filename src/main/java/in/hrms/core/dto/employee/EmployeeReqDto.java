package in.hrms.core.dto.employee;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import in.hrms.core.enums.GenderEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeReqDto {

    @NotNull(message = "Employee status id is mandatory")
    private Integer employeeStatusId;

    @NotBlank(message = "First Name is Mandatory")
    private String firstName;

    private String middleName;

    private String lastName;

    @NotNull(message = "Blood Group Id is mandatory")
    private Long bloodGroupId;

    @NotBlank(message = "Mobile No is Mandatory")
    private String mobileNo;

    @NotBlank(message = "Personal Mail Id is Mandatory")
    private String personalMailId;

    private String homePhone;

    @NotNull(message = "Gender is Mandatory")
    private GenderEnum gender;

    @NotNull(message = "Date Of Birth Mandatory")
    private Date dateOfBirth;

    @NotBlank(message = "Aadhar No is Mandatory")
    private String aadharNo;

    @NotBlank(message = "Pan No is Mandatory")
    private String panNo;

    @NotNull(message = "Emergency Contact Information is required")
    private List<EmployeeEmergencyContactDetailsReqDto> contactDetailsReqDto;
    private Long createdBy;

    private Long updatedBy;
}

