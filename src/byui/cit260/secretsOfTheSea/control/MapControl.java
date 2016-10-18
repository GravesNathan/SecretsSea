/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.control;

//import byui.cit260.secretsOfTheSea.model.CurrentStatus;
//import byui.cit260.secretsOfTheSea.model.ExplorableAreas;
import byui.cit260.secretsOfTheSea.exceptions.ExplorableAreasException;
import byui.cit260.secretsOfTheSea.exceptions.InventoryControlException;
import byui.cit260.secretsOfTheSea.model.Map;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
//import byui.cit260.secretsOfTheSea.model.Ships;
import byui.cit260.secretsOfTheSea.model.Storms;
import byui.cit260.secretsOfTheSea.exceptions.MapControlException;
import byui.cit260.secretsOfTheSea.model.CurrentStatus;
import byui.cit260.secretsOfTheSea.model.ExplorableAreas;
import byui.cit260.secretsOfTheSea.model.Items;
import byui.cit260.secretsOfTheSea.model.SelectedShip;
//import byui.cit260.secretsOfTheSea.view.ErrorView;
//import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.Hashtable;

import java.util.Random;
import secretsofthesea_rpg.SecretsOfTheSea_RPG;

/**
 *
 * @author Nathan
 */
public class MapControl {
    
    protected final PrintWriter console = SecretsOfTheSea_RPG.getOutFile();
    //MapControl will create the map, place islands and storms, all based on difficulty
    private static char difficulty;
    private static Map mapOne = new Map();
    private static LocationDetails[] location = null;
    private static Storms[] storms = null;
    private static int numStorms = 0;
    private static int[][] mapGrid = null;
    private char [][] visibleMap = null;
    private static int diffMultiplier = 0;
    private static String tempWarning = null;
    private static ExplorableAreasControl setupAreas = null;
    
    public MapControl( char tempDifficulty )
            throws MapControlException, ArrayIndexOutOfBoundsException, 
            ExplorableAreasException  {
        
        this.calcMapSize( tempDifficulty );
        this.populateMap();
        this.populateStorms();
        this.createVisibleMap();
//        this.PrintMap();
//        System.out.println(this.mapToString());
//        this.tempPrintMap2();
//        this.verifyMap();
//        this.tempPrintMap3();
    }
    
    //STEP 4 - Turn outline of solution into working code.
    
    public void calcMapSize ( char difficulty) 
            throws MapControlException {
        
        mapOne.setDifficulty(difficulty);
        int xMax = 4;
        int yMax = 4;
        if (difficulty == 'E' || difficulty == 'e'){
            diffMultiplier = 1;
            tempWarning = "Mild storm ahead.  What would you like to do?";
        }   
        else if (difficulty == 'N' || difficulty == 'n'){
            diffMultiplier = 2;
            tempWarning = "Moderate storm ahead.  What would you like to do?";
        }
        else if (difficulty == 'H' || difficulty == 'h'){
            diffMultiplier = 3;
            tempWarning = "Severe storm ahead.  What would you like to do?";
        }
        else throw new MapControlException("Failed to create map size based on difficulty selection");
        mapOne.setxMax(xMax * diffMultiplier);
        mapOne.setyMax(yMax * diffMultiplier);
        numStorms = 4 * diffMultiplier;
        storms = new Storms[numStorms];
        for (int i=0; i<numStorms; i++)
            storms[i] = new Storms(); 
    }
  
