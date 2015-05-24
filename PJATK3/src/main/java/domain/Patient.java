package domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Patient {
	
	String name;
	String surname;
	String pin;
	String dateBirth;
	String address;
	String weight;
	String height;
	String phoneNumber;
	String dateAdded;
	
        @Size (min = 2, max = 50)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Size (min = 2, max = 50)
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
	
	public String getDateBirth() {
		return dateBirth;
	}
	
	public void setDateBirth(String dateBirth) {
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
	
        @Pattern(regexp = "[0-9]{9}")
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
