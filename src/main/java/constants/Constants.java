package constants;

public class Constants {
    public static class Urls{
        public static final String LOGIN_PAGE = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        public static final String DASHBOARD_PAGE =
                "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        public static final String ADD_EMPLOYEE_PAGE =
                "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee";
    }

    public static class UserCredentials{
        public static final String VALID_LOGIN = "Admin";
        public static final String VALID_PASSWORD = "admin123";
    }

    public static class UsersUpdatedPersonalInfo {
        public static final String NEW_FIRST_NAME = "Name_upd";
        public static final String NEW_LAST_NAME = "LastName_upd";

    }

    public static class ValidationMassages {
        public static final String REQUIRED = "Required";
        public static final String INVALID_CREDENTIALS = "Invalid credentials";
        public static final String DATA_UPDATED_CONFIRMATION_POPUP = "Success\n Successfully Updated";
        public static final String DATA_SAVED_CONFIRMATION_POPUP = "Success\n Successfully Saved";
        public static final String RECORDS_FOUND = "(1) Record Found";
    }

    public static class DatePatterns {
        public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd";
    }

    public static class LengthOfGeneratedRandomValues {
        public static final int DRIVER_LICENSE_NUMBER_LENGTH = 8;
        public static final int USER_FIRST_NAME_LENGTH = 5;
        public static final int USER_LAST_NAME_LENGTH = 8;
        public static final int USER_ID_LENGTH = 8;
        public static final int USER_USER_NAME_LENGTH = 8;
    }

}
