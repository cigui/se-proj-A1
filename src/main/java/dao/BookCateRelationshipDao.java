package dao;

import java.util.List;

import model.BookCateRelationship;

public interface BookCateRelationshipDao {

	public Integer save(BookCateRelationship bookCateRelationship);

	public void delete(BookCateRelationship bookCateRelationship);

	public void update(BookCateRelationship bookCateRelationship);

	public BookCateRelationship getBookCateRelationshipByISBN(int ISBN);
	
	public BookCateRelationship getBookCateRelationshipByCate_ID(int cate_ID);

	public List<BookCateRelationship> getAllBookCateRelationships();

}