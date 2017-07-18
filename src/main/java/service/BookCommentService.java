package service;

import model.BookComment;

import java.util.List;

public interface BookCommentService {

    public BookComment save(BookComment bookComment);

	public void delete(BookComment bookComment);

	public void update(BookComment bookComment);

	public List<BookComment> getBookCommentByISBN(long ISBN);
	
	public List<BookComment> getBookCommentById(int id);

	public List<BookComment> getAllBookComments();
    
	public void SendBookComment(int id,long isbn,String discription,byte score);
    
}