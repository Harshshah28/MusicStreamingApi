package com.geekster.MusicStreamingApi.Utils;

import java.util.regex.Pattern;

public class Validation {

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }


    public static boolean isValidPhoneNumber(String phoneNumber) {
        if(phoneNumber.length()!=10) { return false; }

        else {
            for(char c:phoneNumber.toCharArray()) {
                if(!(c>=48 && c<=57))
                    return false;
            }
            return true;
        }
    }
}