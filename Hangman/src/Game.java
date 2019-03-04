public class Game {
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;
    public Game(String answer){
        this.answer=answer;
        hits = "";
        misses = "";
    }
    public String getAnswer(){
        return answer;
    }
    private char normalizeGuess(char letter){
        if(! Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required!");
        }
        letter = Character.toLowerCase(letter);
        if(misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1){
            throw new IllegalArgumentException(letter + " letter has already been guesed");
        }
        return letter;
    }
    public boolean applyGuess(char letter){  //verific daca litera e buna
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if(isHit){
            hits += letter;
        }else{
            misses += letter;
        }
        return isHit;
    }
    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }
    public String getCurrentProgress(){
        String progress = "";
        for(char letter : answer.toCharArray()){
            char display = '-';
            if(hits.indexOf(letter) != -1){
                display=letter;
            }
            progress += display;
        }
        return progress;
    }
    public boolean isWon(){
        return getCurrentProgress().indexOf('-') == -1;  //verific daca mai sunt '-' in  cuvant
    }
}
