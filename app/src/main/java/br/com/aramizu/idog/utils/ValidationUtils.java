package br.com.aramizu.idog.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidationUtils {

    private static final String TAG = "ValidationsUtils";

    public static final String EMAIL_FIELD_VALIDATION = "email";
    public static final String LENGTH_6_FIELD_VALIDATION = "len6";
    public static final String LENGTH_8_FIELD_VALIDATION = "len8";
    public static final String LENGTH_12_FIELD_VALIDATION = "len12";

    private ValidationUtils() {
        // This utility class is not publicly instantiable
    }

    public static boolean isEmailValid(String email) {
        Pattern pattern;
        Matcher matcher;
        String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
