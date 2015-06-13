import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class N47TicTacToe {

    private static final int MAX_MOVES_PER_PLAYER = 5;

    private static final BufferedReader in = new PoliteCodeAbbeyBufferedReader(new InputStreamReader(System.in));
    public static final StringBuffer answers = new StringBuffer();

    public static void main(String args[]) throws IOException {
        int numLines = Integer.valueOf(in.readLine());
        in.lines().limit(numLines)
                .map(N47TicTacToe::tictactoe)
                .forEach(N47TicTacToe::output)
        ;
        System.out.println("Here are the answers :");
        System.out.println(answers.toString());
    }

    private static void output(Object result) {
        answers.append(result).append(" ");
    }

    private static int tictactoe(String testCaseData) {
        return winningMove(Arrays.stream(testCaseData.split(" ")).mapToInt(Integer::parseInt).iterator());
    }

    private static int winningMove(Iterator<Integer> moves) {
        List<Integer> X = new ArrayList<>(MAX_MOVES_PER_PLAYER);
        List<Integer> O = new ArrayList<>(MAX_MOVES_PER_PLAYER);
        int i = 0;
        while (moves.hasNext()) {
            X.add(moves.next());
            if (madeALine(X)) return i + 1;
            i++;
            if (moves.hasNext()) {
                O.add(moves.next());
                if (madeALine(O)) return i + 1;
                i++;
            }
        }
        return 0;
    }

    private static boolean madeALine(List<Integer> moves) {
        for (Line line : Line.values()) {
            if (line.isCompleted(moves)) return true;
        }
        return false;
    }


    enum Line {
        H1(1, 2, 3),
        H2(4, 5, 6),
        H3(7, 8, 9),

        V1(1, 4, 7),
        V2(2, 5, 8),
        V3(3, 6, 9),

        D1(1, 5, 9),
        D2(3, 5, 7);

        private List<Integer> cells;

        Line(int from, int via, int to) {
            this.cells = Arrays.asList(from, via, to);
        }

        public boolean isCompleted(List<Integer> moves) {
            return moves.containsAll(cells);
        }
    }


    static class PoliteCodeAbbeyBufferedReader extends BufferedReader {

        private int currentLine = -1;
        private int numLines;

        public PoliteCodeAbbeyBufferedReader(Reader in, int sz) {
            super(in, sz);
        }

        public PoliteCodeAbbeyBufferedReader(Reader in) {
            super(in);
        }

        @Override
        public String readLine() throws IOException {
            currentLine++;
            if (currentLine <= 0) {
                System.out.print("Hello, how many lines of test this time ? ");
                String line = super.readLine();
                numLines = Integer.parseInt(line);
                return line;
            } else if (currentLine < numLines) {
                System.out.println("Thanks, could you give me line number " + currentLine +" please :");
                return super.readLine();

            } else {
                System.out.println("Thank you very much, I've passed the data along. Bye");
                return super.readLine();
            }
        }
    }

}