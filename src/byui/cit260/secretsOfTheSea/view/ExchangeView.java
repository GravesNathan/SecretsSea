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
import byui.cit260.secretsOfTheSea.model.LocationDetails;

/**
 *
 * @author SDababneh
 */
public class ExchangeView extends View {
    
    public ExchangeView(NewGameControl username, MapControl map, ShipSelectionControl playerShip,
            InventoryControl inventory, LocationDetails island){
                super("Exchanging / Trading Resouces can be tricky.  Make sure you know that those you trade with may not offer fair trades."
                + "\n"
                + "\n Please choose a trade option below:"
                + "\n O - Offer Trade"
//                + "\n A - Accept Trade Terms"
                + "\n C - Close Exchange Menu"
                + "\n I - Inventory Menu"
                + "\n V - View Status"
                + "\n G - Game Menu \n", username, map, playerShip, inventory, island);
    }

    
    public void ExchangeItemsControl(){
        this.console.println("ExchangeItemsControl stub");
    }
    
//    public void acceptTradeControl(){
//        this.console.println("acceptTradeControl stub");
//    }
    
    public void closeTradeControl(){
        this.console.println("closeTradeControl stub");
    }
      
    @Override
    public boolean doAction(char entry){
        char value = entry;
        try{
        switch (value) {
            case 'O':
		this.ExchangeItemsControl();
		return false;
            case 'X':
		return false;
//            case 'A':
//		this.acceptTradeControl();
//		return false;
            case 'C':
		this.closeTradeControl();
		return true;
            case 'I':
		InventoryManagerView inventory = new InventoryManagerView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'V':
		StatusesView status = new StatusesView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'G':
		GameMenuView gameMenu = new GameMenuView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            default:
                throw new CharInputException("\n\n" +entry + " is an invalid input at this time \n"
                        + "Please provide acceptable input from the menu below.\n");
                //this.console.println("\n Invalid choice. Please try again.");
                //return false;
        }
        }catch (CharInputException cie){
                ErrorView.display(this.getClass().getName(),cie.getMessage());
                return false;
        }
    }
}
