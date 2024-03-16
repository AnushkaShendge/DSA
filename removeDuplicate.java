public class removeDuplicate {
    public static boolean[] map = new boolean[26];

    public static void Duplicate(String s, int idx, String ns) {
        if (idx == s.length()) {
            System.out.println("New String without Duplicates : " + ns);
            return;
        }

        char curr = s.charAt(idx);

        if (!map[curr - 'a']) {
            ns += curr;
            map[curr - 'a'] = true;
        }

        Duplicate(s, idx + 1, ns);
    }

    public static void main(String args[]) {
        String s = "abbccda";
        String ns = "";
        Duplicate(s, 0, ns);
    }
}
