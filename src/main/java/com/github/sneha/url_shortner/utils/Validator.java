package com.github.sneha.url_shortner.utils;

import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidUrl(String url){
        try {
            new URL(url).toURI();
            Pattern pattern = Pattern.compile(Constants.URL_PATTERN);
            Matcher matcher = pattern.matcher(url);
            return matcher.matches();
        } catch (Exception e) {
            return false;
        }
    }
}
