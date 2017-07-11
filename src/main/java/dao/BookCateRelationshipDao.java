package dao;

import java.util.List;

import model.BookCateRelationship;

public interface BookCateRelationshipDao {

	public Integer save(BookCateRelationship bookCateRelationship);

	public void delete(BookCateRelationship bookCateRelationship);

	public void update(BookCateRelationship bookCateRelationship);

	public List<Integer> getCategoriesIdByIsbn(long isbn);
	
	public List<Long> getBooksIsbnByCate_id(int cate_id);

	public List<BookCateRelationship> getAllBookCateRelationships();

}