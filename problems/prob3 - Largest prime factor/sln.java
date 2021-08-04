import java.lang.Math;

class Main {
    public static void main(String[] args) {
        long i = 600851475143L;
        System.out.println(largest_prime_factor(i));
    }

    public static long largest_prime_factor(long n) {
        long largest = 1;
        
        // check if n is even
        while(n % 2 == 0) {
            largest = 2;
            n /= 2;
        }

        // check odd numbers
        for(int i = 3; i <= Math.sqrt(n); i += 2) {
            // check if `i` is a factor
            while(n % i == 0) {
                largest = i; // we know i > largest
                n /= i;
            }
        }

        // check for prime number factors
        if(n > 2 && n > largest) {
            largest = n;
        }

        return largest;
    }
}
