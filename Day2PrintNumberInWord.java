public class Day2PrintNumberInWord {
    public static void main(String[] args){
        PrintNumberInWord(5);
    }
    public static void PrintNumberInWord(int number){
        String numberStr = null;
        if (0 == number) {
            numberStr = "ZERO";
        } else if (1 == number) {
            numberStr = "ONE";
        } else if (2 == number) {
            numberStr = "TWO";
        } else if (3 == number) {
            numberStr = "THREE";
        } else if (4 == number) {
            numberStr = "FOUR";
        } else if (5 == number) {
            numberStr = "FIVE";
        } else if (6 == number) {
            numberStr = "SEX";
        } else if (7 == number) {
            numberStr = "SEVEN";
        } else if (8 == number) {
            numberStr = "EIGHT";
        } else if (9 == number) {
            numberStr = "NINE";
        } else {
            numberStr = "OTHER";
        }
        System.out.println("nested-if: " + numberStr);
        switch (number) {
            case 0:  numberStr = "ZERO";  break;
            case 1:  numberStr = "ONE";   break;
            case 2:  numberStr = "TWO";   break;
            case 3:  numberStr = "THREE"; break;
            case 4:  numberStr = "FOUR";  break;
            case 5:  numberStr = "FIVE";  break;
            case 6:  numberStr = "SEX";   break;
            case 7:  numberStr = "SEVEN"; break;
            case 8:  numberStr = "EIGHT"; break;
            case 9:  numberStr = "NINE";  break;
            default: numberStr = "OTHER"; break;
        }
        System.out.println("switch-case: " + numberStr);

    }
}
