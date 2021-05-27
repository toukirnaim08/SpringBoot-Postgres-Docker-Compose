package com.Abacc.Adelaide.Services;

import com.Abacc.Adelaide.Dto.EventDto;
import com.Abacc.Adelaide.Models.Event;
import com.Abacc.Adelaide.Models.Role;
import com.Abacc.Adelaide.Models.User;
import com.Abacc.Adelaide.Repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
}
