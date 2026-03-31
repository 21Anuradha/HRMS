package in.hrms.core.enums;

public enum AttendancePunchTypeEnum {
    CHECK_IN,      // First entry into workplace
    CHECK_OUT,     // Final exit from workplace
    BREAK_OUT,     // Start of a break (lunch/tea/personal)
    BREAK_IN,      // End of a break
    OVERTIME_IN,   // Extra work start
    OVERTIME_OUT,  // Extra work end
    MANUAL_ENTRY   // HR/Admin inserted entry
}