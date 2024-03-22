package com.mekadspace.HospitalManagement.config;

public class ConstantUtils {
    public static final String REGEXP_MOBILE_PATTERN = "[0-9]{10}";
    public static final String REGEXP_ALPHABET_ONLY_NOT_NULL = "^[a-zA-Z ]+$";
    public static final String REGEXP_ALPHABET_ONLY_ALLOW_NULL = "^[A-Za-z]*$";
    public static final String REGEXP_NUMBERS_ONLY = "^[0-9]+$";
    public static final String REGEXP_ZERO_OR_ONE = "^[01]*$";
    public static final String REGEXP_USERNAME = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
    public static final String REGEXP_ALPHABET_ONLY_WITH_SPACE = "^[A-Za-z\\s]+$";
    public static final String REGEXP_ALPHABET_ONLY_WITH_SPACE_AND_UNDERSCORE = "^[a-zA-Z_ ]$";
//    public static final String REGEXP_ADDRESS = "^[a-zA-Z\s0-9,.&()#@]$";
    public static final String REGEXP_SHORT_CODE = "^[a-zA-Z0-9\\-.]$";
    public static final String REGEXP_NUMBERS_ONLY_ALLOW_NULL = "^[0-9]*$";
}