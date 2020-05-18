package com.ttyc.recursion;

/**
 * 求数组元素之和 {1,3,5,7,9,11,13}
 */
public class Sum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        int result = new Sum().sum(arr);
        System.out.println(result);
    }

    public int sum(int[] arr) {
        return sum(0, arr);
    }

    /**
     * 函数功能：arr[0] + sum(arr[1],arr[2]...arr[n-1])
     */
    private int sum(int index, int[] arr) {
        if(index==arr.length) {
            return 0;
        }
        return arr[index] + sum(index+1, arr);
    }
}
