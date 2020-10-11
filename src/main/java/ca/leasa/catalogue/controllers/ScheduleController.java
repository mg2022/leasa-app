package ca.leasa.catalogue.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.leasa.catalogue.models.Item;
import ca.leasa.catalogue.models.ItemSchedule;
import ca.leasa.catalogue.models.Slot;
import ca.leasa.catalogue.services.CatalogueService;
import ca.leasa.catalogue.services.ScheduleService;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
	
	@Autowired
	ScheduleService scheduleService;
	
	@GetMapping( produces = "application/json; charset=UTF-8", value = "/api/schedule")
	public ItemSchedule getAvail(@RequestParam(name = "id") Long catalogueItemID) {
		return scheduleService.getAvail(catalogueItemID);
	}
	
	@PostMapping(value ="/api/schedule")
	public boolean bookItem(@RequestParam(name = "user") String userRenter,
			@RequestParam(name = "id") Long catalogueItemID, 
			@RequestBody Slot slot){
		
		return scheduleService.bookItem(userRenter, catalogueItemID, slot);
	
	}
	
}
