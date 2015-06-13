import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Créé par yach17 le 13/06/2015.
 */
public class N72FunnyWordsGenerator {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static final char[] consonants = "bcdfghjklmnprstvwxz".toCharArray();
    public static final char[] vowels = "aeiou".toCharArray();
    private static int random;

    public static void main(String args[]) throws IOException {
        String firstLine[] = in.readLine().split(" ");
        random = Integer.valueOf(firstLine[1]);
        Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(N72FunnyWordsGenerator::funnyWord)
                .forEach(N72FunnyWordsGenerator::output)
        ;
    }

    private static void output(Object result) {
        System.out.print(result + " ");
    }


    private static String funnyWord(int nbLetter) {
        char[] funnyWord = new char[nbLetter];

        for (int i = 0; i < nbLetter; i++) {
            random = linearCongruentialGeneratorNextValue(445, 700001, 2097152, random);
            funnyWord[i]= (i % 2 == 0) ? consonant(random) : vowel(random);
        }
        return new String(funnyWord);
    }

    public static int linearCongruentialGeneratorNextValue(int a, int c, int m, int x0){
        return  (a * x0 + c) % m;
    }

    public static char vowel(int number) {
        return vowels[number % vowels.length];
    }
    public static char consonant(int number) {
        return consonants[number % consonants.length];
    }

}
