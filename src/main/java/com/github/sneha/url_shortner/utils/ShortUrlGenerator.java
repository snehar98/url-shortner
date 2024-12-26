package com.github.sneha.url_shortner.utils;

import java.util.Random;

/**
 * Utility class for generating random short URLs.
 * This class provides a method to generate a unique short URL from a predefined character set.
 * The generated short URL is a random alphanumeric string of a specified length.
 *
 * @author sneharavikumartl
 */
public class ShortUrlGenerator {

    // Characters that can be used in the generated short URL
    private static final String CHARSET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // The length of the short URL. You can modify this value if needed.
    private static final int SHORT_URL_LENGTH = 10;

    /**
     * Generate a random short URL.
     *
     * This method generates a random alphanumeric string of length SHORT_URL_LENGTH
     * using a predefined character set.
     *
     * @return a random alphanumeric string of length SHORT_URL_LENGTH
     */
    public static String generateShortUrl() {
        Random random = new Random();  // Random generator to pick characters
        StringBuilder shortUrl = new StringBuilder(SHORT_URL_LENGTH);  // StringBuilder to build the short URL

        // Loop to generate each character of the short URL
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(CHARSET.length());  // Pick a random index from the character set
            shortUrl.append(CHARSET.charAt(index));  // Append the character to the short URL
        }

        // Return the generated short URL as a string
        return shortUrl.toString();
    }
}
