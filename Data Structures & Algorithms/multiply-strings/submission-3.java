class Solution {
    public String multiply(String num1, String num2) {
    int n = num1.length();
    int m = num2.length();
    int mul=1;
    int sum=0;
    int[] result = new int[m+n];
            if (num1.equals("0") || num2.equals("0")) return "0";

    for(int i=n-1;i>=0;i--){
        for(int j=m-1;j>=0;j--){
            int n1=num1.charAt(i)-'0';
            int n2=num2.charAt(j)-'0';
            mul=n1*n2;
            sum=mul+result[i+j+1];
            result[i+j+1] = sum%10;
            result[i+j] += sum/10;
        }
    }

         StringBuilder sb = new StringBuilder();
        int k = 0;

        // Skip leading zeros
        while (k < result.length && result[k] == 0) k++;

        for (; k < result.length; k++)
            sb.append(result[k]);

        return sb.toString();

    }
}
