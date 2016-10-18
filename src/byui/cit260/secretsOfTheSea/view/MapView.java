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
import byui.cit260.secretsOfTheSea.exceptions.MapControlException;
import byui.cit260.secretsOfTheSea.model.CurrentStatus;
import byui.cit260.secretsOfTheSea.model.LocationDetails;
import byui.cit260.secretsOfTheSea.model.Map;
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.AbstractAction;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.KeyStroke;
//import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import secretsofthesea_rpg.SecretsOfTheSea_RPG;

/**
 *
 * @author Nathan
 */
public class MapView extends View{
    
//    private final BufferedReader keyboard = SecretsOfTheSea_RPG.getInFile();
//    private final PrintWriter console = SecretsOfTheSea_RPG.getOutFile();
    //private static JLabel ship = new JLabel();
//    private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
//    private static final String MOVE_UP = "move up";
//    private static final String MOVE_DOWN = "move down";
//    private static final String MOVE_LEFT = "move left";
//    private static final String MOVE_RIGHT = "move right";
//    private InputView input = new InputView();
//    private MapControl tempMap = null;
//    private NewGameControl tempUsername = null;
//    private ShipSelectionControl tempPlayerShip = null;
//    private InventoryControl tempInventory = null;  
//    Had above lines if need to take away extends View
    
    
    public MapView( NewGameControl username, MapControl map, ShipSelectionControl playerShip,
            InventoryControl inventory, LocationDetails island){
        super( "************Move Ship View*****************"
                + "\n\n"
                + "\n\nShip Health = " + playerShip.getHealth()
                + "\nShip Defense = " + playerShip.getDefense()
                + "\nShip Speed = " + playerShip.getSpeed()
                + "\nCurrent Morale = " + playerShip.getMorale()
                + "\n" + inventory.cargoMapString()
                + "\n\nMap of the Sea \n\n" + map.mapToString()
                + "\nPlease enter an option below."
                + "\n D - Dock ship"
                //+ "\n W - Work on(Repair) ship"
                + "\n I - View Inventory"
                + "\n V - View all Statuses"
                + "\n G - Game Menu"
                + "\n\n Or Use the E, R, T, and 4 keys to move your ship"
                + "\nLeft, Down, Right, and Up respectively.", username, map, playerShip, inventory, island);
    }

    
   
    @Override
    public boolean doAction(char entry){
        char value = entry;
        if (value == 'E' || value == 'R' || value == 'T' || value == '4'){
            try {
                tempMap.moveShip(entry, ShipSelectionControl.getSelectedShip(), tempInventory);
                } catch (MapControlException | InventoryControlException ex) {
                ErrorView.display("MapView", ex.getMessage());
                }
                this.setPromptMessage("\n\n************Move Ship View*****************"
                + "\nCURRENT STATUS\n" + CurrentStatus.getStatusMessage()
                + "\n\nShip Health = " + tempPlayerShip.getHealth()
                + "\nShip Defense = " + tempPlayerShip.getDefense()
                + "\nShip Speed = " + tempPlayerShip.getSpeed()
                + "\nCurrent Morale = " + tempPlayerShip.getMorale()
                + "\n" + tempInventory.cargoMapString()
                + "\nMap of the Sea \n\n" + tempMap.mapToString() + "\n\n\n"
                + "Please enter an option below."
                + "\n D - Dock ship"
                //+ "\n W - Work on(Repair) ship"
                + "\n I - View Inventory"
                + "\n V - View all Statuses"
                + "\n G - Game Menu"
                + "\n\nUse the E, R, T, and 4 keys to move your ship"
                + "\nLeft, Down, Right, and Up respectively.");
                return false;
        }
        switch (value) {
            case 'D':
                if (Map.getSpot(CurrentStatus.getCurrentX(), 
                        CurrentStatus.getCurrentY()) == 1){
                    OnShipView onShip = new OnShipView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
                    return true;
                    }else { this.console.println("There is not an island in site to dock at");
		return false;
                }
                //Work on ship is done by using Lumber in InventoryView
//            case 'W':
//		this.workOnShipControl();
//		return false;
            case 'I':
		InventoryManagerView inventory = new InventoryManagerView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		//Update Prompt message with new stats after inventory usage.
                this.setPromptMessage("\n\n************Move Ship View*****************"
                + "\nCURRENT STATUS\n" + CurrentStatus.getStatusMessage()
                + "\n\nShip Health = " + tempPlayerShip.getHealth()
                + "\nShip Defense = " + tempPlayerShip.getDefense()
                + "\nShip Speed = " + tempPlayerShip.getSpeed()
                + "\nCurrent Morale = " + tempPlayerShip.getMorale()
                + "\n" + tempInventory.cargoMapString()
                + "\nMap of the Sea \n\n" + tempMap.mapToString() + "\n\n\n"
                + "Please enter an option below."
                + "\n D - Dock ship"
                //+ "\n W - Work on(Repair) ship"
                + "\n I - View Inventory"
                + "\n V - View all Statuses"
                + "\n G - Game Menu"
                + "\n\nUse the E, R, T, and 4 keys to move your ship"
                + "\nLeft, Down, Right, and Up respectively.");
                return false;
            case 'V':
		StatusesView status = new StatusesView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            case 'G':
		GameMenuView gameMenu = new GameMenuView(tempUsername, tempMap, tempPlayerShip, tempInventory, tempIsland);
		return false;
            default:
                ErrorView.display(this.getClass().getName(),"\n Invalid choice.  Please try again.");
                return false;
        } 
        
    }

//    private void workOnShipControl() {
//        System.out.println("Work on Ship stub called."); 
//    }

}