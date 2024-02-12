package assign.first.keepnote.dao;

import java.util.List;

import assign.first.keepnote.exception.CategoryNotFoundException;
import assign.first.keepnote.model.Category;

public interface CategoryDAO {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

	public boolean createCategory(Category category);

	public boolean deleteCategory(int noteId);

	public boolean updateCategory(Category category);

	public Category getCategoryById(int categoryId) throws CategoryNotFoundException;

	public List<Category> getAllCategoryByUserId(int userId);
}
