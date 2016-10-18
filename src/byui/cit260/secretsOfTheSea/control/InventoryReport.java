/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.control;

import byui.cit260.secretsOfTheSea.exceptions.CharInputException;
import byui.cit260.secretsOfTheSea.view.InventoryManagerView;
import byui.cit260.secretsOfTheSea.view.ErrorView;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import secretsofthesea_rpg.SecretsOfTheSea_RPG;

/**
 *
 * @author Nathan
 */
public class InventoryReport {
    
    protected final PrintWriter console = SecretsOfTheSea_RPG.getOutFile();
    
    public InventoryReport(InventoryControl inventory, String outFileLocation){
        printInventory(inventory, outFileLocation);
    }
    
    public void printInventory(InventoryControl inventory, String outFileLocation){
//        try (BufferedWriter out = new BufferWriter(new FileWriter(outputLocation))){
        BufferedWriter outFile = null;
        try {  
            outFile = new BufferedWriter(new FileWriter(outFileLocation));
            outFile.write("Current Cargo\r\n");
            outFile.write(inventory.cargoToString());
            //outFile.write("\r\n \r\nCurrent Storage\r\n");
            //outFile.write(inventory.storageToString());
        } catch (IOException ex1){
            ErrorView.display(this.getClass().getName(), ex1.getMessage() +"Error Creating Inventory Report.");
        } finally{
            if (outFile != null){
                try {
                    outFile.close();
                } catch (IOException ex2){
                    ErrorView.display(this.getClass().getName(), ex2.getMessage() + "Error closing InventoryReport file");
                }
            }
        }
    }
}