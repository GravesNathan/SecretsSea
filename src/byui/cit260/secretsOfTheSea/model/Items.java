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
public class Items implements Serializable{
        
    private char charName = ' ';
    private String name =null;
    private int quantity = 0;
    
    public Items(char charName, String name, int quantity){
        this.setCharName(charName);
        this.setName(name);
        this.setQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getCharName() {
        return charName;
    }

    public void setCharName(char charName) {
        this.charName = charName;
    }

    
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "\r\n " + charName + " - "+ name + " :quantity = " + quantity;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.charName;
        hash = 19 * hash + Objects.hashCode(this.name);
        hash = 19 * hash + this.quantity;
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
        final Items other = (Items) obj;
        if (this.charName != other.charName) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.quantity != other.quantity) {
            return false;
        }
        return true;
    }
    
    
    
}
