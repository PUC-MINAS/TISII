import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class User implements JSONInterface {
	private String username;
	private String email;
	private String password;
	private int type;
	private int status;
	private DataRegister data;
	private List<Loan> loans;
	private List<Reserve> reserves;
	
	public User(String username, String email, String password, int type, int status, DataRegister data) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.type = type;
		this.status = status;
		this.data = data;
		this.loans = new ArrayList<Loan>();
		this.reserves = new ArrayList<Reserve>();
	}
	
	public User() {
		this.setUsername("");
		this.setEmail("");
		this.setData(null);
		this.setLoans(new ArrayList<Loan>());
		this.setReserves(new ArrayList<Reserve>());
		this.setPassword("");
		this.setStatus(0);
		this.setType(0);		
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

	public List<Loan> getLoans() {
		return loans;
	}
	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

	public List<Reserve> getReserves() {
		return reserves;
	}
	public void setReserves(List<Reserve> reserves) {
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
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		User u = (User) arg0;
		return u.getUsername().compareTo(this.getUsername()) == 0 && u.getEmail().compareToIgnoreCase(this.getEmail()) == 0;
	}

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		JSONArray aLoans = new JSONArray();
		JSONArray aReserve = new JSONArray();
		o.put("username", this.getUsername());
		o.put("password", this.getPassword());
		o.put("email", this.getEmail());
		o.put("type", this.getType());
		o.put("status", this.getStatus());
		o.put("data", this.getData().toJSONObject());
		
		if (this.getLoans() != null) {
			for (Loan l : this.getLoans()) {
				aLoans.put(l.toJSONObject());
			}
		}
		
		if (this.getReserves() != null) {
			for (Reserve r : this.getReserves()) {
				aReserve.put(r.toJSONObject());
			}
		}		
		
		o.put("loans", aLoans);
		o.put("reserves", aReserve);
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
		JSONArray arrayLoans = o.getJSONArray("loans");
		JSONArray arrayReserve = o.getJSONArray("reserves");
		JSONObject ob;
		Loan l;
		Reserve r;
		List<Loan> loans = new ArrayList<Loan>();
		List<Reserve> reserves = new ArrayList<Reserve>();
		for(int i = 0; i < arrayLoans.length(); i++) {
			l = new Loan();
			l.fromJSONObject(arrayLoans.getJSONObject(i));
			loans.add(l);
		}
		for (int i= 0; i < arrayReserve.length() ; i++) {
			r = new Reserve();
			r.fromJSONObject(arrayReserve.getJSONObject(i));
			reserves.add(r);
		}
		this.setLoans(loans);
		this.setReserves(reserves);
		
	}
}
