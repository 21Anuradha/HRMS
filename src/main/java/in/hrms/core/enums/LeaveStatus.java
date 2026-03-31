package in.hrms.core.enums;

public enum LeaveStatus {
    PENDING,        // Awaiting approval
    APPROVED,       // Leave approved by manager/HR
    REJECTED,       // Leave rejected
    CANCELLED,      // Cancelled by employee or admin
    TAKEN,          // Leave taken (optional, useful for payroll)
    LAPSED          // Leave not used and expired (e.g., for Casual Leave)
}