/*
    before start:
               ' ' --------no sign, no dot
               '.' --------no dot  -----has dot
        '-' or '+' --------no sign, no dot  -----has sign
        '0' to '9' --------      ------start
            others --------return false
    after start:
               '.' --------no dot, no e -----has dot
               'e' --------no e, not last --------has e
        '-' or '+' --------previous must be e, not last
        '0' to '9' --------      
               ' ' --------previous can't be e or - or +, break
    after break
               remainning characters must all be ' '

    return true
*/


public class Solution {
    public boolean isNumber(String s) {
        int i = 0;
        boolean hasE = false;
        boolean hasDot = false;
        boolean hasSign = false;
        boolean hasStart = false;
        
        while(i<s.length())
        {
            char c = s.charAt(i);
            if(!hasStart)
            {
                if(c==' ')
                {
                    if(hasSign||hasDot) return false;
                    i++;
                    continue;
                }
                if(c=='+'||c=='-')
                {
                    if(hasSign||hasDot) return false;
                    hasSign = true;
                    i++;
                    continue;
                }
                if(c=='.')
                {
                    if(hasDot) return false;
                    hasDot = true;
                    i++;
                    continue;
                }
                if(c>='0'&&c<='9')
                {
                    hasStart = true;
                    i++;
                    continue;
                }
                else return false;
            }
            else
            {
                if(c=='.')
                {
                    if(hasDot||hasE) return false;
                    hasDot = true;
                    i++;
                    continue;
                }
                if(c=='e')
                {
                    if(hasE||i==s.length()-1) return false;
                    hasE = true;
                    i++;
                    continue;
                }
                if(c=='+'||c=='-')
                {
                    if(i==s.length()-1||s.charAt(i-1)!='e') return false;
                    i++;
                    continue;
                }
                if(c==' ')
                {
                    if(s.charAt(i-1)=='e'||s.charAt(i-1)=='+'||s.charAt(i-1)=='-') return false;
                    break;
                }
                if(c<'0'||c>'9') return false;
                i++;
            }
        }
        while(i<s.length()&&s.charAt(i)==' ') i++;
        return hasStart&&i==s.length();
    }
}