 public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int ret= 0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1])
            {
                ret+=prices[i]-prices[i-1];
            }
        }
        return ret;
    }