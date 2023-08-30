package se.kth.id1021;

/**
 * The startup Main class to start up initializations of the static and dynamic 
 * stacks, and to set up a benchmark that tries to estimate the cost of using either stacks.
 */
public class Main{
    public static void main(String[] args) {

        int itemToAdd = 1000;

        Stack s = new StaticStack(itemToAdd+1);
        long startTime = System.nanoTime();
        for(int i=0; i<itemToAdd; i++){
            s.push(i);
        }
        long endTime = System.nanoTime();
        System.out.println("Static stack took: "+ Long.toString(endTime-startTime) + " ns.");

        s = new DynamicStack(4);
        startTime = System.nanoTime();
        for(int i=0; i<itemToAdd; i++){
            s.push(i);
        }
        endTime = System.nanoTime();
        System.out.println("Dynamic stack took: "+ Long.toString(endTime-startTime) + " ns.");
    }
}
