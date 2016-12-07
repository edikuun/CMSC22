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
public class ThreadSolution extends Thread {

    private int[] length;
    private int[] width;
    private int l;
    private int start;
    private int size;
    private String[] result;

    public ThreadSolution(int[] length, int[] width, int l, int start, int size) {
        this.length = length;
        this.width = width;
        this.l = l;
        this.start = start;
        this.size = size;
        result = null;
    }

    public void run() {
        for (int x = 0; x < start + size; x++) {
            int left = length[(x + l - 1) % l];
            int right = length[(x + 1) % l];
            int middle = length[x];

            if (x == 0) {
                if (left == right) {
                    left = 0;
                } else if (left == middle && left == 1) {
                    left = 0;
                }
            }

            if (x == l - 1) {
                if (left == right) {
                    right = 0;
                } else if (left == middle) {
                    right = 0;
                }
            }
            width[x] = (middle | right) ^ left; //check if neighbors indicates 1 or 0
        }
    }

    public int[] getWidth() {
        return width;
    }
}
