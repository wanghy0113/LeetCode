public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")) return "0";
        List<Character> list = new ArrayList<Character>();
        
        for(int i=0;i<num2.length();i++)
        {
            int carry = 0;
            int c2 = num2.charAt(num2.length()-i-1)-'0';
            for(int j=0;j<num1.length();j++)
            {
                int c1 = num1.charAt(num1.length()-j-1)-'0';
                while(list.size()<i+j+1) list.add('0');
                int exist = list.get(i+j)-'0';
                list.set(i+j, (char)(((c1*c2+carry+exist)%10)+'0'));
                carry = (c1*c2+carry+exist)/10;
            }
            if(carry!=0) list.add((char)('0'+carry));
        }
        char[] array = new char[list.size()];
        for(int i=0;i<list.size();i++)
        {
            array[i] = list.get(list.size()-1-i);
        }
        String ret = new String(array);
        return ret;
    }
}