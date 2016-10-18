/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.view;

import byui.cit260.secretsOfTheSea.control.GameControl;
import byui.cit260.secretsOfTheSea.control.InventoryControl;
import byui.cit260.secretsOfTheSea.control.InventoryReport;
import byui.cit260.secretsOfTheSea.control.MapControl;
import byui.cit260.secretsOfTheSea.control.NewGameControl;
import byui.cit260.secretsOfTheSea.control.ShipSelectionControl;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import byui.cit260.secretsOfTheSea.model.Map;
import byui.cit260.secretsOfTheSea.model.Storms;
import java.io.Console;

/**
 *
 * @author Nathan
 */
public class GameMenuView extends View{

    //InputView input2 = new InputView();
        
    public GameMenuView(NewGameControl username, MapControl map, ShipSelectionControl playerShip,
            InventoryControl inventory, LocationDetails island){
                super("\n Game Menu Options"
        + "\n S - Save Game"
        + "\n L - Load Game"
        + "\n H - Help"
        + "\n I - Inventory Manager"
        + "\n M - View Map"
        + "\n V - View all Statuses"
        + "\n T - Temp Inventory Report"
        + "\n\n C - Close Menu"
        + "\n Q - Quit Game", username, map, playerShip, inventory, island);
 //These aren't reachable here, but aren't assignable outside this constructor...
 //Could possibly have these setup in super constructor before the prompt message...
//        tempUsername = username;  
//        tempMap = map;
//        tempPlayerShip= playerShip;


    }
    
    public void saveGame(){
        this.console.println("\nEnter the file path wh3re you want to save your game");
        String filePath = tempInput.stringInput();
        try{

            GameControl.saveGame(
                    tempUsername.getPlayerName(),  
                    tempMap.getDiffMultiplier(),
                    tempMap.getLocation(),
                    tempMap.getMapGrid(), 
                    tempMap.getMapOne(), 
                    tempMap.getNumStorms(), 
                    tempMap.getStorms(),
                    tempMap.getTempWarning(),
                    tempMap.getDifficulty(),
                    tempPlayerShip.getSelectedShip(),
                    tempPlayerShip.getChozenShip(),
                    tempInventory.getCargo(),
                    tempInventory.getStorage(),
                    tempMap.getSetupAreas(),
                    
                    filePath);
            this.console.println("\nGame has been saved.\n");
        } catch (Exception ex){
            ErrorView.display("GameMenuView", ex.getMessage());
        }
    }
    
    public void loadGame(){
        this.console.println("\nEnter the file path to load your saved data from.");
        String filePath = tempInput.stringInput();
        try{
            //Load a Saved Game
            GameControl.loadGame(filePath, tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
            this.console.println("Saved data has been loaded.  Returning to Game Menu.");
        } catch (Exception ex){
            ErrorView.display("GameMenuView", ex.getMessage());
        }
        //From here the game would return to the game menu, no reason to re-call it.
        //this is because the return is set to false.
    }
        
    public void quitGame(){
        this.console.println("quitGame method called");
    }
    
//    public void closeMenu(){
//        this.console.println("closeMenu method called");
//    }
    
    @Override
    public boolean doAction(char entry){
        //return false to stay in same menu, return true to exit this view to previous view
        //also return false for invalid input to repeat the view with the display function
        char value = entry;
        switch (value) {
            case 'S':
		this.saveGame();
		return false;
            case 'L':
		this.loadGame();
		return false;
            case 'H':
		HelpMenuView helpMenu = new HelpMenuView();
		return false;
            case 'Q':
		this.quitGame();
		return true;
            case 'C':
		//this.closeMenu();  Shouldn't need.  It just returns true and closes.
		return true;
            case 'I':
		InventoryManagerView inventoryView = new InventoryManagerView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'M':
                tempMap.PrintMap();
                return false;
            case 'V':
		StatusesView status = new StatusesView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'T'://Chose T for temporary report
//               Console console = System.console();
//               String outFileLocation = console.readLine("Enter the location where report should be stored");
//               outFileLocation = outFileLocation.trim();

                String outFileLocation = ("InventoryReport.txt");
                InventoryReport inventoryReport = new InventoryReport(tempInventory, outFileLocation);
                return false;
            default:
                ErrorView.display(this.getClass().getName(),"\n Invalid choice.  Please try again.");
                return false;
        }
    }
}