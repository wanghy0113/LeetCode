public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        int i = 1;
        int a = 1;
        while(i<=n)
        {
            if(i!=1) a+=a;
            for(int j=res.size()-1;j>=0;j--)
            {
                res.add(res.get(j)+a);
            }
            i++;
        }
        return res;
    }
}