package com.bridgelabz.note.service;

import java.util.List;

import com.bridgelabz.note.dto.NoteDTO;
import com.bridgelabz.note.model.Note;

public interface NoteService {

	String createNote(NoteDTO noteDto, String token);
	

	List<Note> getAll(String token);


	
	
}
