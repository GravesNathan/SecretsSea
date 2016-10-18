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
public enum SocietyNPCs implements Serializable{
    
    Billy("the privateer"),
    Joe("the barbarian"),
    Nephi("the nephite aztec"),
    Creg("the buchaneers"),
    Derick("the carousers"),
    James("the corsairs"),
    John("the turk");
    
    private final String description;
    
    SocietyNPCs(String description){
        this.description = description;
    }

    public String getdescription() {
        return description;
    }
}
