package ca.leasa.catalogue.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

import ca.leasa.catalogue.model.Item;

@Service
public class CatalogueService implements Catalogue {

	//TODO: save to db
	ConcurrentMap<Long,Item> items = new ConcurrentHashMap<Long,Item>();
	
	public long saveItem(Item item) {
		System.out.println("saving...");
		
		//FIXME: more intelligent item numbering;
		long id = (long)(Math.random()*(100)+1);
		items.put(id, item);
		
		return id;
	}

	public Item getItem(Long id) {
		// TODO Auto-generated method stub
		return items.get(id);
	}

}
