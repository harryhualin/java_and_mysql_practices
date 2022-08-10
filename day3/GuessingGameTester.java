package day3;
import java.util.Random;
import java.util.Scanner;

class GuessingGame {
    private int answer;
    private boolean gameOver;
    private Random generator;
    private int differential;
    private int max;
    private int maxGuessesAllow;
    private int numGuessesTaken;

    public GuessingGame(){this.setMax(0);this.generator = new Random();;};
    public GuessingGame(int max){this.setMax(max);this.generator = new Random();};

    public void newGame(int maxGuessesAllow){
            this.setMaxGuessesAllow(maxGuessesAllow);
            this.setAnswer(this.generator.nextInt(this.getMax()+1));
            this.setGameOver(false);
            this.setDifferential(this.max);
            this.setNumGuessesTaken(0);}

    public void guess(int n){
            if (this.getGameOver()) {
                System.out.println("The game is over. "
                        + "You can not guess again.");
            }
            else if (n>this.getMax()){
                System.out.println("Guess out of range, The guess must be between 0 and " +this.getMax()+
                        "\nEnter your guess, remember it must be between 0 and "+this.getMax());
            }
            else if (n == this.getAnswer()) {
                System.out.println("Congratulation!");
                this.setGameOver(true);
            } else {
                if (n < this.getAnswer()) {
                    System.out.println("Too Low.");
                } else {
                    System.out.println("Too High.");
                }

                if (Math.abs(n-this.getAnswer()) < this.getDifferential()) {
                    System.out.println("Getting Warmer.");
                    this.setDifferential(Math.abs(n-this.getAnswer()));
                } else if (Math.abs(n-this.getAnswer()) > this.getDifferential()) {
                    System.out.println("Getting Colder.");
                    this.setDifferential(Math.abs(n-this.getAnswer()));
                }
                this.setNumGuessesTaken(this.getNumGuessesTaken()+1);
                if (this.numGuessesTaken >= this.maxGuessesAllow) {
                    System.out.println("You have used up all of your guesses.");
                    this.setGameOver(true);
                }
            }
    }
    public boolean isGameOver(){ return this.getGameOver();}

    public int getAnswer(){return this.answer;}
    public void setAnswer(int a){this.answer=a;}

    public boolean getGameOver(){return this.gameOver;}
    public void setGameOver(boolean s){this.gameOver=s;}


    public int getDifferential(){return this.differential;}
    public void setDifferential(int a){this.differential=a;}

    public int getMax(){return this.max;}
    public void setMax(int a){this.max=a;}

    public int getMaxGuessesAllow(){return this.maxGuessesAllow;}
    public void setMaxGuessesAllow(int a){this.maxGuessesAllow=a;}

    public int getNumGuessesTaken(){return this.numGuessesTaken;}
    public void setNumGuessesTaken(int a){this.numGuessesTaken=a;}

}

public class GuessingGameTester{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String option;
        boolean isQuit=false;

        while(isQuit==false){
            System.out.println("Welcome to the Guessing Game");
            System.out.println("Enter the maximum number");
            int n = input.nextInt();
            GuessingGame theGame = new GuessingGame(n);
            System.out.println("Enter the number of guess allowed:");
            n = input.nextInt();
            theGame.newGame(n);
            //System.out.println("answer is:  "+theGame.getAnswer()+" (test only)");
            while(theGame.isGameOver() == false){
                System.out.println("Guess a number between 0 and 100:");
                n = input.nextInt();
                theGame.guess(n);
            }
            while(true){
            System.out.println("Would you like to play again, enter Y for yes, N for no.");
            option=input.next();
            if(option.compareTo("N")==0) {System.out.println("EXITING GAME");isQuit=true;break;}
            else if (option.compareTo("Y")==0) {break;}
            else System.out.println("Enter Y or N only.");
            }

        }

    }
}
