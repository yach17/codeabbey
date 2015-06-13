import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Créé par yach17 le 12/06/2015.
 */
public class N02SumInLoop {
    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        in.readLine();
        int sum = 0;
        for (String number : in.readLine().split(" ")) {
            sum += Integer.parseInt(number);
        }
        System.out.println(sum);
    }

}
