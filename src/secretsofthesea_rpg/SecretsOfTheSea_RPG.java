/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package secretsofthesea_rpg;

//import byui.cit260.secretsOfTheSea.control.StartControl;
import byui.cit260.secretsOfTheSea.control.InventoryControl;
import byui.cit260.secretsOfTheSea.control.MapControl;
import byui.cit260.secretsOfTheSea.control.NewGameControl;
import byui.cit260.secretsOfTheSea.control.ShipSelectionControl;
import byui.cit260.secretsOfTheSea.exceptions.ExplorableAreasException;
import byui.cit260.secretsOfTheSea.exceptions.MapControlException;
import byui.cit260.secretsOfTheSea.exceptions.ShipSelectionException;
import byui.cit260.secretsOfTheSea.model.CurrentStatus;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import byui.cit260.secretsOfTheSea.view.ErrorView;
import byui.cit260.secretsOfTheSea.view.ExplorableAreasView;
import byui.cit260.secretsOfTheSea.view.StartProgramView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SDababneh
 */
public class SecretsOfTheSea_RPG {
    

    /**
     * @param args the command line arguments
     */
//    private static Game currentGame = null;
//    private static Player player = null;
    
    private static PrintWriter outFile = null;//for Console
    private static BufferedReader inFile = null;
    private static PrintWriter errorLog = null;
    private static File errorFile = new File("ErrorsLog.txt");//specify name and path of file here
    private static PrintWriter statusReport = null;
    
    public static void main(String[] args) {
        //Sample Class Set & Print
        /*Sample samepleOne = new Sample();
        *
        *sampleOne.setAttribute("Value");
        *sampleOne.setIntAttribute(1); 
        *
        *String sampleInfo = sampleOne.toString();
        *this.console.println(sampleInfo);
        */
        //End sample Class Set & Print
        
        //StartControl startup = new StartControl();
        //startup.initializeGame();
        NewGameControl tempGame = null;
        MapControl tempMap = null;
        ShipSelectionControl tempShip = null; 
        InventoryControl tempInventory = null;
        LocationDetails tempIsland = null;
        

        
        StartProgramView startProgramView = null;//= new StartProgramView();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); 
        
        try {
        //These lines open a stream for input and output for the console.
        //The 4th line creates and errorLog file in the specified directory.
        //They are created in main so as to be referencable throughout the remainder
        //of the program
        SecretsOfTheSea_RPG.inFile = new BufferedReader(new InputStreamReader(System.in));
        SecretsOfTheSea_RPG.outFile = new PrintWriter(System.out, true);
        
        
        //*******Error Log Creation**********
        if (!errorFile.exists())//Checks if errorFile exists.  Creates it if it does not.
            errorFile.createNewFile();
        errorLog = new PrintWriter(new BufferedWriter(new FileWriter(errorFile, true)));      
        //true tells it to append to what exits instead of creating new one.
        //May create if does not exists, but of that I'm unsure.

        String filePath = "errorLog.txt";
        SecretsOfTheSea_RPG.errorLog = new PrintWriter(filePath);    
        
        //SecretsOfTheSea_RPG.statusReport = new PrintWriter(System.out, true);
        String reportPath = "statusReport.txt";       
        SecretsOfTheSea_RPG.statusReport = new PrintWriter(new BufferedWriter(new FileWriter (reportPath, true)));
        statusReport.println("\r\n ****PLAYER STATUS REPORT**** \r\n " + dateFormat.format(date) + " is your game start time. \r\n");
//                statusReport.write("\n ************ \n");
                statusReport.close();
        
        
        try {//creating instances of the control.  My only concer is whether these will overwrite
            //the read data because I had to make them static to support the set and gets each...
            //Note that without this try - catch the GameMenu Load should have worked fine with
            //The Lines below this try catch.
        tempGame = new NewGameControl("Default");
        tempMap = new MapControl('E');
        tempShip = new ShipSelectionControl(0);
        tempInventory = new InventoryControl();
        tempInventory.startupInventory();
        CurrentStatus.setStatuesCount(1);
        LocationDetails locations[] = MapControl.getLocation();
                for (int i=0; i<8;i++){
                    if(CurrentStatus.getCurrentX()==locations[i].getXCoordinate() &&
                       CurrentStatus.getCurrentY()==locations[i].getYCoordinate()){
                        tempIsland = locations[i];
                        tempIsland.setIslandNumber(0);
                        tempIsland.setSocietyName("Home");
                        tempIsland.setStatue(0);
                    }
                }
//Start with 1 statue from home island.
        
        }catch (MapControlException | ExplorableAreasException | ShipSelectionException mce) { 
            ErrorView.display("GameControl ",mce.getMessage());
        }
        
        //StartProgramView
        startProgramView = new StartProgramView();
        startProgramView.startProgram(tempGame, tempMap, tempShip, tempInventory, tempIsland);
       
        } catch (Throwable ex){ 

            ErrorView.display("SecretsOfTheSea_RPG", "Invalid Entry, please try again.");
            startProgramView.startProgram(tempGame, tempMap, tempShip, tempInventory, tempIsland);
            
            
        }
        finally {
            try{
                if (SecretsOfTheSea_RPG.inFile != null)
                    SecretsOfTheSea_RPG.inFile.close();
                
                if (SecretsOfTheSea_RPG.outFile != null)
                    SecretsOfTheSea_RPG.outFile.close();
                
                if (SecretsOfTheSea_RPG.errorLog != null)
                    SecretsOfTheSea_RPG.errorLog.close();
            } catch (IOException ex) {
                ErrorView.display("SecretsOfTheSea_RPG","Error closing a stream.");
            }
        }
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        SecretsOfTheSea_RPG.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        SecretsOfTheSea_RPG.inFile = inFile;
    }

    public static PrintWriter getErrorLog() {
        return errorLog;
    }

    public static void setErrorLog(PrintWriter errorLog) {
        SecretsOfTheSea_RPG.errorLog = errorLog;
    }

    public static File getErrorFile() {
        return errorFile;
    }

    public static void setErrorFile(File errorFile) {
        SecretsOfTheSea_RPG.errorFile = errorFile;
    }
    public static PrintWriter getStatusReport() {
        return statusReport;
    }

    public static void setStatusReport(PrintWriter statusReport) {
        SecretsOfTheSea_RPG.statusReport = statusReport;
    }
    
}
