package in.hrms.core.entity.employee;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.hrms.core.entity.configuration.BankAccountTypes;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_banking_details")
public class EmployeeBankingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee should not be null")
    @JoinColumn(name = "employee_id")
    private Employees employee;

    @Column(name = "acc_holder_name")
    private String accountHolderName;

    @NotBlank(message = "Bank name is mandatory")
    @Column(name = "bank_name")
    private String bankName;

    @NotBlank(message = "Branch name is mandatory")
    @Column(name = "branch_name")
    private String branchName;

    @NotBlank(message = "Account number is mandatory")
    @Column(name = "account_no")
    private String accountNo;

    @NotBlank(message = "IFSC/SWIFT code  is mandatory")
    @Column(name = "ifsc_swift_code")
    private String ifscCode;

    @ManyToOne
    @JoinColumn(name = "bank_acc_type_id")
    @NotNull(message = "Bank account is mandatory")
    private BankAccountTypes bankAccountType;

    @Column(name = "upi_id", length = 50)
    private String upiId;

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
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

    @OneToMany(mappedBy = "empBankingDetails")
    private List<EmployeeBankingDocuments> bankingDocuments;

}
