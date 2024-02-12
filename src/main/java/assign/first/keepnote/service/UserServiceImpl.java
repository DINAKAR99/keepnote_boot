package assign.first.keepnote.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import assign.first.keepnote.dao.UserDAO;
import assign.first.keepnote.exception.UserAlreadyExistException;
import assign.first.keepnote.exception.UserNotFoundException;
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
public class UserServiceImpl implements UserService {

	/*
	 * Autowiring should be implemented for the userDAO. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword.
	 */
	UserDAO dao1;
	// UserDao2 dao1;

	public UserServiceImpl(UserDAO ud1) {
		this.dao1 = ud1;

	}

	/*
	 * This method should be used to save a new user.
	 */
	@Transactional
	public boolean registerUser(User user) throws UserAlreadyExistException {

		User userByName = dao1.getUserByName(user.getUserName());

		if (userByName == null) {

			dao1.registerUser(user);
			System.out.println(true + "NEW USER CREATED ");
		}

		else {

			throw new UserAlreadyExistException("user already exists");
		}

		return true;

	}

	/*
	 * This method should be used to update a existing user.
	 */

	public User updateUser(User user2, int userId) throws UserNotFoundException {

		User userById = dao1.getUserById(userId);

		if (userById != null) {

			dao1.updateUser(user2);

		}

		else {

			throw new UserNotFoundException("user not found");
		}

		return user2;
	}

	/*
	 * This method should be used to get a user by userId.
	 */

	public User getUserById(int UserId) throws UserNotFoundException {
		User userById = dao1.getUserById(UserId);

		if (userById != null) {
			return userById;
		}

		else {

			throw new UserNotFoundException("user not found");
		}

	}

	/*
	 * This method should be used to validate a user using userId and password.
	 */

	public boolean validateUser(String name, String password) throws UserNotFoundException {

		boolean validateUser = dao1.validateUser(name, password);

		return validateUser;

	}

	/* This method should be used to delete an existing user. */
	public boolean deleteUser(int UserId) {

		boolean deleteUser = dao1.deleteUser(UserId);
		return deleteUser;

	}

	@Override
	public User getUserByName(String userName) throws UserNotFoundException {
		User userByName = dao1.getUserByName(userName);

		if (userByName != null) {
			return userByName;

		}

		else {
			throw new UserNotFoundException("user not found");

		}

	}

}
