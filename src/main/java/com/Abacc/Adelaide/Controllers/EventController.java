package com.Abacc.Adelaide.Controllers;

import com.Abacc.Adelaide.Dto.EventDto;
import com.Abacc.Adelaide.Exceptions.ResourceNotFoundException;
import com.Abacc.Adelaide.Models.Event;
import com.Abacc.Adelaide.Services.EventService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

	@GetMapping("/allevents/delete/{id}")
	public String deleteEvent(@PathVariable(value = "id") Long id, Model model)
			throws ResourceNotFoundException
	{
		eventService.delete(id);
		return "redirect:/allevents";
	}

	@GetMapping("/allevents/edit/{id}")
	public String editEvent(@PathVariable(value = "id") Long id, Model model)
			throws ResourceNotFoundException
	{
		Event event = eventService.findById(id);
		model.addAttribute("editedEvent", event);
		return "redirect:/editevent";
	}
	@GetMapping("/editevent/{id}")
	public String goEditAdmin(@PathVariable(value = "id") Long id, Model model)
	{
		return "editevent";
	}

	@PostMapping("/editevent")
	public String completeUpdatingEvent(@ModelAttribute("event") EventDto eventDto, Model model)
	{

		System.out.println(eventDto.getEventDate());
		this.eventService.save(eventDto);

		List<Event> allEvs = eventService.findAll();
		model.addAttribute("allEvs", allEvs);

		return "allevents";
	}


}
