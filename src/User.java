
public class User {
	String username;
	int id;
	String email;
	String password;
	int type;
	int status;
	Loan[] loans;
	Reserve[] reserves;
	
	public User(String username, int id, String email, String password, int type, int status) {
		this.username = username;
		this.id = id;
		this.email = email;
		this.password = password;
		this.type = type;
		this.status = status;
		this.loans = new loans[10];
		this.reserves = new reserves[10];
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Loan[] getLoans() {
		return loans;
	}
	public void setLoans(Loan[] loans) {
		this.loans = loans;
	}

	public Reserve[] getReserves() {
		return reserves;
	}
	public void setReserves(Reserve[] reserves) {
		this.reserves = reserves;
	}

	public void addBook() {
		
	}
	
	public void removeBook() {
		
	}
}
