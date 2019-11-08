/**
 * JUnit5Demo.java
 * 30 jan. 2018
 */
package assignment_3.jUnit5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author jlnmsi
 *
 */
class JUnit5Demo {

	 
    @BeforeAll
    public static void oneTimeSetUp() {
        // one-time initialization code   
    	System.out.println("@BeforeAll - oneTimeSetUp");
    }
 
    @AfterAll
    public static void oneTimeTearDown() {
        // one-time cleanup code
    	System.out.println("@AfterAll - oneTimeTearDown");
    }
 
    @BeforeEach
    public void setUp() {
    	// Executed before each test method
        System.out.println("@BeforeEach - setUp");
    }
 
    @AfterEach
    public void tearDown() {
    	// Executed after each test method
        System.out.println("@AfterEach - tearDown");
    }

	@Test
    public void testMethod1() {
		int expected = 5;
		int input = 2 + 3;
    	assertTrue(input == expected);
        System.out.println("@Test - testMethod1");
    }
    
    @Test
    public void testMethod2() {
    	assertEquals("Hello","Hello");   // Uses equals() to compare
        System.out.println("@Test - testMethod2");
    }
    
	@Test
    public void testMethod3() {
		int expected = 5;
		int input = 5;
    	assertNotSame(expected, input);  // Uses != to compare
        System.out.println("@Test - testMethod3");
    }
 

}
