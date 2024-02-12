package assign.first.keepnote.dao;

import java.util.List;

import assign.first.keepnote.exception.NoteNotFoundException;
import assign.first.keepnote.model.Note;

public interface NoteDAO {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

	public boolean createNote(Note note);

	public boolean deleteNote(int noteId);

	public List<Note> getAllNotesByUserId(String userId);

	public Note getNoteById(int noteId) throws NoteNotFoundException;

	public boolean UpdateNote(Note note);

}
