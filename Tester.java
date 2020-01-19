
/**
 * A class for playing with a WordList
 *
 * @author Michael Buescher and APCS-A at Hathaway Brown
 * @version 2020-01
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Tester
{
    public static void main (String[] args)
    {
        Scanner kbd = new Scanner (System.in);
        WordArray myWords = new WordArray();
        System.out.println ("Loaded over 23,000 words!");
        
        System.out.print ("How many random words would you like?");
        int n = kbd.nextInt();
        ArrayList results = myWords.getRandomWords (n);
        System.out.println (results);
        
        kbd.close();
    }
}
