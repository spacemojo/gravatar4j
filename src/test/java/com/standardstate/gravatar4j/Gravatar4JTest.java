package com.standardstate.gravatar4j;

import org.junit.Test;
import static org.junit.Assert.*;

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
 */
public class Gravatar4JTest {

    private final static String TEST_EMAIL = "MyEmailAddress@example.com ";
    private final static String TEST_HASH = "0bc83cb571cd1c50ba6f3e8a78ef1346";

    @Test
    public void createURLWithInstanceTest01() {
        
        final Gravatar4J g4j = new Gravatar4J(TEST_EMAIL);

        // create default url
        assertEquals("createURLWithInstanceTest", TEST_EMAIL, g4j.getEmail());

    }

    @Test
    public void createURLTest() {
        
        final String url = Gravatar4J.createURL(TEST_EMAIL);
        assertEquals("createURLTest", "http://www.gravatar.com/avatar/" + TEST_HASH, url);
        
    }
    
}
