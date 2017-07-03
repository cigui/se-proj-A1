package service;

import model.Book;
import model.BookRelease;
import model.BookComment;
import model.Category;
import java.util.List;
/*DisplayMoreBooks、ReleasePreview、SearchBook、ReleaseBook、SendBookComment、SelectCategory*/
public interface DisplayMoreBooksService {

	public Integer save(Book book);

	public void delete(Book book);

	public void update(Book book);

	public Book getBookByISBN(int ISBN);
	
	public Book getBookByTitle(int title);
	
	public Book getBookByAuthor(int author);

	public List<Book> getAllBooks();
    
    public Integer save(BookRelease bookRelease);

	public void delete(BookRelease bookRelease);

	public void update(BookRelease bookRelease);

	public BookRelease getBookReleaseByISBN(int ISBN);
	
	public BookRelease getBookReleaseById(int id);
	
	public BookRelease getBookReleaseByR_id(int r_id);

	public List<BookRelease> getAllBookReleases();

    public Integer save(BookComment bookComment);

	public void delete(BookComment bookComment);

	public void update(BookComment bookComment);

	public BookComment getBookCommentByISBN(int ISBN);
	
	public BookComment getBookCommentById(int id);

	public List<BookComment> getAllBookComments();
    
    public Integer save(Category category);

	public void delete(Category category);

	public void update(Category category);

	public Category getCategoryById(int cate_ID);

	public List<Category> getAllCategories();
    
    public void DisplayMoreBooks();//?
    
    public boolean ReleasePreview(int ISBN);
    
    public boolean SearchBook(String keyword);
    
    public boolean ReleaseBook();//?
    
    public boolean SendBookComment(BookComment bookComment);
    
    public boolean SelectCategory(Category category);
}

