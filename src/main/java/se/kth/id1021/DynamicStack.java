package se.kth.id1021;

public class DynamicStack extends Stack {
    public class StackEmptyException extends RuntimeException {}

    private final int MINIMUM_SIZE;
    private int size;
    private int[] valueStack;
    private int stackPointer;  //pointing to the position of current item.

    public DynamicStack(int initialSize){
        this.MINIMUM_SIZE = initialSize;
        this.size = initialSize;
        this.valueStack = new int[size];
        this.stackPointer = -1;
    }

    public void push(int i) {
        if(stackPointer > size-2){
            expandAndCopy();
        }

        stackPointer++;
        valueStack[stackPointer] = i;
    }

    private void expandAndCopy(){
        int[] expandedValueStack = new int[2*size];

        for(int i = 0;i<size;i++){
            expandedValueStack[i]=valueStack[i];
        }
        this.valueStack = expandedValueStack;
        this.size = this.size*2;
    }

    public int pop() {
        if(stackPointer == -1){
            throw new StackEmptyException();
        }
        
        if(stackPointer <= size/4 && size >= MINIMUM_SIZE){
            shrinkAndCopy();
        }

        int value = valueStack[stackPointer];
        stackPointer--;
        return value;
    }
    
    private void shrinkAndCopy(){
        int[] shrinkValueStack = new int[size/2];

        for(int i = 0;i<size/2;i++){
            shrinkValueStack[i]=valueStack[i];
        }
        this.valueStack = shrinkValueStack;
        this.size = this.size/2;
    }

}
