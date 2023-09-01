package se.kth.id1021;


/**
* The static stack class extends the Stack abstract class, which  
* constructs stacks that have fixed size.
* throws StackFullException.
* throws StackEmptyException.
*/
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

    /**
    * Push the value in stack.
    * @throws StackFullException when the stack is full.
    * @param i int value to put into the stack.
    */
    public void push(int i) {
        if(stackPointer > size-2){
            throw new StackFullException();
        }

        stackPointer++;
        valueStack[stackPointer] = i;
    }

    /**
    * Pop the value on top out of in stack.
    * @throws StackEmptyException when the stack is empty.
    * @return the int value on top out of the stack.
    */
    public int pop() {
        if(stackPointer == -1){
            throw new StackEmptyException();
        }

        int value = valueStack[stackPointer];
        stackPointer--;
        return value;
    }
    

}
