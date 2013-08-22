package com.standardstate.gravatar4j;

import java.security.MessageDigest;

/**
 * TAKEN FROM http://en.gravatar.com/site/implement/images/java/
 */
public class MD5Util {

    private static final int MAGIC_0xFF = 0xFF;
    private static final int MAGIC_0x100 = 0x100;
    private static final int MAGIC_3 = 3;
    private static final int MAGIC_1 = 1;

    /**
     * TAKEN FROM http://en.gravatar.com/site/implement/images/java/
     */
    public static String hex(final byte[] array) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & MAGIC_0xFF) | MAGIC_0x100).substring(MAGIC_1, MAGIC_3));
        }
        return sb.toString();
    }
    
    /**
     * TAKEN FROM http://en.gravatar.com/site/implement/images/java/
     */
    public static String md5Hex(final String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            return hex (md.digest(message.getBytes("CP1252")));
        } catch (Exception e) {
            throw new Gravatar4JException(e);
        }
    }
    
}
