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
import byui.cit260.secretsOfTheSea.exceptions.CharInputException;
import byui.cit260.secretsOfTheSea.model.CurrentStatus;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import byui.cit260.secretsOfTheSea.model.Player;

/**
 *
 * @author Nathan
 */
public class ExplorableAreasView extends View {
    
    public ExplorableAreasView(NewGameControl username, MapControl map, 
            ShipSelectionControl playerShip, InventoryControl inventory, LocationDetails island){
                super("Welcome to the island."//customize island number, if possible name.  " + island.getSocietyName() +"  problems
                        //or calculate in OnShipView, passing to this view
                + "\nPlese select what you would like to do"
                //+ "\nE - Explore the Area"
                //+ "\nM - Move to new Area"
                + "\nB - Board Ship"
                //+ "\nW - Work on Ship"
                + "\nM - Meet society leder"
                + "\nX - Exchange Resources"
                + "\nI - Inventory Manager"
                + "\nV - View all Statuses"
                + "\nG - Game Menu\n", username, map, playerShip, inventory, island);
            }
    
    
//    public void exploreAreaControl(){
//        this.console.println("exploreAreaControl method called");
//    }
    
//    public void onShipView(){
//        this.console.println("onShipView method called");
//        //load OnShipView
//    }
    
//    public void moveAreaControl(){
//        this.console.println("moveAreaControl Stub");
//    }
            
//    public void workOnShipControl(){
//        this.console.println("workOnShipControl method called");
//    }
    
    public void exchangeView(){
        this.console.println("exchangeViewStub called");
    }

    @Override
    public boolean doAction(char entry) {
        char value = entry;
        try{
        switch (value) {
//            case 'E':
//		this.exploreAreaControl();
//		return false;
//            case 'M':
//		this.moveAreaControl();
//		return false;
            case 'B':
                OnShipView loadShipView = new OnShipView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return true;
//            case 'W':
//		this.workOnShipControl();
//		return false;
            case 'M':
                this.meetLeader();
            case 'X':
                ExchangeView exchangeView = new ExchangeView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
                return false;
            case 'I':
		InventoryManagerView inventory = new InventoryManagerView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'V':
		StatusesView statuses = new StatusesView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'G':
		GameMenuView gameMenu = new GameMenuView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            default:
                throw new CharInputException("\n\n" +entry + " is an invalid input at this time \n"
                        + "Please provide acceptable input from the menu below.\n");
        }
        }catch (CharInputException cie){
                ErrorView.display(this.getClass().getName(),cie.getMessage());
                return false;
        } 
    }
    
    public void meetLeader(){
        //Determine if they've already obtained statue from this island.
        //If they have not give it to them.  If they have just say hi.
        if (tempIsland.getIslandNumber() == 0){
            this.console.println("\nYou already know yourself.  This is your island.");
        }
        else {
        if (tempIsland.getStatue()==1){
            this.console.println("Hello" + Player.getName() + ",\nI've heard much "
                + "of your travails at sea.  Here, I'll give you my piece "
                + "\nof the puzzle.  In return I expect a small portion of "
                + "\nthe treasure so that my people can prosper too.");
            CurrentStatus.setStatuesCount(CurrentStatus.getStatuesCount()+1);
            tempIsland.setStatue(0);
            //Call endGameControl to offer up game progress messages.
        } else this.console.println("Hello there " + Player.getName()
                + "\nIt's good to see you again.  I hope you find some rest "
                + "\nduring your stay with us.  Good luck with the rest "
                + "of the statue collecting.");
        }
    }
}
