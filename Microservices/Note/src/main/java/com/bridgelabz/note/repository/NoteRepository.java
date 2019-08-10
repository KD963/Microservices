package com.bridgelabz.note.repository;



import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.note.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

	Optional<Note> findByNoteId(String noteId);
	Optional<Note> findByUserIdAndNoteId(String noteId, String userId);
 

	
}
