public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        if(words.length==0) return res;
        int start = 0;
        int len = 0;
        int count = 0;
        for(int i=0;i<words.length;i++)
        {
            String word = words[i];
            if(len+word.length()+count>L)
            {
                res.add(convert(words, start, i-1, count, len, L));
                start = i;
                count = 1;
                len = word.length();
            }
            else
            {
                count++;
                len+=word.length();
            }
        }
        StringBuilder lastLine = new StringBuilder();
        for(int i=start;i<words.length;i++)
        {
            lastLine.append(words[i]);
            if(i!=words.length-1) lastLine.append(" ");
        }
        while(lastLine.length()<L) lastLine.append(" ");
        res.add(lastLine.toString());
        return res;
    }
    public String convert(String[] words, int start, int end, int count, int len, int L)
    {
        StringBuilder builder = new StringBuilder();
        if(count==1)
        {
            builder.append(words[start]);
            while(builder.length()<L) builder.append(" ");
            return builder.toString();
        }
        
        int avg = (L-len)/(count-1);
        int numOfMore = L-avg*(count-1)-len;
        StringBuilder spaceBuilder = new StringBuilder();
        for(int i=1;i<=avg;i++)
        {
            spaceBuilder.append(" ");
        }
        int more = 0;
        for(int i=start;i<=end;i++)
        {
            builder.append(words[i]);
            if(i!=end)
            {
               if(more<numOfMore) {builder.append(" ");more++;}
               builder.append(spaceBuilder);
            }
        }
        return builder.toString();
    }
}