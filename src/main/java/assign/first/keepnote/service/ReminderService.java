package assign.first.keepnote.service;

import java.util.List;

import assign.first.keepnote.exception.ReminderNotFoundException;
import assign.first.keepnote.model.Reminder;

public interface ReminderService {
	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */
	public boolean createReminder(Reminder reminder);

	public Reminder updateReminder(Reminder reminder, int id) throws ReminderNotFoundException;

	public boolean deleteReminder(int reminderId);

	public Reminder getReminderById(int reminderId) throws ReminderNotFoundException;

	public List<Reminder> getAllReminderByUserId(int userId);
}
