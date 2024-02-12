package assign.first.keepnote.service;

import assign.first.keepnote.exception.UserAlreadyExistException;
import assign.first.keepnote.exception.UserNotFoundException;
import assign.first.keepnote.model.User;

public interface UserService {
	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */
	public boolean registerUser(User user) throws UserAlreadyExistException;

	public User updateUser(User user, int id) throws Exception;

	public boolean deleteUser(int UserId);

	public boolean validateUser(String userName, String password) throws UserNotFoundException;

	public User getUserById(int userId) throws UserNotFoundException;

	public User getUserByName(String userName) throws UserNotFoundException;

}
