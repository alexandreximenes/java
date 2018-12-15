package com.springbootcomjpa2.start;


import org.junit.*;

import static org.junit.Assert.*;

public class AssertTest {

    @Before
    public void before(){
        System.out.println("before");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass");
    }

    @Test
    public void test(){
        System.out.println("teste");
        assertNotNull(new String());
        assertNotEquals(new String(), new StringBuffer());
        //assertNotEquals(new String(),new String());
    }

    @Test
    public void test2(){
        System.out.println("teste2");
        assertEquals(2,2);
        assertTrue(true);
        assertFalse(!true);
    }

    @After
    public void after(){
        System.out.println("after");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass");
    }
}
