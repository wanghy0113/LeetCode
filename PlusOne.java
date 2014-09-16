public class Solution {
    public int[] plusOne(int[] digits) {
        boolean addOne = false;
        int carry = 1;
        for(int i=digits.length-1;i>=0;i--)
        {
            int temp = digits[i];
            digits[i] = (temp+carry)%10;
            carry = (temp+carry)/10;
        }
        if(carry == 1)
        {
            int[] a = new int[digits.length+1];
            a[0] = 1;
            for(int i=1;i<a.length;i++)
            {
                a[i] = digits[i-1];
            }
            return a;
        }
        return digits;
    }
}