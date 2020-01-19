/**
 *  Stores a list of words in an array.
 *  Reads the words from a file;
 *  stores them in an array of Strings;
 *  can retrieve them.
 */

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class WordArray
{
  private String[] words;
  private String fileName = "popular.txt";
  private int numWords = 25322;
  private boolean isSorted;

  /** The constructor attempts to fill the array words with 
   *  words from the file fileName.
   */
  public WordArray()
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

  /** Returns an ArrayList of n random words. 
   *  @param n  The number of words to return
   *  @return   an ArrayList of n random words */
  public ArrayList<String> getRandomWords (int n)
  {
      ArrayList<String> wordList = new ArrayList<String>();
      
      for (int i = 1; i <= n; i++)
      {
          int a = (int)(Math.random() * words.length);
          wordList.add(words[a]);
      }
      return wordList;
  }
}