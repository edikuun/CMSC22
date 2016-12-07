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
public class Rule30Threaded {

    final static int THREAD_COUNT = 1;

    static void display(int size) {
        int l = size;

        int[] length = new int[l]; //set values
        int[] width = new int[l]; //set values
        length[(l / 2)] = 1; // put 1 on the seed

        fill(length); //prints first row

        int portionCount;

        if (l < THREAD_COUNT) {
            portionCount = l;
        } else {
            portionCount = THREAD_COUNT;
        }

        ThreadSolution[] worker = new ThreadSolution[portionCount];
        int threadPart = l / portionCount;
        int additionalPortions = l % portionCount;

        for (int y = 1; y < l; ++y) {
            int start = 0;
            for (int i = 0; i < portionCount; i++) {
                if (i < additionalPortions) {
                    worker[i] = new ThreadSolution(length, width, l, start, threadPart + 1);
                    start = start + threadPart + 1;
                } else {
                    worker[i] = new ThreadSolution(length, width, l, start, threadPart);
                    start = start + threadPart;
                }
            }

            for (int i = 0; i < portionCount; i++) {
                worker[i].start();
            }

            for (int i = 0; i < portionCount; i++) {
                while (worker[i].isAlive()) {
                    try {
                        worker[i].join();
                    } catch (InterruptedException e) {
                        System.err.println("Thread Interrupted: " + e.getMessage());
                    }
                }
            }

            for (int i = 0; i < portionCount; i++) {
                width = worker[i].getWidth();
            }

            fill(width); //print next row
            int[] store = length; //update rows so that it will check on the preceding row
            length = width;
            width = store;
        }
    }

    public static void fill(int[] fill) { //function for printing 1 and 0
        for (int x = 0; x < fill.length; ++x) {
            if (fill[x] == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
        }
        System.out.println();
    }
}
