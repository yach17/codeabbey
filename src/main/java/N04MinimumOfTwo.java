import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Créé par yach17 le 13/06/2015.
 */
public class N04MinimumOfTwo {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int numLines = Integer.valueOf(in.readLine());
        in.lines().limit(numLines)
                .map(N04MinimumOfTwo::minOfTwo)
                .forEach(N04MinimumOfTwo::output)
        ;
    }

    public static int minOfTwo(String line) {
        return Arrays.stream(line.split(" ")).map(Integer::parseInt).mapToInt(Integer::intValue).min().getAsInt();
    }

    private static void output(Object result) {
        System.out.print(result + " ");
    }

}
