/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.view;

import byui.cit260.secretsOfTheSea.control.GameControl;
import byui.cit260.secretsOfTheSea.control.InitializeControl;
import byui.cit260.secretsOfTheSea.control.InventoryControl;
import byui.cit260.secretsOfTheSea.control.MapControl;
import byui.cit260.secretsOfTheSea.control.NewGameControl;
import byui.cit260.secretsOfTheSea.control.ShipSelectionControl;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import secretsofthesea_rpg.SecretsOfTheSea_RPG;

/**
 *
 * @author Nathan
 */
public class StartProgramView {
    
    public StartProgramView(){
        
    }
    private final BufferedReader keyboard = SecretsOfTheSea_RPG.getInFile();
    private final PrintWriter console = SecretsOfTheSea_RPG.getOutFile();
    //InputView is not a super class so no need for inheritance.
    //gets the existing inFile and outFile memory and assigns in here.  This allows the
    //program to use the existing streams instead of opening more streams for each view.
    
    InputView input = new InputView(); 
    
    public void startProgram(NewGameControl tempGame, MapControl tempMap,
            ShipSelectionControl tempShip, InventoryControl tempInventory, LocationDetails tempIsland){
        char mainInput;
        this.displayBanner();
        InitializeControl initialize = new InitializeControl();
        initialize.initializeGame();
        this.startupInput();
        do {//Followed this week's paturn to make this continue when help is the option.  Stops otherwise.
            mainInput = this.startMenuDisplay(tempGame, tempMap, tempShip, tempInventory, tempIsland);
        }while (!((mainInput == 'G') || (mainInput == 'L') || (mainInput == 'Q')));

    }

    public void displayBanner (){
        this.console.println("\n\n *********************************************");
        this.console.println("\n        Secrets of the Sea");
        this.console.println(" The Best Treasure hunting game ever!");
        this.console.println("\n **********************************************");
        
        this.console.println(""
                + "\n Secrets of the Sea is a text-based role playing adventure. In this game, you will be taking on the"
                + "\n role as captain of a ship. You will navigate 7 ports and 22 excavation sites as you seek to acquire 8"
                + "\n highly valuable statues. On each token there is a piece of an ancient inscription, and when all 8 are "
                + "\n put together a secret code is unlocked."
                + "\n"
                + "\n As time has gone on, the statues have changed from history to possible myths. Some believe in"
                + "\n their ability to unlock hidden treasure, while others think it is nothing by a made up story."
                + "\n Leverage your crew & ship to gain access to the ports where you can then explore the sites."
                + "\n Upon gaining equipment and other necessities, voyages will be chosen to not only find these hidden statues, "
                + "\n but to survive the now tumultuous atmosphere of the world."
                + "\n"
                + "\n As you travel you will encounter different societies, each will respond differently to your approach"
                + "\n(Diplomacy, Intimidation, Bribery, Deceit)"
                + "\n"
                + "\n After picking a crew/ship and packing a ship, you will as captain, lead your team on an adventure of a lifetime."
                + "\n Those who preserve and work together are likely to unlock the mysteries awaiting on both sea and land."
                + "\n");
        
        this.console.println("\n Hope you have a fun time."
        + "\n" );
    }
    
    public void startupInput(){
        String input1 = null;
        this.console.println("Press ENTER to Proceed.");

        try {
        input1 = keyboard.readLine();
        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(),"\nError obtaining input\n");
        }
    }
    
    public char startMenuDisplay(NewGameControl tempGame, MapControl tempMap,
            ShipSelectionControl tempShip, InventoryControl tempInventory, LocationDetails tempIsland){//change to return character for comparison in startProgram()
        char mainInput;
        this.console.println("Please select an option below"
                + "\nHotkey - Description"
                + "\n G - Start Game"
                + "\n H - Help Menu"
                + "\n L - Load Game"
                + "\n Q - Quit Game"
                + "\n");
        
        mainInput = this.startMenuInput();
        this.startMenuChoice(mainInput, tempGame, tempMap, tempShip, tempInventory, tempIsland);
        return mainInput;//added this line
    }
    
    public char startMenuInput(){
        char input1;
        input1 = input.charInput();
        while(!((input1 == 'G') || (input1 == 'H') || (input1 == 'L') || (input1 == 'Q'))){
        ErrorView.display(this.getClass().getName(), " that is an invalid entry. Please select an option below:"
            + "\nHotkey - Description"
            + "\n G - Start Game"
            + "\n H - Get Help"
            + "\n L - Load Game"
            + "\n Q - Quit Game");
            input1 = input.charInput();
        }
        return input1;
        //do-while and while loops, continue if condition is true. Exit when false.
    }
    
    public void loadGame(NewGameControl tempGame, MapControl tempMap,
            ShipSelectionControl tempShip, InventoryControl tempInventory, LocationDetails tempIsland){
        this.console.println("\nEnter the file path to load your saved data from.");
        String filePath = input.stringInput();
        //****************Test Load from here and Game Menu**********
        try{
            //Load a Saved Game
            GameControl.loadGame(filePath, tempGame, tempMap, tempShip, tempInventory, tempIsland);
            this.console.println("Saved data has been loaded.  Returning to Game Menu.");
        } catch (Exception ex){
            ErrorView.display("GameMenuView", ex.getMessage());
        }
    }
    
    
    public void startMenuChoice(char userChoice, NewGameControl tempGame, MapControl tempMap,
            ShipSelectionControl tempShip, InventoryControl tempInventory, LocationDetails tempIsland){
        MainMenuView mMView = new MainMenuView();
        switch (userChoice) {
            case 'G':
                mMView.newGame(tempGame, tempMap, tempShip, tempInventory, tempIsland);
                break;
            case 'H':
                mMView.openHelp();
                break;
            case 'L':
                this.loadGame(tempGame, tempMap, tempShip, tempInventory, tempIsland);
                break;
            case 'Q':
                mMView.quitGame();
                break;
            default:
                ErrorView.display(this.getClass().getName(),"\n Invalid Selection *** Try again \n");
        }
    }
    
}
    
/******** String Compare with compareTo  ************
      public void startMenuInput(){
        String input;
        //Scanner keyboard = new Scanner(System.in);
    do {
        input = keyboard.nextLine();
        input = input.trim();
        this.console.println("Invalid Entry. Please select an option below"
            + "\nHotkey - Description"
            + "\nG - Start Game"
            + "\nH - Get Help"
            + "\nL - Load Game"
            + "\nQ - Quit Game"
            + "\ninput = " + input);
    }while(!((input.compareTo("g"))==0));// || (input == 'G') || (input == 'h') || (input == 'H') || (input == 'l') || (input == 'L') || (input == 'q') || (input == 'Q') ) );
        //do-while and while loops, continue if condition is true. Exit when false.
    // 0 is false so if 0 == 0 then it's true and ! again turns it false.
    }
*/
