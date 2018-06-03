
public class DataRegister {
	String firstName;
	String lastName;
	Adress adress;
	String docIdentity;
	String docCpf;
	String phone;
	String cel;
	Date birth;
	Date register;
	
	public DataRegister(String firstName, String lastName, Adress adress, String docIdentity, String docCpf, String phone, String cel, Date birth, Date register) {
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

	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public Date getRegister() {
		return register;
	}
	public void setRegister(Date register) {
		this.register = register;
	}
}
