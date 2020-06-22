package com.ttyc.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;


    }

    public static void sumIndex(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>(nums.length);


        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            int remain = target - ele;
            if(indexMap.containsKey(remain) && indexMap.get(remain) != i) {

            }
        }
    }
}
