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
public class Cargo extends Storage implements Serializable{
    
    private int size;

    public Cargo() {
        this.setSize(100);//Put this is selected ship
        //Put these in a cargo and storage varaible which are an arrayList of Items.
        this.setFoodQuantity(25);
        this.setWaterQuantity(25);
        this.setFuelQuantity(25);
        this.setMunitionsQuantity(5);
        this.setCoinQuantity(200);
        this.setArtifactsQuantity(1);
        this.setGemsQuantity(1);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Cargo{" + "size=" + size + ", foodQuantity=" + foodQuantity + ", waterQuantity=" + waterQuantity + ", fuelQuantity=" + fuelQuantity + ", munitionsQuantity=" + munitionsQuantity + ", coinQuantity=" + coinQuantity + ", artifactsQuantity=" + artifactsQuantity + ", gemsQuantity=" + gemsQuantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.size;
        hash = 71 * hash + this.foodQuantity;
        hash = 71 * hash + this.waterQuantity;
        hash = 71 * hash + this.fuelQuantity;
        hash = 71 * hash + this.munitionsQuantity;
        hash = 71 * hash + this.coinQuantity;
        hash = 71 * hash + this.artifactsQuantity;
        hash = 71 * hash + this.gemsQuantity;
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
        final Cargo other = (Cargo) obj;
        if (this.size != other.size) {
            return false;
        }
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
