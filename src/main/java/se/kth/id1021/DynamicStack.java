package se.kth.id1021;

public class DynamicStack extends Stack {
    public class StackEmptyException extends RuntimeException {}

    private int length = 10;
    private int[] valueStack = new int[length];
    private int stackPointer = -1;  //pointing to the position of current item.

    public void push(int i) {
        if(stackPointer > length-1){
            expandAndCopy();
        }

        stackPointer++;
        valueStack[stackPointer] = i;
    }

    private void expandAndCopy(){
        int[] expandedValueStack = new int[2*length];

        for(int i = 0;i<length;i++){
            expandedValueStack[i]=valueStack[i];
        }
        this.valueStack = expandedValueStack;
        this.length = this.length*2;
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
