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
public enum ItemsEnum implements Serializable{
    //This enum only sets the base value.  It may vary based on societies trust level.
    
    //Adjust Prices as needed to make game fair.  Same goes for ship stats
    //which are located in ShipSelectionControl
    Food('F', "Food", 20, 5),
    Water('W', "Water", 10, 5),
    //Fuel('U', "Fuel", 30, 5),
    //Munitions('M', "Munitions", 40, 15),
    Lumber('L', "Lumber", 30, 10),
    Coin('C', "coin", 1, .1);
    //Artifacts('A', "Artifacts", 50, 1),
    //Gems('G', "Gems", 100, 1);
    
    private final char cName;
    private final String name;
    private final int value;
    private final double weight;

    ItemsEnum (char cName, String name, int value, double weight){
        this.cName = cName;
        this.name = name;
        this.value = value;
        this.weight = weight;
    }
    
    public char getCName(){
        return cName;
    }
    
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public double getWeight() {
        return weight;
    }
    
    
}
