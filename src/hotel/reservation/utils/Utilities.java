package hotel.reservation.utils;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
    public  static  final String DATE_FORMATER = "dd/MM/yyyy";

    public static  boolean isValidNumber(String str) {
        Pattern numberPattern = Pattern.compile(PatternsString.NUMBER_PATTERN);
        Matcher numberMatcher = numberPattern.matcher(str);

        return numberMatcher.find();
    }

    public  static  boolean isValidEmail(String str) {
        Pattern emailPattern = Pattern.compile(PatternsString.EMAIL_PATTERN);
        Matcher emailMatcher = emailPattern.matcher(str);

        return emailMatcher.find();
    }

    public static  boolean isValidDateStringSlashSeparated(String str) {
        Pattern numberPattern = Pattern.compile(PatternsString.DATE_SLASH_PATTERN);
        Matcher numberMatcher = numberPattern.matcher(str);

        return numberMatcher.find();
    }

    public static  boolean isValidDouble(String str){
        Pattern doublePattern = Pattern.compile(PatternsString.DOUBLE_NUMBER_FORMAT);
        Matcher doubleMatcher = doublePattern.matcher(str);

        return doubleMatcher.find();
    }

    public static SimpleDateFormat getDateFormatter() {
        return new SimpleDateFormat(DATE_FORMATER);

    }
}
