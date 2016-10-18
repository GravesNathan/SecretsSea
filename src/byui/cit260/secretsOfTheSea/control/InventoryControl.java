/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.control;

import byui.cit260.secretsOfTheSea.exceptions.InventoryControlException;
import byui.cit260.secretsOfTheSea.model.Cargo;
import byui.cit260.secretsOfTheSea.model.Items;
import byui.cit260.secretsOfTheSea.model.ItemsEnum;
import byui.cit260.secretsOfTheSea.model.SelectedShip;
import byui.cit260.secretsOfTheSea.model.Storage;
import byui.cit260.secretsOfTheSea.view.ErrorView;
import static java.lang.Math.floor;
import java.util.ArrayList;

/**
 *
 * @author Nathan
 */
public class InventoryControl {
    
    private static ArrayList<Items> cargo = null;
    private static ArrayList<Items> storage = null;
    private SelectedShip playerShip = ShipSelectionControl.getSelectedShip();
    private int cargoCap = playerShip.getCargoCapSize();
    
    public InventoryControl(){
        //Decided to keep empty constructor so ExchangeControl class can
        //use the inventory control functions for exhanging items.
    }
    
    public void startupInventory(){
        cargo = new ArrayList<>();
        cargo.add(new Items('F', "Food", 25));
        cargo.add(new Items('W', "Water", 25));
        //cargo.add(new Items('U', "Fuel", 25));
        //cargo.add(new Items('M', "Munitions", 5));
        cargo.add(new Items('C', "Coin", 200));
        cargo.add(new Items('L', "Lumber", 10));
        //cargo.add(new Items('A', "Artifacts", 1));
        //cargo.add(new Items('G', "Gems", 1));
        
//        storage = new ArrayList<>();
//        storage.add(new Items('F', "Food", 25));
//        storage.add(new Items('W', "Water", 25));
//        storage.add(new Items('U', "Fuel", 25));
//        storage.add(new Items('M', "Munitions", 5));
//        storage.add(new Items('C', "Coin", 100));
//        storage.add(new Items('A', "Artifacts", 1));
//        storage.add(new Items('G', "Gems", 1));
    }
    
    public String charToString(char cName)
            throws InventoryControlException{
        switch (cName){
            case 'F':
                return "Food";
            case 'W':
                return "Water";
//            case 'U':
//                return "Fuel";
//            case 'M':
//                return "Munitions";
            case 'C':
                return "Coin";
            case 'L':
                return "Lumber";
//            case 'A':
//                return "Artifacts";
//            case 'G':
//                return "Gems";
            default:
                throw new InventoryControlException ("Failed to convert character input to String");  
        }    
    }    
    public String addItem(char charItem, int quantity)
            throws InventoryControlException{//call for picking up or otherwise adding item to inventory
        for (Items item : cargo){
            if (charItem == item.getCharName()){
                item.setQuantity(quantity + item.getQuantity());
                return (quantity + item.getName() + "have been added to your inventory");
            }
            
        }
        String itemName = charToString(charItem);
        Items newItem = new Items(charItem, itemName, quantity);
        cargo.add(newItem);
        return (quantity + itemName + "have been added to your inventory");
    }
        
    
    public String removeItem(char charItem, int quantity)
            throws InventoryControlException{//call for dropping or otherwise removing item from inventory
        for (Items item : cargo){
            if (charItem == item.getCharName()){
                if (item.getQuantity() - quantity < 0)//make sure not removing too many items.
                    throw new InventoryControlException ("You Don't have that many " + item.getName() + " in your inventory.");
                else item.setQuantity(item.getQuantity() - quantity);
                if (item.getQuantity() == 0)
                    cargo.remove(item);
                return (quantity + item.getName() + " have been removed from your inventory");
            }
            
        }
        throw new InventoryControlException ("You don't have that many " + charToString(charItem) + "available");
    }
    
    public void buyItem(char charItem, int quantity, int value)//Calculate value of purchase with Exchange function
            //Then pass the charItem, quantity, and value here.
            throws InventoryControlException{
        removeItem( ItemsEnum.Coin.getCName(), value);//character for coin and value.
        //removeItem checks for to much being spent so it goes first.
        addItem(charItem, quantity);
    }
    
    public void sellItem(char charItem, int quantity, int value)
            throws InventoryControlException{
        removeItem(charItem , quantity);
        //removeItem checks for to much being sold so it goes first.
        addItem(ItemsEnum.Coin.getCName(), value);//character for coin and value.
        
    }
//    public void shipAdjustments(ShipSelectionControl playerShip){
//        int ship = playerShip.getShipChoice();            
//    }
    
    public String useItem(char charItem, int quantity, ShipSelectionControl tempShip)
        throws InventoryControlException{
        removeItem( charItem, quantity);//If it throws, will it continue or go back... may need to fix by checking quantity before applying
        //item affect.  But it should keep throwing back to the try catch and continue there so we should be good.  I need to remember
        //how these work.
        if (charItem == ItemsEnum.Lumber.getCName()){
            tempShip.setHealth(tempShip.getHealth()+ quantity);
            return ("\nUsed " + quantity + " Lumber and gained " + quantity + " health.\n");
        } else if (charItem == ItemsEnum.Water.getCName() || charItem == ItemsEnum.Food.getCName()) {
            tempShip.setMorale(tempShip.getMorale()+ quantity);
            return ("\nUsed " + quantity + " "+ charToString(charItem) +" and boosted morale by " + quantity + "\n");
        } else if (charItem == ItemsEnum.Coin.getCName()){
            tempShip.setMorale((int)(tempShip.getMorale()+ floor(quantity/50)) );//round down to nearest whole divisible number.
            return ("\nUsed " + quantity + " " +charToString(charItem) +" and boosted morale by " + quantity + "\n");
        } else throw new InventoryControlException ("Problem detecting the item chosen to use.");
    }
    
    
    public String cargoToString(){//used to display a list of current cargo
        String cargoString = "";
            for (Items item: cargo)
                cargoString += item.toString();
        return cargoString;
    }
    
    public String cargoMapString(){
        String cargoMap = "";
        for (Items item : cargo){
            cargoMap += item.getName() + ": " + item.getQuantity() + "\n";
            }
        return cargoMap;
    }
    
    public String storageToString(){//Used to display a list of current storage
        String storageString = "";
            for (Items item: storage)
                storageString += item.toString();
        return storageString;
    }

    public static ArrayList<Items> getCargo() {
        return cargo;
    }

    public static void setCargo(ArrayList<Items> storeCargo) {
        cargo = storeCargo;
    }

    public static ArrayList<Items> getStorage() {
        return storage;
    }

    public static void setStorage(ArrayList<Items> storeStorage) {
        storage = storeStorage;
    }
    
    
}
