package Delivery.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solver {

    public int solve(String fileName) {
        Set<IntPair> intPairSet = new HashSet();
        String inputText = "";
        try {
            Scanner scanner = new Scanner(new File(fileName));
            inputText = scanner.next();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int x = 0;
        int y = 0;

        int roboX = 0;
        int roboY = 0;
        intPairSet.add(new IntPair(x, y));

        for (int i = 0; i < inputText.length(); i += 2) {
            char c = inputText.charAt(i);
            switch (c) {
                case ('^'):
                    y++;
                    break;
                case ('v'):
                    y--;
                    break;
                case ('>'):
                    x++;
                    break;
                case ('<'):
                    x--;
                    break;
                default:
                    break;
            }
            intPairSet.add(new IntPair(x, y));

            char d = inputText.charAt(i + 1);
            switch (d) {
                case ('^'):
                    roboY++;
                    break;
                case ('v'):
                    roboY--;
                    break;
                case ('>'):
                    roboX++;
                    break;
                case ('<'):
                    roboX--;
                    break;
                default:
                    break;
            }
            intPairSet.add(new IntPair(roboX, roboY));
        }

        return intPairSet.size();
    }

    private class IntPair {
        public IntPair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        final int x;
        final int y;

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof IntPair)) {
                return false;
            }

            IntPair i = (IntPair) o;
            return Integer.compare(x, i.x) == 0 && Integer.compare(y, i.y) == 0;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }
}
