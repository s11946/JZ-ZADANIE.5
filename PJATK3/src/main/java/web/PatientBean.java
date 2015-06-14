package web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import service.PatientRepository;
import domain.Patient;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.ValidatorException;

@SessionScoped
@Named("patientBean")
public class PatientBean implements Serializable {
	
	private Patient patient = new Patient();
	
	private List<Patient> patientData;
        
        private List<Patient> filteredPatients;

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

	public List<Patient> getPatientData() {
		return db.getList();
	}
        
        public List<Patient> getFilteredPatients() {
            return filteredPatients;
        }
	
        public void setFilteredPatients(List<Patient> filteredPatients) {
            this.filteredPatients = filteredPatients;
        }
        
	public String addNewPatient(){
		db.addPatient(patient);
		return "showPatient";
	}

        public void uniquePin(FacesContext context, UIComponent component, Object value) {       
        String pesel = (String)value;
        
        for (Patient patient : db.getList()) {           
            if (patient.getPin().equalsIgnoreCase(pesel)) {
		throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Ten numer Pesel znajduj\u0119 si\u0119 ju\u017C w bazie!", null));
            }
        }        
    }
        
        public void validatePinToDate(ComponentSystemEvent event) {
            try {
            UIForm form = (UIForm) event.getComponent();
            UIInput UIpin = (UIInput) form.findComponent("pin");
            UIInput UIdateBirth = (UIInput) form.findComponent("dateBirth");
            
            String dateBirth = UIdateBirth.getValue().toString().substring(27, 29);
            String pin = UIpin.getValue().toString().substring(0, 2);
            
            if (!dateBirth.equals(pin)) {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(form.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Data urodzenia nie jest zgodna z podanym numerem PESEL.", null));
                context.renderResponse();
            }
        }
        catch (NullPointerException exception) {
            
        }
    }
       
	
}
