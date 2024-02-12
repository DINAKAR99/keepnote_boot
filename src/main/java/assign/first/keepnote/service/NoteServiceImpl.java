package assign.first.keepnote.service;

import java.util.List;

import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import assign.first.keepnote.dao.NoteDAO;
import assign.first.keepnote.exception.CategoryNotFoundException;
import assign.first.keepnote.exception.NoteNotFoundException;
import assign.first.keepnote.exception.ReminderNotFoundException;
import assign.first.keepnote.exception.UserAlreadyExistException;
import assign.first.keepnote.model.Note;
import assign.first.keepnote.model.Reminder;
import assign.first.keepnote.model.User;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesn�t currently 
* provide any additional behavior over the @Component annotation, but it�s a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */
@Service
public class NoteServiceImpl implements NoteService {

	/*
	 * Autowiring should be implemented for the NoteDAO,CategoryDAO,ReminderDAO.
	 * (Use Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	NoteDAO dao1;
	// UserDao2 dao1;

	public NoteServiceImpl(NoteDAO ud1) {
		this.dao1 = ud1;

	}
	/*
	 * This method should be used to save a new note.
	 */

	public boolean createNote(Note note) throws ReminderNotFoundException, CategoryNotFoundException {

		dao1.createNote(note);
		System.out.println(true + "NEW NOTE CREATED ");

		return true;

	}

	/* This method should be used to delete an existing note. */

	public boolean deleteNote(int noteId) {
		boolean deleteUser = dao1.deleteNote(noteId);
		return deleteUser;

	}
	/*
	 * This method should be used to get a note by userId.
	 */

	public List<Note> getAllNotesByUserId(String userId) {
		List<Note> allNoteByUserId = dao1.getAllNotesByUserId(userId);

		return allNoteByUserId;

	}

	/*
	 * This method should be used to get a note by noteId.
	 */
	public Note getNoteById(int noteId) throws NoteNotFoundException {
		Note NoteById = dao1.getNoteById(noteId);

		if (NoteById != null) {
			return NoteById;
		}

		else {

			throw new NoteNotFoundException();
		}

	}

	/*
	 * This method should be used to update a existing note.
	 */

	public Note updateNote(Note note, int id)
			throws ReminderNotFoundException, NoteNotFoundException, CategoryNotFoundException {

		Note getNoteById = dao1.getNoteById(id);

		if (getNoteById != null) {

			dao1.UpdateNote(getNoteById);

		}

		else {

			throw new NoteNotFoundException();
		}

		return note;

	}

}
