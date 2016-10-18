/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.view;

import byui.cit260.secretsOfTheSea.exceptions.CharInputException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import secretsofthesea_rpg.SecretsOfTheSea_RPG;

/**
 *
 * @author Nathan
 */
public class InputView {
    
    private final BufferedReader keyboard = SecretsOfTheSea_RPG.getInFile();
    private final PrintWriter console = SecretsOfTheSea_RPG.getOutFile();//Changed to private
    //InputView is not a super class so no need for inheritance.
    //gets the existing inFile and outFile memory and assigns in here.  This allows the
    //program to use the existing streams instead of opening more streams for each view.
    
    public char charInput(){

        char value = ' ';
        try {
            value = Character.toUpperCase(this.keyboard.readLine().charAt(0));
        //this.console.println("Invalid Character Input.  Plese try again.");
        //If possible check for valid character input. Otherwise probably handle
        //swith switch statement wherever this was called from
        }catch (Exception e) {
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
        }
        return value;  //return the user input.
    }
    
    public int intInput(){
        //Scanner keyboard = new Scanner(System.in);
        String input;
        int value = -1;//Need invalid choice for when NumberFormatException is caught.
        //This allows the loop prompting for valid input to continue where this is called from.
        try {
        input = this.keyboard.readLine();
        input = input.trim();
        value = Integer.parseInt(input);
        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(),"Error obtaining input\n");
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),"Please enter a valid whole number.\n");
            
        }
        return value;  //return the user input.
    }
    
        public String stringInput(){
        //Scanner keyboard = new Scanner(System.in);
        String value = null;
        try {
        value = this.keyboard.readLine();
        value = value.trim();
        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(),"Error obtaining input\n");
        }
        return value;
    }
}
