package ra.validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {

    public static String validateStudentId(String id) {
        String pattern = "SV\\d{5}";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(id);

        if (matcher.matches()) {
            return id;
        } else {
            return null;
        }
    }

    public static String validateStudentName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            return name;
        } else {
            return null;
        }
    }

    public static Date validateBirthDay(String birthDay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(birthDay);
        } catch (ParseException e) {
            return null;
        }
    }

    public static String validatePhoneNumber(String phoneNumber) {
        String pattern = "0\\d{9}";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(phoneNumber);

        if (matcher.matches()) {
            return phoneNumber;
        } else {
            return null;
        }
    }

    public static String validateEmail(String email) {
        String pattern = "^[A-Za-z0-9+_.-]+@gmail\\.com$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(email);

        if (matcher.matches()) {
            return email;
        } else {
            return null;
        }
    }

    public static String validateMajor(String major) {
        if (major != null && !major.trim().isEmpty()) {
            return major;
        } else {
            return null;
        }
    }

    public static String validateClassName(String className) {
        if (className != null && !className.trim().isEmpty()) {
            return className;
        } else {
            return null;
        }
    }

    public static Float validateGPA(String gpa) {
        try {
            float gpaFloat = Float.parseFloat(gpa);
            if (gpaFloat >= 0) {
                return gpaFloat;
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Byte validateStatus(String status) {
        try {
            byte statusByte = Byte.parseByte(status);
            if (statusByte >= 1 && statusByte <= 3) {
                return statusByte;
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }
}