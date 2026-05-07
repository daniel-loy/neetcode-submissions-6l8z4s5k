class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        List<Integer> list = new ArrayList<>();
        
        for(int i=digits.length-1;i>=0;i--){
            int sum = digits[i]+carry;
            System.out.println("sum : "+sum);

            carry = sum%10;
            list.add(carry);
            carry = sum/10;
            System.out.println(carry);
        }
        if(carry>0){
        list.add(carry);

        }


        int[] result = new int[list.size()];
        int n = list.size();
        for(int i = n-1;i>=0;i--){
            result[n-i-1] = list.get(i);
        }

        return result;
    }
}
