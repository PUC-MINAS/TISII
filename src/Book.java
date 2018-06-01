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

	public boolean equals(Book b) {
		if(this.isbn==b.getIsbn())
				return true;
		return false;
	}
	
	public String getName() {
		return this.name;
	}
	public Book setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getPublishingCompany() {
		return this.publishingCompany;
	}
	public Book setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
		return this;
	}
	
	public String getLanguage() {
		return this.language;
	}
	public Book setLanguage(String language) {
		this.language = language;
		return this;
	}
	
	public long getIsbn() {
		return this.isbn;
	}
	public Book setIsbn(long isbn) {
		this.isbn = isbn;
		return this;
	}
	
	public int getGenre() {
		return this.genre;
	}
	public Book setGenre(int genre) {
		this.genre = genre;
		return this;
	}
	
	public String getSynopsis() {
		return this.synopsis;
	}
	public Book setSynopsis(String synopsis) {
		this.synopsis = synopsis;
		return this;
	}
	
	public String getAuthor() {
		return this.author;
	}
	public Book setAuthor(String author) {
		this.author = author;
		return this;
	}
}
