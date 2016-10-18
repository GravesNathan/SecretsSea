/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.control;

import byui.cit260.secretsOfTheSea.exceptions.ExchangeItemsException;
import byui.cit260.secretsOfTheSea.model.ExchangeItems;
import java.util.Random;

/**
 *
 * @author SDababneh
 */
public class ExchangeItemsControl {
       
    private ExchangeItems[][] items = null;
    
    
    public ExchangeItemsControl(int islandLeader)
        throws ExchangeItemsException {
        this.setupItems(islandLeader);
    }
    
    public void setupItems(int i)
                throws ExchangeItemsException{
        items = new ExchangeItems[7][3];
            for (ExchangeItems leaderWants : items[i]){
                leaderWants.setDescription(randomResource());
            }
    }
    
    //Refer to ItemEnum.java for list of resources and their weight / value
    
    public String randomResource() throws ExchangeItemsException{
        String resource = null;
        Random number = new Random();
        int resourceNumber = number.nextInt(10);
            switch (resourceNumber){
                case 0:
                    resource = "Food";
                    return resource;
                case 1:
                    resource = "Food";
                    return resource;
                case 2:
                    resource = "Water";
                    return resource;
                case 3:
                    resource = "Water";
                    return resource;
                case 4:
                    resource = "Fuel";
                    return resource;
                case 5:
                    resource = "Munition";
                    return resource;
                case 6:
                    resource = "Coin";
                    return resource;
                case 7:
                    resource = "Artifact";
                    return resource;
                case 8:
                    resource = "Gems";
                    return resource;
                case 9:
                    resource = "none";
                    return resource;
                default:
                    throw new ExchangeItemsException("Error setting Resource in code.");
                    //resource = "error loading resource";  //WEEK 10 IA
                    //return resource;
            }
    }
}
