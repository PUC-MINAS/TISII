import org.json.JSONObject;

public class Reserve implements JSONInterface {

	private int exemplaryCode;
	private Exemplary exemplary;
	
	public Reserve(Exemplary ex) {
		this.setExemplary(ex);
		this.setExemplaryCode(ex.getExemplaryCode());
	}
	
	public Reserve() {
		this.setExemplary(null);
		this.setExemplaryCode(0);
	}
	
	public int getExemplaryCode() {
		return exemplaryCode;
	}

	public Exemplary getExemplary() {
		return exemplary;
	}

	public void setExemplaryCode(int exemplaryCode) {
		this.exemplaryCode = exemplaryCode;
	}

	public void setExemplary(Exemplary exemplary) {
		this.exemplary = exemplary;
	}

	@Override
	public JSONObject toJSONObject() {
		// TODO Auto-generated method stub
		JSONObject o = new JSONObject();
		o.put("exemplaryCode", this.getExemplaryCode());
		return o;
	}

	@Override
	public void fromJSONObject(JSONObject o) {
		// TODO Auto-generated method stub
		this.setExemplaryCode(o.getInt("exemplaryCode"));
		
		this.setExemplary(ServiceExemplary.search(this.getExemplaryCode()));
	}

}
