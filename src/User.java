import org.json.JSONObject;

public class User implements JSONInterface {
	private String username;
	private String email;
	private String password;
	private int type;
	private int status;
	private DataRegister data;
	private Loan[] loans;
	private Reserve[] reserves;
	
	public User(String username, String email, String password, int type, int status, DataRegister data) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.type = type;
		this.status = status;
		this.data = data;
		this.loans = new Loan[10];
		this.reserves = new Reserve[10];
	}
	
	public User() {
		
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	public DataRegister getData() {
		return this.data;
	}
	
	public void setData(DataRegister d) {
		this.data = d;
	}
	
	public void addBook() {
		
	}
	
	public void removeBook() {
		
	}

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		o.put("username", this.getUsername());
		o.put("password", this.getPassword());
		o.put("email", this.getEmail());
		o.put("type", this.getType());
		o.put("status", this.getStatus());
		o.put("data", this.getData().toJSONObject());
		return o;
	}

	@Override
	public void fromJSONObject(JSONObject o) {
		// TODO Auto-generated method stub
		this.setUsername(o.getString("username"));
		this.setEmail(o.getString("email"));
		this.setPassword(o.getString("password"));
		this.setStatus(o.getInt("status"));
		this.setType(o.getInt("type"));
		DataRegister d = new DataRegister();
		d.fromJSONObject(o.getJSONObject("data"));
		this.setData(d);
	}
}
