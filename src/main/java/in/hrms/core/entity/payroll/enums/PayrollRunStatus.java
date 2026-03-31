package in.hrms.core.entity.payroll.enums;

public enum PayrollRunStatus {
    DRAFT,        // created but not processed
    CALCULATED,   // calculations done
    APPROVED,     // approved by HR/Finance
    PAID,         // salaries disbursed
    REVERSED      // payroll reversed/cancelled
}