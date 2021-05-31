package com.Abacc.Adelaide.Controllers;

import com.Abacc.Adelaide.Dto.EventDto;
import com.Abacc.Adelaide.Exceptions.ResourceNotFoundException;
import com.Abacc.Adelaide.Models.Event;
import com.Abacc.Adelaide.Services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

	@ModelAttribute("updatedevent")
	public Event event()
	{
		return new Event();
	}


	@GetMapping("/newevents")
	public String goEvents()
	{
		return "newevents";
	}



	@PostMapping("/newevents")
	public String completeRegistration(@ModelAttribute("event") EventDto eventDto, Model model)
	{

		System.out.println(eventDto.getEventDate());
		this.eventService.save(eventDto);

		List<Event> allEvs = eventService.findAll();
		model.addAttribute("allEvs", allEvs);

		return "allevents";
	}

	@GetMapping("/allevents")
	public String goAllEvents(Model model)
	{
		List<Event> allEvs = eventService.findAll();
		model.addAttribute("allEvs", allEvs);

		return "allevents";
	}


	@GetMapping("/deleteevent")
	public String goDeleteEventById(@RequestParam(value = "deleteid") Long id,Model model)
			throws ResourceNotFoundException
	{
		eventService.delete(id);
		return "redirect:/allevents";
	}

	@GetMapping("/editevent")
	public String goEditEventById(@RequestParam(value = "editid") Long id,Model model)
			throws ResourceNotFoundException
	{
		Event event = eventService.findById(id);
		model.addAttribute("editedEvent", event);
		//System.out.println(event.getEventDate());
		return "editevent";
	}

	@PostMapping("/editevent")
	public String completeUpdatingEvent(@ModelAttribute("updatedevent") Event event, Model model)
	{

		System.out.println("update>>"+ event.getId()+
				event.getTitle()+
				event.getDescription()+
				event.getEventDate()+
				event.getImage());
		//this.eventService.save(event);
		this.eventService.update(event);

		return "redirect:/allevents";
	}


}
