public class numberTheory{
    public static void main(String[] args{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
    }

    // GCD
    public int gcd(int a, int b){
        return  b == 0 ?  a : gcd(b, a%b);     // REM : alternate b,a,b,a,b 
    }

    // LCM 
    public int lcm(int a, int b){
        return (a*b)/gcd(a, b);
    }
}