/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.text.SimpleDateFormat;
import java.util.Date;
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
@FacesValidator("dateValidator")
public class DateValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
        
        Date date = (Date)value;
        Date today = new Date();
        
        if (date.after(today) || dateFormat.format(date).equals(dateFormat.format(today))){
            throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Data urodzenia jest niepoprawna!", null));
        }
    }
    
}
