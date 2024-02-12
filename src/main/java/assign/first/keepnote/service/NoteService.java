package assign.first.keepnote.service;

import java.util.List;

import assign.first.keepnote.exception.CategoryNotFoundException;
import assign.first.keepnote.exception.NoteNotFoundException;
import assign.first.keepnote.exception.ReminderNotFoundException;
import assign.first.keepnote.model.Note;

public interface NoteService {
	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */
	public boolean createNote(Note note) throws ReminderNotFoundException, CategoryNotFoundException;

	public boolean deleteNote(int noteId);

	public List<Note> getAllNotesByUserId(String userId);

	public Note getNoteById(int noteId) throws NoteNotFoundException;

	public Note updateNote(Note note, int id)
			throws ReminderNotFoundException, NoteNotFoundException, CategoryNotFoundException;
}
