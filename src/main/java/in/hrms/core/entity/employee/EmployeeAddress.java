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

import in.hrms.core.entity.configuration.*;

import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_address")
public class EmployeeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @NotNull(message = "Employee is mandatory")
    @JoinColumn(name = "employees_id")
    private Employees employees;

    @Column(name = "house_no")
    @NotBlank(message = "House No is mandatory")
    private String houseNo;

    @NotBlank(message = "Street is mandatory")
    private String street;

    private String locality;

    @NotBlank(message = "Landmark is mandatory")
    private String landmark;

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
    @NotNull(message = "Address type is mandatory")
    @JoinColumn(name = "address_type_id")
    private AddressType addressType;

    @ManyToOne
    @NotNull(message = "Country is mandatory")
    @JoinColumn(name = "country_id")
    private Countries country;

    @NotBlank(message = "Pincode is mandatory")
    @Column(name = "pin_code", length = 6)
    private String pinCode;

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

    @Column(name = "is_active", columnDefinition = "boolean default true", nullable = false)
    private boolean isActive;

}
