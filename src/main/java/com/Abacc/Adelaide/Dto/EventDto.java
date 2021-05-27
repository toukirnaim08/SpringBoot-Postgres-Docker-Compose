package com.Abacc.Adelaide.Dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.util.Date;

public class EventDto {

	private String title;
	private String description;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date eventDate;
	private byte[] image;

	public EventDto() {
	}

	public EventDto(String title, String description, Date eventDate, byte[] image) {
		this.title = title;
		this.description = description;
		this.eventDate = eventDate;
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
}
