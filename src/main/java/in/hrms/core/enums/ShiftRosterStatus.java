package in.hrms.core.enums;

public enum ShiftRosterStatus {
    ASSIGNED,   // Default – shift assigned to employee
    SWAPPED,    // Shift swapped with another employee
    CANCELLED,  // Cancelled (maybe due to leave or holiday)
    COMPLETED,  // Employee attended and completed shift
    MISSED ,     // Employee absent without approval
    WEEK_OFF,
    HOLIDAY
}