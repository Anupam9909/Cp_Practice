public class numberTheory{
    public static void main(String[] args{
        Scanner scn = new Scanner(System.in);

        // GCD
        int a = scn.nextInt();
        int b = scn.nextInt();
        System.out.println("GCD = " + gcd(a,b));
        
        
        // LCM
        int a = scn.nextInt();
        int b = scn.nextInt();
        System.out.println("LCM = " + lcm(a,b));
        
        
        // FACTORS
        int n = scn.nextInt();
        List<Integer> ans = factors(a,b);
        Collections.sort(ans);
        System.out.println("factors of "+n+" = " + ans);

        // PRIMES
        int n = scn.nextInt();
        List<boolean> is_prime = primes(n);
        
        System.out.println("is 3 a prime no " + is_prime.get(3));
        System.out.println("is 8 a prime no " + is_prime.get(8));

        // print all prime number
        for(int i = 2 ; i <= n; i++){
            if(is_prime.get(i)) 
                System.out.println(i+" ");
        }
        
    }

    // GCD   -> T: O(LogN) , S: O(N)
    public int gcd(int a, int b){
        return  b == 0 ?  a : gcd(b, a % b);     // REM : alternate b,a,b,a,b 
    }

    // LCM   -> T: O(LogN) , S: O(N)
    public int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }


    // FACTORS  -> T: O(RootOf(n)) , S : O(1)
    public List<Integer> factors(int n){
        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i*i <= n; i++){
            if(n%i == 0){
                ans.add(i);

                if(i != n/i)   // only distinct element ke liye cond. 
                ans.add(i);
            }
        }

        return ans;
    }

    // PRIMES
    public static boolean[] is_prime(int n){
        boolean[] ans = new boolean[n+1];
        Arrays.fill(ans, true);
        ans[0] = false;
        ans[1] = false;
        // hame sirf fasle mark karna ha (i.e elemination vala tarika)
        for(int i = 2; i*i <=n ; i++){
            if(ans[i]){ 
                for(int j = i*i ; j <= n; j+=i) 
                    ans[j] = false;
            }
        }
        // last me jo true bacha vo hamara ans prime numbers
        return ans;
    } 

}