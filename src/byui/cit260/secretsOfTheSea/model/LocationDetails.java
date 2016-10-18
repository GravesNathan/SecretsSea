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
public class LocationDetails extends Storage implements Serializable{
    private int Statue;
    private int XCoordinate;
    private int YCoordinate;
    private float distance;
    private int islandNumber;//For use in Explorable Areas.
    private String societyName;
    
    public LocationDetails() {
    }

    public int getStatue() {
        return Statue;
    }

    public void setStatue(int Statue) {
        this.Statue = Statue;
    }

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

    public float getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public int getIslandNumber() {
        return islandNumber;
    }

    public void setIslandNumber(int islandNumber) {
        this.islandNumber = islandNumber;
    }

    public String getSocietyName() {
        return societyName;
    }

    public void setSocietyName(String societyName) {
        this.societyName = societyName;
    }

    
    
    @Override
    public String toString() {
        return "LocationDetails{" + ", Statue=" + Statue + ", XCoordinate=" + XCoordinate + ", YCoordinate="
                + YCoordinate + ", distance = " + distance + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.Statue;
        hash = 29 * hash + this.XCoordinate;
        hash = 29 * hash + this.YCoordinate;
        hash = 29 * hash + Float.floatToIntBits(this.distance);
        hash = 29 * hash + this.islandNumber;
        hash = 29 * hash + Objects.hashCode(this.societyName);
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
        final LocationDetails other = (LocationDetails) obj;
        if (this.Statue != other.Statue) {
            return false;
        }
        if (this.XCoordinate != other.XCoordinate) {
            return false;
        }
        if (this.YCoordinate != other.YCoordinate) {
            return false;
        }
        if (Float.floatToIntBits(this.distance) != Float.floatToIntBits(other.distance)) {
            return false;
        }
        if (this.islandNumber != other.islandNumber) {
            return false;
        }
        if (!Objects.equals(this.societyName, other.societyName)) {
            return false;
        }
        return true;
    }

   
}
