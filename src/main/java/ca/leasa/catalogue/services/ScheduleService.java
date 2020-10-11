package ca.leasa.catalogue.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.leasa.catalogue.models.ItemSchedule;
import ca.leasa.catalogue.models.Slot;
import ca.leasa.catalogue.scheduler.SharedMemory;

@Service
public class ScheduleService implements Catalogue {

	@Autowired
	SharedMemory sharedMemory;
	
	public ItemSchedule getAvail(Long catalogueItemID) {
		
		return sharedMemory.catalogueItems.get(catalogueItemID).getItemSchedule();
	}

	public boolean bookItem(String userRenter, Long catalogueItemID, Slot slot) {

		Set<Slot> reservedSlots = sharedMemory.catalogueItems.get(catalogueItemID).getItemSchedule().getReservedSlots();
		Set<Slot> availableSlots = sharedMemory.catalogueItems.get(catalogueItemID).getItemSchedule().getAvailableSlots();
	
		if(reservedSlots.contains(slot))
			return false;	//unable to reserve, already reserved
		
		if(!availableSlots.contains(slot))
			return false; 	//unable to reserve/find, some issue exists
		
		//book it
		availableSlots.remove(slot);
		reservedSlots.add(slot.setUserRenter(userRenter));

		return true;
	}

}
