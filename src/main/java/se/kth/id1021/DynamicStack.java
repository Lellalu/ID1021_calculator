package se.kth.id1021;

public class DynamicStack extends Stack {
    public class StackEmptyException extends RuntimeException {}

    private final int MINIMUM_LENGTH = 10;
    private int length = MINIMUM_LENGTH;
    private int[] valueStack = new int[length];
    private int stackPointer = -1;  //pointing to the position of current item.

    public void push(int i) {
        if(stackPointer > length-2){
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
        
        if(stackPointer <= length/4 && length >= MINIMUM_LENGTH){
            shrinkAndCopy();
        }

        int value = valueStack[stackPointer];
        stackPointer--;
        return value;
    }
    
    private void shrinkAndCopy(){
        int[] shrinkValueStack = new int[length/2];

        for(int i = 0;i<length/2;i++){
            shrinkValueStack[i]=valueStack[i];
        }
        this.valueStack = shrinkValueStack;
        this.length = this.length/2;
    }

}
