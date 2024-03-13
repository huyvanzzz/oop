import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

    /**
     * Given a string, returns the length of the largest run.
     * A a run is a series of adajcent chars that are the same.
     *
     * @param str
     * @return max run length
     */
    public static int maxRun(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int a = 1, b = 1;
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            char d = str.charAt(i);
            if (d == c) {
                a++;
                b = Math.max(a, b);
            } else {
                a = 1;
                c = str.charAt(i);
            }

        }
        return b;
    }


    /**
     * Given a string, for each digit in the original string,
     * replaces the digit with that many occurrences of the character
     * following. So the string "a3tx2z" yields "attttxzzz".
     *
     * @param str
     * @return blown up string
     */
    public static String blowup(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char d = str.charAt(i);
            if (Character.isDigit(d)) {
                if (i + 1 < str.length()) {
                    char h = str.charAt(i + 1);
                    int c = Character.getNumericValue(d);
                    for (int j = 0; j < c; j++) {
                        result.append(h);
                    }
                }

            } else {
                result.append(d);
            }
        }
        return result.toString();
    }

    /**
     * Given 2 strings, consider all the substrings within them
     * of length len. Returns true if there are any such substrings
     * which appear in both strings.
     * Compute this in linear time using a HashSet. Len will be 1 or more.
     */
    public static boolean stringIntersect(String a, String b, int len) {
        if (a == null || b == null || len < 1) {
            return false;
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < a.length() - len; i++) {
            set.add(a.substring(i, i + len));
        }
        for (int i = 0; i < b.length() - len; i++) {
            if (set.contains(a.substring(i, i + len))) {
                return true;
            }
        }
        return false;

    }
}
