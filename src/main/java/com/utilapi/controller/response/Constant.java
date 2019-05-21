package com.utilapi.controller.response;

/**
 * Created by dagomanzano on 15/01/18.
 */
public class Constant {
    //public static final String DID7_SERVICES_PATH = "http://10.1.13.106:8080/detect/services";
    public static final String DID7_SERVICES_PATH = "http://34.199.54.182:8080/detect/services";

    public static final String success = "All went well, and (usually) some data was returned";
    public static final String fail = "There was a problem with the data submitted, or some pre-condition of the API call wasn't satisfied";
    public static final String error = "An error occurred in processing the request, i.e. an exception was thrown";
    public static final String delimitator = "_";
    public static final String successfulCreation = "Successful creation";
    public static final String unableToCreate = "Unable to create. The client with this Shared Key already exists";

    public static final String invalidParameter = "Invalid parameter";
    public static final String emptyParameter = "Null or empty parameter";
    public static final String serverErrorr = "Server error. A serious error occurred in the server or there was a communication problem between the application and server.";

    // DEVICE REGISTRATION
    public static final String EMAIL_DEVICE_REGISTRATION_SENT = "A registration email has been sent";
    public static final String EMAIL_DEVICE_REGISTRATION_SUBJECT = "Vault Bank device registration";
    public static final String EMAIL_THREAD_SENDER_ERROR = "Error while sending registration email";
    public static final String EMAIL_SETTING_PARAMETERS_ERROR = "Error while setting email parameters";
    public static final String USER_REGISTER_SUCCESSFUL = "registerUser_successful.vm";
    public static final String USER_REGISTER_FAIL = "registerUser_Failed.vm";

    public static final int GENERAL_DID_SUCCESS_CODE = 1020;
    public static final int DID_CLIENT_SUCCESSFULLY_REMOVED = 502;
    public static final int DID_CLIENT_ALREADY_EXISTS = 504;
    public static final int PUSH_SERVICE_SUCCESSFULLY_SENT = 938;

    // DID7 Endpoints
    public static final String PUSH_SERVICE = "/WSDetectPushAuthService";
    public static final String FACE_ENROLLMENT_SUBJECT = "Face Enrollment";
    public static final String FACE_ENROLLMENT_MESSAGE = "Tap to enroll your face as an Authentication Factor";
    public static final String FACE_AUTHENTICATION_SUBJECT = "Face Enrollment";

}
