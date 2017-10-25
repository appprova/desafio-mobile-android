package com.app.desafio_mobile_android.intrastructure;

public class Constants {

    public static final String ABOUT_URL = "https://www.linkedin.com/in/selem-afonso-a0b75a8";
    public static final String BASE_API = "https://api.github.com/";
    public enum ErrorType {
        NETWORK_ERROR, SERVICE_ERROR, GENERIC_ERROR, CUSTOM_ERROR
    }

    public static class DatePattern {
        public static final String DATE_ENGLISH = "yyyy-MM-dd'T'HH:mm:ss";
        public static final String DEFAULT_FORMAT = "MM/dd/yyyy hh:mm:ss aa";
    }
}
