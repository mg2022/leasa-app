package ca.leasa.catalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.leasa.catalogue.impl.CatalogueService;

@RestController
@RequestMapping("catalogue")
public class CatalogueController {
	
	@Autowired
	CatalogueService catalogueService;
	
	@GetMapping(value = "/api/javainuse")
	public String sayHello() {
		return "Swagger Hello Universe";
	}
	
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	@PostMapping(produces = "application/json", value ="/api/upload")
	public void saveItem(){
		
		catalogueService.saveItem();
	
	}
	
	
	/*
	@POST
	@Path("/upload")
	public String sayHello() {
		return "Swagger Hello Universe";
	}
	*/
}
