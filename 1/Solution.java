import java.util.HashMap;

class Solution {
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