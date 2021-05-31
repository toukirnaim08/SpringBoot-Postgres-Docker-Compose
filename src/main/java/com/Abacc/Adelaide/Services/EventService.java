package com.Abacc.Adelaide.Services;

import com.Abacc.Adelaide.Dto.EventDto;
import com.Abacc.Adelaide.Exceptions.ResourceNotFoundException;
import com.Abacc.Adelaide.Models.Event;
import com.Abacc.Adelaide.Models.User;

import java.util.List;

public interface EventService {
	Event save(EventDto eventDto);
	void delete(Long id) throws ResourceNotFoundException;
	Event update(Event event);
	List<Event> findAll();
	Event findById(Long id) throws ResourceNotFoundException;
}
