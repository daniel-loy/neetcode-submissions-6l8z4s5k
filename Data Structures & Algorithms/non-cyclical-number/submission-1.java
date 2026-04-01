class Solution {
    public boolean isHappy(int n) {
    HashSet<Integer> hash = new HashSet<>();
    while(n!=1 && !hash.contains(n)){
        hash.add(n);
        int x=n;
        int sum =0;
        while(x!=0){
            sum+= (x%10)*(x%10);
            x/=10;
        }
        n = sum;
            System.out.println(sum);
    }  
    if(n==1){
        return true;
    }
    else{
        return false;
    }
    }
}
