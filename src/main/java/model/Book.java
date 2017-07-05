package model;


public class Book {
	private long isbn;
	private String title;
	private String author;
	private String publisher;
	private String translator;
	private String coverSrc;
	private byte score;

	public Book(){
		
	}
	
	public Book(long isbn,String title,String author,String publisher,String translator,String coverSrc, byte score){
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.translator = translator;
		this.coverSrc = coverSrc;
		this.score = score;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTranslator() {
		return translator;
	}

	public void setTranslator(String translator) {
		this.translator = translator;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getCoverSrc() {
		return coverSrc;
	}

	public void setCoverSrc(String coverSrc) {
		this.coverSrc = coverSrc;
	}

	public byte getScore() {
		return score;
	}

	public void setScore(byte score) {
		this.score = score;
	}

	
}
