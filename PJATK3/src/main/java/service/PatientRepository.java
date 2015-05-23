package service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import domain.Patient;
@ApplicationScoped
public class PatientRepository {
	
	

	List<Patient> patientRepository = new ArrayList<Patient>();
	
	public void addPatient (Patient patient) {
		
		Patient newPatient = new Patient();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		Date date = new Date();
		
		newPatient.setName(patient.getName());
		newPatient.setSurname(patient.getSurname());
		newPatient.setPin(patient.getPin());
		newPatient.setDateBirth(patient.getDateBirth());
		newPatient.setAddress(patient.getAddress());
		newPatient.setWeight(patient.getWeight());
		newPatient.setHeight(patient.getHeight());
		newPatient.setPhoneNumber(patient.getPhoneNumber());
		newPatient.setDateAdded(dateFormat.format(date));
		
		patientRepository.add(newPatient);
	}
	
	public List<Patient> getList(){
		return patientRepository;
		
		
	}
}
