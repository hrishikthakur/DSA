// Approach is kinda greedy here

public static int maxProfit(int[] cost){

    int n = cost.length;

    // 1st transaction -> agar aaj ya aaj k "pehle" sell kiya toh maxProfit
    int[] left = new int[n];
    int maxProfit = Integer.MIN_VALUE;
    int minVal = cost[0];
    for(int i = 0; i < n; i++){
        int currVal = cost[i];
        int currProfit = currVal - minVal;

        if(currProfit > maxProfit)
            maxProfit = currProfit;

        if(currVal < minVal)
            minVal = currVal;

        left[i] = maxProfit;
    }

    // 2nd transaction -> agar aaj ya aaj k "baad" buy kiya toh maxProfit
    int[] right = new int[n];
    maxProfit = Integer.MIN_VALUE;
    int maxVal = cost[n - 1];
    for(int i = n - 1; i >= 0; i--){
        int currVal = cost[i];
        int currProfit = maxVal - currVal;

        if(currProfit > maxProfit)
            maxProfit = currProfit;

        if(currVal > maxVal)
            maxVal = currVal;

        right[i] = maxProfit;
    }

    maxProfit = 0;
    for(int i = 0; i < n; i++){
        int currProfit = left[i] + right[i];
        if(currProfit > maxProfit)
            maxProfit = currProfit;
    }
    return maxProfit;
}
