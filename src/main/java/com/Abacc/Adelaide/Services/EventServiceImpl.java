package com.Abacc.Adelaide.Services;

import com.Abacc.Adelaide.Dto.EventDto;
import com.Abacc.Adelaide.Exceptions.ResourceNotFoundException;
import com.Abacc.Adelaide.Models.Event;
import com.Abacc.Adelaide.Models.Role;
import com.Abacc.Adelaide.Models.User;
import com.Abacc.Adelaide.Repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{

	private EventRepository eventRepository;

	public EventServiceImpl(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	@Override
	public Event save(EventDto eventDto) {
		Event event = new Event(eventDto.getTitle(), eventDto.getDescription(), eventDto.getEventDate(), eventDto.getImage());
		return eventRepository.save(event);
	}

	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public void delete(Long id)
			throws ResourceNotFoundException
	{
		Event tempEvent = this.eventRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Employee ID Not Found:: " + id));
		this.eventRepository.delete(tempEvent);
	}

	@Override
	public Event update(Event event)
	{
		return eventRepository.save(event);
	}

	@Override
	public Event findById(Long id)
			throws ResourceNotFoundException
	{

		Event tempEvent = this.eventRepository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Employee ID Not Found:: " + id));
		return tempEvent;
	}
}
