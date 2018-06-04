import org.json.JSONObject;

public class Adress implements JSONInterface {
	private String adress;
	private String number;
	private String complement;
	private String cep;
	private String city;
	private String state;
	
	public Adress(String adress, String number, String complement, String cep, String city, String state) {
		this.adress = adress;
		this.number = number;
		this.complement = complement;
		this.cep = cep;
		this.city = city;
		this.state = state;
	}
	
	public Adress() {
		
	}

	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		o.put("adress", this.getAdress());
		o.put("number", this.getNumber());
		o.put("complement", this.getComplement());
		o.put("cep", this.getCep());
		o.put("city", this.getCity());
		o.put("state", this.getState());
		return o;
	}

	@Override
	public void fromJSONObject(JSONObject o) {
		// TODO Auto-generated method stub
		this.setAdress(o.getString("adress"));
		this.setNumber(o.getString("number"));
		this.setComplement(o.getString("complement"));
		this.setCep(o.getString("cep"));
		this.setCity(o.getString("city"));
		this.setState(o.getString("state"));
	}
}
