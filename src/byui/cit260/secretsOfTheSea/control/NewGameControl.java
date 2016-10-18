/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.control;

import byui.cit260.secretsOfTheSea.model.Map;
import byui.cit260.secretsOfTheSea.model.Player;
import byui.cit260.secretsOfTheSea.model.SelectedShip;

/**
 *
 * @author SDababneh
 */
public class NewGameControl {
    
    private static Player player1 = null;//Initializeing here allows it's use throughout class refering to the same object for get and set
    //private String tempUserName = null;  He lost me on the whole tempUserName thing.  Have some grasp of constructors, but not completely.


    //these are called constructors.  
    public NewGameControl(String tempNameControl){
        //pass username from MainMenuView to here
        //and assign to tempUser
        //Why?  Is he trying to initiate the whole class right here to save running time by less calls?
        player1 = new Player( tempNameControl );

    }
    /*My thoughts on the constructor.  When you create a new object
    ClassName ObjectName = null; does not actually give it a place in memory, only creates
    the object.  The ObjectName = ClassName(); is where the memory is actually created.
    Essentially this is a constructor call which executes.  This is where the actual memory of
    ObjectName is created.
    Similar to a function call you can add in variables or literal data to the constructor call.
    You likewise need the constructor itself prepared to receive those arguments.  Within the constructor
    you can assign default values to the variables that were passed.
    This would cause the ObjectName location in memory to hold these default values at this time.
    
    So Brandon is saying, have Player accept a string to assign the name right away once it's called.
    A step up the latter have the view pass the username to the NewGameControl constructor.
    This constructor assign that value to a temporary username.  Then it can call the player constructor
    assigning with the temporary username being pass to player.  The Player constructor accepts
    this and assigns it immediately to the name attribute within the model layer for that object.
    This would elimate the need for the setPlayerName control.
    */

    //public void setPlayerName(String userName){ 
        //init player with String player name from view
        //pass temp username to player
        //player1 = new Player( userName );//Why separate instead of all up top?
        //player1.setName(userName);//accepts value from view then pushes to the model layer
     //   }
    
    public static String getPlayerName(){
        return Player.getName();
    }

    public static void setPlayerName(String playerName) {
        Player.setName(playerName);
    }
    
    
}
