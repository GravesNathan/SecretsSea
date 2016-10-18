/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.control;

import byui.cit260.secretsOfTheSea.model.CurrentStatus;
import byui.cit260.secretsOfTheSea.model.SelectedShip;
import byui.cit260.secretsOfTheSea.model.Ships;
import byui.cit260.secretsOfTheSea.exceptions.ShipSelectionException;

/**
 *
 * @author Nathan
 */
public class ShipSelectionControl {
    
    private static SelectedShip selectedShip = new SelectedShip();;
    private Ships[] ship = null;
    private static int chozenShip = -1;
    private int baseStats = 5;
    private int baseHealth = 10;
   
    
    public ShipSelectionControl(int tempShipChoice)
            throws ShipSelectionException{
        chozenShip = tempShipChoice;
        this.createShips();
        this.assignShip(tempShipChoice);
        selectedShip.setShipChoice(tempShipChoice);
    }
    
    public void createShips(){
        ship = new Ships[4];//Initialize an array of 4 ship objects
        for (int i=0; i<4; i++)
            ship[i] = new Ships();
        //End of creating the object.
        //Begin setting ship stats
        //ship0
        ship[0].setName("Submersible");
        ship[0].setDescription("Sneak in, deceive leaders, slide away");
        ship[0].setCargoCapSize(20);
        ship[0].setMorale(-1);
        ship[0].setSpeed(-1);
        ship[0].setDefense(4);
        ship[0].setDeceit(1);
        ship[0].setDiplomacy(1);
        ship[0].setIntimidation(0);
        ship[0].setBribery(0);
        ship[0].setHealth(8);
        
        String ship0Info = ship[0].toString();
        //this.console.println(ship0Info);
        
        //ship1
        ship[1].setName("Ironclad");
        ship[1].setDescription("Highest Intimidation and defense of the game");
        ship[1].setCargoCapSize(60);
        ship[1].setMorale(-2);
        ship[1].setSpeed(-3);
        ship[1].setDefense(5);
        ship[1].setDeceit(-1);
        ship[1].setDiplomacy(0);
        ship[1].setIntimidation(1);
        ship[1].setBribery(0);
        ship[1].setHealth(10);
        
        String ship1Info = ship[1].toString();
        //this.console.println(ship1Info);
        
        //ship2
        ship[2].setName("Galley");
        ship[2].setDescription("Higher Supplies, better trade opportunities");
        ship[2].setCargoCapSize(100);
        ship[2].setMorale(0);
        ship[2].setSpeed(0);
        ship[2].setDefense(1);
        ship[2].setDeceit(0);
        ship[2].setDiplomacy(0);
        ship[2].setIntimidation(-1);
        ship[2].setBribery(1);
        ship[2].setHealth(6);
        
        String ship2Info = ship[2].toString();
        //this.console.println(ship2Info);
        
        //ship3
        
        ship[3].setName("Clipper");
        ship[3].setDescription("Speed across the open sea, you'll with any race with this ship.");
        ship[3].setCargoCapSize(40);
        ship[3].setMorale(3);
        ship[3].setSpeed(4);
        ship[3].setDefense(-1);
        ship[3].setDeceit(0);
        ship[3].setDiplomacy(1);
        ship[3].setIntimidation(0);
        ship[3].setBribery(-1);
        ship[3].setHealth(4);
        String ship3Info = ship[3].toString();
        //this.console.println(ship3Info);
        
        for (int i=0; i<4; i++){//Adjust stats per ship in preparation to print
            ship[i].setCargoCapSize(baseStats + ship[i].getCargoCapSize());
            ship[i].setMorale(baseStats + ship[i].getMorale());
            ship[i].setSpeed(baseStats + ship[i].getSpeed());
            ship[i].setDefense(baseStats + ship[i].getDefense());
            ship[i].setDeceit(baseStats + ship[i].getDeceit());
            ship[i].setDiplomacy(baseStats + ship[i].getDiplomacy());
            ship[i].setIntimidation(baseStats + ship[i].getIntimidation());
            ship[i].setBribery(baseStats + ship[i].getBribery());
            ship[i].setHealth(baseHealth + ship[i].getHealth());
        }
    /*    
        //SelectedShip Set & Print
        selectedShip = new SelectedShip();
        //Set the Default stats here, selected ship stats are adjusted + and - based
        //on the player's choice.  This is the base for all ships.
        selectedShip.setName("baseStats");
        selectedShip.setDescription("Ship not Chosen yet");
        selectedShip.setCargoCapSize(baseStats);
        selectedShip.setMorale(baseStats);
        selectedShip.setSpeed(baseStats);
        selectedShip.setDefense(baseStats);
        selectedShip.setDeceit(baseStats);
        selectedShip.setDiplomacy(baseStats);
        selectedShip.setIntimidation(baseStats);
        selectedShip.setBribery(baseStats);
        selectedShip.setHealth(baseStats);
            */
    }
    
