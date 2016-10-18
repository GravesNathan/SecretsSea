/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.view;

import byui.cit260.secretsOfTheSea.control.GameControl;
import byui.cit260.secretsOfTheSea.control.InventoryControl;
import byui.cit260.secretsOfTheSea.control.MapControl;
import byui.cit260.secretsOfTheSea.control.NewGameControl;
import byui.cit260.secretsOfTheSea.control.ShipSelectionControl;
import byui.cit260.secretsOfTheSea.exceptions.ExplorableAreasException;
//import byui.cit260.secretsOfTheSea.model.Player;
import byui.cit260.secretsOfTheSea.exceptions.MapControlException;
import byui.cit260.secretsOfTheSea.exceptions.ShipSelectionException;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import byui.cit260.secretsOfTheSea.model.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import secretsofthesea_rpg.SecretsOfTheSea_RPG;

/**
 *
 * @author Nathan
 */
public class MainMenuView {
    
    //brandon notes
    //start here
    //initialize here and it's accessible throughout class.
   private NewGameControl newUserSettings = null; //again why are we creating the memory later in line 30 instead of here?
   private MapControl mainMap = null;
   private LocationDetails island = null;
   private final BufferedReader keyboard = SecretsOfTheSea_RPG.getInFile();
   private final PrintWriter console = SecretsOfTheSea_RPG.getOutFile();
    //InputView is not a super class so no need for inheritance.
    //gets the existing inFile and outFile memory and assigns in here.  This allows the
    //program to use the existing streams instead of opening more streams for each view.
   
//   private ShipSelectionControl userShip = null; 
//   MapControl createMap = null;
   
   private ShipSelectionControl assignPlayerShip = null; 
   private InventoryControl inventory = null; 
   InputView input = new InputView();
    //combined two new game functions to get this single one.
   
   public MainMenuView(){
       
   }
   
    public void newGame(NewGameControl tempGame, MapControl tempMap,
            ShipSelectionControl tempShip, InventoryControl tempInventory, LocationDetails tempIsland){
        //Input Name
        this.console.println("Greetings Captain, welcome to the port-city of Rexburg, "
                + "how shall we address you?");
        String userName = input.stringInput();
        //Choose difficulty
        char difficultyLevel;
        do{
        this.console.println("Please select your difficulty.  "
                + "\nE = Easy"
                + "\nN = Normal"
                + "\nH = Hard");
        //difficultyLevel = Character.toUpperCase(difficultyReader.next().charAt(0));
        difficultyLevel = input.charInput();
        if (!((difficultyLevel == 'E') || (difficultyLevel == 'N') || (difficultyLevel == 'H')))
            ErrorView.display(this.getClass().getName(),"Invalid Input.  Please try again.");
         }while(!((difficultyLevel == 'E') || (difficultyLevel == 'N') || (difficultyLevel == 'H') || (difficultyLevel == 'S')));

//Try - Catch test code
        try{
        mainMap = new MapControl (difficultyLevel);
        } catch (MapControlException me) {
            this.console.println(me.getMessage());
        
        
        }catch  (IndexOutOfBoundsException oub) {
                this.console.println(oub.getMessage() + "\n" + oub.getStackTrace() + "\n");
        
        }catch (ExplorableAreasException eae) {
                this.console.println(eae.getMessage());
            ErrorView.display(this.getClass().getName(),"Returning to start program view.  Press Enter to Proceed");
            String pressEnter = null;
            String value = " ";
        try {
            pressEnter = keyboard.readLine();
        } catch (IOException ioe) {
            ErrorView.display(this.getClass().getName(),"Error obtaining input\n");
        }            
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.startProgram(tempGame, tempMap, tempShip, tempInventory, tempIsland);//Does this only work with an independent executable?
        }
        
        //Choose Ship
        String charShipChoice = "Raft";
        int shipChoice = 0;
        
        ShipSelectionControl tempShips = null;
        try {
        tempShips = new ShipSelectionControl(0);
                } catch (ShipSelectionException sse) {
                    this.console.println(sse.getMessage());
                ErrorView.display(this.getClass().getName(),"Error occured while creating ships"
                        + "for player to select from.");
        }
        do{
        this.console.println("\n Please select your ship with with options 0 through 3"
                + tempShips.toString());
        shipChoice = input.intInput();

        if (!((shipChoice == 0) || ( shipChoice == 1) || ( shipChoice == 2) || ( shipChoice ==3)))
            ErrorView.display(this.getClass().getName(),"Invalid Input.  Please try again.");
        }while(!( (shipChoice == 0) || ( shipChoice == 1) || ( shipChoice == 2) || ( shipChoice ==3) ));
        
        try {
        assignPlayerShip = new ShipSelectionControl(shipChoice);
            } catch (ShipSelectionException sse) {
                    ErrorView.display(this.getClass().getName(),sse.getMessage());
                ErrorView.display(this.getClass().getName(),"\n You must enter a valid number or we will give you a raft."
                + " Try again, you won't survive on a raft.");
        }
                
        newUserSettings = new NewGameControl(userName);
        inventory = new InventoryControl();
        
        try {
        this.console.println("Welcome " + Player.getName() +
                ", let's begin your " + mainMap.getUserDifficulty() + " adventures in Secrets of the Sea."
                + "\n Prepare to board your " + assignPlayerShip.getShipName() +  " and set sails on the open seas.");
        } catch (MapControlException me_difficulty) {
            ErrorView.display(this.getClass().getName(),me_difficulty.getMessage());
        }
        ExplorableAreasView beginExplore = new ExplorableAreasView(newUserSettings, mainMap, assignPlayerShip, inventory, island);
    }
    
    public void openHelp(){
        this.console.println("openHelp fucntion called");
            //load Help Menu into view
        HelpMenuView helpMenu = new HelpMenuView();
        
    }
    
    public void quitGame(){
        this.console.println("quitGame fucntion called");
    }
    
}
