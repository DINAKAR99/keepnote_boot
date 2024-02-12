package assign.first.keepnote.model;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.Mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/*
 * The class "Category" will be acting as the data model for the Category Table in the database. 
 * Please note that this class is annotated with @Entity annotation. 
 * Hibernate will scan all package for any Java objects annotated with the @Entity annotation. 
 * If it finds any, then it will begin the process of looking through that particular 
 * Java object to recreate it as a table in your database.
 */
@Entity
public class Category {
	/*
	 * This class should have six fields
	 * (categoryId,categoryName,categoryDescription,
	 * categoryCreatedBy,categoryCreationDate,notes). Out of these six fields, the
	 * field categoryId should be primary key and auto-generated. This class should
	 * also contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method. The value of
	 * categoryCreationDate should not be accepted from the user but should be
	 * always initialized with the system date. annotate notes field with @OneToMany
	 * and @JsonIgnore
	 */
	@Id
	@GeneratedValue
	public int CategoryId;
	public String CategoryName;
	public String CategoryDescription;
	public int categoryCreatedBy;
	public final Date CategoryCreationDate = new Date();;
	@OneToMany(mappedBy = "category")
	public List<Note> Notes;

	public Category(String categoryName, String categoryDescription, int categoryCreatedBy, List<Note> notes) {
		CategoryName = categoryName;
		CategoryDescription = categoryDescription;
		this.categoryCreatedBy = categoryCreatedBy;
		Notes = notes;
	}

	public Category() {
	}

	public int getCategoryId() {
		return CategoryId;
	}

	public void setCategoryId(int categoryId) {
		CategoryId = categoryId;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		CategoryDescription = categoryDescription;
	}

	public Date getCategoryCreationDate() {
		return CategoryCreationDate;
	}

	public List<Note> getNotes() {
		return Notes;
	}

	public void setNotes(List<Note> notes) {
		Notes = notes;
	}

	@Override
	public String toString() {
		return "Category [CategoryId=" + CategoryId + ", CategoryName=" + CategoryName + ", CategoryDescription="
				+ CategoryDescription + ", CategoryCreationDate=" + CategoryCreationDate + ", Notes=" + Notes + "]";
	}

	public int getCategoryCreatedBy() {
		return categoryCreatedBy;
	}

	public void setCategoryCreatedBy(int categoryCreatedBy) {
		this.categoryCreatedBy = categoryCreatedBy;
	}

}