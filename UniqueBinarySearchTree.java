
//DP
public class Solution {
    public int numTrees(int n) {
        int[] a = new int[n+1];
        a[0] = 1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                a[i]+=a[i-j]*a[j-1];
            }
        }
        return a[n];
    }
}

//recursive
public class Solution {
    public int numTrees(int n) {
        if(n==0) return 1;
        int sum = 0;
        for(int i=1;i<=n;i++)
        {
            sum+=numTrees(i-1)*numTrees(n-i);
        }
        return sum;
    }
}