public class Reverse {
    public static void main(String[] args) {
        String s = reverseS("hello");
        System.out.println(s);
    }
    public static String reverseS(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

}
