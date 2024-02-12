package assign.first.keepnote.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import assign.first.keepnote.exception.NoteNotFoundException;
import assign.first.keepnote.model.Note;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

/*
 * This class is implementing the UserDAO interface. This class has to be annotated with 
 * @Repository annotation.
 * @Repository - is an annotation that marks the specific class as a Data Access Object, 
 * thus clarifying it's role.
 * @Transactional - The transactional annotation itself defines the scope of a single database 
 * 					transaction. The database transaction happens inside the scope of a persistence 
 * 					context.  
 * */
@Repository
@Transactional
public class NoteDAOImpl implements NoteDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	EntityManager s1;

	public NoteDAOImpl(EntityManager ee) {

		this.s1 = ee;

	}

	/*
	 * Create a new note
	 */

	public boolean createNote(Note note) {
		s1.persist(note);

		System.out.println("in save transaction");

		return true;

	}

	/*
	 * Remove an existing note
	 */

	public boolean deleteNote(int noteId) {
		Note Note = s1.find(Note.class, noteId);
		if (Note != null) {

			s1.remove(Note);
			return true;
		}
		return false;

	}

	/*
	 * Retrieve details of all notes by userId
	 */

	public List<Note> getAllNotesByUserId(String userId) {
		List<Note> resultList = s1.createQuery(" from Note", Note.class).getResultList();
		return resultList;

	}

	/*
	 * Retrieve details of a specific note
	 */

	public Note getNoteById(int NoteId) throws NoteNotFoundException {
		Note Note = s1.find(Note.class, NoteId);

		return Note;
	}

	/*
	 * Update an existing note
	 */

	public boolean UpdateNote(Note note) {
		Note merge = s1.merge(note);
		if (merge != null) {
			return true;

		}

		return false;
	}

}
