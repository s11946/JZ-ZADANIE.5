package web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import service.PatientRepository;
import domain.Patient;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@SessionScoped
@Named("patientBean")
public class PatientBean implements Serializable {
	
	private Patient patient = new Patient();
	
	private ListDataModel<Patient> patientData = new ListDataModel<Patient>();

	@Inject
	PatientRepository db;
	
	public PatientBean() {
		this.db = new PatientRepository();
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public ListDataModel<Patient> getPatientData() {
		patientData.setWrappedData(db.getList());
		return patientData;
	}
	
	public String addNewPatient(){
		db.addPatient(patient);
		return "showPatient";
	}

        public void uniquePin(FacesContext context, UIComponent component, Object value) {
            
            String pin = (String) value;
            
            for ( Patient patient : db.getList()) {
                if(patient.getPin().equalsIgnoreCase(pin)) {
                    FacesMessage message = new FacesMessage(
                    "Osoba o tym numerze Pesel istnieje już w bazie");
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message);
                }
                    
            }
        }
	
}
