package com.bridgelabz.note.dto;

//import lombok.Data;


//@Data
public class NoteDTO {

	private String title;
	private String description;

	public NoteDTO() {

	}

	public NoteDTO(String title, String description) {
		super();
		this.title = title;
		this.description = description;
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

	@Override
	public String toString() {
		return "NoteDTO [title=" + title + ", description=" + description + "]";
	}
	
	

}