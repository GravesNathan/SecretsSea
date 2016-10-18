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
public class Ships implements Serializable{
    protected String name;
    protected String description;
    protected int cargoCapSize;
    protected int morale;
    protected int speed;
    protected int defense;
    protected int deceit;
    protected int diplomacy;
    protected int intimidation;
    protected int bribery;
    protected int health;

    public Ships() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCargoCapSize() {
        return cargoCapSize;
    }

    public void setCargoCapSize(int cargoCapSize) {
        this.cargoCapSize = cargoCapSize;
    }

    public int getMorale() {
        return morale;
    }

    public void setMorale(int morale) {
        this.morale = morale;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDeceit() {
        return deceit;
    }

    public void setDeceit(int deceit) {
        this.deceit = deceit;
    }

    public int getDiplomacy() {
        return diplomacy;
    }

    public void setDiplomacy(int diplomacy) {
        this.diplomacy = diplomacy;
    }

    public int getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(int intimidation) {
        this.intimidation = intimidation;
    }

    public int getBribery() {
        return bribery;
    }

    public void setBribery(int bribery) {
        this.bribery = bribery;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    
    
    @Override
    public String toString() {
        return "Ships{" + "name=" + name + ", description=" + description + ", cargoCapSize=" 
                + cargoCapSize + ", morale=" + morale + ", speed=" + speed + ", defense=" 
                + defense + ", deceit=" + deceit + ", diplomacy=" + diplomacy + ", intimidation=" 
                + intimidation + ", bribery=" + bribery + ", health= " + health +'}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.description);
        hash = 89 * hash + this.cargoCapSize;
        hash = 89 * hash + this.morale;
        hash = 89 * hash + this.speed;
        hash = 89 * hash + this.defense;
        hash = 89 * hash + this.deceit;
        hash = 89 * hash + this.diplomacy;
        hash = 89 * hash + this.intimidation;
        hash = 89 * hash + this.bribery;
        hash = 89 * hash + this.health;
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
        final Ships other = (Ships) obj;
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
        if (this.health != other.health) {
            return false;
        }
        return true;
    }

    
    
}
