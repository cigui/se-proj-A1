package dao;

import java.util.List;

import model.BookCateRelationship;

public interface BookCateRelationshipDao {

	public Integer save(BookCateRelationship bookCateRelationship);

	public void delete(BookCateRelationship bookCateRelationship);

	public void update(BookCateRelationship bookCateRelationship);

	public BookCateRelationship getBookCateRelationshipByIsbn(int isbn);
	
	public BookCateRelationship getBookCateRelationshipByCate_id(int cate_id);

	public List<BookCateRelationship> getAllBookCateRelationships();

}