package assign.first.keepnote.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import assign.first.keepnote.exception.UserNotFoundException;
import assign.first.keepnote.model.User;
import jakarta.persistence.EntityManager;

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
public class UserDaoImpl implements UserDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */
	EntityManager s1;

	public UserDaoImpl(EntityManager sessionFactory) {
		this.s1 = sessionFactory;

	}

	/*
	 * Create a new user
	 */

	public boolean registerUser(User user) {
		System.out.println(user);

		s1.persist(user);

		System.out.println("in save transaction");

		return true;

	}

	/*
	 * Update an existing user
	 */

	public boolean updateUser(User user) {

		User merge = s1.merge(user);
		if (merge != null) {
			return true;

		}

		return false;

	}

	/*
	 * Retrieve details of a specific user
	 */@Transactional
	public User getUserById(int UserId) {

		User user = s1.find(User.class, UserId);

		return user;

	}

	/*
	 * validate an user
	 */

	public boolean validateUser(String userId, String password) throws UserNotFoundException {
		try {
			s1
					.createQuery("SELECT u from User u where userName= :user and userPassword =:pass", User.class)
					.setParameter("user", userId).setParameter("pass", password)
					.getSingleResult();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			// TODO: handle exception
			throw new UserNotFoundException("user not found");
		}
		return true;

	}

	/*
	 * Remove an existing user
	 */
	public boolean deleteUser(int userId) {

		User user = s1.find(User.class, userId);
		if (user != null) {
			s1.remove(userId);
			return true;

		}

		return false;

	}

	@Override
	public User getUserByName(String name) {
		User singleResult = null;
		try {
			singleResult = s1.createQuery("select u from User u where userName= :name ", User.class)
					.setParameter("name", name)
					.getSingleResult();

		} catch (Exception e) {

			return singleResult;

		}

		return singleResult;

	}

}
