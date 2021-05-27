package com.Abacc.Adelaide.Controllers;

import com.Abacc.Adelaide.Dto.EventDto;
//import com.Abacc.Adelaide.Dto.EventDto2;
import com.Abacc.Adelaide.Dto.RegistrationDto;
import com.Abacc.Adelaide.Services.EventService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class EventController {

	private EventService eventService;

	public EventController(EventService eventService) {
		this.eventService = eventService;
	}


	@ModelAttribute("event")
	public EventDto eventDto()
	{
		return new EventDto();
	}


	@GetMapping("/newevents")
	public String goEvents()
	{
		return "newevents";
	}

	@PostMapping("/newevents")
	public String completeRegistration(@ModelAttribute("event") EventDto eventDto)
	{

		System.out.println(eventDto.getEventDate());
		this.eventService.save(eventDto);

		return "admin";
	}
}
