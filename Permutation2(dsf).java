public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] loc = new int[num.length];
        List<Integer> sol = new ArrayList<Integer>();
        dsf(res, loc, sol, num, 0);
        return res;
    }
    
    public void dsf(List<List<Integer>> res, int[] loc, List<Integer> sol, int[] num, int level)
    {
        if(level==num.length) 
        {
            res.add(sol);
            return;
        }
        for(int i=0;i<num.length;i++)
        {
            if((i==0||num[i]!=num[i-1]||loc[i-1]==1)&&loc[i]!=1)  //don't forget to ensure loc[i]!=1
            {
                loc[i] = 1;
                List<Integer> list = new ArrayList<Integer>(sol);
                list.add(num[i]);
                dsf(res, loc, list, num, level+1);
                loc[i] = 0;
            }
        }
    }
}