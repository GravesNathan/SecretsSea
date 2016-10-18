/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.view;

import byui.cit260.secretsOfTheSea.control.InventoryControl;
import byui.cit260.secretsOfTheSea.control.MapControl;
import byui.cit260.secretsOfTheSea.control.NewGameControl;
import byui.cit260.secretsOfTheSea.control.ShipSelectionControl;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import byui.cit260.secretsOfTheSea.view.ErrorView;
import secretsofthesea_rpg.SecretsOfTheSea_RPG;

/**
 *
 * @author SDababneh
 */
public abstract class View implements ViewInterface {
    
    protected InputView tempInput = new InputView();
    private String promptMessage;
    protected NewGameControl tempUsername = null;
    protected MapControl tempMap = null;
    protected ShipSelectionControl tempPlayerShip= null;
    protected InventoryControl tempInventory = null;
    protected LocationDetails tempIsland = null;
    protected final BufferedReader keyboard = SecretsOfTheSea_RPG.getInFile();
    protected final PrintWriter console = SecretsOfTheSea_RPG.getOutFile();
    
    public View(String promptMessage, NewGameControl username, MapControl map, ShipSelectionControl playerShip,
        InventoryControl inventory, LocationDetails island) {
        tempUsername = username;  
        tempMap = map;
        tempPlayerShip= playerShip;
        tempInventory = inventory;
        tempIsland = island;
        this.console.println("\n");
        this.promptMessage = promptMessage;
        this.display();
    }
    
    @Override
    public void display(){
        boolean done = false;
        char value = ' ';
        do {
                this.console.println(this.promptMessage);
		value = this.getInput();
		done = this.doAction(value);
                //doAction in sub-class return true to stay in
                //same view.  return false to remain in same view.  return true
                //to exit view and return to previous view.
        }while (!done);
    }//Repeat until the player chooses to close the menu or quit the game.
    

    
    @Override
    public char getInput(){
        //Scanner keyboard = new Scanner(System.in);
        char value = ' ';
        try {
        value = Character.toUpperCase(this.keyboard.readLine().charAt(0));      
        //try {value = this.keyboard.readLine().charAt(0);
        //We need to add a throw here for invalid input.  Character class I created!
            //Something like detecting if input is NOT NAN should do.
        }catch (Exception e) {
            ErrorView.display(this.getClass().getName(),"Error reading input: " + e.getMessage());
        }
        return value;  //return the user input.
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
    
    public void nextInput() {
        this.console.println("\n");
        this.promptMessage = promptMessage;
        this.display();//This calls doAction which is overridden...How can I get it to detect... I can next the switches within a for/switch in doAction
        //This can have 0 be 1st input, 1 second, and so on.  If they hit close at any time it closes
        //If they select to cancel...can I call the default constructor again...
    }
}

