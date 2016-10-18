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
public class ExchangeItemsException extends Exception{
    
    public ExchangeItemsException() {
    }

    public ExchangeItemsException(String message) {
        super(message);
    }

    public ExchangeItemsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExchangeItemsException(Throwable cause) {
        super(cause);
    }

    public ExchangeItemsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
