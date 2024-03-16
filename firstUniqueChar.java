public class firstUniqueChar {
    public static int uniqChar(String s) {
        int[] freq = new int[26];
        char[] chars = s.toLowerCase().toCharArray();

        for (char c : chars) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "Anushka";
        System.out.println("First Unique Character in String Is: " + uniqChar(s));
    }
}