    public void populateMap() 
            throws ArrayIndexOutOfBoundsException, ExplorableAreasException, MapControlException{
        int xMax = mapOne.getxMax();
        int yMax = mapOne.getyMax();
        location = new LocationDetails[8];
            for (int i=0; i<8; i++){
                if (i>=8)
                    throw new ArrayIndexOutOfBoundsException ("Error, program trying to "
                            + "create too many islands");
                        //ArrayIndexOutOfBoundsException("Error creating islands.  Program attempting"
                        // + "to create more islands than allowed.");
                location[i] = new LocationDetails();
            }
            int tempX;
            int tempY;
            Random xRand = new Random();
            Random yRand = new Random();
            mapGrid = new int[xMax][yMax];
        //Creates an array of size xMax, each of which holds an array of size Ymax.  it may help to think of arrays as list
        //The main list is broken into xMax categories.  The categories have yMax items each
            for (int i=0; i<8; i++){
                tempX = xRand.nextInt(xMax);
                tempY = yRand.nextInt(yMax);
                if (mapGrid[tempX][tempY] == 0) {
                    location[i].setXCoordinate(tempX);
                    location[i].setYCoordinate(tempY);
                    location[i].setIslandNumber(i);
                    location[i].setStatue(1);
                    //You already have one in CurrentStatus
                    location[i].setSocietyName(locationNumToString(i));
                    if (i == 0){
                        CurrentStatus.setCurrentX(tempX);
                        CurrentStatus.setCurrentY(tempY);
                        CurrentStatus.setCurrentIsland(i);
                        CurrentStatus.setCurrentArea(0);
                        location[i].setStatue(0);//Set Home Island count to 0
                    }
                    mapGrid[tempX][tempY] = 1;
                    setupAreas = new ExplorableAreasControl(i);                   
                }
                else i--; //offset increment when the island ends up stacked on another island.
            }
        //Create Locations has finished here
    }
        //This section populates Storms
    public void populateStorms(){
            int tempX = 0;
            int tempY = 0;
            int xMax = mapOne.getxMax();
            int yMax = mapOne.getyMax();
            Random xRand = new Random();
            Random yRand = new Random();
            for (int i=0; i<numStorms; i++){ // fix then change to for each, indiv assign required
                tempX = xRand.nextInt(xMax);
                tempY = yRand.nextInt(yMax);
                if (mapGrid[tempX][tempY] == 0) {
                    storms[i].setXCoordinate(tempX);
                    storms[i].setYCoordinate(tempY);
                    storms[i].setPowerLevel(3 * diffMultiplier);
                    storms[i].setWarning(tempWarning);
                    mapGrid[tempX][tempY] = 2;
                }
                else i--; //offset increment when the island ends up stacked on another island.
            }
            mapOne.setGrid(mapGrid);//Initial set after Creation of map.
      }
    
    public String locationNumToString(int number) throws MapControlException{
        switch (number){
            case 0:
                return "Home";
            case 1:
                return "Privateer";
            case 2:
                return "Barbarian";
            case 3:
                return "Aztec";
            case 4:
                return "Buchaneers";
            case 5:
                return "Carousuers";
            case 6:
                return "Corsairs";
            case 7:
                return "Turks";
            default:
                throw new MapControlException ("Error converting island number to String");
        }
    }  
      
    public void createVisibleMap()
        throws MapControlException{
        int xMax = mapOne.getxMax();
        int yMax = mapOne.getyMax();
        visibleMap = new char[xMax][yMax];
        for ( int i=0;i<xMax;i++){
            for ( int j=0; j<yMax;j++){
                visibleMap[i][j] = reDrawSpot(i, j);
                if (CurrentStatus.getCurrentX()==i &&
                        CurrentStatus.getCurrentY()==j){
                    visibleMap[i][j] = 'S';
                }
            }
        }
        
        Map.setVisibleMap(visibleMap);//Initial set after creation of visual map.
    }  
    
