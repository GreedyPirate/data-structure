package com.ttyc.chapter6.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大堆：一颗完全二叉树，用数组存储
 */
public class MaxHeap {

    private int[] queue = new int[10];

    private int size;

    /**
     * 先不要把data放到队列尾部，
     */
    public void add(int data) {
        int i = size;
        if(i == 0) {
            queue[0] = data;
        }else {
            siftUp(i, data);
        }
        size++;
    }

    private void siftUp(int k, int x){
        while (k>0) {
            int parent = (k-1) >>> 1;
            int e = queue[parent];
            if(e > x) {
                break;
            }
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }

    public int poll() {
        int max = queue[0];
        int last = queue[size - 1];
        queue[0] = last;
        queue[size-1] = 0; //最后一个空间 释放

        size--;
        if(size != 0) {
        }
        return max;
    }
}
