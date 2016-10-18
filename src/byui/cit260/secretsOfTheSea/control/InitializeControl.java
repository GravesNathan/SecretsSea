/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.control;

//import byui.cit260.secretsOfTheSea.control.GameDifficultyControl;
import byui.cit260.secretsOfTheSea.model.Cargo;
import byui.cit260.secretsOfTheSea.model.Map;
//import byui.cit260.secretsOfTheSea.control.TrustTrialControl;
import byui.cit260.secretsOfTheSea.model.CurrentStatus;
import byui.cit260.secretsOfTheSea.model.ExplorableAreas;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import byui.cit260.secretsOfTheSea.model.Player;
import byui.cit260.secretsOfTheSea.model.SelectedShip;
import byui.cit260.secretsOfTheSea.model.Ships;
import byui.cit260.secretsOfTheSea.model.Societies;
import byui.cit260.secretsOfTheSea.model.SocietyNPCs;
import byui.cit260.secretsOfTheSea.model.Storage;

/**
 *
 * @author Nathan
 */
public class InitializeControl {
    
    public void initializeGame(){
//        //Map Class Set & Print
//        Map mapOne = new Map();
//   
//        mapOne.setDifficulty('h');
//        mapOne.setxMax(4);
//        mapOne.setyMax(4);
//        
//        String mapInfo = mapOne.toString();
//        //this.console.println(mapInfo);
//        //End Map Class Set & Print
//        
//        //CurrentStatus Class Set & Print
//        CurrentStatus status = new CurrentStatus();
//        
//        status.setCurrentX(1);
//        status.setCurrentY(1);
//        status.setStatuesCount(1);
//        status.setLifeStatus("Alive and well");
//        status.setGameDifficulty("Normal");
//        status.setStatusMessage("Default Message");
//                
//        String statusInfo = status.toString();
//        //this.console.println(statusInfo);
//        //End CurrentStatus Class Set & Print
//        
//        //ExplorableAreas Class Set & Print
//        ExplorableAreas areaOne = new ExplorableAreas();
//        
//        areaOne.setDescription("Beach Front");
//        areaOne.setHasStatue(1);
//        areaOne.setResource1("Food");
//        areaOne.setResource2("Water");
//        areaOne.setResource1Quantity(3);
//        areaOne.setResource2Quantity(5);
//        areaOne.setTravelDistance(14);
//        
//        String areaInfo = areaOne.toString();
        //this.console.println(areaInfo);
        //End ExplorableAreas Class Set & Print
       
        /**************************************/ 
        //LocationDetails Class Set & Print
        /*************************************/
        /*  Location One Setup */
/*        LocationDetails locationOne = new LocationDetails();
        
        locationOne.setFood(2);
        locationOne.setWater(2);
        locationOne.setFuel(2);
        locationOne.setMunitions(2);
        locationOne.setCoin(2);
        locationOne.setArtifacts(3);
        locationOne.setGems(2);
        locationOne.setStatue(2);
        locationOne.setXCoordinate(2);
        locationOne.setYCoordinate(2);
        
        String locationOneInfo = locationOne.toString();
        //this.console.println(locationOneInfo);
        /*  End of Location One ********/
        /*  Location Two Setup */
/*        LocationDetails locationTwo = new LocationDetails();
        
        locationTwo.setFood(2);
        locationTwo.setWater(2);
        locationTwo.setFuel(2);
        locationTwo.setMunitions(2);
        locationTwo.setCoin(2);
        locationTwo.setArtifacts(3);
        locationTwo.setGems(2);
        locationTwo.setStatue(2);
        locationTwo.setXCoordinate(2);
        locationTwo.setYCoordinate(2);
        
        String locationTwoInfo = locationTwo.toString();
        //this.console.println(locationTwoInfo);
        /*  End of Location Two ********/
        /*  Location Three  Setup */
/*        LocationDetails locationThree = new LocationDetails();
        
        locationThree.setFood(2);
        locationThree.setWater(2);
        locationThree.setFuel(2);
        locationThree.setMunitions(2);
        locationThree.setCoin(2);
        locationThree.setArtifacts(3);
        locationThree.setGems(2);
        locationThree.setStatue(2);
        locationThree.setXCoordinate(2);
        locationThree.setYCoordinate(2);
        
        String locationThreeInfo = locationThree.toString();
        //this.console.println(locationThreeInfo);
        /*  End of Location Three ********/
        /*  Location Four Setup */
 /*       LocationDetails locationFour = new LocationDetails();
        
        locationFour.setFood(2);
        locationFour.setWater(2);
        locationFour.setFuel(2);
        locationFour.setMunitions(2);
        locationFour.setCoin(2);
        locationFour.setArtifacts(3);
        locationFour.setGems(2);
        locationFour.setStatue(2);
        locationFour.setXCoordinate(2);
        locationFour.setYCoordinate(2);
        
        String locationFourInfo = locationFour.toString();
        //this.console.println(locationFourInfo);
        /*  End of LocationFour  ********/
        /*  Location Five Setup */
 /*       LocationDetails locationFive = new LocationDetails();
        
        locationFive.setFood(2);
        locationFive.setWater(2);
        locationFive.setFuel(2);
        locationFive.setMunitions(2);
        locationFive.setCoin(2);
        locationFive.setArtifacts(3);
        locationFive.setGems(2);
        locationFive.setStatue(2);
        locationFive.setXCoordinate(2);
        locationFive.setYCoordinate(2);
        
        String locationFiveInfo = locationFive.toString();
        //this.console.println(locationFiveInfo);
        /*  End of LocationFive  ********/
        /*  Location Six Setup */
 /*       LocationDetails locationSix = new LocationDetails();
        
        locationSix.setFood(2);
        locationSix.setWater(2);
        locationSix.setFuel(2);
        locationSix.setMunitions(2);
        locationSix.setCoin(2);
        locationSix.setArtifacts(3);
        locationSix.setGems(2);
        locationSix.setStatue(2);
        locationSix.setXCoordinate(2);
        locationSix.setYCoordinate(2);
        
        String locationSixInfo = locationSix.toString();
        //this.console.println(locationSixInfo);
        /*  End of LocationSix  ********/
        /*  Location Seven Setup */
/*        LocationDetails locationSeven = new LocationDetails();
        
        locationSeven.setFood(2);
        locationSeven.setWater(2);
        locationSeven.setFuel(2);
        locationSeven.setMunitions(2);
        locationSeven.setCoin(2);
        locationSeven.setArtifacts(3);
        locationSeven.setGems(2);
        locationSeven.setStatue(2);
        locationSeven.setXCoordinate(2);
        locationSeven.setYCoordinate(2);
        
        String locationSevenInfo = locationSeven.toString();
        //this.console.println(locationSevenInfo);
        /*  End of LocationSeven  ********/
        /*  Location Eight Setup */
/*        LocationDetails locationEight = new LocationDetails();
        
        locationEight.setFood(2);
        locationEight.setWater(2);
        locationEight.setFuel(2);
        locationEight.setMunitions(2);
        locationEight.setCoin(2);
        locationEight.setArtifacts(3);
        locationEight.setGems(2);
        locationEight.setStatue(2);
        locationEight.setXCoordinate(2);
        locationEight.setYCoordinate(2);
        
        String locationEightInfo = locationEight.toString();
        //this.console.println(locationEightInfo);
        /*  End of LocationEight  ********/
        
        
        //End LocationDetails Class Set & Print
        
        //Player Class Set & Print
        //Player playerOne = new Player();
        
        //playerOne.setName("Nathan the Amazing");
        //playerOne.setApproachChoice(1);
        //playerOne.setHelp("Replace this string with the actual help menu to display.");
        //playerOne.setPlayerChoice('1');
        
        //String playerInfo = playerOne.toString();
        //this.console.println(playerInfo);
        //End Player Class Set & Print

//        //Societies Class Set & Print
//        Societies societyOne = new Societies();
//        
//        societyOne.setName("Aztecs");
//        societyOne.setDescription("The Aztec Society is the oldest society found.");
//        societyOne.setPositiveApproach("Bribery");
//        societyOne.setNeutralApproach("Diplomacy");
//        societyOne.setNegativeApproach("Intimidation");
//                
//        String societyInfo = societyOne.toString();
        //this.console.println(societyInfo);
        //End Societies Class Set & Print

        //SocietyNPCs Class Set & Print
       // SocietyNPCs societyOneNPC = new SocietyNPCs();
        
        //societyOneNPC.setLeaderName("Achcauhtli");
        //societyOneNPC.setLeaderDescription("Achcauhtli stands 6 feet tall, is very thin and fit.  He shows no emotion on his face.");
        //societyOneNPC.setLeaderTrustLevel(0);
        //societyOneNPC.setLeaderTrustLevelTarget(4);
        //societyOneNPC.setLeaderTrustStatus("Untrusted");
                
        //String societyNPCInfo = societyOneNPC.toString();
        //this.console.println(societyNPCInfo);
        //End SocietyNPCs Class Set & Print
        
        
        //Ships Class Set & Print
        //Ship choices add or subtract from base stats set further below.

        
 /*       String selectedShipInfo = selectedShip.toString();
        //this.console.println(selectedShipInfo);
        
        //Storage Set & Print
        Storage storage = new Storage();
        
        storage.setFood(1);
        storage.setWater(2);
        storage.setFuel(3);
        storage.setMunitions(4);
        storage.setCoin(5);
        storage.setArtifacts(6);
        storage.setGems(7);
        
        String storageInfo = storage.toString();
        //this.console.println(storageInfo);
        
        //Cargo Set & Print
        Cargo cargo = new Cargo();
        
        cargo.setFood(3);
        cargo.setWater(4);
        cargo.setFuel(7);
        cargo.setMunitions(8);
        cargo.setCoin(2);
        cargo.setArtifacts(2);
        cargo.setGems(2);
        
        String cargoInfo = cargo.toString();
        //this.console.println(cargoInfo);
        
        //calcMapSize check
        //MapControl difficultyCon1 = new MapControl();
        //difficultyCon1.calcMapSize( mapOne);
        //mapInfo = mapOne.toString();
        //this.console.println(mapInfo);
        
        
        //populateMap check
        //difficultyCon1.populateMap( mapOne, locationOne, locationTwo, locationThree, locationFour,
         //       locationFive, locationSix, locationSeven, locationEight, status);
        //String allLocationInfo = locationOne.toString() + "\n" + locationTwo.toString() + "\n" 
        //        + locationThree.toString() + "\n" + locationFour.toString() + "\n" + locationFive.toString()
          //      + "\n" + locationSix.toString() + "\n" + locationSeven.toString() + "\n" + locationEight.toString();
        //this.console.println(allLocationInfo);

        //compareTrustLevels check
        TrustTrialControl TrustNPC1 = new TrustTrialControl();
        TrustNPC1.compareTrustLevels( societyOneNPC, status );
        societyNPCInfo = societyOneNPC.toString();
        //this.console.println(societyNPCInfo + " " + status.getStatusMessage());
        statusInfo = status.toString();
        //this.console.println(statusInfo);
        
        //Check SelectedShip
        //playerOne.setPlayerChoice('0');
        //ShipSelectionControl chooseShip = new ShipSelectionControl();
        //chooseShip.assignShip(player.getPlayerChoice(), ship, selectedShip, status);
        //selectedShipInfo = selectedShip.toString();
        //this.console.println(selectedShipInfo + "\n" + status.getStatusMessage());
         */
    }
         
}
