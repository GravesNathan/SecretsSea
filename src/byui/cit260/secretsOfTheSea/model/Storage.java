/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.model;

import java.io.Serializable;

/**
 *
 * @author Nathan
 */
public class Storage implements Serializable{
    
    protected int foodQuantity;
    protected int waterQuantity;
    protected int fuelQuantity;
    protected int munitionsQuantity;
    protected int coinQuantity;
    protected int artifactsQuantity;
    protected int gemsQuantity;

    public Storage() {
        this.setFoodQuantity(25);
        this.setWaterQuantity(25);
        this.setFuelQuantity(25);
        this.setMunitionsQuantity(5);
        this.setCoinQuantity(200);
        this.setArtifactsQuantity(1);
        this.setGemsQuantity(1);
    }

    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    public int getWaterQuantity() {
        return waterQuantity;
    }

    public void setWaterQuantity(int waterQuantity) {
        this.waterQuantity = waterQuantity;
    }

    public int getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(int fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public int getMunitionsQuantity() {
        return munitionsQuantity;
    }

    public void setMunitionsQuantity(int munitionsQuantity) {
        this.munitionsQuantity = munitionsQuantity;
    }

    public int getCoinQuantity() {
        return coinQuantity;
    }

    public void setCoinQuantity(int coinQuantity) {
        this.coinQuantity = coinQuantity;
    }

    public int getArtifactsQuantity() {
        return artifactsQuantity;
    }

    public void setArtifactsQuantity(int artifactsQuantity) {
        this.artifactsQuantity = artifactsQuantity;
    }

    public int getGemsQuantity() {
        return gemsQuantity;
    }

    public void setGemsQuantity(int gemsQuantity) {
        this.gemsQuantity = gemsQuantity;
    }

    @Override
    public String toString() {
        return "Storage{" + "foodQuantity=" + foodQuantity + ", waterQuantity=" + waterQuantity + ", fuelQuantity=" + fuelQuantity + ", munitionsQuantity=" + munitionsQuantity + ", coinQuantity=" + coinQuantity + ", artifactsQuantity=" + artifactsQuantity + ", gemsQuantity=" + gemsQuantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.foodQuantity;
        hash = 79 * hash + this.waterQuantity;
        hash = 79 * hash + this.fuelQuantity;
        hash = 79 * hash + this.munitionsQuantity;
        hash = 79 * hash + this.coinQuantity;
        hash = 79 * hash + this.artifactsQuantity;
        hash = 79 * hash + this.gemsQuantity;
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
        final Storage other = (Storage) obj;
        if (this.foodQuantity != other.foodQuantity) {
            return false;
        }
        if (this.waterQuantity != other.waterQuantity) {
            return false;
        }
        if (this.fuelQuantity != other.fuelQuantity) {
            return false;
        }
        if (this.munitionsQuantity != other.munitionsQuantity) {
            return false;
        }
        if (this.coinQuantity != other.coinQuantity) {
            return false;
        }
        if (this.artifactsQuantity != other.artifactsQuantity) {
            return false;
        }
        if (this.gemsQuantity != other.gemsQuantity) {
            return false;
        }
        return true;
    }
    
    
}
