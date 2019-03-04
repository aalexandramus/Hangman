import java.sql.SQLOutput;
import java.util.Scanner;
public class Prompter {
    private Game game;

    public Prompter(Game game){
        this.game=game;
    }
    public boolean promptForGuess(){
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;
        do {
            System.out.println("Enter a letter:  ");
            String guessInput = scanner.nextLine();
            char guess = guessInput.charAt(0); //face string din valoafrea introdusa de la tast

            try {
                isHit = game.applyGuess(guess);
                isAcceptable = true;  //doar daca nu se aplica exceptia
            } catch (IllegalArgumentException iae) {
                System.out.printf("%s. Please try again!%n",
                                    iae.getMessage());
            }
        }while (! isAcceptable);
        return isHit;
    }
    public void displayProgress(){
        System.out.printf("You have %d tries lift to solve : %s%n",
                game.getRemainingTries(),
                game.getCurrentProgress());

    }
    public void displayOutcome(){
        if(game.isWon()){
            System.out.printf("Congratulations, you won with %d tries remaining.%n",
                                game.getRemainingTries());
        } else {
            System.out.printf("Bummer the word was %s.%n",
                                game.getAnswer());
        }
    }
}
