// The outer loop becomes the inner loop
// By doing so we are preventing its permutations

public static int change(int target, int[] nums) {
  int[] dp = new int[target + 1];
  dp[0] = 1; // target = 0 can be achieved -> {}

  for (int i = 0; i < nums.length; i++) {

    for (int currTarget = 1; currTarget <= target; currTarget++) {

      int remainingTarget = currTarget - nums[i];
      if (remainingTarget >= 0) {
        dp[currTarget] += dp[remainingTarget];
      }
    }
  }
  return dp[target];
}
