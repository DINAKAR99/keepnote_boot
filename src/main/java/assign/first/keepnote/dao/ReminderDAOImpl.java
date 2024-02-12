package assign.first.keepnote.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import assign.first.keepnote.exception.ReminderNotFoundException;
import assign.first.keepnote.model.Reminder;
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
public class ReminderDAOImpl implements ReminderDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	EntityManager s1;

	public ReminderDAOImpl(EntityManager sf) {
		this.s1 = sf;

	}

	/*
	 * Create a new reminder
	 */

	public boolean createReminder(Reminder reminder) {
		s1.persist(reminder);

		System.out.println("in save transaction");

		return true;

	}

	/*
	 * Update an existing reminder
	 */

	public boolean updateReminder(Reminder reminder) {
		Reminder merge = s1.merge(reminder);
		if (merge != null) {
			return true;

		}

		return false;

	}

	/*
	 * Remove an existing reminder
	 */

	public boolean deleteReminder(int ReminderId) {
		Reminder Reminderr = s1.find(Reminder.class, ReminderId);
		if (Reminderr != null) {

			s1.remove(Reminderr);
			return true;
		}
		return false;

	}

	/*
	 * Retrieve details of a specific reminder
	 */

	public Reminder getReminderById(int ReminderId) throws ReminderNotFoundException {
		Reminder Reminderr = s1.find(Reminder.class, ReminderId);

		return Reminderr;

	}

	/*
	 * Retrieve details of all reminders by userId
	 */

	public List<Reminder> getAllReminderByUserId(int userId) {
		List<Reminder> resultList = s1.createQuery(" from Reminder", Reminder.class).getResultList();
		return resultList;

	}

}
