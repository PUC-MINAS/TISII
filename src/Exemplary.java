import org.json.JSONObject;

public class Exemplary implements JSONInterface{
	private int exemplaryCode;
	private boolean braile;
	private int status;
	private long isbnBook;
	private Book book;
	private String localization;
	
	public Exemplary(int exemplaryCode, boolean braile, Book book, String localization) {
		this.exemplaryCode = exemplaryCode;
		this.braile = braile;
		this.status = StatusExemplary.AVAILABEL;
		this.isbnBook = book.getIsbn();
		this.book = book;
		this.localization = localization;
	}
	
	public Exemplary() {
		this.exemplaryCode = 0;
		this.braile = false;
		this.status = 0;
		this.book = null;
		this.localization = null;
	}
	
	public int getExemplaryCode() {
		return this.exemplaryCode;
	}
	public void setExemplaryCode(int exemplaryCode) {
		this.exemplaryCode = exemplaryCode;
	}
	
	public boolean getBraile() {
		return this.braile;
	}
	public void setBraile(boolean braile) {
		this.braile = braile;
	}
	
	public int getStatus() {
		return this.status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public String getLocalization() {
		return localization;
	}
	public void setLocalization(String localization) {
		this.localization = localization;
	}
	public void setIsbnBook(int isbnBook) {
		this.isbnBook = isbnBook;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		Exemplary ex = (Exemplary) arg0;
		return ex.getExemplaryCode() == this.getExemplaryCode();
	}

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		return new JSONObject(this);
	}

	@Override
	public void fromJSONObject(JSONObject o) {
		// TODO Auto-generated method stub
		this.setExemplaryCode(o.getInt("exemplaryCode"));
		this.setBraile(o.getBoolean("braile"));
		this.setStatus(o.getInt("status"));
		this.setIsbnBook(o.getInt("isbnBook"));
		this.setLocalization(o.getString("localization"));
		
		/*this part is under test*/
		Book b = new Book();
		b.fromJSONObject(o.getJSONObject("book"));
		this.setBook(b);
	}
	
	
}
