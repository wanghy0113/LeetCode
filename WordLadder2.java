public class Solution {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        HashMap<String, Set<String>> graph = generateGraph(start, end, dict);
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>();
        sol.add(start);
        dsf(res, sol, graph, start, end);
        return res;
    }
    
    public HashMap generateGraph(String source, String sink, Set<String> dict)
    {
        HashMap<String, Set<String>> map = new HashMap<String, Set<String>>();
        Set<String> cur = new HashSet<String>();
        cur.add(source);
        Set<String> next = new HashSet<String>();
        while(cur.size()!=0)
        {
            boolean isFinished = false;
            dict.removeAll(cur);
            for(String str : cur)
            {
                map.put(str, new HashSet<String>());
                for(int i=0;i<str.length();i++)
                {
                    for(char c='a';c<='z';c++)
                    {
                        char[] array = str.toCharArray();
                        array[i] = c;
                        String newstr = new String(array);
                        if(newstr.equals(sink))
                        {
                            map.get(str).add(sink);
                            isFinished = true;
                        }
                        else if(dict.contains(newstr))
                        {
                            map.get(str).add(newstr);
                            next.add(newstr);
                        }
                    }
                }
            }
            if(!isFinished)
            {
                cur = next;
                next = new HashSet<String>();
            }
            else break;
        }
        return map;
    }
    
    public void dsf(List<List<String>> res, List<String> sol, HashMap<String, Set<String>> graph, String str, String end)
    {
        if(str.equals(end))
        {
            res.add(sol);
            return;
        }
        if(graph.containsKey(str))
        {
            Set<String> adj = graph.get(str);
            for(String s : adj)
            {
                List<String> list = new ArrayList<String>(sol);
                list.add(s);
                dsf(res, list, graph, s, end);
            }
        }
        
    }
    
}