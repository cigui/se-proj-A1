package service;

import model.BookComment;

import java.util.List;

public interface SendBookCommentService {

    public Integer save(BookComment bookComment);

	public void delete(BookComment bookComment);

	public void update(BookComment bookComment);

	public List<BookComment> getBookCommentByISBN(int ISBN);
	
	public List<BookComment> getBookCommentById(int id);

	public List<BookComment> getAllBookComments();
    
	public void SendBookComment(int id,long isbn,String discription,byte score);
    
}