public class Day2MinsToYearDay {
    public static void main(String[] args){
        solution( 3456789);
    }
    public static void solution(int mins){
        int years=0, days=0 ;
        days=mins/(24*60);
        years=days/365;
        days=days%365;
        System.out.printf("%d minutes is approximately %d years and %d days",mins,years,days);
    }
}
