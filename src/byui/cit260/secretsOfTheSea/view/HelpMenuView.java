/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.view;


import byui.cit260.secretsOfTheSea.control.MapControl;
import byui.cit260.secretsOfTheSea.control.NewGameControl;
import byui.cit260.secretsOfTheSea.control.ShipSelectionControl;
import java.util.Scanner;

/**
 *
 * @author SDababneh
 */
public class HelpMenuView extends View{
    
    public  HelpMenuView(){
            super("\n****HELP MENU***"
                + "\n"
                + "\nHotkey - Description"
                + "\n G - What is the Goal of the Game?"
                + "\n H - Health Explained"
                + "\n M - How to Move"
                + "\n R - Resource Types"
                + "\n S - Societies"
                + "\n T - Trust Levels"                
                + "\n C - Close Menu"
                + "\n ", null, null, null, null, null);
    }
    
    /*Editted existing code so that the returnHelpMenu is called from the switch
    Removed any call from the quitMenu option causing it to break.  This setup allows
    the help menu to return to previous view instead of just to the startGameView.
    Week 7 material has a nice layout once you get use to it.  I've implemented
    with constructors in ExplorableAreas and GameMenuView.  it allows the Views
    to return to previous view when they are done executing with ease.
    */
    
    @Override
    public boolean doAction(char entry){
        char value = entry;
        
        switch (value) {
            case 'G':
                this.describeGameGoal();
                this.returnHelpMenu();
                return false;
            case 'H':
                this.healthExplained();
                this.returnHelpMenu();
                return false;
            case 'M':
                this.howToMove();
                this.returnHelpMenu();
                return false;
            case 'R':
                this.resourceTypes();
                this.returnHelpMenu();
                return false;
            case 'S':
                this.societyHelp();
                this.returnHelpMenu();
                return false; 
            case 'T':
                this.trustLevelsExplained();
                this.returnHelpMenu();
                return false;                
            case 'C':
                return true;
            default:
                ErrorView.display(this.getClass().getName(),value + " is an invalid entry. Please select an option below:");
            return false;
        }
        
    }

    private void describeGameGoal() {
        this.console.println("\n *** What is the Goal of the Game: ***"
                        + "\n"
                        + "\n The goal of the game is to gather up all of the 8 statues."
                        + "\n You have been given the first statue by your own people, you "
                        + "\n must now travel the Seas to find other the other societies"
                        + "\n that have the remaining statues."
                        + "\n"
                        + "\n Be mindful that you won't be trusted at first.  You must use"
                        + "\n your wit, charm, strength and guile to win over each society"
                        + "\n so that you can find all of the statues without finding yourself"
                        + "\n swimming with the sharks."
                        + "\n "
        );
    }

    
    private void healthExplained() {
        this.console.println("\n *** HEALTH EXPLAINED ***"
                        + "\n"
                        + "\n As you travel through the game you and your crew will face ."
                        + "\n storms at sea, hunger, thirst, and the possibility of an "
                        + "\n angry society."
                        + "\n"
                        + "\n The type of ship you select will have varying levels of ability"
                        + "\n to withstand these trials.  Choose wisely and be sure to repair"
                        + "\n your ship as needed."
                        + "\n "
        );
    }



    private void howToMove() {
        this.console.println("\n *** HOW TO MOVE ***"
                        + "\n"
                        + "\n While navigating the seas you can steer your vessel by using the "
                        + "\n E, R, T, & 4 keys.  E = Right, T = Left, R = Down & 4 = Up."
                        + "\n"
        );
    }

    private void resourceTypes() {
        this.console.println("\n *** RESOURCE TYPES ***"
                        + "\n"
                        + "\n Enter Description Here."
                        + "\n"
                        + "\n"
        );
    }

    private void societyHelp() {
        this.console.println("\n *** SOCIETIES EXPLAINED ***"
                        + "\n"
                        + "\n Enter Description Here."
                        + "\n"
                        + "\n"
        );
    }

    private void trustLevelsExplained() {
        this.console.println("\n *** TRUST LEVELS EXPLAINED ***"
                        + "\n"
                        + "\n Enter Description Here."
                        + "\n"
                        + "\n"
                            );
    }
    
        public void quitMenu() {
        //StartProgramView returnToStart = new StartProgramView();
        //returnToStart.startMenuDisplay();
        //This will return the user to the main game menu but ends the program.  
        //Ideal action would be to return to calling menu (Main or Game)
        //Need help figuring this part out.
    }
       
        public void returnHelpMenu(){
//        String input1 = null;
        InputView input = new InputView();
        input.stringInput();
        this.console.println("Press ENTER to Proceed.");
//        input1 = keyboard.nextLine();
//        this.displayMenu();
    }
        
}
