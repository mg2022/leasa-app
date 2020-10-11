package ca.leasa.catalogue.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ca.leasa.catalogue.impl.CatalogueService;

@RestController
@Path("catalogue2")
public class CatalogueController2 {
	
	@Autowired
	CatalogueService catalogueService;
	
	@GET
	@Path("/api/javainuse")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public String sayHello() {
		return "Swagger Hello Universe";
	}
	
	@POST
	@Path("/api/upload")
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public void saveItem(){
		
		//catalogueService.saveItem();
	
	}
	
	
	/*
	@POST
	@Path("/upload")
	public String sayHello() {
		return "Swagger Hello Universe";
	}
	*/
}
