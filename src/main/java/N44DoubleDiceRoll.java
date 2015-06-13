import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Créé par yach17 le 13/06/2015.
 */
public class N44DoubleDiceRoll {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int numLines = Integer.valueOf(in.readLine());
        for (int i = 0; i < numLines; i++) {
            String testCaseData[] = in.readLine().split(" ");
            int firstRoll = Integer.parseInt(testCaseData[0]);
            int secondRoll = Integer.parseInt(testCaseData[1]);
            System.out.print(doubleDiceRoll(firstRoll, secondRoll) + " ");
        }
    }

    private static int doubleDiceRoll(int firstRoll, int secondRoll) {
        return normalize(firstRoll) + normalize(secondRoll);
    }

    private static int normalize(int roll) {
        return (roll % 6) +1;
    }
}
