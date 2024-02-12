package assign.first.keepnote.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import assign.first.keepnote.exception.CategoryNotFoundException;
import assign.first.keepnote.model.Category;
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
public class CategoryDAOImpl implements CategoryDAO {

	/*
	 * Autowiring should be implemented for the SessionFactory.(Use
	 * constructor-based autowiring.
	 */

	EntityManager s1;

	public CategoryDAOImpl(EntityManager em) {
		this.s1 = em;

	}

	/*
	 * Create a new category
	 */
	public boolean createCategory(Category category) {

		s1.persist(category);

		System.out.println("in save transaction");

		return true;

	}

	/*
	 * Remove an existing category
	 */
	public boolean deleteCategory(int categoryId) {
		Category category = s1.find(Category.class, categoryId);
		if (category != null) {

			s1.remove(category);
			return true;
		}
		return false;

	}
	/*
	 * Update an existing category
	 */

	public boolean updateCategory(Category category) {

		Category merge = s1.merge(category);
		if (merge != null) {
			return true;

		}

		return false;

	}
	/*
	 * Retrieve details of a specific category
	 */

	public Category getCategoryById(int categoryId) throws CategoryNotFoundException {

		Category category = s1.find(Category.class, categoryId);

		return category;

	}

	/*
	 * Retrieve details of all categories by userId
	 */
	public List<Category> getAllCategoryByUserId(int userId) {
		List<Category> resultList = s1.createQuery(" from Category", Category.class).getResultList();
		return resultList;
	}

}