    public void moveShip(char direction, SelectedShip tempShip, InventoryControl tempInventory)
        throws MapControlException, InventoryControlException {
        int y = CurrentStatus.getCurrentY();
    int x = CurrentStatus.getCurrentX();
        switch( direction ) { 
            case 'E'://Left Movement
                if (y>0){
                    visibleMap[x][y] = reDrawSpot(x,y);
                    CurrentStatus.setCurrentY(y-1);
                    visibleMap[x][y-1]='S';
                    Map.setVisibleMap(visibleMap);
                    moveResourceUsage(tempShip, tempInventory);
                }
                else throw new MapControlException ("Left is out of bounds."
                        + "Please try a different menu selection");
                break;
            case 'T'://Right Movement
                if (y<mapOne.getyMax()-1){//minus 1 to match end of array
                    visibleMap[x][y] = reDrawSpot(x,y);
                    CurrentStatus.setCurrentY(y+1);
                    visibleMap[x][y+1]='S';
                    Map.setVisibleMap(visibleMap);
                    moveResourceUsage(tempShip, tempInventory);
                }
                else throw new MapControlException ("Right is out of bounds."
                        + "Please try a different menu selection"); 
                break;
            case '4': //Up Movement
                if (x>0){
                    visibleMap[x][y] = reDrawSpot(x,y);
                    CurrentStatus.setCurrentX(x-1);
                    visibleMap[x-1][y]='S';
                    Map.setVisibleMap(visibleMap);
                    moveResourceUsage(tempShip, tempInventory);
                }
                else throw new MapControlException ("Up is out of bounds. "
                        + "Please try a different menu selection");
                break;
            case 'R'://Down Movement
                if (x<mapOne.getxMax()-1){//minus 1 to match end of array
                    visibleMap[x][y] = reDrawSpot(x,y);
                    CurrentStatus.setCurrentX(x+1);
                    visibleMap[x+1][y]='S';
                    Map.setVisibleMap(visibleMap);
                    moveResourceUsage(tempShip, tempInventory);
                }
                else throw new MapControlException ("Down is out of bounds. "
                        + "Please try a different menu selection"); 
                break;
            default:
                throw new MapControlException ("Unexpected Error ocurred when moving ship.");
        }
        if (mapGrid[CurrentStatus.getCurrentX()][CurrentStatus.getCurrentY()] == 2){
            int damage = storms[0].getPowerLevel() - tempShip.getDefense();
            if (damage > 0){//damage is positive if sustained.
                tempShip.setHealth(tempShip.getHealth() - damage); //Currently all storms are the same.
                CurrentStatus.setStatusMessage("You ran into a storm.  Your ship sustained " + damage + " damage.");
            } else
                CurrentStatus.setStatusMessage("You ran into a storm.  Your defense held firm, no damage was sustained.");
            //Will need to keep better track of these on the grid to call correct one if that's changed.
        }
            else if (mapGrid[CurrentStatus.getCurrentX()][CurrentStatus.getCurrentY()] == 1)
                CurrentStatus.setStatusMessage("You arrived at an island.  What would you like to do now?");
            else CurrentStatus.setStatusMessage("You moved, but nothing exciting happend");
        
        if (tempShip.getHealth()<=0){
            CurrentStatus.setStatusMessage("Your Ship has been Destroyed, you and your crew "
                    + "were lost at sea and never found.  Be sure to watch your health next time.");
            System.out.println("EndGameControlStub");//Will need to Call new EndGameControl Instead
        }else if (tempShip.getMorale()<=0){
            CurrentStatus.setStatusMessage("Your crew rebelled against you and threw you off the ship. "
                    + "\nBe sure to keep their Morale higher next time.");
            System.out.println("EndGameControlStub");//Will need to Call new EndGameControl Instead
        }

    }
    
