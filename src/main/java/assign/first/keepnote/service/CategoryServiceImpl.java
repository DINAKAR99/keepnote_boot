package assign.first.keepnote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import assign.first.keepnote.dao.CategoryDAO;
import assign.first.keepnote.dao.ReminderDAO;
import assign.first.keepnote.exception.CategoryNotFoundException;
import assign.first.keepnote.exception.ReminderNotFoundException;
import assign.first.keepnote.model.Category;
import assign.first.keepnote.model.Reminder;

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
public class CategoryServiceImpl implements CategoryService {
	/*
	 * Autowiring should be implemented for the CategoryDAO. (Use Constructor-based
	 * autowiring) Please note that we should not create any object using the new
	 * keyword.
	 */
	CategoryDAO dao1;
	// UserDao2 dao1;

	public CategoryServiceImpl(CategoryDAO ud1) {
		this.dao1 = ud1;

	}

	/*
	 * This method should be used to save a new category.
	 */
	public boolean createCategory(Category category) {
		boolean reminder2 = dao1.createCategory(category);

		return reminder2;

	}

	/* This method should be used to delete an existing category. */
	public boolean deleteCategory(int categoryId) {
		boolean deletecategory = dao1.deleteCategory(categoryId);
		return deletecategory;

	}

	/*
	 * This method should be used to update a existing category.
	 */

	public Category updateCategory(Category category, int id) throws CategoryNotFoundException {
		Category getCategoryById = dao1.getCategoryById(id);

		if (getCategoryById != null) {

			dao1.updateCategory(getCategoryById);

		}

		else {

			throw new CategoryNotFoundException();
		}

		return category;
	}

	/*
	 * This method should be used to get a category by categoryId.
	 */
	public Category getCategoryById(int CategoryId) throws CategoryNotFoundException {
		Category CategoryById = dao1.getCategoryById(CategoryId);

		if (CategoryById != null) {
			return CategoryById;
		}

		else {

			throw new CategoryNotFoundException();
		}

	}

	/*
	 * This method should be used to get a category by userId.
	 */

	public List<Category> getAllCategoryByUserId(int userId) {
		List<Category> allCategoryByUserId = dao1.getAllCategoryByUserId(userId);

		return allCategoryByUserId;

	}

}
