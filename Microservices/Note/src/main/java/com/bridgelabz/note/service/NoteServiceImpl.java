package com.bridgelabz.note.service;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.elasticsearch.cli.UserException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bridgelabz.note.dto.NoteDTO;
import com.bridgelabz.note.exception.NoteException;

import com.bridgelabz.note.model.Note;

import com.bridgelabz.note.repository.NoteRepository;
import com.bridgelabz.note.repository.UserRepository;
import com.bridgelabz.note.util.JwtTokenInterface;
import com.bridgelabz.note.model.User;

/**
 * @author Kalyani Deobhankar
 * 
 * 
 * @since 19.06.2019
 *
 */
@Service
public class NoteServiceImpl implements NoteService {

	Logger logger = Logger.getLogger(NoteServiceImpl.class.getName());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private NoteRepository noteRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private JwtTokenInterface jwtToken;

//	@Autowired
//	private INote inote;

	/**
	 * Details Create a note having two parameter
	 * 
	 * @param noteDto
	 * @param token
	 */

	@Override
	public String createNote(NoteDTO noteDto, String token) {

		String userId = jwtToken.verifyToken(token);
		System.out.println("userId" + userId);

		Optional<User> optionalUser = userRepository.findByUserId(userId);

		System.out.println("Optional user " + optionalUser);
		Note note = modelMapper(noteDto, Note.class);

		String noteId = note.getUserId();
		logger.info("note id " + noteId);
		/*
		 * if(noteDto.getTitle().isEmpty() && noteDto.getDescription().isEmpty()) {
		 * throw new NoteException("Title and description should not be empty"); } else
		 * {
		 */
		System.out.println("before note");
		if (optionalUser.isPresent()) {
			System.out.println("Inside note creation");

			note.setCreateTime(LocalDateTime.now());
			note.setUpdateTime(LocalDateTime.now());
			note.setUserId(userId);

			noteRepository.save(note);

			return "create note ";

		}

		return "fails";

	}

	/**
	 * 
	 * /** Details getAll is collection-type method
	 *
	 * 
	 * 
	 * @param a token
	 */

	@Override
	public List<Note> getAll(String token) {
		String userId = jwtToken.verifyToken(token);

		/*
		 * List<Note> filterNote = notes.stream().filter(note -> { return
		 * note.getUserId().equals(userId); }).collect(Collectors.toList());
		 * 
		 * logger.info("Filter notes " + filterNote); return filterNote;
		 */

		/*
		 * 
		 * Optional<User> optionalUser = userRepository.findByUserId(userId);
		 * 
		 * if (optionalUser.isPresent()) { List<Note> notes = noteRepository.findAll();
		 * return notes;
		 * 
		 * } else { throw new UserException("Invalid user");}
		 */

		logger.info("User id " + userId);
//
//		List<Note> notes = noteRepository.findAll();
//		List<Note> filterNote = notes.stream().filter(note -> {
//			return note.getUserId().equals(userId);
//		}).filter(note -> !note.isTrash() && !note.isArchive()).collect(Collectors.toList());
//		return filterNote;
//		

		List<Note> notes = noteRepository.findAll();
		List<Note> filterNote = notes.stream().filter(note -> {
			return note.getUserId().equals(userId);
		}).collect(Collectors.toList());
		return filterNote;
	}

	/**
	 * @param <E>
	 * @param <T>
	 * @param srcObject
	 * @param desObject
	 * @return
	 */
	private <E, T> E modelMapper(T srcObject, Class<E> desObject) {

		return mapper.map(srcObject, desObject);
	}

	/**
	 * VerifyUser is a boolean method that checks whether given user is valid or not
	 * 
	 * @param token
	 */
	public boolean verifyUser(String token) {
		String userId = jwtToken.verifyToken(token);
		Optional<User> optionalUser = userRepository.findByUserId(userId);
		if (optionalUser.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

}
