// Approach is kinda greedy here

public static int maxProfit1(int[] cost){
    int min = cost[0];
    int maxProfit = Integer.MIN_VALUE;

    for(int i = 0; i < cost.length; i++){
        if(cost[i] < min){
            min = cost[i];
        }
        int currProfit = cost[i] - min;
        maxProfit = Math.max(maxProfit, currProfit);
    }

    return maxProfit;
}

