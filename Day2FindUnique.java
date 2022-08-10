public class Day2FindUnique {
    public static void main(String[] args){
        findUnique(new int[]{2, 2, 1});

    }
    public static void findUnique(int[] arr){
        // Do XOR of all elements and return
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
        }
        System.out.println("Element occurring once is " + res);
    }
}
