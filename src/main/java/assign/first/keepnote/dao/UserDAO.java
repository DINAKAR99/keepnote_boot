package assign.first.keepnote.dao;

import assign.first.keepnote.exception.UserNotFoundException;
import assign.first.keepnote.model.User;

public interface UserDAO {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

	public boolean registerUser(User user);

	public boolean updateUser(User user);

	public User getUserById(int UserId);

	public User getUserByName(String name);

	public boolean validateUser(String userName, String password) throws UserNotFoundException;

	public boolean deleteUser(int UserId);
}
