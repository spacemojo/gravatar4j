package com.standardstate.gravatar4j;

/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2013 Fred Leclerc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author Fred Leclerc
 * @version 1.0
 *
 * Reference : http://en.gravatar.com/site/implement/images/ 
 * 
 */
public class Gravatar4J {

    // http://www.gravatar.com/avatar/00000000000000000000000000000000?s=12&d=http://jsonlint.com/c/images/logo_arc90.png
    // String url = "http://example.com/query?q=" + URLEncoder.encode("random word £500 bank $", "ISO-8859-1"); // Or "UTF-8"
    
    private final static String PARAMETER_DEFAULT = "d";
    private final static String PARAMETER_FORCE_DEFAULT = "f";
    private final static String FORCE_DEFAULT_YES = "y";
    private final static String FORCE_DEFAULT_NO = "n";

    public final static String DEFAULT_404 = "404";
    public final static String DEFAULT_MYSTERY_MAN = "mm";
    public final static String DEFAULT_IDENTICON = "identicon";
    public final static String DEFAULT_MONSTERID = "monsterid";
    public final static String DEFAULT_WAVATAR = "wavatar";
    public final static String DEFAULT_RETRO = "retro";
    public final static String DEFAULT_BLANK = "blank";
    
    private final static String PARAMETER_SIZE = "s";
    private final static int SIZE_DEFAULT = 80;
    private final static int SIZE_MAX = 2048;
    private final static int SIZE_MIN = 1;

    private final static String PARAMETER_RATING = "r";
    public final static String RATING_G = "g";
    public final static String RATING_PG = "pg";
    public final static String RATING_R = "r";
    public final static String RATING_X = "x";

    private final static String EXTENSION_JPG = "jpg";
    private final static String EXTENSION_PNG = "png";
        
    private final static String GRAVATAR_URL_PREFIX = "http://www.gravatar.com/avatar/";
    private final static String GRAVATAR_SECURE_URL_PREFIX = "https://secure.gravatar.com/avatar/";

    private String email = null;
    private String defaultImage = null;
    private String forceDefault = FORCE_DEFAULT_NO;
    private int size = SIZE_DEFAULT;
    private String rating = RATING_G;
    private String extension = null;
    private boolean https = false;

    public Gravatar4J(final String email) {
        this.email = email;
    }

    public String createURL() {
        return (this.https) ? GRAVATAR_SECURE_URL_PREFIX : GRAVATAR_URL_PREFIX + MD5Util.md5Hex(email.trim().toLowerCase()) + createQueryString();
    }

    public String createQueryString() {

        final StringBuilder builder = new StringBuilder("?");
        
        builder.append(createSizeParameterAndValue());
        
        return builder.toString();

    }
    
    public String createSizeParameterAndValue() {
        return "s=" + this.size;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(final String defaultImage) {
        this.defaultImage = defaultImage;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(final String extension) {
        this.extension = extension;
    }

    public String getForceDefault() {
        return forceDefault;
    }

    public void setForceDefault(final String forceDefault) {
        this.forceDefault = forceDefault;
    }

    public boolean isHttps() {
        return https;
    }

    public void setHttps(final boolean https) {
        this.https = https;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(final String rating) {
        this.rating = rating;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    /**
     * The quick and easy way to get started, this produces the url with all default
     * parameters with the passed email. If there is no image related to the passed
     * email, the default gravatar image will be displayed instead.
     *
     * @param email The email used to produce the url
     * @return The url to fetch the image
     */
    public static String createURL(final String email) {
        return GRAVATAR_URL_PREFIX + MD5Util.md5Hex(email.trim().toLowerCase());
    }
    
}
