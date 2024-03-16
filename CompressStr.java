public class CompressStr {
    public static int compress(char[] c) {
        int resIdx = 0;
        int i = 0;
        while (i < c.length) {
            char curr = c[i];
            int count = 0;

            while (i < c.length && c[i] == curr) {
                count++;
                i++;
            }

            c[resIdx] = curr;
            resIdx++;

            if (count > 1) {
                String countStr = Integer.toString(count);
                for (char digit : countStr.toCharArray()) {
                    c[resIdx] = digit;
                    resIdx++;
                }
            }
        }

        return resIdx;
    }

    public static void main(String[] args) {
        char[] c = { 'a', 'a', 'a', 'b', 'b' };
        int compressedLength = compress(c);

        for (int i = 0; i < compressedLength; i++) {
            System.out.print(c[i]);
        }
    }
}