    public void moveResourceUsage(SelectedShip tempShip,  InventoryControl tempInventory ) 
            throws InventoryControlException{
        int speed = tempShip.getSpeed();
        int moral = tempShip.getMorale();
        ArrayList<Items> tempCargo = InventoryControl.getCargo();
        //Hashtable<String, ArrayList<Items>> cargoHash = new Hashtable<>();
        //cargohash.put("Food",)Not finished, but I think we can create a nice hash table
        //In a model, enum, or separate class to easly search the correct inventory.
        //I'm thinking the hash will need to be created when the inventory is initially created.
        //Then it would be the primary source to access and adjust the array list.
        boolean foodExists = false;
        boolean waterExists = false;
        int foodQuantity = -1;
        int waterQuantity = -1;
        for (Items item : tempCargo)
            if ("Food" == item.getName()){
                foodExists = true;
                foodQuantity = item.getQuantity();
            }
        for (Items item : tempCargo){
            //System.out.println("check for water");
            if ("Water" == item.getName()){
                waterExists = true;
                waterQuantity = item.getQuantity();
            }
        }
        
        if (speed >= 8){//Don't need removing too many check since only removing 1
            if (!foodExists && !waterExists){//If player out of both food and water
                tempShip.setMorale(tempShip.getMorale()-1);
            } else if( !foodExists){//If player is out of food or water, but not both
                tempShip.setMorale(tempShip.getMorale()-1);
                tempInventory.removeItem('W', 1);//Must be capital
            } else if( !waterExists){//If player is out of food or water, but not both
                tempShip.setMorale(tempShip.getMorale()-1);
                tempInventory.removeItem('F', 1);//Must be capital
            } else {
                tempInventory.removeItem('W', 1);//Must be capital
                tempInventory.removeItem('F', 1);//Must be capital
            }
        } else if (speed >= 6){
            if (!foodExists && !waterExists){//If player out of both food and water
                tempShip.setMorale(tempShip.getMorale()-2);
            } else if( !foodExists){//If player is out of food or water, but not both
                tempShip.setMorale(tempShip.getMorale()-1);
                if (waterQuantity >=2)//Make sure not removing too many.
                    tempInventory.removeItem('W', 2);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('W', waterQuantity);
            } else if( !waterExists){//If player is out of food or water, but not both
                tempShip.setMorale(tempShip.getMorale()-1);
                if (foodQuantity >=2)//Make sure not removing too many.
                    tempInventory.removeItem('F', 2);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('F', foodQuantity);
            } else {
                if (waterQuantity >=2)//Make sure not removing too many.
                    tempInventory.removeItem('W', 2);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('W', waterQuantity);
                if (foodQuantity >=2)//Make sure not removing too many.
                    tempInventory.removeItem('F', 2);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('F', foodQuantity);
            }
        } else if (speed >= 4){
            //System.out.println("Spped>=4 Test ");
            if (!foodExists && !waterExists){//If player out of both food and water
                tempShip.setMorale(tempShip.getMorale()-3);
            } else if( !foodExists){//If player is out of food or water, but not both
                tempShip.setMorale(tempShip.getMorale()-2);
                if (waterQuantity >=3)//Make sure not removing too many.
                    tempInventory.removeItem('W', 3);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('W', waterQuantity);
            } else if( !waterExists){//If player is out of food or water, but not both
                tempShip.setMorale(tempShip.getMorale()-2);
                if (foodQuantity >=3)//Make sure not removing too many.
                    tempInventory.removeItem('F', 3);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('F', foodQuantity);
            } else {
                //System.out.println(" have both food and water ");
                if (waterQuantity >=3){//Make sure not removing too many.
                    //System.out.println("\nremove water, waterQuantity " + waterQuantity);
                    tempInventory.removeItem('W', 3);//Must be capital
                } else {//If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('W', waterQuantity);
                    //System.out.println("\nLast Of Water, waterQuantity " + waterQuantity);
                }
                if (foodQuantity >=3){//Make sure not removing too many.
                    tempInventory.removeItem('F', 3);//Must be capital
                   // System.out.println("\nremove food, food Quantity " + foodQuantity);
                } else {//If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('F', foodQuantity);
                    //System.out.println("Last of Food, food Quantity " + foodQuantity);
                }
            }
            //Old if speed >= 4, before added checks for quantity.  was needed to avoid errors
            //of removing too many.
//            if (!foodExists && !waterExists){//If player out of both food and water
//                tempShip.setMorale(tempShip.getMorale()-3);
//            } else if( !foodExists){//If player is out of food or water, but not both
//                tempShip.setMorale(tempShip.getMorale()-2);
//                tempInventory.removeItem('W', 3);//Must be capital
//            } else if( !waterExists){//If player is out of food or water, but not both
//                tempShip.setMorale(tempShip.getMorale()-2);
//                tempInventory.removeItem('F', 3);//Must be capital
//            } else {
//                tempInventory.removeItem('W', 3);//Must be capital
//                tempInventory.removeItem('F', 3);//Must be capital
//            }
        }else {
            if (!foodExists && !waterExists){//If player out of both food and water
                tempShip.setMorale(tempShip.getMorale()-4);
            } else if( !foodExists){//If player is out of food or water, but not both
                tempShip.setMorale(tempShip.getMorale()-2);
                if (waterQuantity >=4)//Make sure not removing too many.
                    tempInventory.removeItem('W', 4);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('W', waterQuantity);
            } else if( !waterExists){//If player is out of food or water, but not both
                tempShip.setMorale(tempShip.getMorale()-2);
                if (foodQuantity >=4)//Make sure not removing too many.
                    tempInventory.removeItem('F', 4);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('F', foodQuantity);
            } else {
                if (waterQuantity >=4)//Make sure not removing too many.
                    tempInventory.removeItem('W', 4);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('W', waterQuantity);
                if (foodQuantity >=4)//Make sure not removing too many.
                    tempInventory.removeItem('F', 4);//Must be capital
                else //If above line was going to remove too many instead remove what's left.
                    tempInventory.removeItem('F', foodQuantity);
            }
            
            
            
//            if (!foodExists && !waterExists){//If player out of both food and water
//                tempShip.setMorale(tempShip.getMorale()-4);
//            } else if( !foodExists){//If player is out of food or water, but not both
//                tempShip.setMorale(tempShip.getMorale()-2);
//                tempInventory.removeItem('W', 4);//Must be capital
//            } else if( !waterExists){//If player is out of food or water, but not both
//                tempShip.setMorale(tempShip.getMorale()-2);
//                tempInventory.removeItem('F', 4);//Must be capital
//            } else {
//                tempInventory.removeItem('W', 4);//Must be capital
//                tempInventory.removeItem('F', 4);//Must be capital
//            }
        }
    }
        
        
    /*Not use currently because can't get arrow keys working with key listeners.
    public void exploreMap(KeyEvent e, SelectedShip tempShip)
        throws MapControlException {
    int key = e.getKeyCode();
    int y = CurrentStatus.getCurrentY();
    int x = CurrentStatus.getCurrentX();
    int tempHealth = 0;
        switch( key ) { 
            case KeyEvent.VK_UP:
                if (y>0){
                    visibleMap[x][y] = reDrawSpot(x,y);
                    CurrentStatus.setCurrentY(y-1);
                    visibleMap[x][y-1]='S';
                    Map.setVisibleMap(visibleMap);
                }
                else throw new MapControlException ("That direction is out of bounds."
                        + "Please try a different menu selection");
                break;
            case KeyEvent.VK_DOWN:
                if (y<mapOne.getyMax()){
                    visibleMap[x][y] = reDrawSpot(x,y);
                    CurrentStatus.setCurrentY(y+1);
                    visibleMap[x][y+1]='S';
                    Map.setVisibleMap(visibleMap);
                }
                else throw new MapControlException ("That direction is out of bounds."
                        + "Please try a different menu selection"); 
                break;
            case KeyEvent.VK_LEFT:
                if (x>0){
                    visibleMap[x][y] = reDrawSpot(x,y);
                    CurrentStatus.setCurrentX(x-1);
                    visibleMap[x-1][y]='S';
                    Map.setVisibleMap(visibleMap);
                }
                else throw new MapControlException ("That direction is out of bounds."
                        + "Please try a different menu selection");
                break;
            case KeyEvent.VK_RIGHT :
                if (x<mapOne.getxMax()){
                    visibleMap[x][y] = reDrawSpot(x,y);
                    CurrentStatus.setCurrentX(x+1);
                    visibleMap[x+1][y]='S';
                    Map.setVisibleMap(visibleMap);
                }
                else throw new MapControlException ("That direction is out of bounds."
                        + "Please try a different menu selection"); 
                break;
            default:
                throw new MapControlException ("That direction is out of bounds."
                        + "Please try a different menu selection");
        }
        if (mapGrid[CurrentStatus.getCurrentX()][CurrentStatus.getCurrentY()] == 2){
            tempHealth = tempShip.getHealth()-storms[0].getPowerLevel(); //Currently all storms are the same.
            //Will need to keep better track of these on the grid to call correct one if that's changed.
            tempShip.setHealth(tempHealth);
            //if (tempHealth <= 0)
                //Call EndGameView with status of Game Over here.
        }
    }*/


