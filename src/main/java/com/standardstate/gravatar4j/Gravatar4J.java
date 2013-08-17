package com.standardstate.gravatar4j;

import java.security.MessageDigest;

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
    private final static String RATING_G = "g";
    private final static String RATING_PG = "pg";
    private final static String RATING_R = "r";
    private final static String RATING_X = "x";

    private final static String JPG = "jpg";
    private final static String PNG = "png";
        
    private final static String GRAVATAR_URL_PREFIX = "http://www.gravatar.com/avatar/";
    private final static String GRAVATAR_SECURE_URL_PREFIX = "https://secure.gravatar.com/";
    
    private String defaultImage = null;
    private int size = SIZE_DEFAULT;

    public Gravatar4J() { }

    public static String getURL(final String email) {        
        return GRAVATAR_URL_PREFIX + MD5Util.md5Hex(email.trim().toLowerCase());
    }
    
}
