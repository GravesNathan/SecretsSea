/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.secretsOfTheSea.exceptions;

/**
 *
 * @author Nathan
 */
public class CharInputException extends Exception{
    //Added class for any bad Character Input
    public CharInputException() {
    }

    public CharInputException(String message) {
        super(message);
    }

    public CharInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public CharInputException(Throwable cause) {
        super(cause);
    }

    public CharInputException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
