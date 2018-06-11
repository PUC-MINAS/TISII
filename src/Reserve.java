import java.time.LocalDate;

import org.json.JSONObject;

public class Reserve implements JSONInterface {

	private int exemplaryCode;
	private Exemplary exemplary;
	private LocalDate reserveDate;
	
	public Reserve(Exemplary ex) {
		this.setExemplary(ex);
		this.setExemplaryCode(ex.getExemplaryCode());
		this.setReserveDate(LocalDate.now());
	}
	
	public Reserve() {
		this.setExemplary(null);
		this.setExemplaryCode(0);
		this.setReserveDate(null);
	}
	
	public int getExemplaryCode() {
		return exemplaryCode;
	}

	public Exemplary getExemplary() {
		return exemplary;
	}
	
	public LocalDate getReserveDate() {
		return this.reserveDate;
	}
	
	public void setReserveDate(LocalDate reserveDate) {
		this.reserveDate = reserveDate;
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
		o.put("reserveDate", this.getReserveDate().toString());
		return o;
	}

	@Override
	public void fromJSONObject(JSONObject o) {
		// TODO Auto-generated method stub
		this.setExemplaryCode(o.getInt("exemplaryCode"));
		this.setReserveDate(LocalDate.parse(o.getString("reserveDate")));
		this.setExemplary(ServiceExemplary.search(this.getExemplaryCode()));
	}

}
