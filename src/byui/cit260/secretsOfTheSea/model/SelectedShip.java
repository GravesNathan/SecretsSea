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
 * 
 */
public class SelectedShip extends Ships implements Serializable{
    private int shipHealth;
    private int shipChoice;
    
    public SelectedShip() {
    }

//    I changed all getShipHealth and setShipHealth to getHealth and setHealth.
//    These are taken from the Ships class so no need for declaration here.
//    public int getHealth() {
//        return shipHealth;
//    }
//
//    public void setHealth(int shipHealth) {
//        this.shipHealth = shipHealth;
//    }

    public int getShipChoice() {
        return shipChoice;
    }

    public void setShipChoice(int shipChoice) {
        this.shipChoice = shipChoice;
    }

    
    
    @Override
    public String toString() {
        return "SelectedShip{" + "shipHealth=" + shipHealth + ", name=" + name 
                + ", description=" + description + ", cargoCapSize=" + cargoCapSize
                + ", morale=" + morale + ", speed=" + speed + ", defense=" + defense 
                + ", deceit=" + deceit + ", diplomacy=" + diplomacy + ", intimidation=" 
                + intimidation + ", bribery=" + bribery + ", shipChoice =" + shipChoice + '}';
            }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.description);
        hash = 97 * hash + this.shipHealth;
        hash = 97 * hash + this.cargoCapSize;
        hash = 97 * hash + this.morale;
        hash = 97 * hash + this.speed;
        hash = 97 * hash + this.defense;
        hash = 97 * hash + this.deceit;
        hash = 97 * hash + this.diplomacy;
        hash = 97 * hash + this.intimidation;
        hash = 97 * hash + this.bribery;
        hash = 97 * hash + this.shipChoice;
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
        final SelectedShip other = (SelectedShip) obj;
        if (this.shipHealth != other.shipHealth) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (this.cargoCapSize != other.cargoCapSize) {
            return false;
        }
        if (this.morale != other.morale) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        if (this.defense != other.defense) {
            return false;
        }
        if (this.deceit != other.deceit) {
            return false;
        }
        if (this.diplomacy != other.diplomacy) {
            return false;
        }
        if (this.intimidation != other.intimidation) {
            return false;
        }
        if (this.bribery != other.bribery) {
            return false;
        }
        if (this.shipChoice != other.shipChoice) {
            return false;
        }
        return true;
    }
        
}
