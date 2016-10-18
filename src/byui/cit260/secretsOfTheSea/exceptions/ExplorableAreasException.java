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
public class ExplorableAreasException extends Exception{

    public ExplorableAreasException() {
    }

    public ExplorableAreasException(String message) {
        super(message);
    }

    public ExplorableAreasException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExplorableAreasException(Throwable cause) {
        super(cause);
    }

    public ExplorableAreasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
