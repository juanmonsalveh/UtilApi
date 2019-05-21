package com.utilapi.util;

import org.apache.commons.validator.routines.EmailValidator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author esalcedo
 */
public class Validator extends RegularExpressionUtil{

    public Boolean validateEmail(String email) {
        EmailValidator validator = EmailValidator.getInstance();
        if (email.trim() != null && !email.trim().isEmpty()) {
            if (validator.isValid(email)) {
                String[] div=email.trim().split("@")[1].split("\\.");
                if(div.length>4) {
                    return Boolean.FALSE;
                }
                return (email.trim().length() <= Regex.EMAIL.getMax());
            } else {
                return Boolean.FALSE;
            }
        } else {
            return Boolean.FALSE;
        }
    }

    public Boolean validateAlpha(String value) {
        if (value.trim() != null && !value.trim().isEmpty()) {
            return value.trim().matches("([" + Regex.ALPHA.getValue() + "]){" + Regex.ALPHA.getMin() + "," + Regex.ALPHA.getMax() + "}");
        } else {
            return Boolean.FALSE;
        }
    }

    public Boolean validateAlphaNumeric(String value) {
        if (value.trim() != null && !value.trim().isEmpty()) {
            return value.trim().matches("([" + Regex.ALPHA_NUMERIC.getValue() + "]){" + Regex.ALPHA_NUMERIC.getMin() + "," + Regex.ALPHA_NUMERIC.getMax() + "}");
        } else {
            return Boolean.FALSE;
        }
    }

    public Boolean validatePhone(String phone) {
        if (phone.trim() != null && !phone.trim().isEmpty()) {
            return phone.trim().matches("([" +  Regex.PHONE.getValue() + "]){" + Regex.PHONE.getMin() + "," + Regex.PHONE.getMax() + "}");
        } else {
            return Boolean.FALSE;
        }
    }

    public Boolean validatePassword(String password) {
        if (password.trim() != null && !password.trim().isEmpty()) {
            int matches = runTest( Regex.PASSWORD.getValue() + "{" + Regex.PASSWORD.getMin() + "," + Regex.PASSWORD.getMax() + "}$", password);
            return (matches > 0);
        } else {
            return Boolean.FALSE;
        }
    }

    private static int runTest(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int matches = 0;
        while (matcher.find()) {
            matches++;
        }
        return matches;
    }

    public Boolean isNotNull (Object o) {
        return (o != null);
    }

    public Boolean validateISOCurrency(String currencyIso) {
        if (currencyIso != null && !currencyIso.isEmpty()) {
            return currencyIso.matches("([" + Regex.ISO_CURRENCY.getValue() + "]){" + Regex.ISO_CURRENCY.getMax() + "}");
        } else {
            return Boolean.FALSE;
        }
    }


    public Boolean validateIP(String ip) {
        if (ip != null && !ip.isEmpty()) {
            return ip.matches(Regex.IP.getValue());
        } else {
            return Boolean.FALSE;
        }
    }

    public Boolean validateNumeric(String number) {
        if (number != null && !number.isEmpty()) {
            return number.matches(Regex.NUMERIC.getValue());
        } else {
            return Boolean.FALSE;
        }
    }
}
