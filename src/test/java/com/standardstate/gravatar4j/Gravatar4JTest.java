package com.standardstate.gravatar4j;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Test
    public void createURLWithInstanceTest01() {
        
        final Gravatar4J g4j = new Gravatar4J(TEST_EMAIL);

        // create default url
        assertEquals("createURLWithInstanceTest -> email", TEST_EMAIL, g4j.getEmail());

        // size parameter
        assertEquals("createURLWithInstanceTest -> size", g4j.createSizeParameterAndValue(), "s=80");
        g4j.setSize(120);
        assertEquals("createURLWithInstanceTest -> size", g4j.createSizeParameterAndValue(), "s=120");
        
        
        
    }

    @Test
    public void createSizeParameterAndValueTest() {

        final Gravatar4J g4j = new Gravatar4J(TEST_EMAIL);

        // size parameter
        assertEquals("createURLWithInstanceTest -> size", g4j.createSizeParameterAndValue(), "s=80");
        g4j.setSize(120);
        assertEquals("createURLWithInstanceTest -> size", g4j.createSizeParameterAndValue(), "s=120");

        exception.expect(RuntimeException.class);
        g4j.setSize(0);
        g4j.createSizeParameterAndValue();

        exception.expect(RuntimeException.class);
        g4j.setSize(-1);
        g4j.createSizeParameterAndValue();
        
        exception.expect(RuntimeException.class);
        g4j.setSize(2049);
        g4j.createSizeParameterAndValue();
        
    }
    
    @Test
    public void createForceDefaultParameterAndValueTest() {

        final Gravatar4J g4j = new Gravatar4J(TEST_EMAIL);
        
        // force default parameter
        assertEquals("createForceDefaultParameterAndValue -> default", "f=n", g4j.createForceDefaultParameterAndValue());
        
        g4j.setForceDefault("");
        exception.expect(RuntimeException.class);
        g4j.createForceDefaultParameterAndValue();
        
        g4j.setForceDefault(null);
        exception.expect(RuntimeException.class);
        g4j.createForceDefaultParameterAndValue();
        
        g4j.setForceDefault("t");
        exception.expect(RuntimeException.class);
        g4j.createForceDefaultParameterAndValue();
        
        g4j.setForceDefault(Gravatar4J.FORCE_DEFAULT_YES);
        assertEquals("createForceDefaultParameterAndValue -> default", "f=y", g4j.createForceDefaultParameterAndValue());
        
        g4j.setForceDefault(Gravatar4J.FORCE_DEFAULT_NO);
        assertEquals("createForceDefaultParameterAndValue -> default", "f=n", g4j.createForceDefaultParameterAndValue());
        
    }
    
    @Test
    public void createURLTest() {
        
        final String url = Gravatar4J.createURL(TEST_EMAIL);
        assertEquals("createURLTest", "http://www.gravatar.com/avatar/" + TEST_HASH, url);
        
    }
    
}
