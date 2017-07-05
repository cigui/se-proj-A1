package service;

import model.BookComment;

import java.util.List;

public interface SendBookCommentService {

    public Integer save(BookComment bookComment);

	public void delete(BookComment bookComment);

	public void update(BookComment bookComment);

	public BookComment getBookCommentByISBN(int ISBN);
	
	public BookComment getBookCommentById(int id);

	public List<BookComment> getAllBookComments();
    
    public boolean SendBookComment(BookComment bookComment);
    
}