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
public class Storms implements Serializable{
    
    public Storms(){    
    }

    private int XCoordinate;
    private int YCoordinate;
    private int powerLevel;
    private String warning;

    public int getXCoordinate() {
        return XCoordinate;
    }

    public void setXCoordinate(int XCoordinate) {
        this.XCoordinate = XCoordinate;
    }

    public int getYCoordinate() {
        return YCoordinate;
    }

    public void setYCoordinate(int YCoordinate) {
        this.YCoordinate = YCoordinate;
    }

    public int getPowerLevel() {
        return powerLevel;
    }

    public void setPowerLevel(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    
    @Override
    public String toString() {
        return "Storms{ XCoordinate=" + XCoordinate + ", YCoordinate="
                + YCoordinate + ", powerLevel = " + powerLevel + ", warning = "
                + warning + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.XCoordinate;
        hash = 67 * hash + this.YCoordinate;
        hash = 67 * hash + this.powerLevel;
        hash = 67 * hash + Objects.hashCode(this.warning);
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
        final Storms other = (Storms) obj;
        if (this.XCoordinate != other.XCoordinate) {
            return false;
        }
        if (this.YCoordinate != other.YCoordinate) {
            return false;
        }
        if (this.powerLevel != other.powerLevel) {
            return false;
        }
        if (!Objects.equals(this.warning, other.warning)) {
            return false;
        }
        return true;
    }

    
}
