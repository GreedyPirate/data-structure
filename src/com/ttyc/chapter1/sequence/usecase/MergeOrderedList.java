package com.ttyc.chapter1.sequence.usecase;

import java.util.Arrays;

/**
 * 合并两个有序表
 */
public class MergeOrderedList {
    public static void main(String[] args) {
        int[] a = {4, 7, 9, 10, 15}, b = {2, 5, 6, 8, 11, 17, 20};
        int[] c = merge(a, b);
        System.out.println(Arrays.toString(c));
    }

    private static int[] merge(int[] a, int[] b) {
        int[] ret = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length  && j < b.length) {
            int ai = a[i], bj = b[j];
            if (ai < bj) {
                insert(ret, k, ai);
                i++;
            } else {
                insert(ret, k, bj);
                j++;
            }
            k++;
        }

        while (i <= a.length - 1) {
            insert(ret, k, a[i++]);
            k++;
        }

        while (j <= b.length - 1) {
            insert(ret, k, b[j++]);
            k++;
        }
        return ret;
    }

    private static void insert(int[] arr, int index, int i) {
        System.arraycopy(arr, index, arr, index + 1, arr.length - index - 1);
        arr[index] = i;
    }
}
