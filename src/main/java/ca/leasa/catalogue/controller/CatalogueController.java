package ca.leasa.catalogue.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.leasa.catalogue.impl.CatalogueService;
import ca.leasa.catalogue.model.Item;

@RestController
@RequestMapping("catalogue")
public class CatalogueController {
	
	@Autowired
	CatalogueService catalogueService;
	
	@GetMapping( produces = "application/json; charset=UTF-8", value = "/api/item")
	public Item getItem(@RequestParam(name = "id") Long id) {
		return catalogueService.getItem(id);
	}
	
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	@PostMapping(value ="/api/item")
	public long saveItem(@RequestBody Item item){
		
		return catalogueService.saveItem(item);
	
	}
	
	//get images
	
	
	/*
	@POST
	@Path("/upload")
	public String sayHello() {
		return "Swagger Hello Universe";
	}
	*/
	
	
}
