package web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import service.PatientRepository;
import domain.Patient;

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

	
}
