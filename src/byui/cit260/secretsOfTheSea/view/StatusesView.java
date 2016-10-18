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
import byui.cit260.secretsOfTheSea.exceptions.MapControlException;
import byui.cit260.secretsOfTheSea.model.CurrentStatus;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import byui.cit260.secretsOfTheSea.model.Player;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import secretsofthesea_rpg.SecretsOfTheSea_RPG;


/**
 *
 * @author Nathan
 */
public class StatusesView extends View{
    
                protected final PrintWriter statusReport =
            SecretsOfTheSea_RPG.getStatusReport();
                
    public StatusesView(NewGameControl username, MapControl map, ShipSelectionControl playerShip,
            InventoryControl inventory, LocationDetails island){
        super( "************Current Game Status*****************"
                + "\n\n"
                + "\nPlayer Name = " + Player.getName()
                + "\nStatue Count =" + CurrentStatus.getStatuesCount()
                + "\n\nShip Health = " + playerShip.getHealth()
                + "\nShip Defense = " + playerShip.getDefense()
                + "\nShip Speed = " + playerShip.getSpeed()
                + "\nCurrent Morale = " + playerShip.getMorale()
                + "\n" + inventory.cargoMapString()
                + "\n\nMap of the Sea \n\n" + map.mapToString()
                + "\n C - Close Status View"
                + "\n P - Print Status Report", username, map, playerShip, inventory, island);
    }
    
  
    
        
    @Override
    public boolean doAction(char entry){
        char value = entry;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); 
        
//        String diffDisplay = new String();
//                
//            try {
//                switch (tempMap.getUserDifficulty()) {
//                    case "H":
//                        diffDisplay = "Hard";
//                        return true;
//                    case "N":
//                        diffDisplay = "Normal";
//                        return true;
//                    case "E":
//                        diffDisplay = "Easy";
//                        return true;
//                    default:
//                        diffDisplay = "Unknown";
//                        return true;
//                }           } catch (MapControlException ex) {
//            ErrorView.display(this.getClass().getName(), ex.getMessage() +"- Error converting the difficulty character to a display name.");
//            }
        
        

        switch (value) {
//            case 'G':  Took out so we don't have a loop of game menu and statuses view
//                GameMenuView gamemenu = new GameMenuView();
//                return false; 
            case 'C'://closes inventory manager view
                return true;    
            case 'P':
                BufferedWriter statusReport = null;
                try {
                String reportPath = "statusReport.txt";       
                statusReport = new BufferedWriter(new FileWriter(reportPath, true));
//                statusReport = new PrintWriter(new BufferedWriter(new FileWriter (reportPath, true)));
                        statusReport.write("\r\n *****STATUS REPORT***** \r\n");
                        statusReport.write("\r\n Date & Time: ");
                        statusReport.write(dateFormat.format(date));
                        statusReport.write("\r\n Player Name: ");
                        statusReport.write("\"" + tempUsername.getPlayerName() + "\"");
                        statusReport.write("\r\n Difficulty: ");
                        statusReport.write("\"" + tempMap.getDifficulty() + "\"");
                        statusReport.write("\r\n");
                        statusReport.write("\r\n ************ \r\n");
                } catch (IOException ex1){
            ErrorView.display(this.getClass().getName(), ex1.getMessage() +"- Error Creating Status Report.");
        } finally{
            if (statusReport != null){
                try {
                    statusReport.close();
                } catch (IOException ex2){
                    ErrorView.display(this.getClass().getName(), ex2.getMessage() + "- Error closing Status Report file");
                }
            }
        }
                this.console.println("Your Status Report has been successfully written to disk.");
                return true;
            default:
                ErrorView.display(this.getClass().getName(),"\n" + value + " is an invalid entry. Please select an option below:");
                return false;
        }
    }
}
