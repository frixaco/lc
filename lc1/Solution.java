package lc1;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution lc1Solution = new Solution();

        int[] nums = { 1, 2, 3, 4, 5 };
        int[] result = lc1Solution.twoSum(nums, 9);
        System.out.println(result[0] + " " + result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> remainders = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];
            if (remainders.containsKey(remainder)) {
                return new int[] { i, remainders.get(remainder) };
            }

            remainders.put(nums[i], i);
        }

        return new int[] {};
    }
}