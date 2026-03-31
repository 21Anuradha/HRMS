package in.hrms.core.enums;

public enum AttendanceSource {
    BIOMETRIC,     // From machine (fingerprint, RFID, face recognition)
    MOBILE_APP,    // GPS + selfie attendance
    WEB_PORTAL,    // Employee self-service
    ADMIN_MANUAL,  // HR/admin correction
}