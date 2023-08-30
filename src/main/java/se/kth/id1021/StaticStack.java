package se.kth.id1021;

public class StaticStack extends Stack {
    public class StackFullException extends RuntimeException {}
    public class StackEmptyException extends RuntimeException {}

    private final int LENGTH = 10;
    private int[] valueStack = new int[LENGTH];
    private int stackPointer = -1;  //pointing to the position of current item.

    public void push(int i) {
        if(stackPointer > LENGTH-1){
            throw new StackFullException();
        }

        stackPointer++;
        valueStack[stackPointer] = i;
    }

    public int pop() {
        if(stackPointer == -1){
            throw new StackEmptyException();
        }

        int value = valueStack[stackPointer];
        stackPointer--;
        return value;
    }
    

}
