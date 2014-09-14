public class Solution {
    public String getPermutation(int n, int k) {
        if(n==0) return "";
        k = k-1;
        int factorial = 1;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=n;i++)
        {
            factorial*=i;
            list.add (i);
        }
        StringBuilder builder = new StringBuilder();
        while(n>0)
        {
            factorial/=n;
            builder.append(list.get(k/factorial));
            list.remove(k/factorial);
            k=k%factorial;
            n--;
        }
        return builder.toString();
        
    }
}