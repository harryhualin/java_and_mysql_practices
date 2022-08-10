package day3;

public class NonIntResultException extends RuntimeException{
    String message;
    public NonIntResultException(int a, int b){
        message=a + " divided by " +b +" is not an integer";
   }
    public String toString(){
        return message ;
    }


    public static void main(String args[]){
        try{
            // I'm throwing the custom exception using throw
            throw new NonIntResultException(7,4);
        }
        catch(NonIntResultException exp){
            System.out.println(exp) ;
        }
    }
}
