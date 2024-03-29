package assign.first.keepnote.service;

import java.util.List;

import assign.first.keepnote.exception.CategoryNotFoundException;
import assign.first.keepnote.model.Category;

public interface CategoryService {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */
	public boolean createCategory(Category category);

	public boolean deleteCategory(int noteId);

	public Category updateCategory(Category category, int id) throws CategoryNotFoundException;

	public Category getCategoryById(int categoryId) throws CategoryNotFoundException;

	public List<Category> getAllCategoryByUserId(int userId);

}
