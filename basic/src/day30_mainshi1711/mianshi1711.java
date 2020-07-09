package day30_mainshi1711;

/**
 * ClassName:mianshi1711
 * Package:day30_mainshi1711
 * Discription:
 *
 * @Data:2020/7/9 16:32
 */
public class mianshi1711 {
    public static int findClosest(String[] words, String word1, String word2) {
            if (words == null || words.length < 1) return 0;
            int i1 = -1, i2 = -1, result = words.length;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    if (i2 > -1) {
                        result = Math.min(Math.abs(i2 - i), result);
                    }
                    i1 = i;
                } else if (words[i].equals(word2)) {
                    if (i1 > -1) {
                        result = Math.min(Math.abs(i1 - i), result);
                    }
                    i2 = i;
                }
            }
            return result;
        }

    public static void main(String[] args) {
        String[] words = {"I", "am", "a", "student", "from", "a", "university", "in", "a", "city"};
        int closest = findClosest(words, "a", "student");
        System.out.println(closest);
    }

}
