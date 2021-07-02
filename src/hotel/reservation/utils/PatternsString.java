package hotel.reservation.utils;

public class PatternsString {
    public static final String EMAIL_PATTERN = "^(.+)@(.+).(.+)$";
    public static final String NUMBER_PATTERN = "^[0-9]*$";
    public static final String DATE_SLASH_PATTERN = "^([0-9]{2})\\/([0-9]{2})\\/([0-9]{4})$"; //date formate is  (mm/dd/yyyy)
    public static final String DOUBLE_NUMBER_FORMAT = "^([1-9])([0-9]*)(\\.{1})*([0-9]+)*$";
}
