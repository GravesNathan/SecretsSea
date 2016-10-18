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
public class TrustTrialView extends View{
    
    public TrustTrialView(NewGameControl username, MapControl map, ShipSelectionControl playerShip,
            InventoryControl inventory, LocationDetails island){
        super("\n Trust Trial"
                + "\n D - Diplomatic Approach"
                + "\n S - Scare Tactics/Intimidation Approach"
                + "\n B - Bribery Approach"
                + "\n T - Treachery/Deceit Approach"
                + "\n F - Flee the Island"
                + "\n I - Inventory Manager"
                + "\n V - View All Statuses"
                + "\n G - Game Menu View", username, map, playerShip, inventory, island);
    }
    
    public void diplomaticApproach(){
        this.console.println("Diplomatic Approach function stub");
    }

    public void intimidationApproach(){
        this.console.println("Intimidation Approach function stub");
    }
        
    public void briberyApproach(){
        this.console.println("Bribery Approach function stub");
    }
    
    public void deceitApproach(){
        this.console.println("Deceit Approach function stub");
    }
    
    public void fleeApproach(){
        this.console.println("Flee Approach function stub");
    }
    
    @Override
    public boolean doAction(char entry){
        char value = entry;
        
        switch (value) {
            case 'D':
                this.diplomaticApproach();
                return false;
            case 'S':
                this.intimidationApproach();
                return false;
            case 'B':
                this.briberyApproach();
                return false;
            case 'T':
                this.deceitApproach();
                return false;
            case 'F':
                this.fleeApproach();
                return false;
            case 'I':
		InventoryManagerView inventory = new InventoryManagerView(tempUsername, tempMap, tempPlayerShip,
                        tempInventory, tempIsland);
		return false;
            case 'V':
		StatusesView status = new StatusesView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'G':
                GameMenuView gamemenu = new GameMenuView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
                return false; 
            default:
                ErrorView.display(this.getClass().getName(),"\n Invalid choice. Please try again.");
                return false;
        }
    }
    
}
