package se.kth.id1021;


public class Main{
    public static void main(String[] args) {
        Item[] expr = {
            new Item(Item.ItemType.ADD),
        };

        Calculator calc = new Calculator(expr);
        int res = calc.run();
        System.out.println("Calculator:res=" + res);
    }
}
