package ca.leasa.catalogue.scheduler;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;

import ca.leasa.catalogue.models.Item;
import ca.leasa.catalogue.models.Slot;

//TODO: convert to keydb.dev or redis or elasticsearch or cassandra
@Component
public class SharedMemory{
	
	public ConcurrentMap<Long,Item> catalogueItems = new ConcurrentHashMap<Long,Item>();
	
}
