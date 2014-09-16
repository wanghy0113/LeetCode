public class Solution {
    public String simplifyPath(String path) {
        Deque<String> queue = new LinkedList<String>();
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while(i<=path.length())
        {
            char c = i==path.length()?'/':path.charAt(i);
            if(c=='/')
            {
                if(builder.length()!=0)
                {
                    String str = builder.toString();
                    if(str.equals("..")&&!queue.isEmpty()) 
                    {
                        queue.removeLast();
                    }
                    else if(!str.equals(".")&&!str.equals(".."))
                    {
                        queue.add(str);
                    }
                    builder = new StringBuilder();
                }
                i++;
                continue;
                
            }
            builder.append(c);
            i++;
        }
        StringBuilder res = new StringBuilder();
        while(!queue.isEmpty())
        {
            res.append("/");
            res.append(queue.remove());
        }
        return res.length()==0?"/":res.toString();
        
    }
}