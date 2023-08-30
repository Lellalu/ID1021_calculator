package se.kth.id1021;


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
