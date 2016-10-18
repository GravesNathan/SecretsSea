/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Nathan
 */
public class Player implements Serializable{
    // class instance variables
    private static String name;
    private int approachChoice;
    private String help;
    private char playerChoice;
    
    public Player(String tempName) {
        this.setName(tempName);
    }

    public static String getName() {
        return name;
    }

    public int getApproachChoice() {
        return approachChoice;
    }

    public static void setName(String tempName) {
        name = tempName;
    }

    public void setApproachChoice(int approachChoice) {
        this.approachChoice = approachChoice;
    }

    public char getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(char playerChoice) {
        this.playerChoice = playerChoice;
    }

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    
    //@Override
    public String toString() {
        return "Player{" + "name=" + name + ", approachChoice=" + approachChoice + ", playerChoice =" 
                + playerChoice + "\n help=\n" + help + '}';
    }

    //@Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.approachChoice;
        hash = 97 * hash + this.playerChoice;
        hash = 97 * hash + Objects.hashCode(this.help);
        return hash;
    }

    //@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.approachChoice != other.approachChoice) {
            return false;
        }
        if (this.playerChoice != other.playerChoice) {
            return false;
        }
        if (!Objects.equals(this.help, other.help)) {
            return false;
        }
        return true;
    }
    
    
}
