public class Day2CountMax {
    public static void main(String[] args){
    countMax(new int[]{3, 5, 2, 5, 5, 5});

    }
    public static void countMax(int[] arr){
        int max=arr[0];
        int count=0;
        for (int j : arr) {
            if (j == max) count++;
            else if (j > max) {
                max = j;
                count = 1;
            }
        }
        System.out.printf( "The largest number is %d, The occurrence count of the largest number is %d",
                max,count);
    }
}
