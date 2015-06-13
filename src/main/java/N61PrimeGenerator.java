import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Projet StairwaysToHeavens
 * Créé par yach17 le 13/06/2015.
 */
public class N61PrimeGenerator {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String args[]) throws IOException {
        in.readLine();
        long startTime = System.currentTimeMillis();
        Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToLong(generator::getPrime)
                .forEach((long prime) -> System.out.print(prime + " "))
        ;
//        System.out.println(System.lineSeparator() + (System.currentTimeMillis() - startTime));
    }


    private static PrimeGenerator generator = new PrimeGenerator();


    private static class PrimeGenerator {

        List<Long> primes;

        private PrimeGenerator() {
            primes = new ArrayList<>();
            primes.add(2L);
        }

        public long getPrime(int index) {
            if( primes.size() <= index ){
                computeUpTo(index);
            }
            return primes.get(index - 1);
        }

        private void computeUpTo(int upTo) {
            int currentIndex = primes.size() - 1;
            long maybePrime = primes.get(currentIndex)+1;
            while(currentIndex <= upTo ){
                if (isPrime(maybePrime)) {
                    primes.add(maybePrime);
                    currentIndex++;
                }
                maybePrime++;
            }
        }

        private boolean isPrime(long maybePrime) {
            long biggestFactor = (long) Math.sqrt(maybePrime);
            for (Long prime : primes) {
                if( prime > biggestFactor) break;
                if( maybePrime % prime == 0) return false;
            }
            return true;
        }

    }
}
