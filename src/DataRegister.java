import java.time.LocalDate;

import org.json.JSONObject;

public class DataRegister implements JSONInterface {
	private String firstName;
	private String lastName;
	private Adress adress;
	private String docIdentity;
	private String docCpf;
	private String phone;
	private String cel;
	private LocalDate birth;
	private LocalDate register;
	
	public DataRegister(String firstName, String lastName, String docIdentity, String docCpf, String phone, String cel, LocalDate birth, LocalDate register,  Adress adress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.docIdentity = docIdentity;
		this.docCpf = docCpf;
		this.phone = phone;
		this.cel = cel;
		this.birth = birth;
		this.register = register;
	}
	
	public DataRegister() {
		
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Adress getAdress() {
		return adress;
	}
	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public String getDocIdentity() {
		return docIdentity;
	}
	public void setDocIdentity(String docIdentity) {
		this.docIdentity = docIdentity;
	}

	public String getDocCpf() {
		return docCpf;
	}
	public void setDocCpf(String docCpf) {
		this.docCpf = docCpf;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCel() {
		return cel;
	}
	public void setCel(String cel) {
		this.cel = cel;
	}

	public LocalDate getBirth() {
		return birth;
	}
	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public LocalDate getRegister() {
		return register;
	}
	public void setRegister(LocalDate register) {
		this.register = register;
	}

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		o.put("firstName", this.getFirstName());
		o.put("lastName", this.getLastName());
		o.put("docIdentify", this.getDocIdentity());
		o.put("docCpf", this.getDocCpf());
		o.put("phone", this.getPhone());
		o.put("cel", this.getCel());
		o.put("birth", this.getBirth().toString());
		o.put("register", this.getRegister());
		o.put("adress", this.getAdress().toJSONObject());
		return o;
	}

	@Override
	public void fromJSONObject(JSONObject o) {
		// TODO Auto-generated method stub
		this.setFirstName(o.getString("firstName"));
		this.setLastName(o.getString("lastName"));
		this.setDocIdentity(o.getString("docIdentify"));
		this.setDocCpf(o.getString("docCpf"));
		this.setPhone(o.getString("phone"));
		this.setCel(o.getString("cel"));
		this.setBirth(LocalDate.parse(o.getString("birth")));
		this.setRegister(LocalDate.parse(o.getString("register")));
		Adress a = new Adress();
		a.fromJSONObject(o.getJSONObject("adress"));
		this.setAdress(a);
	}
}
