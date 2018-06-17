import org.json.JSONObject;

public class Book implements JSONInterface {
	private String name;
	private String publishingCompany;
	private String language;
	private long isbn;
	private Genre genre;
	private String synopsis;
	private String author;
	
	public Book(String name, String publishingCompany, String language, long isbn, int genre, String synopsis, String author) {
		this.name = name;
		this.publishingCompany = publishingCompany;
		this.language = language;
		this.isbn = isbn;
		this.synopsis = synopsis;
		this.author = author;
		this.setGenre(genre);
	}
	
	public Book setGenre(int genre) {
		// TODO Auto-generated method stub
		this.genre = ServiceGenre.search(genre);
		return this;
	}
	
	public Genre getGenre() {
		return this.genre;
	}
	

	public Book() {
		this.name = null;
		this.publishingCompany = null;
		this.language = null;
		this.isbn = 0;
		this.synopsis = null;
		this.author = null;
		this.genre = null;
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

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		o.put("name", this.getName());
		o.put("publishingCompany", this.getPublishingCompany());
		o.put("language", this.getLanguage());
		o.put("isbn", this.getIsbn());
		o.put("genre", this.getGenre().id);
		o.put("synopsis", this.getSynopsis());
		o.put("author", this.getAuthor());
		
		return o;
	}

	@Override
	public void fromJSONObject(JSONObject o) {
		// TODO Auto-generated method stub
		this.setName(o.getString("name"));
		this.setPublishingCompany(o.getString("publishingCompany"));
		this.setLanguage(o.getString("language"));
		this.setIsbn(o.getLong("isbn"));
		this.setGenre(o.getInt("genre"));
		this.setSynopsis(o.getString("synopsis"));
		this.setAuthor(o.getString("author"));
	}

	public boolean contains(String str) {
		// TODO Auto-generated method stub
		return this.getName().toLowerCase().contains(str.toLowerCase()) ||
				this.getAuthor().toLowerCase().contains(str.toLowerCase()) ||
				this.getPublishingCompany().toLowerCase().contains(str.toLowerCase()) ||
				this.getSynopsis().toLowerCase().contains(str.toLowerCase());
	}
}
