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

/**
 *
 * @author SDababneh
 */
public class EndGameView extends View{
    
    public EndGameView(NewGameControl username, MapControl map, ShipSelectionControl playerShip,
            InventoryControl inventory, LocationDetails island){
        super("\n Game Over"
                + "\n C - View Credits"
                + "\n V - View All Statuses"
                + "\n E - Exit Game"
                + "\n S - Start New Game", username, map, playerShip, inventory, island);
    }
    
    public void viewCredits(){
        this.console.println("View Credits function stub");
    }
    
    public void exitGame(){
        this.console.println("Exit Game function stub");
    }
    
  @Override
    public boolean doAction(char entry){
        char value = entry;
    
        switch (value) {
            case 'C':
                this.viewCredits();
                return false;
            case 'E':
                this.exitGame();
                return false;
            case 'V':
		StatusesView status = new StatusesView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'S':
                MainMenuView mainMenu = new MainMenuView();
                return false; 
            default:
                this.console.println("\n Invalid choice. Please try again.");
                return false;
        }
    }
}
