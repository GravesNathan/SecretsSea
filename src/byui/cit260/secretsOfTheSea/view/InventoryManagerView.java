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
import byui.cit260.secretsOfTheSea.exceptions.InventoryControlException;
import byui.cit260.secretsOfTheSea.model.Items;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import secretsofthesea_rpg.SecretsOfTheSea_RPG;

/**
 *
 * @author Nathan
 */
public class InventoryManagerView{
    
    protected final PrintWriter console = SecretsOfTheSea_RPG.getOutFile();
    
    private String promptMessage;
//    private NewGameControl tempUsername = null;
//    private MapControl tempMap = null;
//    private ShipSelectionControl tempPlayerShip= null;
    private InventoryControl tempInventory = null;
    private ShipSelectionControl tempShip = null;
    private InputView getInput = new InputView();
    char item;
    char action ;
    int quantity =0;
    String strAction = "";
    
    public InventoryManagerView(NewGameControl username, MapControl map, 
            ShipSelectionControl playerShip, InventoryControl inventory, LocationDetails island){
//        tempUsername = username;  
//        tempMap = map;
//        tempPlayerShip= playerShip;
        tempInventory = inventory;
        tempShip = playerShip;
        this.console.println("\n");
        this.promptMessage = ("\n                   Inventory Manager"
                +"\n Please select a resource or close the inventory manager."
                + inventory.cargoToString()
                + "\n\nE - Exit Inventory Manager");
        this.display();
    }
    
    public void display(){
        boolean done = false;
        
        do {
            try {
                do{
                this.promptMessage = ("\n                   Inventory Manager"
                +"\n\n Please select a resource or exit the inventory manager."
                + tempInventory.cargoToString()
                + "\n\nE - Exit Inventory Manager");
                
                this.console.println(this.promptMessage);
		item = getInput.charInput();
                if (! ((item == 'F') || (item == 'W') 
                        //||(item == 'U') ||(item == 'M') 
                        ||(item == 'C') || (item == 'L') 
                        //||(item == 'A') ||(item == 'G') 
                        || (item == 'E')) ){
                    ErrorView.display(this.getClass().getName(),"Invalid Input.  Please select from the following inventory");
                    continue;
                }
                }while (! ((item == 'F') || (item == 'W') 
                        //||(item == 'U') ||(item == 'M') 
                        ||(item == 'C') || (item == 'L') 
                        //||(item == 'A') ||(item == 'G') 
                        || (item == 'E')) );
                
                if( item == 'E')//Exit Inventory manager if E is selected.
                     break;
                
                /********************************
                 * Above checks need to make dynamic for existing inventory somehow
                 ************************************/    
                do{
                this.console.println("What would you like to do with this item?"
                        + "\nD - Drop"
                        + "\nU - Use"
                        + "\nE - Exit Inventory Manager");
                action = getInput.charInput();
                if (! ((action == 'D') || (action == 'U') || (action == 'E')) ){
                    ErrorView.display(this.getClass().getName(),"Invalid Input.  Please choose actions to take"
                            + "\n from the list below.");
                    continue;
                }
                else if (action == 'D')
                    strAction = "drop";
                else if (action == 'U')
                    strAction = "use";
                }while (! ((action == 'D') || (action == 'U') ||(action == 'E')) );
                if( action == 'E'){//Exit Inventory manager if E is selected.
                     break;
                }
                //Why didn't this exit!!!!!!!!!!!!!!!!!!???????????????????
                do{
                this.console.println("Plese input the quantity to " + strAction);
                quantity = getInput.intInput();
                if (quantity<=0) {
                    ErrorView.display(this.getClass().getName(),"Invalid Input.  Please input"
                            + "a positive whole number");
                }
                //Need to make this detect if quantity > currentItems.
                //This may be easier handled by calling the control layer and
                //making a function to check here.  Instead of below
                }while ((quantity<=0));//||(quantity > ))

		done = this.doAction(item, action, quantity);
            }catch (InputMismatchException ime) {
                this.console.println("Invalid input type.  Please follow instructions.");
            }
        }while (!done);
    }
    
        public boolean doAction(char item, char action, int quantity){
            try {
                switch (action) {
                    case 'D':
                        this.console.println(tempInventory.removeItem(item, quantity));
                        return false;
                    case 'U':
                        this.console.println(tempInventory.useItem(item, quantity, tempShip));//This one may be complicated, but after use remove what was used.
                        return false;
                        //Option E is handled twice in above giant do-while to exit inventory upon inputo of E
                    default:
                        return true;//change to a throw later.
                }
            }catch (InventoryControlException ice){
                this.console.println(ice.getMessage());
                return false;
            }
        }

}  
//    public void takeItem(){
//        this.console.println("takeItem function stub");
//    }  Take not option in inventory, I picture this in explorableAreas
//     after finding an item if player chooses to keep it.

//    public void viewResource(){
//        this.console.println("viewResourceView called (maybe in same view, separte output and prompt)");
//    }  Don't see point in this anymore.
    


        //Add a throw for error detecting correct input.  Then close inventory manager


//                    case 'T':
//                        this.takeItem();
//                        return false;
//                    case 'V':
//                        this.viewResource();//unsure if needed or purpose.  perhaps to describe what the items are used for.
//                        return false;
                    
//        //            case 'G':  Took off so we don't have an endless loop of inventory, game menu
//        //                GameMenuView gamemenu = new GameMenuView();
//        //                return false; 
//                    case 'C'://closes inventory manager view
//                        return true;                
//                    default:
//                        this.console.println("\n" + value + " is an invalid entry. Please select an option below:");
//                        return false;
//                }
//        }
