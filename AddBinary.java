xpublic class Solution {
    public String addBinary(String a, String b) {
        return addBinary(a,b,0);
    }
    
    public String addBinary(String a, String b, int carry)
    {
        if(a.length()==0&&b.length()==0) return carry==0?"":"1";
        if(a.length()==0) return addBinary(b,carry==0?"0":"1",0);
        if(b.length()==0) return addBinary(a,carry==0?"0":"1",0);
        char ac = a.charAt(a.length()-1);
        char bc = b.charAt(b.length()-1);
        if(ac=='0'&&bc=='0') return addBinary(a.substring(0,a.length()-1),b.substring(0,b.length()-1),0)+carry;
        if(ac=='1'&&bc=='1') return addBinary(a.substring(0,a.length()-1),b.substring(0,b.length()-1),1)+carry;
        return addBinary(a.substring(0,a.length()-1),b.substring(0,b.length()-1),carry)+(1-carry);
        
    }
}