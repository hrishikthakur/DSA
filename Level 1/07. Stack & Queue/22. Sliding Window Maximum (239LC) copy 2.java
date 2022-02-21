class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // (n - k) - 0 + 1 because [a,b] = b - a + 1
        int[] res = new int[n - k + 1];
        int idx = 0;

        // deque to store indices
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {

            // si -> starting index of the current window
            int si = i - k + 1;
            // removeFirst -> when front element is no more in the current window
            if (dq.size() > 0 && dq.getFirst() < si) {
                dq.removeFirst();
            }

            // removeLast -> when the previous elements are smaller than the current
            while (dq.size() > 0 && nums[dq.getLast()] < nums[i]) {
                dq.removeLast();
            }

            // addLast -> we can be the ans of the current or upcoming windows
            dq.addLast(i);

            // getFirst -> to get max of a complete window
            if (i >= k - 1) {
                res[idx++] = nums[dq.getFirst()];
            }
        }
        return res;
    }
}
