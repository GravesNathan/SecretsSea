/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.exceptions;

/**
 *
 * @author SDababneh
 */
public class ShipSelectionException extends Exception{

    public ShipSelectionException() {
    }

    public ShipSelectionException(String message) {
        super(message);
    }

    public ShipSelectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShipSelectionException(Throwable cause) {
        super(cause);
    }

    public ShipSelectionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
