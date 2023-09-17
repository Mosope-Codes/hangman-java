
import java.util.Scanner;

public class Hangman {
    

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Let's play Hamgman!");
            
            String randomWordChoice = randomWord(words);
            System.out.println(randomWordChoice);

            int i = 0;
            String placeholder = printPlaceholders(randomWordChoice);
            String missedGuess = "";
            
            

            while (true) {
                if(missedGuess.length() == (i + 1)){
                    System.out.println(gallows[i + 1]);
                    i++;
                } else{
                    System.out.println(gallows[i]);
                }

                System.out.print("\nGuess: ");
                String charString = scan.next();
                char userGuess = charString.charAt(0);
                

                System.out.print("\nWord: ");                
                placeholder = updatePlaceholder(randomWordChoice, userGuess, placeholder);
                System.out.println(placeholder);

                System.out.print("\nMisses: ");
                missedGuess = printMissedGuesses(randomWordChoice, userGuess, missedGuess);
                System.out.println(missedGuess);

                if(placeholder.indexOf("_") == -1){
                    System.out.println("YOU WON!");
                    System.exit(0);
                } else if(missedGuess.length() > 5){
                    System.out.println(gallows[gallows.length - 1]);
                    System.out.println("RIP");
                    System.out.println("The word is " + randomWordChoice);
                    System.exit(0);
                } 

            }
        }

        

        
        
        
        
        
        

    }

    public static String randomWord(String[] words){
        int randomNumber = (int)(Math.random() * words.length);
        return words[randomNumber];
    }

    public static boolean checkGuess(String word, char guess){
        boolean result = false;           
        for(int i = 0; i < word.length(); i++){
        if(word.charAt(i) == guess){
            result = true;            
        }
    }        
		return result;
    }

    public static String updatePlaceholder(String word, char guess, String placeholder){
        placeholder = placeholder.replace(" ", "");
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == guess){
                placeholder = placeholder.substring(0, i) + word.charAt(i) + placeholder.substring(i + 1);;               
            }
        }
        placeholder = placeholder.replace("", " ");
        return placeholder;
    }

    /**
     * functionName = printMissedGuess
     * Compare two letters
     * Check if they are equal. If they are not, store in an array.
     * @param word
     * @param guess
     */

    public static String printMissedGuesses(String word, char guess, String missedLetters){
        if(word.indexOf(guess) == -1){
            missedLetters += guess;
        }       
        return missedLetters;
        }
        

    public static String printPlaceholders(String word){
        String placeholderDisplay = "";
        for(int i = 0; i < word.length(); i++){           
            placeholderDisplay += "_ ";
        }
        return placeholderDisplay;
    }

    

}





