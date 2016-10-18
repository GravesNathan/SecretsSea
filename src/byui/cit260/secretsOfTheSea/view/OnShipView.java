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
import byui.cit260.secretsOfTheSea.model.CurrentStatus;
import byui.cit260.secretsOfTheSea.model.LocationDetails;

/**
 *
 * @author SDababneh
 */
public class OnShipView extends View{
 
    public OnShipView(NewGameControl username, MapControl map, ShipSelectionControl playerShip,
            InventoryControl inventory, LocationDetails island){
        super("You are on your ship at dock.  What would you like to do?"
                + "\n"
                + "\n Please choose an option below:"
                + "\n L - Launch the ship"
                + "\n D - Disembark (Leave the ship)"
                //+ "\n W - Work on(Repair) the ship"
                + "\n I - View Inventory"
                + "\n V - View all Statuses"
                + "\n M - View Map"
                + "\n G - Game Menu \n", username, map, playerShip, inventory, island);
            }
    
    public void launchShipControl(){
        this.console.println("launchShipControl stub");
    }
    
    public void workOnShipControl(){
        this.console.println("workOnShip stub");
    }
  
    @Override
    public boolean doAction(char entry){
        char value = entry;
        
        switch (value) {
            case 'L':
		//this.launchShipControl();
                MapView moveShip = new MapView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'D':
                //Load Island from mapControl/societies referene by name.islandnum...?
                //compare current location to locaton[i] x and y coordinates
                //if same set that as the local area varialbe and pass to explorableArea.
                //change enum to be society names organized by number.  
                //location.getIslandNum can help in next view to get name.
                //Guess will have to make due with island numbers...
                //add name with bit switch in populate maep to location details.
                LocationDetails locations[] = MapControl.getLocation();
                for (int i=0; i<8;i++){
                    if(CurrentStatus.getCurrentX()==locations[i].getXCoordinate() &&
                       CurrentStatus.getCurrentY()==
                       locations[i].getYCoordinate()){
                        tempIsland = locations[i];
                        ExplorableAreasView explorableareas = 
                                new ExplorableAreasView(tempUsername, tempMap, 
                                        tempPlayerShip, tempInventory, tempIsland);
                    }
                }
		return true;
//            case 'W':
//		this.workOnShipControl();
//		return false;
            case 'I':
		InventoryManagerView inventory = new InventoryManagerView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'V':
		StatusesView status = new StatusesView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'M':
                tempMap.PrintMap();
                return false;
            case 'G':
		GameMenuView gameMenu = new GameMenuView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            default:
                ErrorView.display(this.getClass().getName(),"\n Invalid choice.  Please try again.");
                return false;
        } 
        
    }
}
