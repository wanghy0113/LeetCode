public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        int[] map = new int[num.length];
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        res.add(sol);
        subsetsWithDup(res, sol, num, map, 0);
        return res;
    }
    
    public void subsetsWithDup(List<List<Integer>> res, List<Integer> sol, int[] num, int[] map, int index)
    {
        for(int i=index;i<num.length;i++)
        {
            if(i!=0&&num[i]==num[i-1]&&map[i-1]==0) continue;
            List<Integer> list = new ArrayList<Integer>(sol);
            list.add(num[i]);
            map[i] = 1;
            res.add(list);
            subsetsWithDup(res, list, num, map, i+1);
            map[i] = 0;
        }
    }
}