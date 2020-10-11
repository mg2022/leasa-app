package ca.leasa.catalogue.services;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.leasa.catalogue.models.Item;
import ca.leasa.catalogue.models.Slot;
import ca.leasa.catalogue.scheduler.SharedMemory;

@Service
public class CatalogueService implements Catalogue {
	
	@Autowired
	SharedMemory sharedMemory;
	
	public long saveItem(String username, Item item) {
		System.out.println("saving...");
		
		//FIXME: more intelligent item numbering;
		long catalogueItemID = (long)(Math.random()*(100)+1);
		
		//FIXME: persist in db with username
		sharedMemory.catalogueItems.put(catalogueItemID, item.setId(catalogueItemID).setUserOwner(username));
		
		//TODO: call ScheduleService to do this
		createInitialTimeSlots(item);
		
		return catalogueItemID;
	}
 
	//TODO: refactor out into sheduleService (microservice)
	private void createInitialTimeSlots(Item item) {

		Set<Slot> slots = new HashSet<Slot>();
		
		for(long i = 1;i<100;i++){
			slots.add(new Slot().setDate(LocalDate.now().plusDays(i)));
		}
		
		item.getItemSchedule().setAvailableSlots(slots);
		
	}

	public Item getItem(Long catalogueItemID) {
		
		return sharedMemory.catalogueItems.get(catalogueItemID);
	}

}
