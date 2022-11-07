
//Srinayana Patil
//11/29/2021
//Hangman.java
//this is the code for the hangman game

import java.util.Scanner;
import java.util.Array;
import java.util.*;
import java.io.IOException;
class Hangman2 {
    
  public static void main(String[] args) {
 
    boolean playing = true; // declaring playing as true. is used when the game is being played
    Scanner s = new Scanner(System.in);  
    
 while (playing == true){  // when the game is being played
    int limbs = 10;
    Set<String> lettersGuessedB = new HashSet<>();//storing characters guessed before in the HashSet 
    System.out.println("Player 1, Enter a word:");
    
    String gameWord = s.nextLine().toLowerCase(); // the word is changed to lowercase
  
    int length = gameWord.length();// length is the length of the word entered by player 1

    char[] gameWordChars = gameWord.toCharArray(); //converts the string entered by player 1 to characters 

    //creates and prints an array of chars with the same length as string
    char[] dash = gameWord.toCharArray(); //setting every charachter in word to dash
    
    for (int i = 0; i < length; i++) { // this for loop adds dash in place of the letters of the word for player 2 to guess
        dash[i] = '_';
    }



    for (int i = 0; i<25;i++){ // 25 blank spaces so that the player2 cannot see the word while playing
        System.out.println( "  ");
    }
    System.out.println("limbs remaining: " +limbs); // prints the limbs

   

    // Main loop to take guesses 
    while((!String.valueOf(dash).equals(gameWord)) && (limbs <=10 && limbs > 0))  { 
        // when the letters in the dashes equal to the game word, then game ends; same with when the limbs are = 0
        // that is why, to continue playing the game, we say the opposite of those two
        
        boolean correct = false; //initializing the variables that will be used in this loop
        boolean repeated = false; //used to check if user guessed the same letter twice
        System.out.println("Letters guessed:" + lettersGuessedB.stream().reduce("", String::concat)); // this line of code adds every time a letter is guessed to the list

        for (int a = 0; a < length; a++) { // prints dashes in place of the letters of the word and a space after each letter which makes it easy to read
            System.out.print(dash[a] + " ");
        }
        System.out.println(); // prints in a new line
        

        //asks user for a guess(currentGuess), then stores that guess in Char (currentGuessChar) and String tempstring
        System.out.print("Player 2, guess a letter:");
        String currentGuess = s.next().toLowerCase().substring(0, 1); // the player 2's current guess letter is changed to lowercase 
        char currentGuessChar = currentGuess.charAt(0); //gets char data from scanner. charAt 0 for a letter is the letter itself

        //checks if user already guessed the letter previously
        if (lettersGuessedB.contains(currentGuess))  {
         
            System.out.println("You already guessed that letter");

            repeated = true; // it is repeated
            System.out.println(limbs + " limbs remaining"); // limbs aren't changed from previous guess
        }

        lettersGuessedB.add(currentGuess); // you are adding new guessed to the lettersGuessedB(letters guessed before)list

        //if the guess is not a repeated guess, checks if the guessed letter is in the word
        if (!repeated) { 
           
            for (int i = 0; i < length; i++) {
                if (gameWordChars[i] == currentGuessChar) { // if the characters of the game word correspond to the letter, then the dash in that index is replaced with that letter
                dash [i] = currentGuessChar;  //replaces _ with guessed letter 
                    correct = true;
                    
                }
            }
            if (correct) {
                System.out.print(limbs + " limbs remaining");
            } 
            else 
            {
                limbs--;
                System.out.print(limbs + " limbs remaining"); // if the letter isn't in the word, then the limbs are subtracted by 1
            }
            System.out.println();
        }
    
    }
    if((!String.valueOf(dash).equals(gameWord)) || limbs == 0) // if not all dashes are filled with the correct letters by player 2, or if the limbs = 0, player 1 wins
        {

        System.out.println("Player 1 wins!");
    }
    else
    {
        System.out.println(gameWord);

        System.out.println("Player 2 wins!"); // if not, player 2 wins
    } 

    System.out.println("Play again (y/n) ?");
    String again=s.next(); // takes in user's input

    if (again.equalsIgnoreCase("y")) // the .equalsIgnoreCase compares two strings irrespective of the case. In this part of the program, it is comparing teh users' input to what we have
    {

        playing = true; // if the users input is 'y' like our if statement, then another round of game starts

        gameWord = s.nextLine().toLowerCase();// scans the player 1's word for the second round

     }
   else if (again.equalsIgnoreCase("n"))// else, program ends
    {
            playing = false;
    }
     
    }

s.close(); // scanner is closed

 } 
 private static String gameWord;
 } 

