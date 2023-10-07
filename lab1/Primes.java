public class Primes{


 public static void main(String[] args) {
 	System.out.println("Prime numbers less than 100: ");
 	
 	for (int i=2; i<=100; i++) {
 	
 		if (isPrime(i)) {
 	 		System.out.println(i + " ");
 	 	}
 	}
 }
 
 

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
