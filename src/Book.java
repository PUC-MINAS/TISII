
public class Book {
	private String name;
	private String publishingCompany;
	private String language;
	private long isbn;
	private int genre;
	private String synopsis;
	private String author;
	
	public Book(String name, String publishingCompany, String language, long isbn, int genre, String synopsis, String author) {
		this.name = name;
		this.publishingCompany = publishingCompany;
		this.language = language;
		this.isbn = isbn;
		this.genre = genre;
		this.synopsis = synopsis;
		this.author = author;
	}
	
	public Book() {
		this.name = null;
		this.publishingCompany = null;
		this.language = null;
		this.isbn = 0;
		this.genre = 0;
		this.synopsis = null;
		this.author = null;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPublishingCompany() {
		return this.publishingCompany;
	}
	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	private long getIsbn() {
		return this.isbn;
	}
	private void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	
	private int getGenre() {
		return this.genre;
	}
	private void setGenre(int genre) {
		this.genre = genre;
	}
	
	public String getSynopsis() {
		return this.synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
