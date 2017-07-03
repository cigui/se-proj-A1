package dao;

import java.util.List;

import model.BookComment;

public interface BookCommentDao {

	public Integer save(BookComment bookComment);

	public void delete(BookComment bookComment);

	public void update(BookComment bookComment);

	public BookComment getBookCommentByISBN(int ISBN);
	
	public BookComment getBookCommentById(int id);

	public List<BookComment> getAllBookComments();

}