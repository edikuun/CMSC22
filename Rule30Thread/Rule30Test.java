/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rule30Thread;

/**
 *
 * @author chromalix
 */
public class Rule30Test {

    public static void main(String[] args) {
        long startTime;
        long endTime;
        long threadedDuration;
        long nonThreadedDuration;

        int size = 8000;

        startTime = System.currentTimeMillis();
        Rule30Threaded.display(size);
        endTime = System.currentTimeMillis();
        threadedDuration = endTime - startTime;

        System.out.println();

        startTime = System.currentTimeMillis();
        Rule30.display(size);
        endTime = System.currentTimeMillis();
        nonThreadedDuration = endTime - startTime;

        System.out.println("Duration(threaded): " + threadedDuration + "ms");
        System.out.println("Duration(non-threaded): " + nonThreadedDuration + "ms");

    }
}
