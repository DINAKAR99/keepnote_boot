package assign.first.keepnote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import assign.first.keepnote.dao.ReminderDAO;
import assign.first.keepnote.exception.ReminderNotFoundException;
import assign.first.keepnote.model.Reminder;

/*
* Service classes are used here to implement additional business logic/validation 
* This class has to be annotated with @Service annotation.
* @Service - It is a specialization of the component annotation. It doesnt currently 
* provide any additional behavior over the @Component annotation, but its a good idea 
* to use @Service over @Component in service-layer classes because it specifies intent 
* better. Additionally, tool support and additional behavior might rely on it in the 
* future.
* */
@Service
public class ReminderServiceImpl implements ReminderService {

	/*
	 * Autowiring should be implemented for the ReminderDAO. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword.
	 */

	ReminderDAO dao1;
	// UserDao2 dao1;

	public ReminderServiceImpl(ReminderDAO ud1) {
		this.dao1 = ud1;

	}

	/*
	 * This method should be used to save a new reminder.
	 */

	public boolean createReminder(Reminder reminder) {

		boolean reminder2 = dao1.createReminder(reminder);

		return reminder2;

	}

	/*
	 * This method should be used to update a existing reminder.
	 */

	public Reminder updateReminder(Reminder reminder, int id) throws ReminderNotFoundException {
		Reminder getReminderById = dao1.getReminderById(id);

		if (getReminderById != null) {

			dao1.updateReminder(getReminderById);

		}

		else {

			throw new ReminderNotFoundException();
		}

		return reminder;
	}

	/* This method should be used to delete an existing reminder. */

	public boolean deleteReminder(int reminderId) {
		boolean deleteReminder = dao1.deleteReminder(reminderId);
		return deleteReminder;
	}

	/*
	 * This method should be used to get a reminder by reminderId.
	 */

	public Reminder getReminderById(int ReminderId) throws ReminderNotFoundException {
		Reminder ReminderById = dao1.getReminderById(ReminderId);

		if (ReminderById != null) {
			return ReminderById;
		}

		else {

			throw new ReminderNotFoundException();
		}

	}

	/*
	 * This method should be used to get a reminder by userId.
	 */

	public List<Reminder> getAllReminderByUserId(int userId) {
		List<Reminder> allReminderByUserId = dao1.getAllReminderByUserId(userId);

		return allReminderByUserId;

	}

}
