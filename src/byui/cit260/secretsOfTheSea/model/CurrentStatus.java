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
 * @author SDababneh
 */
public class CurrentStatus implements Serializable{
    //CurrentLocation
    //StatuesCount
    //LifeStatus
    
    private static int currentX;
    private static int currentY;
    private static int currentArea;
    private static int currentIsland;//set which island they are on for explorableAreas.
    private static int StatuesCount;    
    private String LifeStatus;
    private String gameDifficulty;
    private static String statusMessage;
    
    public CurrentStatus() {
    }

    public static int getCurrentX() {
        return currentX;
    }

    public static void setCurrentX(int currentX) {
        CurrentStatus.currentX = currentX;
    }

    public static int getCurrentY() {
        return currentY;
    }

    public static void setCurrentY(int currentY) {
        CurrentStatus.currentY = currentY;
    }

    public static int getCurrentArea() {
        return currentArea;
    }

    public static void setCurrentArea(int currentArea) {
        CurrentStatus.currentArea = currentArea;
    }

    public static int getCurrentIsland() {
        return currentIsland;
    }

    public static void setCurrentIsland(int currentIsland) {
        CurrentStatus.currentIsland = currentIsland;
    }
   
    
    /**
     * Get the value of StatuesCount
     *
     * @return the value of StatuesCount
     */
    public static int getStatuesCount() {
        return StatuesCount;
    }

    /**
     * Set the value of StatuesCount
     *
     * @param StatuesCount new value of StatuesCount
     */
    public static void setStatuesCount(int tempStatuesCount) {
        StatuesCount = tempStatuesCount;
    }



    /**
     * Get the value of LifeStatus
     *
     * @return the value of LifeStatus
     */
    public String getLifeStatus() {
        return LifeStatus;
    }

    /**
     * Set the value of LifeStatus
     *
     * @param LifeStatus new value of LifeStatus
     */
    public void setLifeStatus(String LifeStatus) {
        this.LifeStatus = LifeStatus;
    }

    public String getGameDifficulty() {
        return gameDifficulty;
    }

    public void setGameDifficulty(String gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
    }

    public static String getStatusMessage() {
        return statusMessage;
    }

    public static void setStatusMessage(String tempStatusMessage) {
        statusMessage = tempStatusMessage;
    }

    
    
    @Override
    public String toString() {
        return "CurrentStatus{" + " currentX = "+ currentX + ", currentY" + currentY + ", StatuesCount= " + StatuesCount + ", LifeStatus=" + LifeStatus 
                + ", GameDifficulty=" + gameDifficulty + "statusMessage = " + statusMessage + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.StatuesCount);
        hash = 23 * hash + Objects.hashCode(this.LifeStatus);
        hash = 23 * hash + Objects.hashCode(this.gameDifficulty);
        hash = 23 * hash + Objects.hashCode(this.statusMessage);
        hash = 23 * hash + Objects.hashCode(CurrentStatus.currentX);
        hash = 23 * hash + Objects.hashCode(CurrentStatus.currentY);
        hash = 23 * hash + Objects.hashCode(CurrentStatus.currentArea);
        hash = 23 * hash + Objects.hashCode(CurrentStatus.currentIsland);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CurrentStatus other = (CurrentStatus) obj;
        if (!Objects.equals(this.StatuesCount, other.StatuesCount)) {
            return false;
        }
        if (!Objects.equals(this.LifeStatus, other.LifeStatus)) {
            return false;
        }
        if (!Objects.equals(this.gameDifficulty, other.gameDifficulty)) {
            return false;
        }
        if (!Objects.equals(this.statusMessage, other.statusMessage)) {
            return false;
        }
        //Static variables shouldn't need this.  They are the same
        //across all instances of the class.
//        if (!Objects.equals(this.currentX, other.currentX)) {
//            return false;
//        }
//        if (!Objects.equals(this.currentY, other.currentY)) {
//            return false;
//        }
        return true;
        
    
    }

}
