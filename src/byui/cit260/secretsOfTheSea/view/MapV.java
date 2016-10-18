///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package byui.cit260.secretsOfTheSea.view;
//
//import byui.cit260.secretsOfTheSea.control.InventoryControl;
//import byui.cit260.secretsOfTheSea.control.MapControl;
//import byui.cit260.secretsOfTheSea.control.NewGameControl;
//import byui.cit260.secretsOfTheSea.control.ShipSelectionControl;
//import byui.cit260.secretsOfTheSea.exceptions.MapControlException;
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.io.BufferedReader;
//import java.io.PrintWriter;
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
//import javax.swing.UnsupportedLookAndFeelException;
//import secretsofthesea_rpg.SecretsOfTheSea_RPG;
//
///**
// *
// * @author Nathan
// */
//public class MapV{
//    
//    private final BufferedReader keyboard = SecretsOfTheSea_RPG.getInFile();
//    private final PrintWriter console = SecretsOfTheSea_RPG.getOutFile();
//    //private static JLabel ship = new JLabel();
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
//    
//    
//    
//    public MapV( NewGameControl username, MapControl map, ShipSelectionControl playerShip,
//            InventoryControl inventory, LocationDetails island){
//        //super("Map View");
//        KeyEventDemo keyDetect = new KeyEventDemo("Map View");
//        char tempInput = 'Z';
//        do {
//        console.println( map.mapToString() + "\n"
//                + "Please enter an option below or use the arrow keys to move your ship."
//                + "\n D - Dock ship"
//                + "\n W - Work on(Repair) ship"
//                + "\n I - View Inventory"
//                + "\n V - View all Statuses"
//                + "\n M - View Map"
//                + "\n G - Game Menu");
//        tempUsername = username;
//        tempMap = map;
//        tempPlayerShip = playerShip;
//        tempInventory = inventory;
//        tempInput = input.charInput();
//        //KeyEventDemo keyDetect = new KeyEventDemo("Move Ship View");
//        }while(tempInput != 'D');
//    }
//
//    
//   
////    @Override
//    public boolean doAction(char entry){
//        return false;//get rid of error
//    }
//
//}