package se.kth.id1021;

/**
 * The startup Main class to start up initializations of the static and dynamic 
 * stacks, and to set up a benchmark that tries to estimate the cost of using either stacks.
 */
public class Main{
    public static void main(String[] args) {
        System.out.println("Adding " + args[0] + " integer to static and dynamic array.");
        System.out.println("Running it " + args[1] + " times.");


        int itemToAdd = Integer.parseInt(args[0]);
        int maxLoop = Integer.parseInt(args[1]);

        Stack s;
        long startTimeStatic;
        long endTimeStatic;
        long startTimeDynamic;
        long endTimeDynamic;
        long[] staticRunningTime = new long[maxLoop];
        long[] dynamicRunningTime = new long[maxLoop];

        for(int i=0; i<maxLoop; i++){
            s = new StaticStack(itemToAdd);
            startTimeStatic = System.nanoTime();
            for(int j=0; j<itemToAdd; j++){
                s.push(j);
            }
            for(int j=0; j<itemToAdd; j++){
                s.pop();
            }
            endTimeStatic = System.nanoTime();
            staticRunningTime[i] = endTimeStatic-startTimeStatic;

            s = new DynamicStack(4);
            startTimeDynamic = System.nanoTime();
            for(int j=0; j<itemToAdd; j++){
                s.push(j);
            }
            for(int j=0; j<itemToAdd; j++){
                s.pop();
            }
            endTimeDynamic = System.nanoTime();
            dynamicRunningTime[i] = endTimeDynamic-startTimeDynamic;
        }

        long staticMaxTime = Long.MIN_VALUE;
        long staticMintime = Long.MAX_VALUE;
        long staticSumTime = 0;
        long dynamicMaxTime = Long.MIN_VALUE;
        long dynamicMinTime = Long.MAX_VALUE;
        long dynamicSumTime = 0;
        for(int i=0; i<maxLoop; i++){
            staticSumTime += staticRunningTime[i];
            dynamicSumTime += dynamicRunningTime[i];
            if(staticRunningTime[i] > staticMaxTime) {
                staticMaxTime = staticRunningTime[i];
            }
            if(dynamicRunningTime[i] > dynamicMaxTime) {
                dynamicMaxTime = dynamicRunningTime[i];
            }
            if(staticRunningTime[i] < staticMintime) {
                staticMintime = staticRunningTime[i];
            }
            if(dynamicRunningTime[i] < dynamicMinTime) {
                dynamicMinTime = dynamicRunningTime[i];
            }
        }

        System.out.printf("Max StaticArray running time: %d ns\n", staticMaxTime);
        System.out.printf("Min StaticArray running time: %d ns\n", staticMintime);
        System.out.printf("StaticArray average running time: %.2f\n", (double) staticSumTime / maxLoop);
        System.out.printf("Max DynamicArray running time: %d ns\n", dynamicMaxTime);
        System.out.printf("Min DynamicArray running time: %d ns\n", dynamicMinTime);
        System.out.printf("DynamicArray average running time: %.2f ns\n", (double) dynamicSumTime / maxLoop);
        System.out.printf("ratio: %.2f\n", ((double) staticSumTime / maxLoop)/((double) dynamicSumTime / maxLoop));
    }
}
