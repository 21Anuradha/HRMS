package in.hrms.core.util;


public class CustomResponseStatusCode {

    private CustomResponseStatusCode() {
        throw new IllegalStateException("Utility Class");
    }

    public static final int SUCCESS = 2000;
    public static final int SUCCESS_ONLY = 35000;
    public static final int PROCESSING = 1172;
    public static final int FAIL = 9000;
    public static final int SOMETHING_WENT_WRONG = 2023;
    public static final int INTERNAL_SERVER_ERROR = 2005;
    public static final int EXCEPTION_OCCURRED = 2009;
    public static final int DEFAULT_RESPONSE = 2011;
    public static final int INVALID_CREDENTIAL = 2001;
    public static final int UNAUTHORISED_USER = 2002;
    public static final int INVALID_TOKEN = 2006;
    public static final int UNAUTHORIZED_IP = 2010;
    public static final int UNAUTHORISED_ACCESS = 2020;
    public static final int ACCESS_TOKEN_CHANGED = 2022;
    public static final int ACCOUNT_INACTIVE = 2026;
    public static final int ACCOUNT_TEMPORARILY_BLOCKED = 1173;
    public static final int INVALID_OLD_PASSWORD = 3007;
    public static final int OTP_EXPIRED = 8000;
    public static final int INVALID_OTP = 2013;
    public static final int USER_NOT_FOUND = 2007;
    public static final int INVALID_USER = 2031;
    public static final int TARGET_USER_NOT_FOUND = 2028;
    public static final int CUSTOMER_ALREADY_EXIST = 3005;
    public static final int CREDENTIAL_ALREADY_EXISTS = 1174; 
    public static final int MOBILE_ALREADY_EXISTS = 102;
    public static final int MAIL_ALREADY_EXISTS = 101;
    public static final int BOTH_MOBILE_AND_MAIL_ALREADY_EXISTS = 100;
    public static final int PAN_ALREADY_EXISTS = 103;
    public static final int BAD_REQUEST = 2004;
    public static final int INSUFFICIENT_DATA = 2008;
    public static final int DUPLICATE_DATA = 2024;
    public static final int INSERTION_FAIL = 2014;
    public static final int UPDATE_FAIL = 2025;
    public static final int EMPTY_FILE = 2019;
    public static final int IMAGE_UPLOAD_ERROR = 5003;
    public static final int NOT_FOUND = 2003;
    public static final int NO_RESULT_FOUND = 2030;
    public static final int INSUFFICIENT_WALLET_BALANCE = 2015;
    public static final int INSUFFICIENT_BALANCE = 5001;
    public static final int REQUESTED_AMOUNT_GREATERTHAN_AVAILABLE_AMOUNT = 2017;
    public static final int AVAILABLE_LIMIT_REACHED = 1171;
    public static final int GIFT_CARD_MAX_AMT_LIMIT = 5004;
    public static final int PARENT_USER_WALLET_NOT_ACTIVE = 2029;
    public static final int CHILD_USER_WALLET_NOT_ACTIVE = 3000;
    public static final int BUSINESS_ENTITY_NOT_AVAILABLE = 2027;
    public static final int DURATION_EXPIRED = 3008;
    public static final int NOT_ELIGIBLE = 3002;
    public static final int ELIGIBLE = 3003;
    public static final int CONTENT_MISMATCH = 5002;
    

}