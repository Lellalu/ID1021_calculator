package se.kth.id1021;

public class StaticStack extends Stack {
    public class StackFullException extends RuntimeException {}
    public class StackEmptyException extends RuntimeException {}

    private int size;
    private int[] valueStack;
    private int stackPointer;  //pointing to the position of current item.

    public StaticStack(int initialSize){
        this.size = initialSize;
        this.valueStack = new int[size];
        this.stackPointer = -1;
    }

    public void push(int i) {
        if(stackPointer > size-2){
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
