package domain;

import java.util.Date;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Patient {
	
	String name;
	String surname;
	String pin;
	Date dateBirth;
	String address;
	String weight;
	String height;
	String phoneNumber;
	String dateAdded;
	
        
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPin() {
		return pin;
	}
	
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	public Date getDateBirth() {
		return dateBirth;
	}
	
	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getWeight() {
		return weight;
	}
	
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String getHeight() {
		return height;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
        
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getDateAdded() {
		return dateAdded;
	}
	
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
	

}
