/*
 * This file contains JUnit test cases for HandBag.java and the
 * methods from Bag.java.
 *
 * You should NOT modify this file! When you push Basics.java to
 * GitHub, it should run these tests. You can see the results in the
 * "Actions" tab of your repository.
 */

import org.junit.*;

import static org.junit.Assert.*;


public class HandBagTest {
    HandBag b;

    @Before
    public void setUp() throws Exception {
        b = new HandBag("Blue", 4);
    }

    @Test(timeout = 50)
    public void testGetColor() {
        assertEquals("Blue", b.getColor());
    }

    @Test(timeout = 50)
    public void testSetColor1() {
        b.setColor("White");
        assertEquals("White", b.getColor());
    }

    @Test(timeout = 50)
    public void testGetNumberOfContentsEmpty() {
        assertEquals(0, b.getNumberOfContents());
    }

    @Test(timeout = 50)
    public void testGetNumberOfContentsNonEmpty() {
        assertTrue(b.addItem("Cheese"));
        assertTrue(b.addItem("Eggs"));
        assertEquals(2, b.getNumberOfContents());
        assertTrue(b.addItem("Bacon"));
        assertTrue(b.addItem("Coffee"));
        assertEquals(4, b.getNumberOfContents());
        assertFalse(b.addItem("Bread"));
        assertEquals(4, b.getNumberOfContents());
    }

    @Test(timeout = 10000)
    public void testGetNumberOfContentsPop() {
        b.addItem("Cheese");
        b.addItem("Eggs");
        assertEquals("Eggs", b.popItem());
        assertEquals(1, b.getNumberOfContents());
    }

    @Test(timeout = 50)
    public void TestGetCapacity() {
        assertEquals(4, b.getCapacity());
    }

    @Test(timeout = 50)
    public void TestSetColor() {
        b.setColor("Red");
        assertEquals("Red", b.getColor());
    }

    @Test(timeout = 50)
    public void TestIncreaseCapacity() {
        assertEquals("Blue Bag (0 / 4)", b.toString());
        b.increaseCapacity(2);
        assertEquals(6, b.getCapacity());
        assertEquals("Blue Bag (0 / 6)", b.toString());
    }

    @Test(timeout = 50)
    public void TestEnhance() {
        b.enhance();
        assertEquals(5, b.getCapacity());
        b.enhance();
        assertEquals(6, b.getCapacity());
    }

}