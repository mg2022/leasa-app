package ca.leasa.catalogue.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Slot {

	@JsonIgnore
	String userRenter = null; 	//when slot is booked to a user it is !null
	LocalDate date;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((userRenter == null) ? 0 : userRenter.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (userRenter == null) {
			if (other.userRenter != null)
				return false;
		} else if (!userRenter.equals(other.userRenter))
			return false;
		return true;
	}
	
	public String getUserRenter() {
		return userRenter;
	}
	public Slot setUserRenter(String userRenter) {
		this.userRenter = userRenter;
		
		return this;
	}
	public LocalDate getDate() {
		return date;
	}
	public Slot setDate(LocalDate date) {
		this.date = date;
		
		return this;
	}
	
	
}
