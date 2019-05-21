package com.utilapi.util;

/**
 * @author esalcedo
 */

public class RegularExpressionUtil {

    public enum Regex {
        EMAIL("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", 256),
        ALPHA("A-Za-z\\s", 1, 100),
        ALPHA_NUMERIC("A-Za-z0-9\\s", 3, 100),
        PASSWORD("^[A-Za-z0-9\\d@$!%*?&.#]", 6, 20),
        //PASSWORD("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&.#])[A-Za-z\\d@$!%*?&.#]", 8, 20),
        PHONE("[0-9]", 7, 15),
        ISO_CURRENCY("A-Z",3),
        IP("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$"),
        NUMERIC("\\d{1,}");

        private String value;
        private int min;
        private int max;

        Regex(String value, int min, int max) {
            this.value = value;
            this.min = min;
            this.max = max;
        }

        Regex(String value, int max) {
            this.value = value;
            this.max = max;
        }

        Regex(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }

}