    public char reDrawSpot(int x, int y)
        throws MapControlException{//Puts original map character back onto
        //visual map in place of ship.
        //System.out.println("MapSpot " + x + " " + y + " holds " + Map.getSpot(x, y));
        switch (Map.getSpot(x,y)){
            case 0:
                return '.';
            case 1:
                if (x==location[0].getXCoordinate()&& y==location[0].getYCoordinate())
                    return 'H';//Returns H if the Island is a home island.
                return 'O';
            case 2:
                return '*';
            default:
                throw new MapControlException("Failed to re-populate spot on map.");
        }
    }
    
    public String getUserDifficulty()
            throws MapControlException {
        char nameDifficulty = mapOne.getDifficulty();
        switch (nameDifficulty) {
            case 'E':
                return "Easy";
            case 'N': 
                return "Normal";
            case 'H':
                return "Hard";
            default: 
                throw new MapControlException ("Failed to read from set Difficulty"); 
        }
    }
    
    
    public void PrintMap(){
        //backend Map
        //this.console.println("\nfor-each bad Print, 0 = empty, 1 = island, 2 = storm");
        this.console.println("\n");
               
        System.out.println("Test Print Map function");
        this.console.println("\nTemporary Map Print, 0 = empty, 1 = island, 2 = storm");
        for(int[] row : mapGrid){
            this.console.println();
            for(int column : row)
                System.out.print("  " + column + "  ");
        }    
    }

