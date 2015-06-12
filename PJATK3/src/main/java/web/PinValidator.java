/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Bartek
 */
@FacesValidator("pinValidator")
public class PinValidator implements Validator {

    
    private byte PESEL[] = new byte[11];
    public void validate(FacesContext context, UIComponent component, Object value) 
            throws ValidatorException {
        
        String pin = (String)value;
        
        for(int i = 0;i<11;i++) {
            PESEL[i] = Byte.parseByte(pin.substring(i, i + 1));
        }
        
         int peselSum = PESEL[0] + (PESEL[1] * 3) + (PESEL[2] * 7) + (PESEL[3] * 9) 
                + PESEL[4] + (PESEL[5] * 3) + (PESEL[6] * 7) + (PESEL[7] * 9) + PESEL[8] 
                    + (PESEL[9] * 3);
        int controlDigit = 10 - (peselSum%10);
        
        if (controlDigit != PESEL[10]) {
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Tw\u00f3j PESEL nie jest poprawny!", null));
        }             
    }
}
