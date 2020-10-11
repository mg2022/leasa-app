package ca.leasa.catalogue.models;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ItemSchedule {

	Set<Slot> availableSlots = new HashSet<Slot>();
	Set<Slot> reservedSlots = new HashSet<Slot>();
	
	public Set<Slot> getAvailableSlots() {
		return availableSlots;
	}
	public void setAvailableSlots(Set<Slot> availableSlots) {
		this.availableSlots = availableSlots;
	}
	public Set<Slot> getReservedSlots() {
		return reservedSlots;
	}
	public void setReservedSlots(Set<Slot> reservedSlots) {
		this.reservedSlots = reservedSlots;
	}
	
	
}
