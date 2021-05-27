package com.Abacc.Adelaide.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private long id;

	private String title;
	private String description;


	@DateTimeFormat(pattern = "yyyy-MM-dd")
	//@NotNull(message = "Cannot be empty")
	private Date eventDate;

	@Lob
	@Column(name = "image")
	private byte[] image;

	public Event() {
	}

	public Event(String title, String description, Date eventDate, byte[] image) {
		this.title = title;
		this.description = description;
		this.eventDate = eventDate;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
