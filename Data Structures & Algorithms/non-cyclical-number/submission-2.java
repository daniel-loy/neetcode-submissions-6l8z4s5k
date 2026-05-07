class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        
        while(n!=1){
            set.add(n);
            int rem = 0;
            int div = 0;
            int num = 0;
            while(n >= 10){
                rem = n%10;
                n = n/10;
                num = num+rem*rem;
                System.out.println(num);
            }
            n = num+n*n;
            if(set.contains(n)){
                return false;
            }
        }
        return true;
    }
}
