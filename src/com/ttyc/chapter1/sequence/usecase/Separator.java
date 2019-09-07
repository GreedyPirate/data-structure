package com.ttyc.chapter1.sequence.usecase;

import java.util.Arrays;

/**
 * 给定数组A，x，要求比x小的放左边，比x大的放右边
 *
 * @author jaynnay
 * @createTime 2019/1/29 22:28
 * @description
 */
public class Separator {

    public static int[] separate(int[] arr) {
        // TODO check balabala ...
        int i = 1, j = arr.length - 1, x = arr[0];
        while (i < j && j - i != 1) {
            // 为什么要i<j，i从左往右扫描，已经排除了比x小的，j没必要再去找了
            while (i < j && arr[i] < x) {
                i++;
            }
            while (i < j && arr[j] > x) {
                j--;
            }

            int temp;
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        int temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
