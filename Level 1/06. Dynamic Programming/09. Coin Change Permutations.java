// ************************************ Tabulation ************************************

class Solution {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1; // target = 0 can be achieved -> {}

        for (int currTarget = 1; currTarget <= target; currTarget++) {
            for (int i = 0; i < nums.length; i++) {
                int remainingTarget = currTarget - nums[i];
                if (remainingTarget >= 0) {
                    dp[currTarget] += dp[remainingTarget];
                }
            }
        }
        return dp[target];
    }
}

// Combination Sum IV (LeetCode 377)