    public String mapToString(){
        String showUserMap = "\r\n";
        for(char[] row : Map.getVisibleMap()){
            showUserMap += "\r\n";
            for(char column : row)
                showUserMap += ("  " + column + "  ");
        }
        showUserMap += ("\r\n\r\n. = empty or unknown space,  H = home island,  S = Ship \n"
                + "* = Storm,  O = Island");
        return showUserMap;
    }
    
    public static char getDifficulty() {
        return Map.getDifficulty();
    }

    public static void setDifficulty(char storedifficulty) {
        difficulty = storedifficulty;
    }

    public static Map getMapOne() {
        return mapOne;
    }

    public static void setMapOne(Map storeMapOne) {
        mapOne = storeMapOne;
    }

    public static LocationDetails[] getLocation() {
        return location;
    }

    public static void setLocation(LocationDetails[] storeLocation) {
        location = storeLocation;
    }

    //Get Location Number here
    
    public static Storms[] getStorms() {
        return storms;
    }

    public static void setStorms(Storms[] storeStorms) {
        storms = storeStorms;
    }

    public static int getNumStorms() {
        return numStorms;
    }

    public static void setNumStorms(int storeNumStorms) {
        numStorms = storeNumStorms;
    }

    public static int[][] getMapGrid() {
        return Map.getGrid();
    }

    public static void setMapGrid(int[][] storeMapGrid) {
        Map.setGrid(mapGrid);
    }

    public static int getDiffMultiplier() {
        return diffMultiplier;
    }

    public static void setDiffMultiplier(int storeDiffMultiplier) {
        diffMultiplier = storeDiffMultiplier;
    }

    public static String getTempWarning() {
        return tempWarning;
    }

    public static void setTempWarning(String storeTempWarning) {
        tempWarning = storeTempWarning;
    }

    public static ExplorableAreas[][] getSetupAreas() {
        return ExplorableAreasControl.getAreas();
    }

    public static void setSetupAreas(ExplorableAreasControl setupAreas) {
        ExplorableAreasControl.setAreas(getSetupAreas());
    }

}


