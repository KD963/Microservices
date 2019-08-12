package com.bridgelabz.note.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.note.dto.NoteDTO;
import com.bridgelabz.note.model.Note;

import com.bridgelabz.note.response.Response;
import com.bridgelabz.note.service.NoteService;

@RestController
@RequestMapping("/notes")

public class NoteController {

	@Autowired
	private NoteService noteService;

	@PostMapping("/create")
	public ResponseEntity<Response> createNote(@RequestBody @Valid NoteDTO noteDTO, @RequestHeader String token) {
		String message = noteService.createNote(noteDTO, token);
		Response response = new Response(200, message, token);
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public List<Note> getAll(@RequestHeader String token) {
		List<Note> notes = noteService.getAll(token);
		return notes;

	}

}
