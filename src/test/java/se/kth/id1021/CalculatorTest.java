package se.kth.id1021;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class CalculatorTest extends TestCase
{
    public void testCalculator1()
    {
        Item[] expr = {
            new Item(Item.ItemType.VALUE, 10),
            new Item(Item.ItemType.VALUE, 2),
            new Item(Item.ItemType.VALUE, 5),
            new Item(Item.ItemType.MUL),
            new Item(Item.ItemType.ADD),
        };

        Calculator calc = new Calculator(expr, true, 10);
        int actual = calc.run();
        assertEquals("Check if 10*2+5 is equal to 20", 20, actual);
    }

    public void testCalculator2()
    {
        Item[] expr = {
            new Item(Item.ItemType.VALUE, 4),
            new Item(Item.ItemType.VALUE, 5),
            new Item(Item.ItemType.ADD),
            new Item(Item.ItemType.VALUE, 6),
            new Item(Item.ItemType.MUL),
        };

        Calculator calc = new Calculator(expr, true, 10);
        int actual = calc.run();
        assertEquals("Check if (4+5)*6 is equal to 54", 54, actual);
    }

    public void testCalculatorExpand()
    {   
        // 1+1 twelve times to test expand dynamic stack.
        Item[] expr = {
            new Item(Item.ItemType.VALUE, 1),
            new Item(Item.ItemType.VALUE, 2),
            new Item(Item.ItemType.VALUE, 3),
            new Item(Item.ItemType.VALUE, 4),
            new Item(Item.ItemType.VALUE, 5),
            new Item(Item.ItemType.VALUE, 6),
            new Item(Item.ItemType.VALUE, 7),
            new Item(Item.ItemType.VALUE, 8),
            new Item(Item.ItemType.VALUE, 9),
            new Item(Item.ItemType.VALUE, 10),
            new Item(Item.ItemType.VALUE, 11),
            new Item(Item.ItemType.VALUE, 12),
            new Item(Item.ItemType.VALUE, 13),
            new Item(Item.ItemType.VALUE, 14),
            new Item(Item.ItemType.VALUE, 15),
            new Item(Item.ItemType.VALUE, 16),
            new Item(Item.ItemType.ADD),
            new Item(Item.ItemType.MUL),
            new Item(Item.ItemType.ADD),
            new Item(Item.ItemType.MUL),
            new Item(Item.ItemType.ADD),
            new Item(Item.ItemType.MUL),
            new Item(Item.ItemType.ADD),
            new Item(Item.ItemType.MUL),
            new Item(Item.ItemType.ADD),
            new Item(Item.ItemType.MUL),
            new Item(Item.ItemType.ADD),
            new Item(Item.ItemType.MUL),
            new Item(Item.ItemType.ADD),
            new Item(Item.ItemType.MUL),
            new Item(Item.ItemType.ADD),
        };

        Calculator calc = new Calculator(expr, false, 10);
        int actual = calc.run();
        assertEquals("Check if ((16+15)*14+13)*12... is equal to ", 20643839, actual);
    }
}
