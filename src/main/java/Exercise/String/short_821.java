package Exercise.String;

import java.util.Arrays;

public class short_821 {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        Arrays.fill(res, Integer.MAX_VALUE);
        int pos = -1;
        for (int i = 0; i < S.length(); i++) {
            if (C == S.charAt(i)) {
                pos = i;
                res[i] = 0;
            } else if (pos != -1) {
                res[i] = i - pos;
            }
        }
        pos = -1;
        for (int i = S.length() - 1; i >= 0; i--) {
            if (C == S.charAt(i)) {
                pos = i;
                res[i] = 0;
            } else if (pos != -1) {
                res[i] = Math.min(pos - i, res[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "iloveleetcode";
        char C = 'e';
        int[] array = new short_821().shortestToChar(S, C);
        for (int i : array) {
            System.out.print(i + ",");
        }
    }
}

