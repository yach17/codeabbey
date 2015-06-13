import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

/**
 * Créé par yach17 le 13/06/2015.
 */
public class N67FibonnacciSequence {
    private static final List<BigInteger> fibonacciSequence = Collections.unmodifiableList(computeFibonacciSequence(1000));

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int numLines = Integer.valueOf(in.readLine());
        in.lines().limit(numLines)
                .map(N67FibonnacciSequence::fibonnacciIndex)
                .forEach(N67FibonnacciSequence::output)
        ;
    }

    private static void output(Object result) {
        System.out.print(result + " ");
    }

    private static Integer fibonnacciIndex(String fibonnacciNumber) {
        return fibonacciSequence.indexOf(new BigInteger(fibonnacciNumber));
    }

    private static List<BigInteger> computeFibonacciSequence(int nbvaluesToCompute) {
        List<BigInteger> sequence = new ArrayList(nbvaluesToCompute);
        BigInteger previous = BigInteger.ZERO;
        BigInteger current = BigInteger.ONE;

        sequence.add(previous);
        sequence.add(current);
        for (int i = 2; i < nbvaluesToCompute; i++) {
            BigInteger next = previous.add(current);
            sequence.add(next);
            previous = current;
            current = next;
        }
        return sequence;
    }

}
