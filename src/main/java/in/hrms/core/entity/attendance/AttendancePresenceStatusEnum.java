package in.hrms.core.entity.attendance;

public enum AttendancePresenceStatusEnum {
    PRESENT,       // Worked full/required hours
    ABSENT,        // No attendance
    ON_LEAVE,      // Approved leave (paid/unpaid depends on leave policy)
    HOLIDAY,       // Company-declared holiday
    WEEK_OFF,      // Weekly off (e.g., Sunday)
    HALF_DAY  //Half Day
}