    public void assignShip(int tempShipChoice1)
            throws ShipSelectionException{//Players choice is made the assigned ship for
        //this play through.
        
        for (int i=0; i<4; i++){
            if ( i == tempShipChoice1){
                selectedShip.setName(ship[i].getName() );
                selectedShip.setDescription(ship[i].getDescription());
                selectedShip.setCargoCapSize(ship[i].getCargoCapSize());
                selectedShip.setMorale(ship[i].getMorale());
                selectedShip.setSpeed(ship[i].getSpeed());
                selectedShip.setDefense(ship[i].getDefense());
                selectedShip.setDeceit(baseStats + ship[i].getDeceit());
                selectedShip.setDiplomacy(ship[i].getDiplomacy());
                selectedShip.setIntimidation(ship[i].getIntimidation());
                selectedShip.setBribery(ship[i].getBribery());
                selectedShip.setHealth(ship[i].getHealth());
                return;  
            }
        }
        throw new ShipSelectionException("Error Populating Ship Details");//WEEK 10 IA
    }
    
    @Override //Used to show the potential selected ships stats.  This is
    //printed to the user before choosing the ship.
    public String toString() {
        String shipsPrint = "\n";
        for (int i=0; i<4; i++){          
            shipsPrint += ("\n\nPress " + i + " to select this ship:"
                    + "\nname= " + ship[i].getName()
                    + "\ndescription= " + ship[i].getDescription()
                    + "\nhealth= " + ship[i].getHealth()
                    //+ "\nMax Cargo= " + ship[i].getCargoCapSize() 
                    + ", morale= " + ship[i].getMorale()
                    + ", speed= " + ship[i].getSpeed()
                    + ", defense " + ship[i].getDefense());
                    //+ "\ndeceit= " + ship[i].getDeceit()
                    //+ ", Diplomacy= " + ship[i].getDiplomacy()
                    //+ ", intimidation= " + ship[i].getIntimidation()
                   // + ", bribery " + ship[i].getBribery());
        }
        return shipsPrint;
    }
    
    public int getShipChoice(){
        return selectedShip.getShipChoice();
    }
    
    public String getShipName(){
        return selectedShip.getName();
    }
    
    public String getDescription(){
        return selectedShip.getDescription();
    }
    
    public int getCargoCapSize(){
        return selectedShip.getCargoCapSize();
    }
    
    public int getMorale(){
        return selectedShip.getMorale();
    }
    
    public void setMorale(int newMorale){
        selectedShip.setMorale(newMorale);
    }
    
    public int getSpeed(){
        return selectedShip.getSpeed();
    }
    
    public void setSpeed(int newSpeed){
        selectedShip.setSpeed(newSpeed);
    }
    
    //may not need this as I'm working directly with model layer from MapControl
    public int getHealth(){
        return selectedShip.getHealth();
    }
    
    public void setHealth(int newHealth){
        selectedShip.setHealth(newHealth);
    }
    
    //*****************************************
    //These stats are retreivable, but not changable during game play, at least not yet.
    public int getDefense(){
       return selectedShip.getDefense();
    }
    
    public int getDeceit(){
        return selectedShip.getDeceit();
    }
    
    public int getDiplomacy(){
        return selectedShip.getDiplomacy();
    }
    
    public int getIntimidation(){
        return selectedShip.getIntimidation();
    }
    
    public int getBribery(){
        return selectedShip.getBribery();
    }

    public static SelectedShip getSelectedShip() {
        return selectedShip;
    }

    public static void setSelectedShip(SelectedShip storeSelectedShip) {
        selectedShip = storeSelectedShip;
    }

    public static int getChozenShip() {
        return chozenShip;
    }

    public static void setChozenShip(int chozenShip) {
        ShipSelectionControl.chozenShip = chozenShip;
    }
    
}
