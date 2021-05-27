package com.Abacc.Adelaide.Services;

import com.Abacc.Adelaide.Dto.EventDto;
import com.Abacc.Adelaide.Models.Event;

public interface EventService {
	Event save(EventDto eventDto);
}
