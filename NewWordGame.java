
/**
 * The program scrambles a word from the list and the user has to guess that word!
 *
 * @authors (Yasmin A, Shruthi R, Isy H)
 * @version (2020-01)
 */

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class NewWordGame
{
  private String[] words;
  private String fileName = "popular.txt";
  private int numWords = 25322;
  private boolean isSorted;
  private static String original;
  private static String scrambled = " ";
  private static String guess;

  /** The constructor attempts to fill the array words with 
   *  words from the file fileName.
   */
  public NewWordGame()
  {
    
    File file = new File(fileName);
    Scanner wordFile = null;
    try
    {
        wordFile = new Scanner(file);
    }
    catch (FileNotFoundException ex)
    {
        System.out.println("*** Cannot open " + fileName + " ***");
        System.exit(1);        // quit the program
    } 

    // Initialize the array of words
    words = new String[numWords];
    // Fill the array from the input file
    for (int i = 0; i < numWords; i++)
    {
      words[i] = wordFile.nextLine();
    }
}
  
  /** 
   *  
   *  Finds the original word from the list of words
  */
  public String chooseRandomWord()
  {
      original = words[(int)(Math.random()*words.length)];
      return original;
  }
  
  /** 
   *  
   *  Scrambles the original word
  */
  public String scrambleWord()
  {
    ArrayList<Character> origword = new ArrayList<Character>(original.length());
    for (int i = 0; i < original.length(); i++) // fills the new array with each of the characters
    {
        origword.add(original.charAt(i));
    }
    ArrayList<Character> scram = new ArrayList<Character>(original.length()); // scrambles the word based on the index
    while (origword.size() > 0)
    {
        int num = (int)(Math.random()*origword.size());
        scram.add(origword.get(num));
        origword.remove(num);
    }
    for (int k = 0; k < scram.size(); k++) // fills a new array with the scrambled word
    {
        scrambled += scram.get(k);
    }
    return scrambled;
  }
  
  /** 
   *  
   *  Checks if the users guess is correct
  */
 public boolean checkGuess()
  {
      if (guess.equals(original))
      {
          return true;
      }
      return false;
  }
   
  public static void main (String[] args)
    {
        Scanner kbd = new Scanner (System.in);
        NewWordGame myWords = new NewWordGame();
        System.out.println(myWords.chooseRandomWord());
        System.out.println(myWords.scrambleWord());
        int startingGuess = 3;
        
        System.out.println("What do you think this word is? (You have " + (startingGuess+1) + " guesses left, so guess wisely!!)");
        guess = kbd.nextLine();
        for (int i = 0; i <= 3; i++)
        {
            if(myWords.checkGuess() == true)
            {
                System.out.println("Congrats! You got it right!! The unscrambled word is " + myWords.original + ".");
                break;
            }
            else
            {
                if (i == 3)
                {
                    System.out.println("Sorry, " + guess + " is incorrect. The correct answer is " + myWords.original + ".");
                }
                else
                {
                    System.out.println("Sorry, " + guess + "is incorrect. Please try again! " + "You have " + startingGuess + " guesses left. Be careful!");
                    guess = kbd.nextLine();
                    startingGuess --;
                }
            }
        }
        kbd.close();
    }
}