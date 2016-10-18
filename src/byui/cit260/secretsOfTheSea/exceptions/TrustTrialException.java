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
public class TrustTrialException extends Exception{

    public TrustTrialException() {
    }

    public TrustTrialException(String message) {
        super(message);
    }

    public TrustTrialException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrustTrialException(Throwable cause) {
        super(cause);
    }

    public TrustTrialException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
}
